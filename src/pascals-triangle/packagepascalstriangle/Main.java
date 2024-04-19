package packagepascalstriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {

    int numRows = 5;
    
    generatePascalsTriangle(numRows).stream().forEach(row -> {
      System.out.print("\n |");
      row.stream().forEach(value -> System.out.print(value + "|"));
      System.out.print(" ");
    });
  
    /**
     *  Output Result:
     * 
     *   |1| 
     *   |1|1| 
     *   |1|2|1| 
     *   |1|3|3|1| 
     *   |1|4|6|4|1| 
     */
    
  }

  private static List<List<Integer>> generatePascalsTriangle(int numRows) {
    
    List<List<Integer>> pascalsTriangle = new ArrayList<List<Integer>>();
    List<Integer> row = new ArrayList<>();

    if (numRows < 1 || numRows > 30) { // prevents constraints: 1 <= numRows <= 30
      pascalsTriangle.add(new ArrayList<>(Arrays.asList(-1)));
      return pascalsTriangle;
    }
    
    for (int i = 0; i < numRows; i++) {

      row.add(0, 1); // increment the row.

      /**
       * Does sum operations with the values inserted in the row and then saves it
       * with the add() method from pascalsTriangle list.
       */
      IntStream.range(1, row.size() - 1).forEach(index -> row.set(index, row.get(index) + row.get(index + 1)));

      pascalsTriangle.add(new ArrayList<>(row));
    }
    return pascalsTriangle;
  }

}
