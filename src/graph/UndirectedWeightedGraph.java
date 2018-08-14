package graph;
import java.util.List;

public interface UndirectedWeightedGraph {
	List<Integer> reachable(int vertex);
	boolean isConnected();
	List<Edge> minimumSpanningTree();
	List<Edge> shortestPath(int source);

}
