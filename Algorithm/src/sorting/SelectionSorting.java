package sorting;

public class SelectionSorting extends Sorting{

    @Override
    void sort(int[] nums) {
        for (int location = 0; location < nums.length - 1; location++) {
            int minIndex = location;
            for (int index = location; index < nums.length; index++)
                minIndex = nums[minIndex] > nums[index] ? index : minIndex;
            swap(nums, location, minIndex);
        }
    }

    @Override
    void optimizedSort(int[] nums) {
        boolean swapped;
        for (int location = 0; location < nums.length - 1; location++) {
            int minIndex = location;
            swapped = false;
            for (int index = location; index < nums.length; index++) {
                if (nums[minIndex] > nums[index]) {
                    minIndex = index;
                    swapped = true;
                }
            }
            if (swapped) swap(nums, location, minIndex);
            else break;
        }
    }
}
