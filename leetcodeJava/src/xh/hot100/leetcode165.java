package xh.hot100;

public class leetcode165 {
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
    }

    public static int compareVersion(String version1, String version2) {
        if (version1 == version2) {
            return 0;
        }
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int len = Math.min(len1, len2);
        for (int i = 0; i < len; i++) {
            int num1 = Integer.valueOf(v1[i]);
            int num2 = Integer.valueOf(v2[i]);
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        if (len1 != len2) {
            if (len1 == len) {
                for (int i = len; i < len2; i++) {
                    if (Integer.valueOf(v2[i]) > 0) {
                        return -1;
                    }
                }
            }
            if (len2 == len) {
                for (int i = len; i < len1; i++) {
                    if (Integer.valueOf(v1[i]) > 0) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
