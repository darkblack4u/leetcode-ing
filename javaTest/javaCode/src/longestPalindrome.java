// 5. 最长回文子串
// 给你一个字符串 s，找到 s 中最长的回文子串。

 

// 示例 1：

// 输入：s = "babad"
// 输出："bab"
// 解释："aba" 同样是符合题意的答案。
// 示例 2：

// 输入：s = "cbbd"
// 输出："bb"
// 示例 3：

// 输入：s = "a"
// 输出："a"
// 示例 4：

// 输入：s = "ac"
// 输出："a"
 

// 提示：

// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成

class Solution {
    public String longestPalindrome(String s) {
        if(s == "" || s.length() == 1) return s;
        int max = 0;
        String sb = ""; 
        for(int i = 0; i < s.length() - 1; i++){
            int length = 1;
            String subS = s.substring(i, i+1);
            String a = sub(s, i, i);
            String b = sub(s, i, i + 1);
            if(a.length() > b.length()){
                length = a.length();
                subS = a;
            }else{
                length = b.length();
                subS = b;
            }
            if(length > max){
                max = length;
                sb = subS;
            }
        }
        return sb;
    }
    public String sub(String s, int left, int right){
        if(left != right && s.charAt(left) != s.charAt(right)) {
            return s.substring(left, right);
        }
        int start = left;
        int end = right;
        for(int i = 1; i <= left && i <= s.length() - 1 - right; i ++){
            if(s.charAt(left - i) == s.charAt(right + i)){
                start--;
                end++;
            }else{
                break;
            }
        }
        return s.substring(start, end + 1);
    }
}