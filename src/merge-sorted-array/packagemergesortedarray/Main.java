package packagemergedortedsrray;

import java.util.Arrays;

public class Main {

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
