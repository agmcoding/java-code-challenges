package packageFizzBuzz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
  
//	Given an integer 'n', return a string array 'answer' (1-indexed) where:
//
//		answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
//		answer[i] == "Fizz" if i is divisible by 3.
//		answer[i] == "Buzz" if i is divisible by 5.
//		answer[i] == i (as a string) if none of the above conditions are true.

  public static void main(String[] args) {
    System.out.println(fizzBuzz(20));
    System.out.println("OutPut Result using Ternary Operator:");
    System.out.println(fizzBuzzWithTernaryOperator(20));
    
    /* Output Result:
     * [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16, 17, Fizz, 19, Buzz]
     * OutPut Result using Ternary Operator: 
     * [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16, 17, Fizz, 19, Buzz]
     */
  }

  public static List<String> fizzBuzz(int n) {
    List<String> answer = new LinkedList<>();

    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        answer.add("FizzBuzz");
      } else if (i % 3 == 0) {
        answer.add("Fizz");
      } else if (i % 5 == 0) {
        answer.add("Buzz");
      } else {
        answer.add(String.valueOf(i));
      }
    }
    return answer;
  }

  static List<String> fizzBuzzWithTernaryOperator(int n) {
    /* FizzBuzz Algorithm with Ternary Operator */
    List<String> answer = new ArrayList<>();
    String currentIndexAnswer = "";

    for (int i = 1; i <= n; i++) {
      currentIndexAnswer = i % 3 == 0 && i % 5 == 0 ? "FizzBuzz"
          : i % 3 == 0 ? "Fizz" : i % 5 == 0 ? "Buzz" : String.valueOf(i);
      answer.add(currentIndexAnswer);
    }

    return answer;
  }

}
