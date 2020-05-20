package telematics.labs;
import static org.junit.Assert.assertTrue;
import static telematics.labs.Main.copyFile;
import org.junit.Test;
import java.io.IOException;
import java.io.File;

public class Tests {

    @Test
	public void test()throws IOException  {

        String from = "/home/olga/Books/MyFile";
        String to = "/home/olga/MyFile";

        File newFile = new File("/home/olga/Books/MyFile");
        boolean created = newFile.createNewFile();
        assertTrue(copyFile(from, to));
        File movedFile = new File("/home/olga/MyFile");
        movedFile.delete();  
        newFile.delete();
        
    }

}
