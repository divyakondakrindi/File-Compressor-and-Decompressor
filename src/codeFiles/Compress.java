package codeFiles;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class Compress {
    public static void method(File file) throws IOException {
        // fetches the path of the textfile
        String fileDirectory = file.getParent();
//        System.out.println(fileDirectory);
        // to read the content in file (bytes)
        FileInputStream finput = new FileInputStream(file);
        //to store content in to a file and the path of that file
        FileOutputStream fos = new FileOutputStream(fileDirectory+"\\compressedfile2.gz");
        // to convert that content to gz and store
        GZIPOutputStream gzipos = new GZIPOutputStream(fos);
        //buffer array to store the content
        byte [] buffer = new byte[1024];
        int len;
        // it will read  from finput  and write it in buffer array
        // if we reach the end of file the len will be -1 and it comes out of loop
        while((len=finput.read(buffer)) != -1){
            gzipos.write(buffer,0,len);
        }
        finput.close();
        gzipos.close();
        fos.close();


  }

    public static void main(String[] args) throws IOException {
        File path = new File("C:\\Users\\hp\\Documents\\TEXT\\ultrasonic based.docx");
        method(path);
    }
}
