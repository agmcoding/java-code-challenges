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
//
//	Example 2:
//
//	Input: nums = [1,1,1,1,1]
//	Output: [1,2,3,4,5]
//	Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
//
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

		System.out.print("\n\nWith 'Arrays.parallelPrefix()' method: ");

		int[] nums2 = { 3, 1, 2, 10, 1 };
		Arrays.stream(runningSumWithArraysParallelPrefix(nums2))
		.forEach(value -> System.out.print(value + ", "));

		System.out.print("\n\nNow just using for loop and modifying the input Array: ");

		runningSumInPlace(nums);
		Arrays.stream(nums).forEach(value -> System.out.print(value + ", "));

		/** 
		 * Output Result:
		 *
		 * With Stream API: 3, 4, 6, 16, 17, 
		 *
		 * With 'Arrays.parallelPrefix()' method: 3, 4, 6, 16, 17, 
		 *
		 * Now just using for loop and modifying the input Array: 3, 4, 6, 16, 17, 
		 */

	}



	/**
	 * Explanation for these {@code Stream API} methods:<br>
	 * 
	 * <p>We use {@code range()} method from {@code IntStream} interface to create
	 * indexes from {@code  1} to {@code nums.length}<br>
	 * (similar to a for loop, but with many utility methods).
	 * 
	 * <p>The {@code  map()} method will change the values from the <b>runningSumArray</b> 
	 * according to the given function that is passed.<br>
	 * 
	 * <p>The {@code toArray()} method will return an {@code int} array containing the elements of this stream.
	 * 
	 * @param nums the array to be copied and to be performed a running sum
	 * @return an array containing a running sum from the <b>nums</b> provided.<br>
	 * 		   If the <b>nums</b> array is null or contains no elements, an array with a value of {@code -1} is returned instead
	 */
	private static int[] runningSumWithStreamAPI(int[] nums) {

		if (nums == null || nums.length == 0) {
			int[] responseForNull = { -1 };
			return responseForNull;
		}

		int[] runningSumArray = nums.clone();

		IntStream.range(1, nums.length).map(index -> runningSumArray[index] += runningSumArray[index - 1]).toArray();
		return runningSumArray;
	}


	/**
	 * In this use case, maybe it is not the best method since the <b>nums</b> array
	 * has a small length.
	 * 
	 * <p>As the {@link Arrays#parallelPrefix(int[], java.util.function.IntBinaryOperator) documentation} states:
	 * <i>Parallel prefix computation is usually more efficient than sequential loops for large arrays.</i>
	 *  
	 * @param nums the array, which is cloned to make a running sum of it
	 * @return an array containing a running sum from the <b>nums</b> provided.<br>
	 * 		   If the <b>nums</b> array is null or contains no elements, an array with a value of {@code -1} is returned instead
	 */
	private static int[] runningSumWithArraysParallelPrefix(int[] nums) {

		if (nums == null || nums.length == 0) {
			int[] responseForNull = { -1 };
			return responseForNull;
		}

		int[] runningSumArray = nums.clone();
		Arrays.parallelPrefix(runningSumArray, (left, right) -> right += left);

		return runningSumArray;
	}



	//  Modifying the Input Array with a for loop
	private static void runningSumInPlace(int[] nums) {
		
		if (nums == null || nums.length == 0) return;
		
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}
	}

}
