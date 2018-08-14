package graph;

public class Edge implements Comparable<Edge> {
	int vertex1;
	int vertex2;
	int weight;
	
	public Edge(int vertex1, int vertex2, int weight){
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}
	
	public String toString() {
		return vertex1 + "-" + vertex2 + " Weight : " + weight;
	}
	
	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Edge edge) {
		return this.weight - edge.weight;
	}
}
