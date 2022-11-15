package codeFiles;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Decompress {
    public static void method(File file) throws IOException {

        String fileDirectory = file.getParent();
        FileInputStream finput = new FileInputStream(file);

        GZIPInputStream gzips = new GZIPInputStream(finput);
        FileOutputStream fout = new FileOutputStream(fileDirectory+"\\decompressed.txt");

        byte [] buffer = new byte[1024];
        int len;
        while((len=gzips.read(buffer)) != -1){
            fout.write(buffer,0,len);
        }
        gzips.close();
        finput.close();
        fout.close();

        //System.out.println(fileDirectory);
    }

    public static void main(String[] args) throws IOException {
        File path = new File("\\C:\\Users\\hp\\Documents\\TEXT\\compressedfile.gz");
        method(path);
    }
}
