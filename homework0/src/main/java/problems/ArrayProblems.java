package problems;

/**
 * Parts b.iii, b.iv, and b.v should go here.
 *
 * (Implement `toString`, `rotateRight`, and `reverse` as described by the spec.
 *  See the spec on the website for picture examples and more explanation!)
 *
 * REMEMBER THE FOLLOWING RESTRICTIONS:
 * - Do not add any additional imports
 * - Do not create new `int[]` objects for `toString` or `rotateRight`
 **/

public class ArrayProblems {
    //toString of passed array
    public static String toString(int[] array) {
        StringBuilder s = new StringBuilder("");
        if (array != null && array.length != 0) { //beginning/null case
            s.append("["); //beginning of the array to String
            for (int i = 0; i < array.length - 1; i++) { //expected case
                s.append(array[i]);
                s.append(", ");
            }
            s.append(array[array.length - 1]); //taking care of edge case
            s.append("]");
            return s.toString();
        }
        return("[]"); //empty array case
    }
    //returns the passed in array with elements rotate one spot to the right
    public static void rotateRight(int[] numbers) {
        if (numbers != null && numbers.length != 0) {//empty/null case
            int last = numbers[numbers.length - 1]; //saving a temp value pointing to last element
            for (int i = numbers.length - 1; i > 0; i--) {//middle case starting backwards
                numbers[i] = numbers[i - 1];
            }
            numbers[0] = last; //edge case
        }
    }
    //returns new array with elements of passed in array in reverse order
    public static int[] reverse(int[] array) {  //1, 2, 3, 4 -> 4, 1, 2, 3
        if (array == null) { //null case
            return null;
        }
        int[] newNum = new int[array.length]; //creates new array (even if length is equal to 0)
        if (array.length != 0) {
            int count = 0; //index of new array
            for (int i = array.length - 1; i >= 0; i--) {
                newNum[count] = array[i];
                count += 1; //incrementing index of new array
            }
        }
        return newNum;
    }
}
