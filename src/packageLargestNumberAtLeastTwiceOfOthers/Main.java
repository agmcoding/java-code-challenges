package packageLargestNumberAtLeastTwiceOfOthers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

//	Challenge:
//	
//	You are given an integer array nums where the largest integer is unique.
//
//	Determine whether the largest element in the array is at least twice as much as every other number in the array. 
//	If it is, return the index of the largest element, or return -1 otherwise.
//
//	 
//	Example 1:
//
//	Input: nums = [3,6,1,0]
//	Output: 1
//	Explanation: 6 is the largest integer.
//	For every other number in the array x, 6 is at least twice as big as x.
//	The index of value 6 is 1, so we return 1.
//			
//	Example 2:
//
//	Input: nums = [1,2,3,4]
//	Output: -1
//	Explanation: 4 is less than twice the value of 3, so we return -1.
//	 
//
//	Constraints:
//
//	2 <= nums.length <= 50
//	0 <= nums[i] <= 100
//	The largest element in nums is unique.
  
  public static void main(String[] args) {

    int[] nums = { 3, 6, 1, 0 };
    
    System.out.println("The dominant index of the array is: " + dominantIndex(nums));
    
    /**
     * Output Result:
     * 
     * The dominant index of the array is: 1
     */
    
  }

  private static int dominantIndex(int[] nums) {

    if (nums == null || nums.length <= 1) return -1;

    List<Integer> numsList = extractedToList(nums);
    
    int highestElement = Collections.max(numsList);
    Collections.sort(numsList);
    numsList.remove(numsList.get(numsList.size() - 1));

    boolean allMatch = numsList.stream().allMatch(value -> highestElement >= 2 * value);

    if (allMatch) return extractedToList(nums).indexOf(highestElement);
    
    return -1;
  }

  private static List<Integer> extractedToList(int[] nums) {
    return Arrays.stream(nums).boxed().collect(Collectors.toList());
  }
  
}
