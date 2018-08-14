package graph;

import stack.*;
import java.util.*;

import queue.QueueArray;

public class Graph implements UndirectedWeightedGraph {
	public List<Edge> edgeList = new ArrayList<Edge>();
	StackArray<Integer> DFSResult;
	public int noOfVertices;
	

	public Graph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		DFSResult = new StackArray<Integer>(Integer.class, noOfVertices);
	}

	public void addEdge(int vertex1, int vertex2, int weight) {
		for (Edge edge : edgeList) {
			if (edge.vertex1 == vertex2 && edge.vertex2 == vertex1) {
				return;
			}
		}
		edgeList.add(new Edge(vertex1, vertex2, weight));
	}

	@Override
	public boolean isConnected() {
		int parent = -1;
		List<Integer> visited = new ArrayList<Integer> ();
		DFS(edgeList.get(0).vertex1, visited, parent);
		if(DFSResult.getElements().length == noOfVertices) {
			return true;
		}
		return false;
	}

	/**
	 * Depth-first search (DFS) is an algorithm for traversing or searching tree or graph data structures
	 * It starts at the root node (an arbitrary node is selected as the root node in the case of a graph)
	 * and explores as far as possible along each branch before backtracking, if there are no adjacent unvisited nodes.
	 * it is use to check cycle
	 * @param vertex
	 * @param visited
	 * @return 
	 */
	public boolean DFS(int vertex, List<Integer> visited, int parent) {
		// Mark the current node as visited and print it
		if(!visited.contains(vertex)) {
		visited.add(vertex);
		DFSResult.push(vertex);
		parent = vertex;
		if(visited.containsAll(getNeighbours(vertex))) {
			DFSResult.pop();
			DFS(DFSResult.getTop(),visited,parent);
		}
		else {
			List<Integer> neighbours = getNeighbours(vertex);
		// Search for all the neighbors of this vertex and start recurring from the first encountered neighbour that is not visited yet.
		for (int index = 0; index < neighbours.size(); index++) {
			if (!visited.contains(neighbours.get(index))) { 
				DFS(neighbours.get(index), visited, parent);
			}
			else {
				if(parent != vertex) {
					return true;
				}
			}
			}
		}
		}
		return false;
	}
	
	private List<Integer> getNeighbours(int vertex) {
		List<Integer> neighbours = new ArrayList<>();
		for(int index = 0; index < edgeList.size(); index++) {
			if(edgeList.get(index).vertex1 == vertex) {
				neighbours.add(edgeList.get(index).vertex2);
			}
			else if(edgeList.get(index).vertex2 == vertex) {
				neighbours.add(edgeList.get(index).vertex1);
			}
		}
		return neighbours;
	}

	/**
	 * this methods returns all the vertices reachable from a given vertex
	 * 
	 * @param vertex
	 * @return
	 */
	@Override
	public List<Integer> reachable(int vertex) {
		List<Integer> reachableList = new ArrayList<Integer>();
		for (Edge edge : edgeList) {
			if (edge.vertex1 == vertex) {
				reachableList.add(edge.vertex2);
			}
			else if(edge.vertex2 == vertex) {
				reachableList.add(edge.vertex1);
				}
			}
		System.out.print("\nVertices reachable from " + vertex + " are ");
		for (int index = 0; index < reachableList.size(); index++) {
			System.out.print(reachableList.get(index) + " ");
		}
		return reachableList;
	}

	@Override
	public List<Edge> minimumSpanningTree() {
		List<Edge> mstEdgeList = new ArrayList<Edge>();
		List<Edge> tempEdgeList = edgeList;// This will store the resultant MST
		Collections.sort(tempEdgeList);     
		for (Iterator<Edge> iterator = tempEdgeList.iterator(); iterator.hasNext();) {
			Edge edge = (Edge) iterator.next();
			mstEdgeList.add(getMinimum(tempEdgeList));
			if(checkCycle(mstEdgeList)) {
				mstEdgeList.remove(edge);
			}
			iterator.remove();
		}
		return mstEdgeList;
	}

	private Edge getMinimum(List<Edge> edgeList) {
		return edgeList.get(0);
	}
	
	private boolean checkCycle(List<Edge> mstEdgeList) {
		int parent = -1;
		List<Integer> visited = new ArrayList<Integer> ();
		return DFS(mstEdgeList.get(0).vertex1, visited, parent);
	}
	
	@Override
	public List<Edge> shortestPath(int source) { 
		int[] sourceDistance = new int[noOfVertices];
		sourceDistance[0] = 0; //distance of source from itself will be zero
		for (int index = 0; index < sourceDistance.length; index++) {
			sourceDistance[index] = Integer.MAX_VALUE; //initiate distance to source from each vertex as maximum
		}
		QueueArray<Integer> queue = new QueueArray<Integer>(Integer.class, noOfVertices);
		for (int index = 0 ; index < noOfVertices; index++) {
			queue.enQueue(getAllVertices()[index]);
		}
		List<Integer> visited = new ArrayList<Integer> ();
		
		List<Edge> shortestPathEdgeList = dijkstraAlgorithm(source, sourceDistance, queue, visited); //method call to the Dijkstra algorithm
		return shortestPathEdgeList;
	}
	
	private List<Edge> dijkstraAlgorithm(int source, int[] sourceDistance, QueueArray<Integer> queue, List<Integer> visited) {
		List<Edge> shortestPathEdgeList = new ArrayList<Edge>();
		List<Integer> neighbours;
		while(!queue.isEmpty()) {
			if(!visited.contains(source)) {
				visited.add(source);
				queue.deQueue();
			}
			neighbours = getNeighbours(source);
			int alternateDistance;
			for (int index = 0; index < neighbours.size(); index++) {
				alternateDistance = sourceDistance[source] + edgeList.get(index).getWeight();
				if(alternateDistance < sourceDistance[neighbours.get(index)]) {
					sourceDistance[neighbours.get(index)] = alternateDistance;
				}
			}
		}
		return shortestPathEdgeList;
	}

	private int [] getAllVertices() {
		int[] vertices = new int[noOfVertices];
		List<Integer> added = new ArrayList<Integer>();
		for (int vertexIndex = 0,edgeIndex = 0; vertexIndex < noOfVertices && edgeIndex < edgeList.size(); edgeIndex++) {
			if(!added.contains(edgeList.get(edgeIndex).vertex1)) {
				vertices[vertexIndex] = edgeList.get(edgeIndex).vertex1;
				added.add(vertices[vertexIndex]);
				vertexIndex++;
			}
			if(!added.contains(edgeList.get(edgeIndex).vertex2)) {
				vertices[vertexIndex] = edgeList.get(edgeIndex).vertex2;
				added.add(vertices[vertexIndex]);	
				vertexIndex++;
			}
		}
		for (int index = 0 ; index < noOfVertices; index++) {
			System.out.println(vertices[index]);
		}
		return vertices;
	}
}
