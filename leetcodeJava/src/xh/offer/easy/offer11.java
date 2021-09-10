package xh.offer.easy;

public class offer11 {
    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int mid = (r + l) / 2;
            if (numbers[mid] < numbers[l]) {
                r = mid;
            } else if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }
        return numbers[l];
    }
}
