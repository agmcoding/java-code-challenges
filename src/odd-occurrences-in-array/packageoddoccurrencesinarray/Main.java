package packageoddoccurrencesinarray;

public class Main {
  
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
