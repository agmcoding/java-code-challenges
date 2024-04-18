package packagefindnumberswithevennumberofdigits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    
    int[] nums = { 12, 345, 2, 6, 7896 };
    List<Integer> numsList = new ArrayList<>(Arrays.asList(12, 345, 2, 6, 7896));
    System.out.println("Finding with Arrays.stream() methods: " + findNumbersWithStreamsAPI(nums));
    System.out.println("Finding with a List and with Streams API: " + findNumbersWithList(numsList));
    System.out.println("Finding with Ternary Operator: " + findNumbersWithTernaryOperator(nums));
    System.out.println(
        "Finding with a List and with Ternary Operator: " + findNumbersWithListAndTernaryOperator(numsList));
    
    /** 
     * Output Result:
     * 
     * Finding with Arrays.stream() methods: 2
     * Finding with a List and with Streams API: 2
     * Finding with Ternary Operator: 2
     * Finding with a List and with Ternary Operator: 2
     */
    
  }
  


  private static long findNumbersWithStreamsAPI(int[] nums) {
    if (checkIfNull(nums) == true) return -1L;
    return Arrays.stream(nums).filter(value -> String.valueOf(value).length() % 2 == 0).count();
  }
  
  
  
  private static long findNumbersWithList(List<Integer> numsList) {
    if (checkIfNull(numsList) == true) return -1L;
    return numsList.stream().filter(value -> String.valueOf(value).length() % 2 == 0).count();
  }
  


  private static int findNumbersWithTernaryOperator(int[] nums) {
    
    if (checkIfNull(nums) == true) return -1;
    
    int countEvenNumberOfDigits = 0;
    String numInIndex = "";

    for (int i = 0; i < nums.length; i++) {
      numInIndex = String.valueOf(nums[i]);
      countEvenNumberOfDigits = (numInIndex.length() % 2 == 0) ? ++countEvenNumberOfDigits
          : countEvenNumberOfDigits;
    }
    return countEvenNumberOfDigits;
  }

  
  
  private static int findNumbersWithListAndTernaryOperator(List<Integer> numsList) {
    
    if (checkIfNull(numsList) == true) return -1;
    
    int countEvenNumberOfDigits = 0;

    for (int i = 0; i < numsList.size(); i++) {
      countEvenNumberOfDigits = (String.valueOf(numsList.get(i)).length() % 2 == 0) ? ++countEvenNumberOfDigits
          : countEvenNumberOfDigits;
    }

    return countEvenNumberOfDigits;
  }

  
  
  private static boolean checkIfNull(int[] nums) {
    return nums == null || nums.length == 0;
  }

  
  
  private static boolean checkIfNull(List<Integer> numsList) {
    return numsList == null || numsList.size() == 0;
  }
  
}
