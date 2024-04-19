package packagerunningsumof1darray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {

    int[] nums = { 3, 1, 2, 10, 1 };
    
    System.out.print("With Stream API: ");
    int[] nums1 = nums.clone();
    Arrays.stream(runningSumWithStreamAPI(nums1)).forEach(value -> System.out.print(value + ", "));

    System.out.print("\n\nWith 'Arrays.parallelPrefix()' method: ");
    int[] nums2 = nums.clone();
    Arrays.stream(runningSumWithArraysParallelPrefix(nums2)).forEach(value -> System.out.print(value + ", "));

    System.out.print("\n\nNow just using for loop and modifying the input Array: ");
    
    int[] nums3 = nums.clone();
    runningSumInPlace(nums3);
    Arrays.stream(nums3).forEach(value -> System.out.print(value + ", "));

    System.out.print("\n\nNow instead of returning an array, returning an integer list: ");
    List<Integer> runningSumList1 = runningSumReturningList(nums);
    runningSumList1.stream().forEach(value -> System.out.print(value + ", "));

    System.out.print("\n\nNow handling with an integer list as a parameter: ");
    List<Integer> runningSumList = new ArrayList<>(Arrays.asList(3, 1, 2, 10, 1));
    List<Integer> runningSumList2 = runningSumHandlingWithList(runningSumList);
    runningSumList2.stream().forEach(value -> System.out.print(value + ", "));

    /**
     * Output Result:
     *
     * With Stream API: 3, 4, 6, 16, 17, 
     *
     * With 'Arrays.parallelPrefix()' method: 3, 4, 6, 16, 17, 
     *
     * Now just using for loop and modifying the input Array: 3, 4, 6, 16, 17, 
     *
     * Now instead of returning an array, returning an integer list: 3, 4, 6, 16, 17, 
     *
     * Now handling with an integer list as a parameter: 3, 4, 6, 16, 17, 
     */

  }



  /**
   * Explanation for these {@code Stream API} methods:<br>
   * 
   * <p>
   * We use {@code range()} method from {@code IntStream} interface to create
   * indexes from {@code  1} to {@code nums.length}<br>
   * (similar to a for loop, but with many utility methods).
   * 
   * <p>
   * The {@code  map()} method will change the values from the
   * <b>runningSumArray</b> according to the given function that is passed.<br>
   * 
   * <p>
   * The {@code toArray()} method will return an {@code int} array containing the
   * elements of this stream.
   * 
   * @param nums the array to be copied and to be performed a running sum
   * @return an array containing a running sum from the <b>nums</b> provided.<br>
   *         If the <b>nums</b> array is null or contains no elements, an array
   *         with a value of {@code -1} is returned instead
   */
  private static int[] runningSumWithStreamAPI(int[] nums) {

    if (nums == null || nums.length == 0) {
      int[] responseForNull = { -1 };
      return responseForNull; // At business definition discretion.
    }

    int[] runningSumArray = nums.clone();

    IntStream.range(1, nums.length).map(index -> runningSumArray[index] += runningSumArray[index - 1]).toArray();
    return runningSumArray;
  }



  /**
   * In this use case, maybe it is not the best method since the <b>nums</b> array
   * has a small length.
   * 
   * <p>
   * As the
   * {@link Arrays#parallelPrefix(int[], java.util.function.IntBinaryOperator)
   * documentation} states: <i>Parallel prefix computation is usually more
   * efficient than sequential loops for large arrays.</i>
   * 
   * @param nums the array, which is cloned to make a running sum of it
   * @return an array containing a running sum from the <b>nums</b> provided.<br>
   *         If the <b>nums</b> array is null or contains no elements, an array
   *         with a value of {@code -1} is returned instead
   */
  private static int[] runningSumWithArraysParallelPrefix(int[] nums) {

    if (nums == null || nums.length == 0) {
      int[] responseForNull = { -1 };
      return responseForNull; // At business definition discretion.
    }

    int[] runningSumArray = nums.clone();
    Arrays.parallelPrefix(runningSumArray, Integer::sum); // in Lambda function it could be: (left, right) -> right + left

    return runningSumArray;
  }



  // Modifying the Input Array with a for loop
  private static void runningSumInPlace(int[] nums) {

    if (nums == null || nums.length == 0)
      return;

    for (int i = 1; i < nums.length; i++) {
      nums[i] += nums[i - 1];
    }
  }



  /**
   * Explanation of this method:<br>
   * 
   * <p>
   * The {@code if} statement checks if the array is null or empty. If so, it
   * returns an empty list (immutable) using {@code Collections.emptyList()}
   * method. This could be at business definition discretion.
   * 
   * <p>
   * We use {@code range()} method from {@code IntStream} interface to create
   * indexes from {@code  1} to {@code numsCopy.length}<br>
   * (similar to a for loop, but with many utility methods).
   * 
   * <p>
   * The {@code forEach()} method will perform an action for each element of the
   * IntStream of the <b>nums</b> array, in this case to store the sum between the
   * value in the current index and the the value from the last index while in the
   * {@code forEach()} operation (creating as a result a running sum).<br>
   * 
   * @param nums the array to be copied and to be performed the running sum.
   * @return a list containing a running sum from the <b>nums</b> provided.<br>
   */
  private static List<Integer> runningSumReturningList(int... nums) {

    if (nums == null || nums.length == 0) {
      return Collections.emptyList(); // At business definition discretion.
    }

    int[] numsCopy = nums.clone();
    IntStream.range(1, numsCopy.length).forEach(index -> numsCopy[index] += numsCopy[index - 1]);
    return IntStream.of(numsCopy).boxed().collect(Collectors.toList());
  }



  /**
   * Explanation of this method:<br>
   * 
   * <p>
   * The {@code if} statement checks if the list is null or empty. If so, it
   * returns an empty list (immutable) using {@code Collections.emptyList()}
   * method. This could be at business definition discretion.
   * 
   * <p>
   * We use {@code range()} method from {@code IntStream} interface to create
   * indexes from {@code  1} to {@code numsCopy.size()}<br>
   * (similar to a for loop, but with many utility methods).
   * 
   * <p>
   * The {@code forEach()} method will perform an action for each element of the
   * IntStream of the <b>numsCopy</b> list, in this case to set the sum between
   * the value in the current index and the the value from the last index while in
   * the {@code forEach()} operation (creating as a result a running sum).<br>
   * 
   * @param nums the list to be copied and to be performed the running sum.
   * @return a list containing a running sum from the <b>nums</b> provided.<br>
   */
  private static List<Integer> runningSumHandlingWithList(List<Integer> nums) {

    if (nums == null || nums.isEmpty()) {
      return Collections.emptyList(); // At business definition discretion.
    }

    List<Integer> numsCopy = nums.stream().collect(Collectors.toList());
    IntStream.range(1, numsCopy.size())
        .forEach(index -> numsCopy.set(index, Integer.sum(numsCopy.get(index), numsCopy.get(index - 1))));
    return numsCopy;
  }

}
