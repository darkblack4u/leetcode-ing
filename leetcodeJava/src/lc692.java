import java.util.*;

public class lc692 {
    /**
     * 692. 前K个高频单词 https://leetcode-cn.com/problems/top-k-frequent-words/
     * 
     * @param strings
     */
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            words[i] = word;
        }
        List<String> ret = topKFrequent(words, k);
        for (String string : ret) {
            System.out.println(string);
        }
        sc.close();
    }

    // public List<String> topKFrequent(String[] words, int k) {
    // HashMap<String, Integer> count = new HashMap<>();
    // for (int i = 0; i < words.length; i++) {
    // int c = count.getOrDefault(words[i], 0);
    // count.put(words[i], c + 1);
    // }
    // List<String> rec = new ArrayList<String>();
    // for (Map.Entry<String, Integer> entry : count.entrySet()) {
    // rec.add(entry.getKey());
    // }
    // Collections.sort(rec, (String a, String b) -> {
    // return count.get(a) == count.get(b) ? a.compareTo(b) : count.get(a) -
    // count.get(b);
    // });
    // return rec.subList(0, k);
    // }

    public static List<String> topKFrequent(String[] words, int k) {
        // 1.先用哈希表统计单词出现的频率
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        // 2.构建小根堆 这里需要自己构建比较规则 此处为 lambda 写法 Java 的优先队列默认实现就是小根堆
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
            if (count.get(s1).equals(count.get(s2))) {
                return s2.compareTo(s1);
            } else {
                return count.get(s1) - count.get(s2);
            }
        });
        // 3.依次向堆加入元素。
        for (String s : count.keySet()) {
            minHeap.offer(s);
            // 当堆中元素个数大于 k 个的时候，需要弹出堆顶最小的元素。
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // 4.依次弹出堆中的 K 个元素，放入结果集合中。
        List<String> res = new ArrayList<String>(k);
        while (minHeap.size() > 0) {
            res.add(minHeap.poll());
        }
        // 5.注意最后需要反转元素的顺序。
        Collections.reverse(res);
        return res;
    }
}
