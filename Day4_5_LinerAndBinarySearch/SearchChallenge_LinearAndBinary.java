package Day4_5_LinerAndBinarySearch;


public class SearchChallenge_LinearAndBinary {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, -1, 1 };
        int missing = firstMissingPositive(nums.clone());
        System.out.println("First Missing Positive Integer: " + missing);

        int[] sortedArr = { 1, 2, 4, 5, 6, 7, 10 };
        int target = 5;
        int index = binarySearch(sortedArr, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}
