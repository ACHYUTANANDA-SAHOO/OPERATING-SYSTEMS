package Exp13_random_access_file;
import java.util.*;
import java.io.*;

public class random_access{

    static final String FILEPATH = "a.txt";

    public static byte[] read_from_file(String path, int pos, int size) throws IOException{
        RandomAccessFile file = new RandomAccessFile(path, "r");
        file.seek(pos);
        byte[] bytes = new byte[size];
        file.read(bytes);
        file.close();
        return bytes;
    }

    public static void write_to_file(String path, String data, int pos) throws IOException{
        RandomAccessFile file = new RandomAccessFile(path, "rw");
        file.seek(pos);
        file.write(data.getBytes());
        file.close();
    }
    public static void main(String[] Args){
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("RANDOM ACCESS FILE : A.TXT : -");
            System.out.println("READING FROM FILE : -");
            System.out.println(new String(read_from_file(FILEPATH,0,18)));

            String data;
            System.out.println("Enter a Sting to Update : ");
            data = sc.nextLine();

            write_to_file(FILEPATH, data, 31);
            System.out.println("FILE UPDATED");

        } 
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}