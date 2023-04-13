package sorting;

public abstract class Sorting {

    abstract void sort(int[] nums);

    abstract void optimizedSort(int[] nums);

    void swap(int[] nums, int indexA, int indexB) {
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }
}
