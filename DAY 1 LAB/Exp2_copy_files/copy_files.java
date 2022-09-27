package Exp2_copy_files;

import java.util.*;
import java.io.*;

public class copy_files {

    public static void copyContent(File a, File b) throws Exception {
        FileInputStream in = new FileInputStream(a);
        FileOutputStream out = new FileOutputStream(b);

        int n;
        while((n = in.read()) != -1){
            out.write(n);
        }

        if (in != null){
            in.close();
        }
        if(out != null){
            out.close();
        }

        System.out.println("Files Copied. ");
    }
    public static void main(String[] Args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Source File Name : ");
        String file_a = sc.nextLine();

        File source = new File(file_a);

        System.out.println("Enter Source File Name : ");
        String file_b = sc.nextLine();

        File destination = new File(file_b);

        copyContent(source,destination);


    }
}
