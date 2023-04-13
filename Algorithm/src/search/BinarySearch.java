package search;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinarySearch {

    int search(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == nums[mid]) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else if (target < nums[mid]) right = mid - 1;
        }
        throw new NoSuchElementException("Target does not exist");
    }
}
