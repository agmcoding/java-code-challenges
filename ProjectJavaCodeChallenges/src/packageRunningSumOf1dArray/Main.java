package packageRunningSumOf1dArray;

public class Main {

//	Challenge:
//	
//	Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//
//			Return the running sum of nums.
//
//			Example 1:
//
//			Input: nums = [1,2,3,4]
//			Output: [1,3,6,10]
//			Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
	
//			Example 2:
//
//			Input: nums = [1,1,1,1,1]
//			Output: [1,2,3,4,5]
//			Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
	
//			Example 3:
//
//			Input: nums = [3,1,2,10,1]
//			Output: [3,4,6,16,17]
//			 
//
//			Constraints:
//
//			1 <= nums.length <= 1000
//			-10^6 <= nums[i] <= 10^6
	
	public static void main(String[] args) {
		int[] nums = {3,1,2,10,1};
		
		int[] runningSumArray = runningSum(nums);
		for (int i: runningSumArray) {
			System.out.print(i + ", ");
		}
		
		System.out.println("\nNow modifying the Input Array:");
		
		runningSumModifyingInputArray(nums);
		for (int i: nums) {
			System.out.print(i + ", ");
		}
		
		/* Output Result:
		 *
		 * 3, 4, 6, 16, 17, 
		 * Now modifying the Input Array:
		 * 3, 4, 6, 16, 17,
		 * 
		 */
		
	}
	
	// Without modifying the Input Array
	
	static int[] runningSum(int[] nums) {
    int[] runningSum = new int[nums.length]; // Created a new array

        runningSum[0] = nums[0];
        for ( int i = 1; i < nums.length; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }
        return runningSum;
    }

	
	//  Modifying the Input Array
	
	static int[] runningSumModifyingInputArray(int[] nums) {
		
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}
		return nums; // Used the same input array
	}
	
}