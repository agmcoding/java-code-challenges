package packageThirdMaximumNumber;

import java.util.Arrays;

public class Main {

//	Challenge:
//	
//	Given an integer array nums, return the third distinct maximum number in this array.
//	If the third maximum does not exist, return the maximum number.
//			 
//
//	Example 1:
//
//	Input: nums = [3,2,1]
//	Output: 1
//	Explanation:
//	The first distinct maximum is 3.
//	The second distinct maximum is 2.
//	The third distinct maximum is 1.
//	
//	Example 2:
//
//	Input: nums = [1,2]
//	Output: 2
//	Explanation:
//	The first distinct maximum is 2.
//	The second distinct maximum is 1.
//	The third distinct maximum does not exist, so the maximum (2) is returned instead.
//	
//	Example 3:
//
//	Input: nums = [2,2,3,1]
//	Output: 1
//	Explanation:
//	The first distinct maximum is 3.
//	The second distinct maximum is 2 (both 2's are counted together since they have the same value).
//	The third distinct maximum is 1.
//			 
//
//	Constraints:
//
//	1 <= nums.length <= 104
//	-231 <= nums[i] <= 231 - 1
	
	public static void main(String[] args) {

		int[] nums = {2,2,3,1};
		
		System.out.println(thirdMax(nums));
		
	}

	
	private static int thirdMax(int[] nums) {
		
		if (nums == null || nums.length == 0) return -1;
        
        Arrays.sort(nums); // all max values should be shifted to the right.
        
        int maxValuesFound = 1;
        /* the index will start close to the end of the array and then decrease. */
        int index = nums.length - 2;
        int currentMaxValue = nums[nums.length - 1];
        
        while (maxValuesFound < 3 && index >= 0) {
            
            if (nums[index] < nums[index + 1]) {
                ++maxValuesFound;
                currentMaxValue = maxValuesFound == 3 ? nums[index] : currentMaxValue;
            }
            
            index--;
        }
        return currentMaxValue;
	}

}
