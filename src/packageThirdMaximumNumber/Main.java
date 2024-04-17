package packageThirdMaximumNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    System.out.print("With a List: ");

    List<Integer> nums = new ArrayList<>(Arrays.asList(2, 2, 3, 1));
    System.out.println(MaxNumberByPositionWithList(nums, 3));
    
    System.out.print("Now with a primitive data type array: ");

    int[] numsPrimitiveArray = { 2, 2, 3, 1};
    System.out.println(MaxNumberByPositionWithPrimitiveArray(numsPrimitiveArray, 3));
    
    /**
     * With a List: 1
     * Now with a primitive data type array: 1
     */
    
  }

  
  /**
   * Finds a distinct maximum integer number in a array, according to the position passed.
   * For finding the third distinct maximum number, pass maxWantedPosition as 3.
   * If the maxWantedPosition does not exist in the array, the maximum number is returned instead.
   */
  private static int MaxNumberByPositionWithList(List<Integer> nums, int maxWantedPosition) {
    
    Optional<List<Integer>> maybeNullNums = Optional.ofNullable(nums);
    if (maybeNullNums.isEmpty()) return -1;
    
    List<Integer> numsSorted = new ArrayList<>(nums);
    Collections.sort(numsSorted); // all max values should be shifted to the right.
    
    int currentMaximumNumber = Collections.max(numsSorted);
    int MaxNumbersFound = 1;
    int index = numsSorted.size() - 2; // the index will start close to the end of the array and then decrease.
    
    while (MaxNumbersFound < maxWantedPosition && index >= 0) {
      
      if (numsSorted.get(index) < numsSorted.get(index + 1)) {
        ++MaxNumbersFound;
        currentMaximumNumber = (MaxNumbersFound == maxWantedPosition) ? numsSorted.get(index) : currentMaximumNumber;
      }
        
      index--;
    }
    
    return currentMaximumNumber;
  }



  private static int MaxNumberByPositionWithPrimitiveArray(int[] nums, int maxWantedPosition) {
    
    if (nums == null || nums.length == 0) return -1;
        
    int[] numsSorted = nums.clone();
        Arrays.sort(numsSorted); // all max values should be shifted to the right.
        
        int currentMaximumNumber = numsSorted[numsSorted.length - 1];
        int MaxNumbersFound = 1;
        int index = numsSorted.length - 2; // the index will start close to the end of the array and then decrease.
        
        while (MaxNumbersFound < maxWantedPosition && index >= 0) {
            
            if (numsSorted[index] < numsSorted[index + 1]) {
                ++MaxNumbersFound;
                currentMaximumNumber = (MaxNumbersFound == maxWantedPosition) ? numsSorted[index] : currentMaximumNumber;
            }
            
            index--;
        }
        return currentMaximumNumber;
  }

}
