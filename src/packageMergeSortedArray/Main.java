package packageMergeSortedArray;

import java.util.Arrays;

public class Main {

//	Challenge:
//	
//	You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the
//	number of elements in nums1 and nums2 respectively.
//
//	Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//	The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
//	To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and
//	the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
//
//	Example 1:
//
//	Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//	Output: [1,2,2,3,5,6]
//	Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//	The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//	
//	Example 2:
//
//	Input: nums1 = [1], m = 1, nums2 = [], n = 0
//	Output: [1]
//	Explanation: The arrays we are merging are [1] and [].
//	The result of the merge is [1].
//	
//	Example 3:
//
//	Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//	Output: [1]
//	Explanation: The arrays we are merging are [] and [1].
//	The result of the merge is [1].
//	Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
//	 
//
//	Constraints:
//
//	nums1.length == m + n
//	nums2.length == n
//	0 <= m, n <= 200
//	1 <= m + n <= 200
//	-109 <= nums1[i], nums2[j] <= 109
//	 
//	Follow up: Can you come up with an algorithm that runs in O(m + n) time?
  
  public static void main(String[] args) {

    int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
    int m = 3, n = 3;	
    merge(nums1, m, nums2, n);
    for (int i: nums1) {
      System.out.print(i + ", ");
    }
    
    
    System.out.println("\nResult with mergeInAnotherWay:");
    
    
    int[] nums3 = {1,2,3,0,0,0}, nums4 = {2,5,6};
    int o = 3, p = 3;
    mergeInAnotherWay(nums3, o, nums4, p);
    for (int j: nums3) {
      System.out.print(j + ", ");
    }
    
    /* Output Result:
     *
     * 1, 2, 2, 3, 5, 6, 
     * Result with mergeInAnotherWay:
     * 1, 2, 2, 3, 5, 6,
     *
     */
    
  }

  static void merge(int[] nums1, int m, int[] nums2, int n) {

    Arrays.sort(nums1); // With this, all values of zero should be shifted to the left.

    for (int i = 0; i < n; i++) {
      nums1[i] = nums2[i];
    }

    Arrays.sort(nums1);

  }

  static void mergeInAnotherWay(int[] nums1, int m, int[] nums2, int n) {

    /* If there's no zeros between the non zero values, than this can also work: */
    
    for (int i = m, j = 0; j < n; i++, j++) {
        nums1[i] = nums2[j];
    }

    Arrays.sort(nums1);

  }
  
  /* 
   * Explanation about Arrays.sort() method: 
   * Arrays.sort method provides us with a quick and simple way to sort an array of primitives or objects that 
   * implement the Comparable interface in ascending order. When sorting primitives, the Arrays.sort method uses a 
   * Dual-Pivot implementation of Quicksort. 
   * May 20, 2021. 
   * Source Sorting Arrays in Java - Baeldunghttps://www.baeldung.com › java-sorting-arrays
   * 
   */
  
  /* StackOverflow question related to dual-pivot-quick-sort and quick-sort:
   * https://stackoverflow.com/questions/20917617/whats-the-difference-of-dual-pivot-quick-sort-and-quick-sort */
  
}
