#include<stdio.h>

int check_presence(int goal, int arr[], int size){
    for(int i = 0;i<size;i++){
        if(goal == arr[i])
            return 1;
    }
    return 0;
}

int print_page_frame(int arr[], int size){
    for(int i = 0; i<size;i++){
        printf("%d \t", arr[i]);
    }
}

int find_LRU(int arr[], int s){
    int minimum = arr[0];
    for(int i = 0;i<s;i++){
        if(arr[i] < minimum)
            minimum = arr[i];
    }
    return minimum;
}

int main(){
    int f;
    printf("Enter Frame Size : ");
    scanf("%d", &f);
    int frame[f];

    int r;
    printf("Enter Size of Reference String : ");
    scanf("%d", &r);

    int ref_str[r];

    printf("Enter Reference String : \n");
    for(int i = 0;i<r;i++){
        scanf("%d", &ref_str[i]);
    }

    int time[f];
    for(int i = 0;i<f;i++){
        time[i] = 0;
    }
    for(int i = 0; i<f;i++){
        frame[i] = -1;
    }

    int page_ptr = -1;
    int count = 0;
    int hits = 0;
    int misses = 0;
    int t = 0;
    int negatives = f;

    print_page_frame(frame,f);
    printf("\n");

    while(count < r){
        if(negatives != 0){
            page_ptr = page_ptr + 1;

            if (check_presence(ref_str[count],frame,f) == 1){
                print_page_frame(frame,f);
                printf(" \t ----- HIT \n");
                page_ptr-=1;
                time[page_ptr-1]= count;
                hits+=1;
            }
            else if(check_presence(ref_str[count],frame,f) == 0){
                frame[page_ptr] = ref_str[count];
                time[page_ptr] = count;
                print_page_frame(frame,f);
                printf(" \t ----- MISS \n");
                negatives-=1;
                misses+=1;
            }
            
        }
        else{
            page_ptr = find_LRU(time,f);

            if (check_presence(ref_str[count],frame,f) == 1){
                print_page_frame(frame,f);
                printf(" \t ----- HIT \n");
                time[page_ptr-1]= count;
                hits+=1;
            }
            else if(check_presence(ref_str[count],frame,f) == 0){
                frame[page_ptr] = ref_str[count];
                time[page_ptr] = count;
                print_page_frame(frame,f);
                printf(" \t ----- MISS \n");
                negatives-=1;
                misses+=1;
            }
        }
        print_page_frame(time,f);
        printf("\n");
        count = count + 1;
    }
    printf("\nNo of Hits = %d \n", hits);
    printf("No. Of Misses = %d \n", misses);
}
