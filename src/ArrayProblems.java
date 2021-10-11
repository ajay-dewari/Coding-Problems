/**
 * Class containing all the coding problems related to one dimention array
 *
 * @author ajaydewari
 * @since 10 Oct 2021
 */
public class ArrayProblems {
    public static void main(String[] args) {
        int[] randonArray = {0, 1, 1, 0, 0, 1, 1, 1, 0, 0};
        randonArray = segregate0and1(randonArray);

        for (int i = 0; i < randonArray.length; i++) {
            System.out.print(" " + randonArray[i]);
        }
    }

    private static int[] segregate0and1(int[] randonArray) {
        //int[] randonArray = {0, 1, 1, 0, 0, 1, 1, 1, 0, 0};
        /* 0, 1, 1, 0, 0, 1, 1, 1, 0, 0(j =0 & i =0)
            0, 1, 1, 0, 0, 1, 1, 1, 0, 0(j =0 & i =1)
            0, 1, 1, 0, 0, 1, 1, 1, 0, 0(j =0 & i =2)
            0, 0, 1, 1, 0, 1, 1, 1, 0, 0(j =1 & i =3)
            0, 0, 0, 1, 1, 1, 1, 1, 0, 0(j =2 & i =4)
            0, 0, 0, 1, 1, 1, 1, 1, 0, 0(j =2 & i =5)
            0, 0, 0, 1, 1, 1, 1, 1, 0, 0(j =2 & i =6)
            0, 0, 0, 1, 1, 1, 1, 1, 0, 0(j =2 & i =7)
            0, 0, 0, 0, 1, 1, 1, 1, 1, 0(j =3 & i =8)
            0, 0, 0, 0, 0, 1, 1, 1, 1, 1(j =4 & i =9)*/
        int j = -1;
        for (int i = 0; i < randonArray.length; i++) {
            if (randonArray[i] == 0) {
                j++;
                int temp = randonArray[i];
                randonArray[i] = randonArray[j];
                randonArray[j] = temp;
            }
        }
        return randonArray;
    }
}