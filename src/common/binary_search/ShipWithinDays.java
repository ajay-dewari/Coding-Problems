package common.binary_search;

/**
 * 1011. Capacity To Ship Packages Within D Days
 * <p>
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 * <p>
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 * <p>
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * <p>
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: weights = [3,2,2,4,1,4], days = 3
 * Output: 6
 * Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: weights = [1,2,3,1,1], days = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= days <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 **/
public class ShipWithinDays {

    public static void main(String[] args) {

        // int[] weights = {1,2,3,4,5,6,7,8,9,10};
        // int days = 5;
        // output: 15

        // int[] weights = {3,2,2,4,1,4};
        // int days = 6;
        // output: 6

        int[] weights = {1,2,3,1,1};
        int days = 4;
        // output: 3

        int ans = shipWithinDays(weights, days);
        System.out.println("The minimum capacity single day can be shipped is " + ans);
    }
    public static int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int weight : weights) {
            high += weight;
            low = Math.max(low, weight);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = getNumberOfDays(weights, mid);
            if (numberOfDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int getNumberOfDays(int[] weights, int cap) {
        int days = 1;
        int load = 0;
        for (int weight : weights) {
            if (load + weight > cap) {
                days += 1;
                load = weight;
            } else {
                load += weight;
            }
        }
        return days;
    }
}
