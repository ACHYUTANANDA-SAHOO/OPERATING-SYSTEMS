// 22. Construct a C program to simulate the First Come First Served disk scheduling algorithm.  
#include<stdio.h>
int main(){
    int n,head;

    printf("Enter No. of I/O request : ");
    scanf("%d", &n);
    printf("Enter Current head position : ");
    scanf("%d",&head);

    int arr[n];
    printf("Enter I/O request Sequence : \n");
    for(int i = 0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    // printing FCFS sequence : -
    printf("FCFS Sequence : ");
    printf("%d ---> ", head);
    for(int i = 0;i<n;i++){
        printf("%d ---> ", arr[i]);
    }

    // finding and displaying seek time : -
    int seek_time;
    if(arr[0] > head){
        seek_time = arr[0] - head;
    }
    else
        seek_time = head - arr[0];

    int x;
    for(int i = 0;i<n-1;i++){
        x = arr[i+1] - arr[i];
        if(x < 0){
            x*=-1;
        }
        seek_time+=x;
    }

    printf("\n SEEK TIME : %d", seek_time);


}