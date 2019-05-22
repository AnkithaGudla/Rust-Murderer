import java.io.*;
import java.util.*;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static StringBuffer sb = new StringBuffer();

    static Map<String, Collection<String>> mainRoadsMap;
    static int[] dists;

    public static void main(String[] args) {
	    int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            processTestCase();
        }
        System.out.println(sb.toString());
    }

    static void processTestCase() {
        int n = in.nextInt();
        readMainRoadsMap();
        int s = in.nextInt();
        traverseMap(n, s);
        writeResults(n, s);
    }

    static void readMainRoadsMap() {
        int m = in.nextInt();
        mainRoadsMap = new HashMap<String, Collection<String>>();
        for (int i = 0; i < m; i++) {
            String x = in.next();
            String y = in.next();
            if (!mainRoadsMap.containsKey(x)) {
                mainRoadsMap.put(x, new ArrayList<String>());
            }
            if (!mainRoadsMap.containsKey(y)) {
                mainRoadsMap.put(y, new ArrayList<String>());
            }
            mainRoadsMap.get(x).add(y);
            mainRoadsMap.get(y).add(x);
        }
    }

    static void traverseMap(int n, int s) {
        List<String> queue = new ArrayList<String>();
        boolean[] visited = new boolean[n+1];
        dists = new int[n + 1];

        queue.add(String.valueOf(s));
        visited[s] = true;

        int counter = 1;
        while (!queue.isEmpty() && counter < n) {
            String v = queue.remove(0);
            int vi = Integer.valueOf(v);
            Collection<String> nbs = mainRoadsMap.containsKey(v) ? mainRoadsMap.get(v) : new ArrayList<String>();
            boolean[] isNb = new boolean[n+1];
            for (String nb : nbs) {
                isNb[Integer.parseInt(nb)] = true;
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && !isNb[i]) {
                    dists[i] = dists[vi] + 1;
                    queue.add(String.valueOf(i));
                    visited[i] = true;
                    counter++;
                }
            }
        }
    }

    static void writeResults(int n, int s) {
        for (int i = 1; i < s; i++) {
            sb.append(dists[i]).append(' ');
        }
        for (int i = s + 1; i <= n; i++) {
            sb.append(dists[i]).append(' ');
        }
        sb.append('\n');
    }
}