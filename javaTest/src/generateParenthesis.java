class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        backtrick(result, n, 0, 0, sb);
        return result;
    }
    public void backtrick(List<String> result, int n, int left, int right, StringBuffer sb){
        if(left == n && right == n){
            result.add(sb.toString());
        }else{
            if(left < n){
                sb.append('(');
                backtrick(result, n, left + 1, right, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if(right < left){
                sb.append(')');
                backtrick(result, n, left, right + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}