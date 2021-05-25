import java.util.Arrays;

public class offer40 {
    public static void main(String[] strings) {

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}
