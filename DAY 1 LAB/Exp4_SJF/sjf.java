// 4. Construct a scheduling program with C that selects the waiting process with the smallest execution time to execute next.

package Exp4_SJF;
import java.util.*;


public class sjf {
  
    static void find_waiting_time(int processes[], int n, int bt[], int wt[]){
        wt[0] = 0;

        for(int i = 1; i<n;i++){
            wt[i] = bt[i-1] + wt[i-1];
        }
    }

    static void find_turn_around_time(int processes[], int n, int bt[], int wt[], int tat[]){
        for(int i = 0; i<n; i++){
            tat[i] = bt[i] + wt[i];
        }
    }

    static void SJF(int processes[], int n, int bt[]){

        int temp;
        // Sorting processes based on BT.
        for(int i = 0;i<n;i++){
            for(int j = i+1 ; j< n ;j++){
                if(bt[i] >= bt[j]){
                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;

                    temp = processes[i];
                    processes[i] = processes[j];
                    processes[j] = temp; 
                }
            }
        }

        int wt[] = new int[n];
        int tat[] = new int[n];

        int total_wt = 0;
        int total_tat = 0;

        find_waiting_time(processes,n,bt,wt);
        find_turn_around_time(processes,n,bt,wt,tat);

        System.out.println("PROCESSES    BURST TIME    WAITING TIME    TAT");

        for(int i = 0;i<n;i++){
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];

            System.out.printf(" %d           ", processes[i]);
            System.out.printf("    %d        ", bt[i]);
            System.out.printf("    %d        ", wt[i]);
            System.out.printf("    %d", tat[i]);
            System.out.printf("\n");

        }
    }

    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Total no. of processes : ");
        int n = sc.nextInt();

        int processes[] = new int[n];
        int bt[] = new int[n];

        System.out.println("Enter The process-IDs : ");
        for(int i = 0; i<n; i++){
            int x = sc.nextInt();
            processes[i] = x;
        }

        System.out.println("Enter Burst time of processes : ");
        for(int i = 0; i<n; i++){
            int x = sc.nextInt();
            bt[i] = x;
        }

        
        SJF(processes, n, bt);

        
    }
}
