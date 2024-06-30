package miscellaneous.arrays_hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku. {@link <a href="https://leetcode.com/problems/valid-sudoku/description/"></a>}
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board =
 * {{"5","3",".",".","7",".",".",".","."}
 * ,{"6",".",".","1","9","5",".",".","."}
 * ,{".","9","8",".",".",".",".","6","."}
 * ,{"8",".",".",".","6",".",".",".","3"}
 * ,{"4",".",".","8",".","3",".",".","1"}
 * ,{"7",".",".",".","2",".",".",".","6"}
 * ,{".","6",".",".",".",".","2","8","."}
 * ,{".",".",".","4","1","9",".",".","5"}
 * ,{".",".",".",".","8",".",".","7","9"}}
 * Output: true
 * Example 2:
 * <p>
 * Input: board =
 * {{"8","3",".",".","7",".",".",".","."}
 * ,{"6",".",".","1","9","5",".",".","."}
 * ,{".","9","8",".",".",".",".","6","."}
 * ,{"8",".",".",".","6",".",".",".","3"}
 * ,{"4",".",".","8",".","3",".",".","1"}
 * ,{"7",".",".",".","2",".",".",".","6"}
 * ,{".","6",".",".",".",".","2","8","."}
 * ,{".",".",".","4","1","9",".",".","5"}
 * ,{".",".",".",".","8",".",".","7","9"}}
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * board.length == 9
 * board{i}.length == 9
 * board{i}{j} is a digit 1-9 or '.'.
 **/
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] input = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.print(isValidSudoku(input));
    }

    public static boolean isValidSudoku(char[][] input) {
        Set<String> sudoku = new HashSet<>();
        int size = input[0].length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char ch = input[i][j];
                if (ch != '.' && (
                                !sudoku.add(ch + " found at coloumn " + i) ||
                                !sudoku.add(ch + " found at row " + j) ||
                                !sudoku.add(ch + " found at matrix " + i/3 + "-" + j/3)
                )) {
                    return false;
                }
            }
        }
        return true;
    }

}
