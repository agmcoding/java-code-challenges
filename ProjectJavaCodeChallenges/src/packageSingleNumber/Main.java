package packageSingleNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class Main {

//	Challenge:
//	
//	Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//	You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//	 
//	Example 1:
//
//	Input: nums = [2,2,1]
//	Output: 1
//	
//	Example 2:
//
//	Input: nums = [4,1,2,1,2]
//	Output: 4
//	
//	Example 3:
//
//	Input: nums = [1]
//	Output: 1
//	 
//
//	Constraints:
//
//	1 <= nums.length <= 3 * 104
//	-3 * 104 <= nums[i] <= 3 * 104
//	Each element in the array appears twice except for one element which appears only once.
	
	public static void main(String[] args) {

		int[] nums = { 4, 1, 2, 1, 2 };

		System.out.println("With HashMap: " + singleNumber(nums));
		System.out.println("With Stream.sorted() method: " + singleNumberBySorting(nums));

		/**
		 * With HashMap: 4
		 * With Stream.sorted() method: 4
		 */

	}

	private static int singleNumber(int[] nums) {

		/** Prevents constrains of the challenge. */
		if (nums == null 
				|| nums.length < 1 
				|| nums.length > 3 *(int) Math.pow(10, 4)
				|| Arrays.stream(nums).anyMatch(value -> value < -30000 || value > 30000)) 
			return -1; // At business definition discretion.

        Map<Integer, Integer> numsMap = new HashMap<>();

		Arrays.stream(nums)
				.forEach(value -> numsMap
						.put(value, (numsMap.get(value) == null) ? 1 : numsMap.get(value) + 1));

		Optional<Entry<Integer, Integer>> uniqueNumber = numsMap.entrySet().stream()
				.filter(entry -> entry.getValue() == 1).findFirst();

		return (uniqueNumber.isPresent()) ? uniqueNumber.get().getKey() : -1; // At business definition discretion.
	}

	
	private static int singleNumberBySorting(int[] nums) {
		
		/** Prevents constrains of the challenge. */
		if (nums == null 
				|| nums.length < 1 
				|| nums.length > 3 *(int) Math.pow(10, 4)
				|| Arrays.stream(nums).anyMatch(value -> value < -30000 || value > 30000))
			return -1; // At business definition discretion.

		int[] sortedNums = Arrays.stream(nums).sorted().toArray();
		
		for (int i = 0; i < sortedNums.length; i += 2) {
			if (i + 1 >= sortedNums.length) return sortedNums[i];
			if (sortedNums[i] != sortedNums[i + 1]) return sortedNums[i];
		}
		return -1; // At business definition discretion.
	}
	
	
}
