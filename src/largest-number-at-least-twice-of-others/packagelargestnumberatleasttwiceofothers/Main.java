package packagelargestnumberatleasttwiceofothers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    int[] nums = { 3, 6, 1, 0 };
    
    System.out.println("The dominant index of the array is: " + dominantIndex(nums));
    
    /**
     * Output Result:
     * 
     * The dominant index of the array is: 1
     */
    
  }

  private static int dominantIndex(int[] nums) {

    if (nums == null || nums.length <= 1) return -1;

    List<Integer> numsList = extractedToList(nums);
    
    int highestElement = Collections.max(numsList);
    Collections.sort(numsList);
    numsList.remove(numsList.get(numsList.size() - 1));

    boolean allMatch = numsList.stream().allMatch(value -> highestElement >= 2 * value);

    if (allMatch) return extractedToList(nums).indexOf(highestElement);
    
    return -1;
  }

  private static List<Integer> extractedToList(int[] nums) {
    return Arrays.stream(nums).boxed().collect(Collectors.toList());
  }
  
}
