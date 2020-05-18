package telematics.labs;
import static telematics.labs.Main.copyFile;
import org.junit.Test;
import java.io.IOException;


public class Tests {

    @Test
	public void test()throws IOException  {
        copyFile("/home/olga/Books/s.txt",  "/home/olga/s.txt");
	}

}
