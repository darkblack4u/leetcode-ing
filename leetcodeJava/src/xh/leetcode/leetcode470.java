package xh.leetcode;

import java.util.Random;

public class leetcode470 {
    public int rand10() {
        int rand10 = 50;
        while (rand10 > 40) {
            rand10 = rand7() + (rand7() - 1) * 7;
        }
        return (rand10 - 1) % 10 + 1;
    }

    public int rand7() {
        Random r = new Random();
        return r.nextInt(7) + 1;
    }
}
