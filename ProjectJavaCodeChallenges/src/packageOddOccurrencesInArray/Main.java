package packageOddOccurrencesInArray;

public class Main {
	
//	Question from Codility platform:
//	
//	 non-empty array A consisting of N integers is given. The array contains an odd number 
//	 of elements, and each element of the array can be paired with another element that 
//	 has the same value, except for one element that is left unpaired.
//
//	 For example, in array A such that:
//
//	 A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9
//
//	 the elements at indexes 0 and 2 have value 9,
//	 the elements at indexes 1 and 3 have value 3,
//	 the elements at indexes 4 and 6 have value 9,
//	 the element at index 5 has value 7 and is unpaired.
//	 
//	 Write a function:
//
//	 class Solution { public int solution(int[] A); }
//
//	 that, given an array A consisting of N integers fulfilling the above conditions, 
//	 returns the value of the unpaired element.
//
//	 For example, given array A such that:
//
//	 A[0] = 9   A[1] = 3   A[2] = 9   A[3] = 3   A[4] = 9   A[5] = 7   A[6] = 9
//
//	 the function should return 7, as explained in the example above.
//
//	 Write an efficient algorithm for the following assumptions:
//
//	 N is an odd integer within the range [1..1,000,000];
//	 each element of array A is an integer within the range [1..1,000,000,000];
//	 all but one of the values in A occur an even number of times.

	public static void main(String[] args) {
		int[] A = { 1, 3, 1, 3, 1, 3, 1, 3, 1, 9, 1 };
		System.out.println(solution(A));
		System.out.println("With Ternary Operator:");
		System.out.println(solutionWithTernaryOperator(A));
	}

	static int solution(int[] A) {
		int unpairedElement = 0;

		for (int i = 2; i < A.length; i++) {
			boolean elementDoesntHavePairOnTheLeft = A[i] != A[i - 2];
			if (elementDoesntHavePairOnTheLeft) {
				boolean elementPlus2LowerThanArrayLength = i + 2 < A.length;
				if (elementPlus2LowerThanArrayLength) { // this statement is for not letting the code get NullPointerException.
					boolean elementHasPairOnTheRight = A[i] == A[i + 2];
					if (elementHasPairOnTheRight) {
						continue;
					} else {
						unpairedElement = A[i];
						break;
					}
				} else {
					unpairedElement = A[i];
					break;
				}
			}
		}
		return unpairedElement;
	}

	static int solutionWithTernaryOperator(int[] A) {
		int unpairedElement = 0;

		for (int i = 2; i < A.length; i++) {
			if (unpairedElement != 0) {
				break;
			}
			unpairedElement = A[i] != A[i - 2] ? i + 2 < A.length ? A[i] == A[i + 2] ? 0 : A[i] : A[i] : 0;
		}
		return unpairedElement;
	}

}
