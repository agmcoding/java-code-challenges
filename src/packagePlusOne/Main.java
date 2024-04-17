package packagePlusOne;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

//	Challenge:
//	
//	You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
//	The digits are ordered from most significant to least significant in left-to-right order.
//	The large integer does not contain any leading 0's.
//
//	Increment the large integer by one and return the resulting array of digits.
//
//
//	Example 1:
//
//	Input: digits = [1,2,3]
//	Output: [1,2,4]
//	Explanation: The array represents the integer 123.
//	Incrementing by one gives 123 + 1 = 124.
//	Thus, the result should be [1,2,4].
//	
//	Example 2:
//
//	Input: digits = [4,3,2,1]
//	Output: [4,3,2,2]
//	Explanation: The array represents the integer 4321.
//	Incrementing by one gives 4321 + 1 = 4322.
//	Thus, the result should be [4,3,2,2].
//	
//	Example 3:
//
//	Input: digits = [9]
//	Output: [1,0]
//	Explanation: The array represents the integer 9.
//	Incrementing by one gives 9 + 1 = 10.
//	Thus, the result should be [1,0].
//	 
//
//	Constraints:
//
//	1 <= digits.length <= 100
//	0 <= digits[i] <= 9
//	digits does not contain any leading 0's.
  
  public static void main(String[] args) {

    System.out.print("With an array of { 4, 3, 2, 1 } : ");
    int[] digitsArray1 = { 4,3,2,1 };
    Arrays.stream(plusOne(digitsArray1)).forEach(value -> System.out.print(value + ", "));
    
    System.out.print("\nWith an array of { 9 } : ");
    int[] digitsArray2 = { 9 };
    Arrays.stream(plusOne(digitsArray2)).forEach(value -> System.out.print(value + ", "));
    
    System.out.print("\nWith an array of { 1, 3, 9 } : ");
    int[] digitsArray3 = { 1, 3, 9 };
    Arrays.stream(plusOne(digitsArray3)).forEach(value -> System.out.print(value + ", "));
    
    /**
     * Output result:
     * 
     * With an array of { 4, 3, 2, 1 } : 4, 3, 2, 2, 
     * With an array of { 9 } : 1, 0, 
     * With an array of { 1, 3, 9 } : 1, 4, 0, 
     */
    
  }

  private static int[] plusOne(int[] digits) {
    
    if (digits == null || digits.length == 0) return IntStream.of(0).toArray();
    
    boolean allValuesAre9 = Arrays.stream(digits).allMatch(value -> value == 9);
    
    if (allValuesAre9) { // Prevents worst case scenario
      int[] newArray = new int[digits.length + 1];
      newArray[0] = 1;
      return newArray;
    }
    
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] != 9) { digits[i]++; break; }
      else digits[i] = 0;
    }
    
    return digits;
  }

}
