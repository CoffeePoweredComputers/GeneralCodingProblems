import java.util.*;
import java.io.*;

class KthSmallestElement{

    public static int getKthSmallestElement(int[] arr, int k, int i){
        
        //if the median is smaller than the desired element then go right

        //if the median is lerger than the desired element then go left





        return min;
    }

    public static void main(String[] args){

        Random rand = new Random();

        //generate an array of 50 random elements
        int[] rand_arr = new int[50];
        for(int i = 0; i < rand_arr.length; i++){
            int new_int = rand.nextInt(50);
            rand_arr[i] = new_int;
        }

        //output that array
        System.out.printf("Initial array: [ ");
        for(int num: rand_arr){
            System.out.printf("%d, ",num);
        }
        System.out.println("]");



        // Get the 3rd, 5th and 17th smallest elements
        int median_index = 0;
        System.out.printf("The 3rd smallest element is %d\n",getKthSmallestElement((int[])rand_arr, 3, median_index));
        System.out.printf("The 5th smallest element is %d\n",getKthSmallestElement((int[])rand_arr, 5, median_index));
        System.out.printf("The 17th smallest element is %d\n",getKthSmallestElement((int[])rand_arr, 17, median_index));
        

    }

}