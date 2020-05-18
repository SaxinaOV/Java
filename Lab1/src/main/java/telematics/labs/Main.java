package telematics.labs;

import java.util.Scanner;
import java.io.File;
import java.io.File.*;
import java.io.IOException;
import java.nio.file.Files;

public class Main{

    public static void main(String[] args)throws IOException {
        Scanner in = new Scanner(System.in);
        String from =  in.nextLine();
        String to =  in.nextLine();
        copyFile(from, to);
        in.close();
    }
    public static void copyFile( String from, String to )throws IOException {

        File src = new File(from);
        File dest = new File(to);

        if(src.isFile()){
            if(!Files.exists(dest.toPath())) {
                Files.copy(src.toPath(), dest.toPath());
            }
            else {
                System.out.println("File already exists");
            }
        }
        else{
            System.out.println("File is not found");
        }
    }
}