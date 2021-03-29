package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph implements GraphInterface {

	private ArrayList<Node> graph;
	private ArrayList<Character> nodeArray = new ArrayList<Character>();
	
	Graph(){
		graph = new ArrayList<>();
	}
	@Override
	public void addNode(int weight, char source, char destination) {
		Node destNode = new Node(weight, destination); ;
		Node tempNode = null;
		for(Node node:graph){
			if(node.nodeName == source){
				tempNode = node;
				break;
			}
		}
		if(tempNode!=null){
			while(tempNode.next!=null){
				tempNode = tempNode.next;
			}
			tempNode.next = destNode;
		}
		else{
			Node sourceNode = new Node(0, source);
			sourceNode.next = destNode;
			graph.add(sourceNode);
		}
		if(!nodeArray.contains(source)) nodeArray.add(source);
		if(!nodeArray.contains(destination)) nodeArray.add(destination);
		
		
	}

	@Override
	public boolean isConnected() {
		int totalNodes = graph.size();
		for(Node node:graph){
			int connected = 0;
			while(node!=null){
				node=node.next;
				connected+=1;
			}
			if(connected!=totalNodes) return false;
		}
		
		return true;
	}

	@Override
	public ArrayList<Character> reachable(char a) {
		ArrayList<Character> path = new ArrayList<>();
		for(Node node:graph){
			if(node.nodeName != a) continue;
			while(node!=null){
				path.add(node.nodeName);
				node = node.next;
					
			}
		}
		return path;
	}

	@Override
	public Set<String> mst() {
		HashMap<Character,Character> parents = new HashMap<>();
		HashMap<String,Integer> mst = new HashMap<>();
		for(Node node:graph){
			String path = node.nodeName + " to ";
			Node tmpNode = node;
			int min = Integer.MAX_VALUE;
			while(tmpNode!=null){
				if(!findCycle(parents,node.nodeName,tmpNode)){
					if(tmpNode.weight<min){
						
					}
				}
				tmpNode = tmpNode.next;
			}
		}
		if(mst.size() == graph.size()-1) return mst.keySet();

		
		for(String path:mst.keySet()){
		}
		
		return mst.keySet();
	}

	private boolean findCycle(HashMap<Character,Character> parents,char nodeName, Node tmpNode) {
		if((parents.containsKey(nodeName)
				&& parents.get(nodeName)== tmpNode.nodeName) || nodeName == tmpNode.nodeName){
			return true;
		}
		
		return false;
	}
	@Override
	public ArrayList<Node> shortestPath(Node start, Node end) {
		
		return null;
	}
	
	int getTotalNode(){
		return this.nodeArray.size();
	}
	
	void displayGraph(){
		for(Node node:graph){
			System.out.print(node.nodeName);
			node = node.next;
			while(node!=null){
				System.out.print("--->"+node.nodeName);
				node = node.next;
			}
			System.out.println();
		}
	}

}
