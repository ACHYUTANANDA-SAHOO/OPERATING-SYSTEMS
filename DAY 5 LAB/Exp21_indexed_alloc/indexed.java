package Exp21_indexed_alloc;
import java.util.*;

public class indexed {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);

        String files[] = new String[100];
        int sizes[] = new int[100];
        int start_ad[] = new int[100];
        int end_ad[] = new int[100];

        int i = 0;

        int directory_size = 50;
        int file_count = 0;
        int directory[] = new int[directory_size];
        
        String f_name;

        while(true){
            System.out.println("Enter Choice | 1. Create File | 2. DISPLAY FILES | 3. DISPLAY ALL | 4. EXIT | \n");
            int choice = sc.nextInt();

            if(choice == 1){
                System.out.println("Enter File Name : ");
                String x = sc.next();
                files[i] = x;

                System.out.println("Enter File Size : ");
                sizes[i] = sc.nextInt();

                System.out.println("Enter Starting Address : ");
                int z = sc.nextInt();

                if(directory[z] == -1 || z > directory_size){
                    System.out.println(("File Cannot be allocated."));
                }

                else {
                    start_ad[i] = z;

                    end_ad[i] = start_ad[i] + sizes[i];
                    for(int k = start_ad[i]; k<end_ad[i]; k++ ){
                        directory[k] = 1;
                    }
                    file_count+=1;

                    System.out.println("FILE ALLOCATED");
                }
                i+=1;
            }

            else if(choice == 2){
                System.out.println("Enter Starting Address : ");
                int z = sc.nextInt();

                for(int k = 0;k< start_ad.length;k++){
                    if(start_ad[k] == z){
                        System.out.println("File Found !!");
                        System.out.println("File name : " + files[k]);
                    }
                    else{
                        System.out.println("File Not Found !! ");
                    }
                }
            }
            else if(choice == 3){
                System.out.println("FILE NAME \t STARTING ADDRESS \t END_ADDRESS");
                for(int k = 0;k< file_count;k++){
                    System.out.println(files[k] + "\t\t" +  start_ad[k] + "\t\t\t" + end_ad[k]);
                }
            }

            else if(choice == 4){
                break;
            }

        }

    }
}
