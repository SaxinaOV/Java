package telematics.labs;

import static org.junit.Test.*;

import org.junit.Test;

import static org.junit.Assert.*;


public class BerriesTest {

    @Test
    public void check() throws InterruptedException {
        Berries.Neighbor N1 = new Berries.Neighbor();
        Berries.Neighbor N2 = new Berries.Neighbor();
        Thread T1 = new Thread(N1);
        Thread T2 = new Thread(N2);
        T1.start();
        T2.start();
        T1.join();
        T2.join();
        int result = Berries.Field.getQuantityOfBerries() + N1.getBerries() + N2.getBerries();
        assertEquals(200, result);

    }

}

