package packageFindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

//	Challenge:
//	
//	Given an array nums of n integers where nums[i] is in the range [1, n], 
//	return an array of all the integers in the range [1, n] that do not appear in nums.
//
//			 
//	Example 1:
//
//	Input: nums = [4,3,2,7,8,2,3,1]
//	Output: [5,6]
//			
//	Example 2:
//
//	Input: nums = [1,1]
//	Output: [2]
//
//	Constraints:
//
//	n == nums.length
//	1 <= n <= 105
//	1 <= nums[i] <= n

  public static void main(String[] args) {

    int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };

    List<Integer> numsList = findDisappearedNumbers(nums);
    numsList.forEach(num -> System.out.print(num + ", "));

    /**
     * Output Result:
     * 
     * 5, 6,
     */

  }

  private static List<Integer> findDisappearedNumbers(int[] nums) {

    if (nums == null || nums.length == 0) {
      return Collections.emptyList(); // At business definition discretion.
    }

    List<Integer> numsList = IntStream.of(nums).boxed().collect(Collectors.toList());
    List<Integer> disappearedNumsList = new ArrayList<>();

    for (int i = 1; i <= numsList.size(); i++) {
      if (!numsList.contains(i)) {
        disappearedNumsList.add(i);
      }
    }

    return disappearedNumsList;
  }

}
