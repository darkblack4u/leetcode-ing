package xh.online.rongyao;

import java.util.*;

/**
 * 忘了三个.以上的情况了，83.33
 */
public class rongyao3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        sc.close();
        System.out.println(realPath(path));
    }

    private static String realPath(String path) {
        ArrayList<String> list = new ArrayList<>();
        char[] paths = path.trim().toCharArray();
        int index = 0;
        StringBuilder pathString = new StringBuilder();
        pathString.append('/');
        if (paths[index] != '/') {
            return pathString.toString();
        }
        while (index < paths.length) {
            if (paths[index] == '.') {
                index++;
                if (index < paths.length) {
                    if (paths[index] == '.') {
                        if (list.size() > 0) {
                            list.remove(list.size() - 1);
                        }
                    } else if (paths[index] != '/') {
                        StringBuilder sb = new StringBuilder();
                        sb.append(".");
                        while (index < paths.length && paths[index] != '/') {
                            sb.append(paths[index]);
                            index++;
                        }
                        list.add(sb.toString());
                    }
                }
            } else if (paths[index] == '/') {
                while (index < paths.length && paths[index] == '/') {
                    index++;
                }
            } else if (paths[index] == '\\') {
                while (index < paths.length && paths[index] == '\\') {
                    index++;
                }
            } else if (paths[index] == ' ') {
                continue;
            } else {
                StringBuilder sb = new StringBuilder();
                while (index < paths.length && paths[index] != '/') {
                    sb.append(paths[index]);
                    index++;
                }
                if (sb.length() > 0) {
                    list.add(sb.toString());
                }
            }
        }
        if (list.size() > 0) {
            for (String p : list) {
                pathString.append(p).append('/');
            }
            pathString.deleteCharAt(pathString.length() - 1);
        }
        return pathString.toString();
    }
}