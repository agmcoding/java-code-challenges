package packageRunningSumOf1dArray;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

//	Challenge:
//	
//	Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//
//	Return the running sum of nums.
//
//	Example 1:
//
//	Input: nums = [1,2,3,4]
//	Output: [1,3,6,10]
//	Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
	
//	Example 2:
//
//	Input: nums = [1,1,1,1,1]
//	Output: [1,2,3,4,5]
//	Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
	
//	Example 3:
//
//	Input: nums = [3,1,2,10,1]
//	Output: [3,4,6,16,17]
//			 
//
//	Constraints:
//
//	1 <= nums.length <= 1000
//	-10^6 <= nums[i] <= 10^6
	
	public static void main(String[] args) {

		System.out.print("With Stream API: ");
		
		int[] nums = { 3, 1, 2, 10, 1 };
		Arrays.stream(runningSumWithStreamAPI(nums))
		.forEach(value -> System.out.print(value + ", "));

		System.out.print("\nNow modifying the Input Array: ");

		runningSumModifyingInputArray(nums);
		Arrays.stream(nums).forEach(value -> System.out.print(value + ", "));
		
		/** 
		 * Output Result:
		 *
		 * With Stream API: 3, 4, 6, 16, 17, 
		 * Now modifying the Input Array: 3, 4, 6, 16, 17, 
		 */
		
	}
	
	
	
	private static int[] runningSumWithStreamAPI(int[] nums) {
		
		if (nums == null || nums.length == 0) {
			int[] responseForNull = {-1};
			return responseForNull;
		}
		
		int[] runningSumArray = nums.clone();
		
		/**
		 * Explanation for these Stream API methods:
		 * 
		 * We use range() method from IntStream interface to create indexes from 1 to nums.length (almost like a for loop, just more optimized);
		 * The map() method will change the values from the runningSumArray according to the given function that we pass;
		 * The toArray() method will store the values with a primitive data type array (in this case an int[] array).
		 */
		IntStream.range(1, nums.length).map(index -> runningSumArray[index] += runningSumArray[index - 1]).toArray();
		return runningSumArray;
	}
	
	
	
	//  Modifying the Input Array
	private static void runningSumModifyingInputArray(int[] nums) {
		
		if (nums == null || nums.length == 0) return;
		
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}
	}
	
}
