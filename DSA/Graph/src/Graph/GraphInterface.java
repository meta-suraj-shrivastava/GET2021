package Graph;

import java.util.ArrayList;
import java.util.Set;

public interface GraphInterface {

	void addNode(int weight,char nodeName,char connectedFrom);
	boolean isConnected();
	ArrayList<Character> reachable(char a);
	Set<String> mst();
	String shortestPath(char start,char end);
	
}
