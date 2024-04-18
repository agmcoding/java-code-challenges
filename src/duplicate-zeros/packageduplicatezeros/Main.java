package packageduplicatezeros;

public class Main {

    public static void main(String[] args) {
        
        int[] arr = {1,0,2,3,0,4,5,0};
        
        duplicateZeros(arr);
        
        for (int i: arr) {
            System.out.print(i + ", ");
        }
        
        /* Output Result:
         * 
         * 1, 0, 0, 2, 3, 0, 0, 4,
         * 
         */
        
    }

    static void duplicateZeros(int[] arr) {
        boolean firstIndexAndWithValueOfZero;

        for (int i = 0; i < arr.length; i++) {

            firstIndexAndWithValueOfZero = arr[i] == 0 && i == 0;

            if (firstIndexAndWithValueOfZero || arr[i] == 0 && arr[i] != arr[i - 1]) {
                for (int j = arr.length - 1; j > i; j--) { 
                    arr[j] = arr[j - 1];
                }
            }
            continue;
        }
    }

}
