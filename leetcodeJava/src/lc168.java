public class lc168 {
    /**
     * 
     * 168. Excel表列名称 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
     * 
     * https://leetcode-cn.com/problems/excel-sheet-column-title/
     * 
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int num = (columnNumber - 1) % 26;
            char ch = (char) ('A' + num);
            sb.append(ch);
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
