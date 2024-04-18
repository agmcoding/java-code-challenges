package packagemaxconsecutiveones;

public class Main {

  public static void main(String[] args) {

    int[] nums = {1,0,1,1,0,1};
    
    System.out.println(findMaxConsecutiveOnes(nums));
    System.out.println("Result with a method with Ternary Operator:");
    System.out.println(findMaxConsecutiveOnesWithTernaryOperator(nums));
    
    /* Output Result:
     *
     * 2
     * Result with a method with Ternary Operator:
     * 2
     * 
     */
    
  }

  static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxConsecutiveOnes = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] != 1) {
                count = 0;
            }
            else {
                count++;
                if (count > maxConsecutiveOnes) {
                    maxConsecutiveOnes = count;
                }
            }
        }   
        return maxConsecutiveOnes;
    }
  
  
  /* Using Ternary Operator and max() method from Math class */
  
  static int findMaxConsecutiveOnesWithTernaryOperator(int[] nums) {
    int count = 0;
    int maxConsecutiveOnes = 0;
    
    for (int i = 0; i < nums.length; i++) {
      count = nums[i] == 1 ? ++count : 0;
      maxConsecutiveOnes = Math.max(count, maxConsecutiveOnes);
    }
    
    return maxConsecutiveOnes;
  }
  
}
