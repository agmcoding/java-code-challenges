package packagerichestcustomerwealth;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    int[][] accounts = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
    
    System.out.println(maximumWealth(accounts));
    System.out.println(maximumWealthWithStreamAPI(accounts));
    
    /* Output Result:
     * 17
     * 17
     */
    
  }

  static int maximumWealth(int[][] accounts) {
    int sum = 0;
    int maximumWealthValue = 0;
    for (int i = 0; i < accounts.length; i++) {
      sum = accounts[i][0];
      for (int j = 1; j < accounts[i].length; j++) {
        sum += accounts[i][j];
      }
      maximumWealthValue = Math.max(sum, maximumWealthValue);
    }
    return maximumWealthValue;
  }

//	or using Stream API

  static int maximumWealthWithStreamAPI(int[][] accounts) {
    return Arrays.stream(accounts).mapToInt(i -> Arrays.stream(i).sum()).max().getAsInt();
  }

}
