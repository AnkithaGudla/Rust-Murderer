package task;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class roads {

        private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String args[]) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    private static void dfs(int node, Map<Integer, List<Integer>> graph, boolean visited[], List<Integer> ccNodes) {
        visited[node] = true;
        ccNodes.add(node);

        List<Integer> nodes = graph.get(node);
        if (nodes != null) {
            for (Integer v : nodes) {
                if (!visited[v]) {
                    dfs(v, graph, visited, ccNodes);
                }
            }
        }
    }

    private static void solve(InputReader in, PrintWriter out) {
        int Q = in.nextInt();
        for (int i = 0; i < Q; i++) {
            int N = in.nextInt();
            int M = in.nextInt();
            int lCost = in.nextInt();
            int rCost = in.nextInt();
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int j = 0; j < M; j++) {
                int u = in.nextInt();
                int v = in.nextInt();

                List<Integer> nodes = graph.get(u);
                if (nodes == null) {
                    nodes = new ArrayList<>();
                }
                nodes.add(v);
                graph.put(u, nodes);

                nodes = graph.get(v);
                if (nodes == null) {
                    nodes = new ArrayList<>();
                }
                nodes.add(u);
                graph.put(v, nodes);
            }
            boolean avisited[] = new boolean[N + 1];
            Arrays.fill(avisited, false);
            long answer = 0;
            for (int j = 1; j <= N; j++) {
                if (!avisited[j]) {
                    List<Integer> ccNodes = new ArrayList<>();
                    dfs(j, graph, avisited, ccNodes);

                    if (lCost <= rCost) {
                        answer += (lCost * ccNodes.size());
                    } else {
                        answer += (lCost + rCost * (ccNodes.size() - 1));
                    }
                }
            }
            out.println(answer);
        }
    }
}