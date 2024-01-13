# Assignment 3 Question (Given an undirected graph, explain how you can determine whether it is a tree or not. What would be the running time?)

An undirected graph is a tree if it has the following properties:

1. **Connected**: There is a path between every pair of vertices. In other words, the graph is not divided into separate subgraphs.
2. **Acyclic**: The graph does not contain any cycles.

You can determine whether an undirected graph is a tree using **Depth-First Search (DFS)** or **Breadth-First Search (BFS)**. Here's a general approach:

1. Start DFS or BFS from any vertex.
2. If the graph is not connected, it means DFS or BFS does not visit all vertices, so it is not a tree.
3. If the graph is connected, check for a cycle. If a cycle exists, it is not a tree. You can check for a cycle during the DFS or BFS by checking if an already visited vertex is encountered that is not the parent of the current vertex.

The running time of this algorithm is $$O(V + E)$$, where $$V$$ is the number of vertices and $$E$$ is the number of edges. This is because each vertex and each edge will be visited once by the DFS or BFS algorithm. This makes the algorithm efficient for large graphs. 

Please note that this method assumes that there are no parallel edges or self-loops in the graph. If these are allowed, additional checks would be needed. 😊
