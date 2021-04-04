package graph;

import java.util.List;
public interface GraphInterface {

	boolean isConnected(int[][] connections);
	List<Integer> isReachable(int[][] connections, int vertex);
	int minKey(int graph[][], int key[], boolean mstSet[]);
	void findMST(int graph[][]);
	int minDistance(int distance[], boolean isVisited[]);
	void findShortestPath(int graph[][], int source, int destination);
	
}
