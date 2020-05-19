package telematics.labs;

import org.junit.Assert;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;


public class TrapezoidalIntegrationTest {

    @Test
    public void integrate() throws ExecutionException, InterruptedException {
        TrapezoidalIntegration integral=new TrapezoidalIntegration();
        integral.integrate();
        TimeUnit.SECONDS.sleep(1);
        Assert.assertTrue(Math.abs(integral.result - 28.8230)<0.0001);

    }
}
