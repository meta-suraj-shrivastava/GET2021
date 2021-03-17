package Graph;

import java.util.ArrayList;

public class Graph implements GraphInterface {

	private ArrayList<Node> graph;
	
	Graph(){
		graph = new ArrayList<>();
	}
	@Override
	public void addNode(int weight, char nodeName, char connectedFrom) {
		Node newNode = new Node(weight,nodeName);
		Node tempNode = null;
		boolean present = false;
		for(Node node:graph){
			if(node.nodeName == connectedFrom){
				tempNode = node;
			}
			if(node.nodeName == nodeName){
				present = true;
			}
		}
		if(tempNode!=null){
			tempNode.next = newNode;
		}
		if(!present){
			graph.add(newNode);
		}
		
		
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
	public ArrayList<Node> mst() {
		ArrayList<Node> mst = new ArrayList<>();
		
		return null;
	}

	@Override
	public ArrayList<Node> shortestPath(Node start, Node end) {
		// TODO Auto-generated method stub
		return null;
	}

}
