import java.util.*;

public class GraphSearch {
    private LinkedList<Integer>[] adj; // Adjacency list
    private int V; // Number of vertices

    GraphSearch(int v) {
        V = v + 1; 
        adj = new LinkedList[V];
        for (int i = 1; i < V; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        // If the graph is undirected, uncomment the following line:
        //adj[w].add(v);
    }

    void DFS(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v]) {
            if (!visited[n]) {
                DFS(n, visited);
            }
        }
    }

    void BFS(int s) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");
            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    boolean isBipartite() {
        int[] colorArr = new int[V];
        Arrays.fill(colorArr, -1);

        for (int i = 1; i < V; i++) {
            if (colorArr[i] == -1) {
                if (!isBipartiteUtil(i, colorArr)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartiteUtil(int src, int[] colorArr) {
        colorArr[src] = 1;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adj[u]) {
                if (colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    queue.add(v);
                } else if (colorArr[v] == colorArr[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GraphSearch g = new GraphSearch(4); // 4 vertices

        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1);
        g.addEdge(4, 2);

        System.out.println("Depth First Traversal starting from vertex 1");
        g.DFS(1, new boolean[g.V]);
        System.out.println("\nBreadth First Traversal starting from vertex 1");
        g.BFS(1);

        if (g.isBipartite())
            System.out.println("\nGraph is bipartite");
        else
            System.out.println("\nGraph is not bipartite");
    }
}
