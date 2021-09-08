import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class lc815 {
    /**
     * 815. 公交路线
     * 
     * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
     * 
     * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1
     * -> ... 这样的车站路线行驶。 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
     * 
     * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/bus-routes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param routes
     * @param source
     * @param target
     * @return
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (target == source)
            return 0;
        HashMap<Integer, ArrayList<Integer>> canReach = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                ArrayList<Integer> singleReach = canReach.getOrDefault(routes[i][j], new ArrayList<Integer>());
                singleReach.add(i);
                canReach.put(routes[i][j], singleReach);
            }
        }
        int ret = 1;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                ArrayList<Integer> reachs = canReach.get(num);
                for (Integer integer : reachs) {
                    if (!vis.contains(integer)) {
                        for (int j = 0; j < routes[integer].length; j++) {
                            if (routes[integer][j] == target) {
                                return ret;
                            } else if (routes[integer][j] == num) {
                                continue;
                            } else {
                                queue.offer(routes[integer][j]);
                            }
                        }
                    }
                    vis.add(integer);
                }
            }
            ret++;
        }
        return -1;
    }
}
