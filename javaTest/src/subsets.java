import java.util.*;
public class subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            
        }
        return ret;
    }
    public static void main(String[] str) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        List<List<Integer>> ret = subsets(nums);
        StringBuilder sb = new StringBuilder();
        for ( int  i =  0 ;i < ret.size();i++){
            List<Integer> sub = ret.get(i);
            sb.append("[");
            for (int j = 0; j < sub.size(); j++) {
                sb.append(sub.get(j)).append(",");
            }
            sb.append("]");
       }
       System.out.println(sb.toString());
    }
}

// https://leetcode-cn.com/problems/subsets/