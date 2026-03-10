package com.example.thread_analysis;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class GraphService {
    private Graph<String, DefaultEdge>threadsNet = new DefaultDirectedGraph<>(DefaultEdge.class);

    public GraphService() {
        //Adding users (Nodes)
        threadsNet.addVertex("Alice");
        threadsNet.addVertex("Bob");
        threadsNet.addVertex("Charlie");
        threadsNet.addVertex("Dan");
        threadsNet.addVertex("Eve");
        threadsNet.addVertex("Frank");


        //Adding follows (Edges)
        threadsNet.addEdge("Alice", "Bob");
        threadsNet.addEdge("Bob", "Charlie");
        threadsNet.addEdge("Charlie", "Dan");
        threadsNet.addEdge("Charlie", "Frank");
    
        threadsNet.addEdge("Alice", "Dan");
        threadsNet.addEdge("Dan", "Charlie");
        threadsNet.addEdge("Charlie", "Eve");
        threadsNet.addEdge("Eve", "Alice");

        threadsNet.addEdge("Alice", "Dan");
        threadsNet.addEdge("Dan", "Charlie");
        threadsNet.addEdge("Eve", "Alice"); 
        threadsNet.addEdge("Alice", "Frank");
        threadsNet.addEdge("Charlie", "Frank");
        

    }

    public List<String> getPath(String start, String end) {
        DijkstraShortestPath<String, DefaultEdge> dijkstra = new DijkstraShortestPath<>(threadsNet);
            var path = dijkstra.getPath(start, end);

            if (path == null) {
                return new ArrayList<>(); //return empty list instead of crashing
            }
            return path.getVertexList();
            
            //return dijkstra.getPath(start,end).getVertexList();
    }
}
