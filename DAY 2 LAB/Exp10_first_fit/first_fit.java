package Exp10_first_fit;
import java.util.*;

public class first_fit {

    static void first_fit(int blocks[], int processes[], int n, int m){
        int allocation[] = new int[n];

        for (int i = 0;i<n;i++){
            allocation[i] = -1;
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(blocks[j] >= processes[i]){
                    allocation[i] = j;
                    blocks[j] = blocks[j] - processes[i];

                    break;
                }
            }
        }

        System.out.println(" Process_No    Process_Size    Block_Size");

        for(int i = 0;i<n;i++){
            System.out.print("\t" + (i+1) + "    ");
            System.out.print("\t     " + processes[i] + "    ");
            if(allocation[i] != -1){
                System.out.print("\t" + (allocation[i] + 1));
            }
            else{
                System.out.print("NOT ALLOCATED");
            }
            System.out.println();
        }
    }
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);

        int n,m;
        System.out.println("Enter Total no. of processes : ");
        n = sc.nextInt();

        System.out.println("Enter Total no. of blocks : ");
        m = sc.nextInt();

        int blocks[] = new int[m];
        int processes[] = new int[n];

        System.out.println("Enter Process Sizes : ");
        for(int i =0; i<n;i++){
            int x = sc.nextInt();
            processes[i] = x;
        }

        System.out.println("Enter Block Sizes : ");
        for(int i =0; i<m;i++){
            int x = sc.nextInt();
            blocks[i] = x;
        }

        first_fit(blocks, processes, n, m);
    }
}
