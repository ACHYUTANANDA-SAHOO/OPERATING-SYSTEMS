package Exp11_Single_lvl_directory;
import java.util.*;

public class single_lvl_directory {

    static boolean file_exists(String x, String files[], int file_count){
        int found = 0;
        for(int i = 0;i < file_count; i++){
            if(x == files[i])
                found = 1;  
        }
        if(found == 1)
            return true;
        else 
            return false;
    }
    public static void main(String[] Args){
        Scanner sc  = new Scanner(System.in);

        String d_name;
        String files[] = new String[100];
        int choice;
        int file_count = -1;

        System.out.println("Enter Directory Name : ");
        d_name = sc.nextLine();

        while(true){
            System.out.println("Options : 1. CREATE A FILE | 2. DISPLAY | 3. EXIT");
            choice = sc.nextInt();

            if(choice == 1){
                System.out.println("Enter File Name :");
                String x = sc.next();
                if(file_exists(x,files,file_count) == false){
                    file_count = file_count + 1;
                    files[file_count] = x;
                }
                else{
                    System.out.println("File Already Exists. ");
                }
            }
            else if(choice == 2){
                System.out.println("\nFiles Present : \n");
                for(int i = 0;i<=file_count;i++){
                    System.out.println(files[i]);
                }
                System.out.println("\n");
            }
            else if(choice == 3){
                break;
            }


        }
    }
}
