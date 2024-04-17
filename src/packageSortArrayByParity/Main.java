package packageSortArrayByParity;

import java.util.stream.IntStream;

public class Main {

//	Challenge:
//	
//	Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
//
//	Return any array that satisfies this condition.
//
//	
//	Example 1:
//
//	Input: nums = [3,1,2,4]
//	Output: [2,4,3,1]
//	Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
//	
//	Example 2:
//
//	Input: nums = [0]
//	Output: [0]
//	 
//
//	Constraints:
//
//	1 <= nums.length <= 5000
//	0 <= nums[i] <= 5000
  
  public static void main(String[] args) {

    int[] nums = {3,1,2,4};
    
    sortArrayByParity(nums);
    
    IntStream.of(nums).forEach(num -> System.out.print(num + ", "));
    
    /**
     * Output Result:
     * 
     * 2, 4, 3, 1, 
     */
  }

  static int[] sortArrayByParity(int[] nums) {
    
    if (nums == null || nums.length == 0) {
      return nums;
    }

    int countOddNumbers = 0;
    int temporaryOddNumber = 0;
    for (int i = 0; i < nums.length; i++) {
      
      if (nums[i] % 2 == 1) countOddNumbers++;
      
      else {
        if (countOddNumbers == 0) continue;
        temporaryOddNumber = nums[i - countOddNumbers];
        nums[i - countOddNumbers] = nums[i]; // Allocating even numbers to the left
        nums[i] = temporaryOddNumber; // Allocating odd numbers to the right.
      }
    }
    
    return nums;
  }

}
