package Graph;

import java.util.ArrayList;

public interface GraphInterface {

	boolean isConnected();
	ArrayList<Character> reachable(char a);
	ArrayList<Node> mst();
	ArrayList<Node> shortestPath(Node start,Node end);
	
}
