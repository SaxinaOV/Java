package telematics.labs;
import java.util.concurrent.*;
import java.util.concurrent.CyclicBarrier;


public class TrapezoidalIntegration {

    static int firstDot = 1;
    static int secondDot = 75;
    static int quantityOfThreads = 1;
    static double lengthOfSection = 0.00001;
    static int lengthOfInterval = (secondDot - firstDot)/(quantityOfThreads);
    static double[] array = new double[quantityOfThreads];

    static Runnable barrierAction = new Runnable() { public void run() {
        double result = 0;
        for(int i = 0; i<quantityOfThreads; i++ ){
            result += array[i];
        }
        System.out.println("Результат: " + result);
        long end=System.currentTimeMillis();
        System.out.println("Время: "+ (end - begin) + " мс");
    }};
    static CyclicBarrier barrier = new CyclicBarrier(quantityOfThreads, barrierAction);

    static double function(double x){
        return (Math.pow(x,0.5) / 15);
    }

    static long begin;

    static class sectionIntegrator implements Runnable{
        int firstPoint, secondPoint;
        int sectionNumber;

        sectionIntegrator(int first, int second, int number){
            firstPoint = first;
            secondPoint = second;
            sectionNumber = number;
        }

        public void run() {
            try {
                double i = firstPoint;
                while(!((Math.abs(i - secondPoint))<0.000001)){
                    array[sectionNumber] += function(i)*lengthOfSection;
                    i+=lengthOfSection;
                }
                if(sectionNumber == quantityOfThreads-1){
                    array[sectionNumber] += function(secondPoint)*lengthOfSection;
                }
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    static void integrate() throws ExecutionException, InterruptedException {

        for (int i = 0; i < quantityOfThreads; i++) {
            int first = firstDot + lengthOfInterval * i;
            int second;
            if(i < quantityOfThreads-1)
                second = firstDot + lengthOfInterval * (i+1);
            else
                second = secondDot;
            sectionIntegrator integrator = new sectionIntegrator(first, second, i);//создаем наш интегратор интервала
            Thread thread = new Thread(integrator);
            thread.start();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        begin=System.currentTimeMillis();
        integrate();
    }
}

