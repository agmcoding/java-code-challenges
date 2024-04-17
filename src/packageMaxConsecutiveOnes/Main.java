package packageMaxConsecutiveOnes;

public class Main {

//	Challenge:
//	
//	Given a binary array nums, return the maximum number of consecutive 1's in the array.
//				 
//	Example 1:
//
//	Input: nums = [1,1,0,1,1,1]
//	Output: 3
//	Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
//		
//	Example 2:
//
//	Input: nums = [1,0,1,1,0,1]
//	Output: 2
//				 
//	Constraints:
//
//	1 <= nums.length <= 105
//	nums[i] is either 0 or 1.
	
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
