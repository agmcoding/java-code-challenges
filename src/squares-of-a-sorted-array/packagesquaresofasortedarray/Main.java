package packagesquaresofasortedarray;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    
    int[] nums = {-7,-3,2,3,11};
    int[] array = sortedSquares(nums);
    
    for (int i: array) {
      System.out.print(i + ", ");
    }
    
    /* Output Result:
     *
     * 4, 9, 9, 49, 121,
     *
     */
    
  }

  static int[] sortedSquares(int[] nums) {
    int[] squaredSortedArray = new int[nums.length];
    
    for (int i = 0; i < nums.length; i++) {
      squaredSortedArray[i] = nums[i] * nums[i];
    }
    
    Arrays.sort(squaredSortedArray);
    
    return squaredSortedArray;
  }
  
}
