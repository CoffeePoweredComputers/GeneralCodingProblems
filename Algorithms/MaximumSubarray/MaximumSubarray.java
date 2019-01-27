//
//
//THIS IS A JAVA IMPLEMENTATION OF THE MAXIMUM SUBARRAY PROBLEM FROM:
//	INTRODUCTION TO ALGORITHMS: CHAPTER 2 - DIVIDE AND CONQUER 
//
//

import java.util.Random;
import java.lang.Math;

class MaximumSubarray{

	//Return Values:
	//a[0]: max-left
	//a[1]: max-right
	//a[2]: left-sum + right-sum
	static public int [] findMaxCrossingSubarray(int[] a, int low, int mid, int high){
		
		//we got some values up in here
		int left_sum = Integer.MAX_VALUE;
		int right_sum = Integer.MIN_VALUE;
		int sum = 0;
		int max_left = 0; 
		int max_right = 0;
		int [] return_vals = new int[3];


		//go from mid down ta low
		for(int i = mid; i > low; i--){
			sum += a[i];
			if(sum > left_sum){
				left_sum = sum;
				max_left = i;
			}
		}

		//go from mid up to high
		sum = 0;
		for(int j = mid; j < high; j++){
			sum += a[j];
			if(sum > right_sum){
				right_sum = sum;
				max_right = j;
			}	
		}

		//return the values that were requested b'th
		return_vals[0] = max_left;
		return_vals[1] = max_right;
		return_vals[2] = left_sum + right_sum;
		return return_vals;

	}

	static public int [] findMaxSub(int [] a, int low, int high){

		if(low == high){
			int [] return_val = {low,high,a[low]};
			return return_val;
		} else{
			int mid = (int)Math.floor((low + high)/2);

			//This returns the following:
			//a[0]: left-low
			//a[1]: left-high
			//a[2]: left-sum
			int [] left = findMaxSub(a,low,mid);

			//THis returns the following:
			//a[0]: right-low
			//a[1]: right-high
			//a[2]: right-sum
			int [] right = findMaxSub(a,mid + 1, high);

			//This returns the following:
			//a[0]: cross-low
			//a[1]: cross-high
			//a[2]: cross-sum
			int [] cross = findMaxCrossingSubarray(a, low,mid,high);

			//and do some tests to see if we have anything to return yet
			if(left[2] >= right[2] && left[2] >= cross[2]){
				return left;	
			} else if(right[2] >= left[2] && right[2] >= cross[2]){
				return right;
			} else {
				return cross;
			}
		}

	}

	static public void main(String [] args){

		//generate an array
		int [] rand_arr = new int[150];
		Random rand = new Random(System.currentTimeMillis());
		for(int i = 0; i < rand_arr.length; i++){
			rand_arr[i] = rand.nextInt(1000);
		}

		//print it 
		System.out.print("A = [ ");
		for(int n: rand_arr){
			System.out.printf(" %d ",n);
		}
		System.out.println("]");

		//get the array of differences
		for(int i = 1; i < rand_arr.length; i++){
			rand_arr[i] = rand_arr[i] - rand_arr[i - 1];
		}
		
		//print it 
		System.out.print("A' = [ ");
		for(int n: rand_arr){
			System.out.printf(" %d ",n);
		}
		System.out.println("]");

		//pass it to the algorithm to compute the optimum buy/sell date
		int [] results = findMaxSub(rand_arr,0,rand_arr.length-1);


		//print the results
		System.out.printf("Buy: %d\nSell: %d\nSum: %d\n",results[0],results[1],results[2]);
	}
}
