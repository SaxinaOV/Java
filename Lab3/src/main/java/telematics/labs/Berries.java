package telematics.labs;
import java.util.Random;

public class Berries {

    static class Field{ 
        private static int berries = 200;
        static void setNewQuantityOfBerries(final int takenBerries) {
            berries -= takenBerries;
        }

        static int getQuantityOfBerries() {
            return berries;
        }
    }

    static Field field = new Field();

    static class Neighbor implements Runnable {
        int progress;

        Neighbor() {
            progress = 0;
        }

        int getBerries() {
            return progress;
        }

        void takeBerries(final int quantityOfBerries) {
            progress += quantityOfBerries;
        }

        @Override
        public void run() {
            final Random r = new Random();
            Integer takenBerries;
            while (!Thread.currentThread().isInterrupted() && field.getQuantityOfBerries() > 0) {
                synchronized (field) {
                    takenBerries = r.nextInt(10);
                    if (field.getQuantityOfBerries() > takenBerries) {
                        this.takeBerries(takenBerries);
                        field.setNewQuantityOfBerries(takenBerries);
                        System.out.println(Thread.currentThread().getName() + " taken " + takenBerries + " berries");
                    } else {
                        final Integer finalBerries = field.getQuantityOfBerries();
                        this.takeBerries(finalBerries);
                        field.setNewQuantityOfBerries(finalBerries);
                        System.out.println(Thread.currentThread().getName() + " taken " + finalBerries + " berries");
                    }
                }
            }
        }
    }

    public static void main(final String[] args) throws InterruptedException {
        final Neighbor firstNeighbor = new Neighbor();
        final Neighbor secondNeighbor = new Neighbor();
        final Thread firstThread = new Thread(firstNeighbor);
        final Thread secondThread = new Thread(secondNeighbor);

        int result = field.getQuantityOfBerries() + firstNeighbor.getBerries() + secondNeighbor.getBerries();
        System.out.println("Result sum = " + result);
        System.out.println("field = " + field.getQuantityOfBerries() + " N1 = " + firstNeighbor.getBerries() + " N2 = " + secondNeighbor.getBerries());
       

        firstThread.start();
        secondThread.start();
        firstThread.join();
        secondThread.join();

        result = field.getQuantityOfBerries() + firstNeighbor.getBerries() + secondNeighbor.getBerries();
        System.out.println("Result sum = " + result);
        System.out.println("field = " + field.getQuantityOfBerries() + " N1 = " + firstNeighbor.getBerries() + " N2 = " + secondNeighbor.getBerries());
    }
}

