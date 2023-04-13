package sorting;

import java.util.Arrays;

public class MergeSorting extends Sorting {

    @Override
    void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    @Override
    void optimizedSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    void merge(int[] nums, int left, int mid, int right) {
        int[] L = Arrays.copyOfRange(nums, left, mid + 1);
        int[] R = Arrays.copyOfRange(nums, mid + 1, right + 1);

        int l = 0, r = 0, k = left;
        while (l < L.length && r < R.length) {
            if (L[l] <= R[r]) nums[k++] = L[l++];
            else nums[k++] = R[r++];
        }
        while (l < L.length) nums[k++] = L[l++];
        while (r < R.length) nums[k++] = R[r++];
    }
}
