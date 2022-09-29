#include<stdio.h>
#include<conio.h>

int main(){
    int max[10][10], need[10][10], alloc[10][10], avail[10], completed[10], safe_sequence[10];
    int p, r, j, i , process, count;

    count = 0;

    printf("Enter No. of processes : ");
    scanf("%d", &p);

    printf("Enter no. of resources : ");
    scanf("%d", &r);

    for(int i = 0;i<p;i++){
        completed[i] = 0;
    }

    printf("Enter Maximum Matrix : \n");
    for(int i = 0;i<p;i++){
        for(int j=0;j<r;j++){
            scanf("%d", &max[i][j]);
        }
    }

    printf("Enter Allocation Matrix : \n");
    for(int i=0;i<p;i++){
        for(int j = 0;j<r;j++){
            scanf("%d", &alloc[i][j]);
        }
    }

    printf("Enter the available resources : ");
    for(int i= 0;i<r; i++){
        scanf("%d", &avail[i]);
    }

    for(int i = 0;i <p;i++){
        for(int j = 0;j<r;j++){
            need[i][j] = max[i][j] - alloc[i][j];
        }
    }

    do{
        printf("\n Max Matrix : \tAllocation Matrix: \n");
        for(int i = 0; i<p;i++){
            for(int j = 0;j<r;j++){
                printf("%d  ",max[i][j]);
            }
            printf("\t\t");
            for(int j = 0;j<r;j++){
                printf("%d  ",alloc[i][j]);
            }
            printf("\n");
        }
        process = -1;

        for(int i = 0;i<p;i++){
            if(completed[i] == 0){
                process = i;
                for(j = 0;j<r;j++){
                    if(avail[j] < need[i][j]){
                        process = -1;
                        break;
                    }
                }
            }
            if(process != -1){
                break;
            }
        }
        if(process != -1){
            printf("\n Process %d runs into completion !", process + 1);

            safe_sequence[count] = process + 1;
            count++;
            for(int j = 0; j< r; j++){
                avail[j] += alloc[process][j];
                alloc[process][j] = 0;
                max[process][i] = 0;
                completed[process] = 1;
            }
        }
    }while(count != p && process != -1);

    if(count == p){
        printf("\n The system is in a safe state !!");
        printf("Safe Sequence : < ");
        for(int i = 0; i<p;i++){
            printf("%d  ", safe_sequence[i]);
        }
        printf(">\n");
    }
    else{
        printf("The system is in the unsafe state !!");
    }

    return 0;
}