package packageCheckIfNAndItsDoubleExist;

import java.util.HashSet;
import java.util.Set;

public class Main {

//	Challenge:
//	
//	Given an array arr of integers, check if there exist two indices i and j such that :
//
//	i != j
//	0 <= i, j < arr.length
//	arr[i] == 2 * arr[j]
//		 
//
//	Example 1:
//
//	Input: arr = [10,2,5,3]
//	Output: true
//	Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
//			
//	Example 2:
//
//	Input: arr = [3,1,7,11]
//	Output: false
//	Explanation: There is no i and j that satisfy the conditions.
//		 
//	Constraints:
//
//	2 <= arr.length <= 500
//	-103 <= arr[i] <= 103
	
	public static void main(String[] args) {
		
		int[] array = {10,2,5,3};
		
		System.out.println("With HashSet: " + checkIfExistWithHashSet(array));
		System.out.println("With two for loops: " + checkIfExistWith2ForLoops(array));
		
		/**
		 * Output Result:
		 * 
		 * With HashSet: true
		 * With two for loops: true
		 */
		
	}

	/**
	 * With HashSet, operations as add() and contains() have O(1) time complexity.
	 * Also, since we don't want to compare equal values, Set implementation will just add unique elements.
	 * 
	 * Information source about Set contains() method time complexity:
	 * Link: https://stackoverflow.com/questions/25247854/what-is-the-time-complexity-performance-of-hashset-contains-in-java
	 */
	static boolean checkIfExistWithHashSet(int[] array) {
		
		if (array == null || array.length == 0) {
			return false;
		}
		
		Set<Integer> setArray = new HashSet<>();
		
		/** 
		 * Instead of using IntStream of int array, like:
		 * 
		 * IntStream.of(array).boxed().collect(Collectors.toSet());
		 * 
		 * or like:
		 * 
		 * Arrays.stream(array).boxed().collect(Collectors.toSet());
		 * 
		 * , we can just add the elements one by one until we find a value corresponded to
		 * a double or a half of an element that we added.
		 */
		
		for (int i : array) {
			if (setArray.contains(2 * i) || i % 2 == 0 && setArray.contains(i / 2))
				return true;
			setArray.add(i); /* If not, we just need to add the element in the HashSet to be compared next time. */
		}
		
		return false;
}



	static boolean checkIfExistWith2ForLoops(int[] array) {
		
		if (array == null || array.length == 0) {
			return false;
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i == j || i % 2 == 1) continue;
				if (array[i] == 2 * array[j] || array[j] == 2 * array[i]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
}
