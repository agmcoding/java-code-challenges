package packagesortarraybyparity;

import java.util.stream.IntStream;

public class Main {

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
