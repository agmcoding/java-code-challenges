package packageFindPivotIndex;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {

//	Challenge:
//	
//	Given an array of integers nums, calculate the pivot index of this array.
//
//	The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of
//	all the numbers strictly to the index's right.
//
//	If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
//	This also applies to the right edge of the array.
//
//	Return the leftmost pivot index. If no such index exists, return -1.
//
//
//	Example 1:
//
//	Input: nums = [1,7,3,6,5,6]
//	Output: 3
//	Explanation:
//	The pivot index is 3.
//	Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
//	Right sum = nums[4] + nums[5] = 5 + 6 = 11
//	
//	Example 2:
//
//	Input: nums = [1,2,3]
//	Output: -1
//	Explanation:
//	There is no index that satisfies the conditions in the problem statement.
//	
//	Example 3:
//
//	Input: nums = [2,1,-1]
//	Output: 0
//	Explanation:
//	The pivot index is 0.
//	Left sum = 0 (no elements to the left of index 0)
//	Right sum = nums[1] + nums[2] = 1 + -1 = 0
//	 
//
//	Constraints:
//
//	1 <= nums.length <= 104
//	-1000 <= nums[i] <= 1000
  
  public static void main(String[] args) {

    int[] nums = { 1, 7, 3, 6, 5, 6 };
    
    System.out.println("With IntStream: " + pivotIndexWithIntStream(nums));
    System.out.println("With just for loops: " + pivotIndexJustWithForLoops(nums));
    System.out.println("Basic solution: " + pivotIndexBasicSolution(nums));
    System.out.println("Basic solution with different approach: " + pivotIndexBasicSolutionWithDifferentApproach(nums));
    
    /**
     * Output Result:
     * 
     * With IntStream: 3
     * With just for loops: 3
     * Basic solution: 3
     * Basic solution with different approach: 3
     */
    
  }
  
  
  /**
   * For this challenge, four solutions were made with different approaches.
   * The use of AtomicInteger class for operations with iterations inside a Lambda expression can be arbitrary,
   * as it may not work with good performance or when the order of elements in an array is important, 
   * and other arguments can be pointed.
   * 
   * Here are some interesting links about AtomicInteger use for Stream API and Lambda Expressions:
   * Link: https://stackoverflow.com/questions/28790784/java-8-preferred-way-to-count-iterations-of-a-lambda
   * Link: https://stackoverflow.com/questions/50977793/is-use-of-atomicinteger-for-indexing-in-stream-a-legit-way
   * Link: https://stackoverflow.com/questions/53329809/why-atomicinteger-based-stream-solutions-are-not-recommended
   */
  private static int pivotIndexWithIntStream(int[] nums) {

    if (nums == null || nums.length == 0) return -1;

    for (AtomicInteger index = new AtomicInteger(0); index.intValue() < nums.length; index.getAndIncrement()) {

      AtomicInteger sumOfTheLeft = new AtomicInteger(0);
      AtomicInteger sumOfTheRight = new AtomicInteger(0);

      IntStream.range(0, index.intValue()).forEach(i -> sumOfTheLeft.getAndAdd(nums[i]));
      IntStream.range(index.intValue() + 1, nums.length).forEach(i -> sumOfTheRight.getAndAdd(nums[i]));

      if (sumOfTheLeft.intValue() == sumOfTheRight.intValue()) return index.intValue();
      
    }
    
    return -1;
  }
  
  
  
  private static int pivotIndexJustWithForLoops(int[] nums) {
    
    if (nums == null || nums.length == 0) return -1;
    
    for (int index = 0; index < nums.length; index++) {
      
      int sumOfTheLeft = 0;
      int sumOfTheRight = 0;
      
      for (int leftNumber = 0; leftNumber < index; leftNumber++) { sumOfTheLeft += nums[leftNumber]; }
      for (int rightNumber = index + 1; rightNumber < nums.length; rightNumber++) { sumOfTheRight += nums[rightNumber]; }

      if (sumOfTheLeft == sumOfTheRight) return index;
    }
    return -1;
  }

  
  
  private static int pivotIndexBasicSolution(int[] nums) {

    if (nums == null || nums.length == 0) return -1;

    int total = 0;
    for (int values: nums) { total += values; }
    int sum = 0;

    for (int index = 0; index < nums.length; sum += nums[index++]) {
      
      if (sum * 2 == total - nums[index]) return index;
      
    }
    return -1;
  }
  
  
  
  private static int pivotIndexBasicSolutionWithDifferentApproach(int[] nums) {
    
    if (nums == null || nums.length == 0) return -1;

    AtomicInteger sumOfTheRight = new AtomicInteger(0);
    Arrays.stream(nums, 1, nums.length).forEach(value -> sumOfTheRight.getAndAdd(value));
    int sumOfTheLeft = 0;

    for (int index = 0; index < nums.length; index++) {

      if (sumOfTheLeft == sumOfTheRight.intValue()) return index;

      sumOfTheLeft += nums[index];
      if (index + 1 >= nums.length) return -1;
      sumOfTheRight.set(sumOfTheRight.intValue() - nums[index + 1]);

    }

    return -1;
  }
  
}
