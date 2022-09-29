#include<stdio.h>

int check_presence(int x, int page_frame[], int y){
    for(int i = 1; i<=y; i++){
        if(x == page_frame[i]){
            return 1;
        }
    }
    return 0;
}

void print_page_frame(int page_frame[], int frame_size){
    for(int i = 1;i<=frame_size;i++){
        printf("%d \t", page_frame[i]);
    }
}

int main(){
    
    printf("Enter Frame Size : ");
    int frame_size;
    scanf("%d", &frame_size);

    int page_frame[frame_size + 1];


    printf("Reference String Size : ");
    int ref_size;
    scanf("%d", &ref_size);

    int ref_str[ref_size + 1];
    printf("Enter Reference String : ");
    for(int i = 1;i<=ref_size;i++){
        scanf("%d", &ref_str[i]);
    }

    for(int i = 0; i<=frame_size;i++){
        page_frame[i] = -1;
    }

    int page_ptr = 0;

    int count = 1;
    int hits = 0;
    int misses = 1;

    print_page_frame(page_frame,frame_size);
    printf("\n");

    while(count <= ref_size){
        
        page_ptr = page_ptr + 1;
        
        
        if(page_ptr > frame_size){
            page_ptr = 1;
        }
        if (check_presence(ref_str[count],page_frame,frame_size) == 1){
            print_page_frame(page_frame,frame_size);
            printf(" \t ----- HIT \n");
            page_ptr-=1;
            hits+=1;
        }
        else if(check_presence(ref_str[count],page_frame,frame_size) == 0){
            page_frame[page_ptr] = ref_str[count];
            print_page_frame(page_frame,frame_size);
            printf(" \t ----- MISS \n");
            misses+=1;
        }

        count = count + 1 ;
        
    }

    printf("\nNo of Hits = %d \n", hits);
    printf("No. Of Misses = %d \n", misses);

    // return 0;

}