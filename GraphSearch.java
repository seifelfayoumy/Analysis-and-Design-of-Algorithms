import java.util.*;

public class GraphSearch {
    private LinkedList<Integer>[] adj; // Adjacency list
    private int V; // Number of vertices
    private int[] parent; // To store the parent of a given vertex


    GraphSearch(int v) {
        V = v + 1; 
        adj = new LinkedList[V];
        parent = new int[V];
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
    
    void printCycle(int v, int u) {
        LinkedList<Integer> cycle = new LinkedList<>();
        cycle.add(u);
        while (v != u) {
            cycle.addFirst(v);
            v = parent[v];
        }
        cycle.addFirst(u);
        System.out.println("Cycle: " + cycle);
    }

    boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {
        if (recStack[v]) {
            return true;
        }

        if (visited[v]) {
            return false;
        }

        visited[v] = true;
        recStack[v] = true;

        for (int n : adj[v]) {
            parent[n] = v;
            if (isCyclicUtil(n, visited, recStack)) {
                printCycle(n, v);
                return true;
            }
        }

        recStack[v] = false;
        return false;
    }

    void isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 1; i < V; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                System.out.println("Graph contains cycle");
                return;
            }
        }
        System.out.println("Graph doesn't contain cycle");
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
        
        g.isCyclic();
    }
}
