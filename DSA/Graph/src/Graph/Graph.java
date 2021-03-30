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
		ArrayList<Character> sources = new ArrayList<>();
		ArrayList<Character> destinations = new ArrayList<>();
		HashMap<String,Integer> mst = new HashMap<>();
		for(Node node:graph){
			String path = node.nodeName + " to ";
			Node tmpNode = node;
			int min = Integer.MAX_VALUE;
			while(tmpNode!=null){
//				if(!findCycle(node.nodeName,tmpNode.nodeName,sources,destinations)){
//					if(tmpNode.weight<min){
//						
//					}
//				}
				tmpNode = tmpNode.next;
			}
		}
		if(mst.size() == graph.size()-1) return mst.keySet();

		
		for(String path:mst.keySet()){
		}
		
		return mst.keySet();
	}
	
	private boolean isVisited(char[] visited,char node){
		for(char visitedNode:visited){
			if(visitedNode == node) return true;
		}
		return false;
	}

//	private boolean findCycle(char source,char dest,ArrayList<Character> sources, ArrayList<Character>  destinations) {
//		if(source == ){
//			return true;
//		}
//		
//		return false;
//	}
	public String shortestPath(char start, char end,int totalWight,char[] visited) {
		if(start == end) return start+"-->"+end;
		else{
			String shortestPath = "";
			for(Node node:graph){
				Node tmpNode = node.next;
				if(node.nodeName == start){
					while(tmpNode!=null && !isVisited(visited,tmpNode.nodeName)){
						shortestPath+=min(shortestPath(tmpNode.nodeName, end,totalWight+tmpNode.weight,visited),
								
								);
						tmpNode = tmpNode.next;
						}
						
					}
				}
			return shortestPath;
			}

		}
	@Override
	public String shortestPath(char start,char end){
		char[] visited = new char[this.nodeArray.size()];
		return shortestPath(start, end, 0,visted);
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
