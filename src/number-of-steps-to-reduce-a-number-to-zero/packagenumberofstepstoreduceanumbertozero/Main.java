package packagenumberofstepstoreduceanumbertozero;

public class Main {

  public static void main(String[] args) {

    System.out.println(numberOfSteps(123));
    System.out.println("With Ternary Operator:");
    System.out.println(numberOfStepsWithTernaryOperator(123));
    
    /* Output Result:
     * 
     * 12
     * With Ternary Operator:
     * 12
     * 
     */
    
  }

  static int numberOfSteps(int num) {
    int numOfSteps = 0;

    while (num > 0) {
      if (num % 2 == 0) {
        num /= 2;
      } else {
        num--;
      }
      numOfSteps++;
    }

    return numOfSteps;
  }

  static int numberOfStepsWithTernaryOperator(int num) {
    int numOfSteps = 0;

    while (num > 0) {
      num = num % 2 == 0 ? num / 2 : --num;
      numOfSteps++;
    }

    return numOfSteps;
  }
  
}
