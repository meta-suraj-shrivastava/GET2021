package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
			while(tempNode.next!=null){
				tempNode = tempNode.next;
			}
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
	public Set<String> mst() {
		HashMap<String,Integer> mst = new HashMap<>();
		ArrayList<Character> source = new ArrayList<>();
		ArrayList<Character> destination = new ArrayList<>();
		for(Node node:graph){
			String path = node.nodeName + " to ";
			if(node.next == null) continue;
			char nearestNode = node.next.nodeName;
			int weight = node.next.weight;
			node = node.next;
			while(node!=null){
				if(node.weight < weight && destination.indexOf(node.nodeName)!=source.indexOf(nearestNode)){
					nearestNode = node.nodeName;
					weight = node.weight;
				}
				node = node.next;
			}
			path+=nearestNode;
			mst.put(path,weight);
			source.add(node.nodeName);
			destination.add(nearestNode);
		}
		if(mst.size() == graph.size()-1) return mst.keySet();
		
		String key = path;
		int minWeight = mst.get(path);
		
		
		for(String path:mst.keySet()){
		}
		
		return mst.keySet();
	}

	@Override
	public ArrayList<Node> shortestPath(Node start, Node end) {
		// TODO Auto-generated method stub
		return null;
	}

}
