// 23. Design a C program to simulate SCAN disk scheduling algorithm.
#include<stdio.h>

void sort_asc(int array[], int size){
    int temp;
    for(int i = 0;i<size;i++){
        for(int j = i+1;j<size;j++){
            if(array[i] > array[j]){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
}

void sort_desc(int array[], int size){
    int temp;
    for(int i = 0;i<size;i++){
        for(int j = i+1;j<size;j++){
            if(array[i] < array[j]){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
}

int main(){
    int n;
    printf("Enter total no.of I/O requests : ");
    scanf("%d",&n);

    int arr[n];

    printf("Enter I/O Requesst Sequence : \n ");
    for(int i = 0;i<n;i++){
        scanf("%d", &arr[i]);
    }

    int head;
    printf("Enter Head Pointer Position :  ");
    scanf("%d", &head);

    int first_cylinder,last_cylinder;
    printf("Enter First Cylinder : ");
    scanf("%d", &first_cylinder);
    printf("Enter Last Cylinder : ");
    scanf("%d", &last_cylinder);

    int l_arr[30], r_arr[30] ;
    int l_arr_s = 0, r_arr_s = 0;
    int k = 0, l=0;
    // finding no. of requests <= Head_position.
    for(int i = 0;i<n;i++){
        if(arr[i] < head){
            l_arr[k] = arr[i];
            k++;
            l_arr_s+=1;
        }
    }

    // finding no. of requests >= Head_position.
    for(int i = 0;i<n;i++){
        if(arr[i] > head){
            r_arr[l] = arr[i];
            l++;
            r_arr_s+=1;
        }
    }

    // sorting arrays : 
    sort_asc(r_arr,r_arr_s);
    sort_desc(l_arr,l_arr_s);

    while(1){
    printf("Enter choice : 1. Head towards greater value | 2. Head towards lower value \n");
    int choice;
    scanf("%d", &choice);

    
    printf("SCAN Sequence : \n");

    if(choice == 1){
        sort_asc(r_arr,r_arr_s);
        sort_desc(l_arr,l_arr_s);

        printf("%d --- > ", head);
        for(int i = 0;i<r_arr_s;i++){
            printf("%d ---> ", r_arr[i]);
        }

        printf(" %d ---> ", last_cylinder);

        for(int i = 0;i<l_arr_s;i++){
            printf("%d ---> ", l_arr[i]);
        }
    }
    else if(choice == 2){
        sort_asc(r_arr,r_arr_s);
        sort_desc(l_arr,l_arr_s);

        printf("%d --- > ", head);

        for(int i = 0;i<l_arr_s;i++){
            printf("%d ---> ", l_arr[i]);
        }

        printf("%d ---> ", first_cylinder);

        for(int i = 0;i<r_arr_s;i++){
            printf("%d ---> ", r_arr[i]);
        }
    }
    }

    return 0;
}