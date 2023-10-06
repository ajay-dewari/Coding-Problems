package common.greedy;

import java.util.Arrays;

/*     **Medium**
 * You are given an integer common.array coins representing coins of different denominations
 * and an integer amount representing a total amount of money. Return the fewest
 * number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 *
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 *
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 * Example 4:
 *
 * Input: coins = [186,419,83,408], amount = 6249
 * Output: 20
 *
 *
 * */
public class MinCoinChange {

    public static void main(String[] args) {
        int[] denominationArray = new int[]{1, 2, 5};
        System.out.print(coinChange(denominationArray, 11));
    }

    //Greedy Approach
    public static int coinChange(int[] coins, int amount) {
        int changeSum = 0;
        int change;
        int position = coins.length - 1;
        Arrays.sort(coins);
        while (amount > 0) {
            if (amount >= coins[position]) {
                change = amount / coins[position];
                amount = amount % coins[position];
                changeSum = changeSum + change;
            }
            if (position == 0 && amount > 0) {
                changeSum = -1;
                break;
            }
            position--;
        }
        return changeSum;
    }
}
