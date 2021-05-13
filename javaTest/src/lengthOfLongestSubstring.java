class Solution {
    public int lengthOfLongestSubstring(String s) {
        int positon = 0;
        int maxlength = 0;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i = 0; i < s.length(); i++){
            String letter = s.substring(i, i + 1);
            if(hm.containsKey(letter)){
                int preIndex = hm.get(letter);
                if(positon <= preIndex){
                    positon = preIndex;
                }
            }
            if(i - positon + 1 > maxlength) {
                maxlength = i - positon + 1;
            }
            hm.put(letter, i + 1);
        }
        return maxlength;
    }
}