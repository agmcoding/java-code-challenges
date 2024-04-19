package packagesinglenumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {

    int[] nums = { 4, 1, 2, 1, 2 };

    System.out.print("Array example: [ ");
    Arrays.stream(nums).forEach(num -> System.out.print(num + ", "));
    System.out.println("]\nWith HashMap: " + singleNumber(nums));
    System.out.println("By sorting with Stream API sorted() method: " + singleNumberBySorting(nums));



    /**
     * Other array that repeat numbers more than twice:
     */
    int[] otherNums = { 1, 2, 4, 5, 5, 5, 30, 30, 30 };
    int lookForThisRepetitionCount = 3;

    System.out.print("\nWith an array of: [ ");
    Arrays.stream(otherNums).forEach(num -> System.out.print(num + ", "));
    System.out.print("]\nFinding all the numbers that repeated " + lookForThisRepetitionCount + " times: ");

    Arrays.stream(numbersThatMatchRepetitionCount(otherNums, lookForThisRepetitionCount))
        .forEach(number -> System.out.print(number + ", "));

    /**
     * Output Result:
     * 
     * Array example: [ 4, 1, 2, 1, 2, ]
     * With HashMap: 4
     * By sorting with Stream API sorted() method: 4
     *
     * With an array of: [ 1, 2, 4, 5, 5, 5, 30, 30, 30, ]
     * Finding all the numbers that repeated 3 times: 5, 30, 
     */

  }



  /**
   * Prevents constrains of the challenge.
   */
  private static boolean violateConstrains(int[] nums) {
    return (nums == null || nums.length < 1 || nums.length > 3 * (int) Math.pow(10, 4)
        || Arrays.stream(nums).anyMatch(value -> value < -30000 || value > 30000));
  }



  /**
   * Returns the single number present in the int array.
   * By using HashMap, it doesn't use constant space, 
   * corresponding to specific constrain of the challenge.
   * However, it shows another possible solution for this challenge.
   */
  private static int singleNumber(int[] nums) {

    /** Prevents constrains of the challenge. */
    if (violateConstrains(nums)) return -1; // At business definition discretion.

    Map<Integer, Integer> numsMap = new HashMap<>();

    Arrays.stream(nums)
        .forEach(value -> numsMap.put(value, (numsMap.get(value) == null) ? 1 : numsMap.get(value) + 1));

    Optional<Entry<Integer, Integer>> uniqueNumber = numsMap.entrySet().stream()
        .filter(entry -> entry.getValue() == 1).findFirst();

    return (uniqueNumber.isPresent()) ? uniqueNumber.get().getKey() : -1; // At business definition discretion.
  }



  /**
   * Returns the single number in the int array.
   * Caution: Targeted only for arrays that each element appears twice 
   * except for one element which appears only once.
   */
  private static int singleNumberBySorting(int[] nums) {
    
    /** Prevents constrains of the challenge. */
    if (violateConstrains(nums)) return -1; // At business definition discretion.

    int[] sortedNums = Arrays.stream(nums).sorted().toArray();

    for (int i = 0; i < sortedNums.length; i += 2) {
      if (i + 1 >= sortedNums.length) return sortedNums[i];
      if (sortedNums[i] != sortedNums[i + 1]) return sortedNums[i];
    }
    return -1; // At business definition discretion.
  }



  /**
   * Returns an int array with all the numbers that repeated 
   * the same amount of times requested from the 'repetitionCount' parameter.
   * If needed to find numbers that appeared just once, pass the second argument as 1.
   * 
   * Explanation:
   * 
   * With HashMap, stores the numbers found in the array as keys
   * and stores as values the amount of times the numbers were found.
   * Thus, by using filter() method from Stream API, filters the keys that have the requested repetition count.
   * Initially, the 'requestedRepetedNums' will be in this format:  key=value  (because of the use of entrySet() method).
   * For this reason, parses these keys and stores them into an int array.
   */
  private static int[] numbersThatMatchRepetitionCount(int[] nums, int repetitionCount) {

    /** Prevents constrains of the challenge. */
    int[] cannotFind = {-1}; // At business definition discretion.
    if (violateConstrains(nums) || 1 > repetitionCount) return cannotFind;

    Map<Integer, Integer> numsMap = new HashMap<>();

    Arrays.stream(nums)
        .forEach(value -> numsMap.put(value, (numsMap.get(value) == null) ? 1 : numsMap.get(value) + 1));

    Object[] requestedRepeatedNums = numsMap.entrySet().stream()
        .filter(entry -> entry.getValue() == repetitionCount).toArray();

    int[] result = new int[requestedRepeatedNums.length];
    /**
     * If (startInclusive >= endExclusive), in other words, 
     * if there are no elements (0 >= 0) , the for loop won't start.
     */
    IntStream.range(0, result.length)
        .forEach(index -> result[index] = Integer.valueOf((requestedRepeatedNums[index]).toString().substring(0,
            requestedRepeatedNums[index].toString().indexOf("="))));

    return (result.length == 0) ? cannotFind : result;
  }

}
