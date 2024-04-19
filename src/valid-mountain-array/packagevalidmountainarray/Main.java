package packagevalidmountainarray;

public class Main {

  public static void main(String[] args) {
    
    int[] arr = {0,3,2,1};
    
    System.out.println(validMountainArray(arr));
    
    /* Output Result:
     *
     * true
     *
     */
  }
  
  static boolean validMountainArray(int[] arr) {
    
    if (arr == null || arr.length < 3) {
      return false;
    }
    
    boolean isDecreasing = false;
    int index = 1;
    
    while (!isDecreasing) {
      
      if (arr[index] == arr[index - 1]) return false; // Validating if it's strictly increasing.
      
      if (arr[index] < arr[index - 1]) {
        isDecreasing = true;
        for (int i = index + 1; i < arr.length; i++) {
          if (arr[i] >= arr[i - 1]) return false;
        }
      }
        
      index++;
    }
    
    return true;
  }
  
}
