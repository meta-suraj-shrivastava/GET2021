package graph;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class Graph implements GraphInterface {

	/**
	 * Check if the all nodes of the graph are connected or not
	 * 
	 * @param connections
	 * @return
	 */
	@Override
	public boolean isConnected(int[][] connections) {
		if(connections==null) {
			throw new NullPointerException("Null value passed");
		}
		int h = connections.length;
		
		if (h == 0) {
			throw new NullPointerException();
		}
		boolean isVisited[] = new boolean[connections.length];

		isConnectedUtil(connections, 0, 0, isVisited);

		for (int i = 0; i < isVisited.length; i++) {
			if (isVisited[i] == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Utility method for isConnected to visit every node
	 * 
	 * @param connections
	 * @param row
	 * @param column
	 * @param isVisited
	 */
	private void isConnectedUtil(int connections[][], int row,
			int column, boolean isVisited[]) {
		if (row < 0 || column < 0 || row >= connections.length
				|| column >= connections.length || connections[row][column] < 0
				|| isVisited[row]) {
			return;
		}

		isVisited[row] = true;
		isConnectedUtil(connections, row + 1, column, isVisited);
		isConnectedUtil(connections, row - 1, column, isVisited);
		isConnectedUtil(connections, row, column + 1, isVisited);
		isConnectedUtil(connections, row, column - 1, isVisited);

	}

	/**
	 * Method to add all node to a list which are reachable from given node
	 * 
	 * @param connections
	 * @param row
	 * @param column
	 * @param isVisited
	 * @param vertices
	 */
	private void isReachableUtil(int connections[][], int row,
			int column, boolean isVisited[], List<Integer> vertices) {
		if (row < 0 || column < 0 || row >= connections.length
				|| column >= connections.length || connections[row][column] < 0
				|| isVisited[row]) {
			return;
		}

		isVisited[row] = true;
		vertices.add(row);
		isReachableUtil(connections, row + 1, column, isVisited, vertices);
		isReachableUtil(connections, row - 1, column, isVisited, vertices);
		isReachableUtil(connections, row, column + 1, isVisited, vertices);
		isReachableUtil(connections, row, column - 1, isVisited, vertices);
	}

	/**
	 * Find all nodes which are reachable from given node
	 * 
	 * @param connections
	 * @param vertex
	 * @return List Of nodes
	 */
	@Override
	public List<Integer> isReachable(int[][] connections, int vertex) {
		if(connections==null) {
			throw new NullPointerException("Null reference is passed");
		}
		int h = connections.length;
		
		if (h == 0) {
			throw new EmptyStackException();
		}
		boolean isVisited[] = new boolean[connections.length];
		LinkedList<Integer> vertices = new LinkedList<Integer>();
		
		for (int i = 0; i < h; i++) {
			isReachableUtil(connections, vertex, i, isVisited, vertices);
		}
		return vertices;
	}

	/**
	 * Find the node which have the minimum weight to reach
	 * 
	 * @param graph
	 * @param key
	 * @param mstSet
	 * @return index of node
	 */
	@Override
	public int minKey(int graph[][], int key[], boolean mstSet[]) {
		int minKey = Integer.MAX_VALUE;
		int vertex = 0;
		for (int index = 0; index < graph.length; index++) {
			if (mstSet[index] == false && key[index] < minKey) {
				minKey = key[index];
				vertex = index;
			}
		}
		return vertex;
	}

	/**
	 * Find the minimum spanning tree in a graph
	 * 
	 * @param graph
	 */
	@Override
	public void findMST(int graph[][]) {
		if(graph==null) {
			throw new NullPointerException("Graph passed is null");
		}else if(graph.length==0) {
			throw new EmptyStackException();
		}
		
		/*We are using the prims algorithm to find the minimum
		 *spanning tree which uses greedy approach 
		 */
		int key[] = new int[graph.length];//To store weight of the nodes
		boolean mstSet[] = new boolean[graph.length];//To store traversed nodes
		int parent[] = new int[graph.length];// To store parent node of a node

		//Traversing through every node in the graph
		for (int index = 0; index < graph.length; index++) {
			mstSet[index] = false;
			key[index] = Integer.MAX_VALUE;
		}
		key[0] = 0;
		parent[0] = -1;
		
		for (int index = 0; index < graph.length - 1; index++) {
			int minkey = minKey(graph, key, mstSet);
			mstSet[index] = true;

			for (int column = 0; column < graph.length; column++) {
				if (graph[minkey][column] > 0 && mstSet[column] == false
						&& key[column] > graph[minkey][column]) {
					key[column] = graph[minkey][column];
					parent[column] = minkey;
				}
			}
		}
		for (int i = 1; i < parent.length; i++) {
			System.out.println(i + "-" + parent[i] + "-->"
					+ graph[parent[i]][i]);
		}
	}

	/**
	 * Finds the minimum distance of nodes from source node
	 * 
	 * @param distance
	 * @param isVisited
	 * @return minValue
	 */
	public int minDistance(int distance[], boolean isVisited[]) {
		int minDistnce = Integer.MAX_VALUE;
		int minValue = 0;
		
		for (int index = 0; index < distance.length; index++) {
			if (isVisited[index] == false && distance[index] < minDistnce) {
				minDistnce = distance[index];
				minValue = index;
			}
		}
		return minValue;
	}

	/**
	 * Finds the shortest path from source to destination
	 * 
	 * @param graph
	 * @param source
	 * @param destination
	 */
	@Override
	public void findShortestPath(int graph[][], int source, int destination) {
		int distance[] = new int[graph.length];
		boolean isVisited[] = new boolean[graph.length];
		int parent[] = new int[graph.length];
		
		for (int index = 0; index < graph.length; index++) {
			isVisited[index] = false;
			distance[index] = Integer.MAX_VALUE;
		}
		distance[source] = 0;

		for (int index = 0; index < graph.length - 1; index++) {

			int minkey = minDistance(distance, isVisited);
			isVisited[minkey] = true;

			for (int column = 0; column < graph.length; column++) {
				if (graph[minkey][column] != 0
						&& isVisited[column] == false
						&& distance[minkey] != Integer.MAX_VALUE
						&& distance[minkey] + graph[minkey][column] < distance[column]) {
					{
						distance[column] = distance[minkey]
								+ graph[minkey][column];
						parent[column] = source;
					}
				}
			}
		}
		
		for (int index = 0; index < parent.length; index++) {
			System.out.println(parent[index] + "->>" + index + "-wt->"
					+ distance[index]);
		}
	}
}