package packageplusone;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

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
