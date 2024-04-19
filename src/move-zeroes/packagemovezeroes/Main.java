package packagemovezeroes;

public class Main {
  
  public static void main(String[] args) {
    
    int[] nums = {0,1,0,3,12};
    moveZeroes(nums);
    for (int i: nums) {
      System.out.print(i + ", ");
    }
    
    /* Output Result:
     *
     * 1, 3, 12, 0, 0, 
     *
     */
    
  }
  
  
  static void moveZeroes(int[] nums) {

    int countZeroElements = 0;

    for (int i = 0; i < nums.length; i++) {

      if (nums[i] == 0) countZeroElements++;
      
      else {
        nums[i - countZeroElements] = nums[i]; /* Attributing a non zero value to an index in the left */
        nums[i] = 0; /* Allocating zero values to the right of the array, in the current index */
      }

    }

  }
  
}
