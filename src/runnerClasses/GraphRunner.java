package runnerClasses;
import java.util.List;

import graph.*;

public class GraphRunner {
	static Graph graph = new Graph(3);
	
	public static void main(String args[]) {
		
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(2, 3, 4);
		GraphRunner.display(graph.edgeList);
		System.out.println(graph.isConnected());
		graph.reachable(1);
		graph.reachable(3);
		//display(graph.minimumSpanningTree());
		System.out.println();
		
		
		
	}
	
	static public void display(List<Edge> edgeList) {
		System.out.println("GRAPH : ");
		for (int index = 0 ; index < edgeList.size(); index++) {
			System.out.println(edgeList.get(index));
		}
	}

}
