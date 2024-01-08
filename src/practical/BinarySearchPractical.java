package practical;

public class BinarySearchPractical {

    private int searchTarget(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else if (target < array[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }

    private int searchTargetInRotatedSortedArray(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] >= array[start]) {
                if (array[mid] > target && array[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid +1;
                }
            } else {
                if (array[mid] < target && array[end] >= target) {
                    start = mid +1;
                } else {
                    end = mid -1;
                }
            }
        }
        return -1;
    }

}
