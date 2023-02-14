package packageHeightChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

//	Challenge:
//	
//	A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line 
//	in non-decreasing order by height. Let this ordering be represented by the integer array expected where 
//	expected[i] is the expected height of the ith student in line.
//
//	You are given an integer array heights representing the current order that the students are standing in. 
//	Each heights[i] is the height of the ith student in line (0-indexed).
//
//	Return the number of indices where heights[i] != expected[i].
//
//
//	Example 1:
//
//	Input: heights = [1,1,4,2,1,3]
//	Output: 3
//	Explanation: 
//	heights:  [1,1,4,2,1,3]
//	expected: [1,1,1,2,3,4]
//	Indices 2, 4, and 5 do not match.
//	
//	Example 2:
//
//	Input: heights = [5,1,2,3,4]
//	Output: 5
//	Explanation:
//	heights:  [5,1,2,3,4]
//	expected: [1,2,3,4,5]
//	All indices do not match.
//	
//	Example 3:
//
//	Input: heights = [1,2,3,4,5]
//	Output: 0
//	Explanation:
//	heights:  [1,2,3,4,5]
//	expected: [1,2,3,4,5]
//	All indices match.
//	 
//
//	Constraints:
//
//	1 <= heights.length <= 100
//	1 <= heights[i] <= 100
	
	public static void main(String[] args) {
		
		System.out.print("With a primitive data type array: ");
		
		int[] heights = {1,1,4,2,1,3};
		System.out.println(heightChecker(heights));
		
		System.out.print("\nWith a List: ");
		
		List<Integer> heights2 = new ArrayList<>(Arrays.asList(1,1,4,2,1,3));
		System.out.println(heightCheckerWithList(heights2));
		
		/**
		 * Output Result:
		 * 
		 * With a primitive data type array: 3
		 * 
		 * With a List: 3
		 */
		
	}


	
	static int heightChecker(int[] heights) {
		
		if (heights == null || heights.length <= 1) return 0;
		
		int[] sortedHeights = heights.clone();
		Arrays.sort(sortedHeights); // Sort primitive data types
		int countHeightsInWrongPosition = 0;
		
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] != sortedHeights[i]) countHeightsInWrongPosition++;
		}
		
		return countHeightsInWrongPosition;
	}
	
	
	
	static long heightCheckerWithList(List<Integer> heights) {
		
		Optional<List<Integer>> maybeNull = Optional.ofNullable(heights);
		if (maybeNull.isEmpty() || heights.size() <= 1) return 0;
		
		List<Integer> sortedHeights = heights.stream().collect(Collectors.toList());
		Collections.sort(sortedHeights);
		
		long countHeightsInWrongPosition = IntStream.range(0, heights.size())
				.filter(index -> ! heights.get(index).equals(sortedHeights.get(index))).count();
		
		return countHeightsInWrongPosition;
	}
	
	
}
