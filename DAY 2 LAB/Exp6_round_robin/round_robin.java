package Exp6_round_robin;
import java.util.*;

public class round_robin {
    static void find_waiting_time(int processes[], int n, int bt[], int wt[], int quantum){

        int rem_bt[] = new int[n];
        for (int i = 0 ; i < n ; i++)
            rem_bt[i] =  bt[i];
      
        int t = 0;

        while(true)
        {
            boolean done = true;
      
            for (int i = 0 ; i < n; i++)
            {
               
                if (rem_bt[i] > 0)
                {
                    done = false;
      
                    if (rem_bt[i] > quantum)
                    {
                        t += quantum;
      
                        rem_bt[i] -= quantum;
                    }
    
                    else
                    {
                        t = t + rem_bt[i];
      
                        wt[i] = t - bt[i];
                        rem_bt[i] = 0;
                    }
                }
            }
    
            if (done == true)
              break;
        }
    }

    static void find_turn_around_time(int processes[], int n, int bt[], int wt[], int tat[]){
        for(int i = 0; i<n; i++){
            tat[i] = bt[i] + wt[i];
        }
    }

    static void round_robin(int processes[], int n, int bt[], int quantum){

        int wt[] = new int[n];
        int tat[] = new int[n];

        int total_wt = 0;
        int total_tat = 0;

        find_waiting_time(processes,n,bt,wt,quantum);
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
        int quantum;

        System.out.println("Enter Time Quantum : ");
        quantum = sc.nextInt();

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

        
        round_robin(processes, n, bt, quantum);

        
    }
}
