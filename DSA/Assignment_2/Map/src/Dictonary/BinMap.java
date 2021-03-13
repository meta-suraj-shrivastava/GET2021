package Dictonary;

import java.util.Iterator;

import javax.json.JsonValue;

/*
 * this class provide the node of the binary tree
 */
class Node{
	String key;
	String value;
	Node left;
	Node right;
	Node(String key,String value){
		this.key = key;
		this.value = value;
		left = null;
		right =null;
	}
}


/*
 * this class provide the basic methods to perform opertaion on map,like insertion,deletion of key value pair
 */
public class BinMap { 
	Node root;
	BinMap(Iterator<String> keys,Iterator<JsonValue> values){
		root = null;
		while(keys.hasNext()){
//			System.out.println(keys.next()+":"+values.next().toString());
			insert(keys.next(),values.next().toString());
		}
	}


	//insert Node to the binary tree contains key value pair ,required key and value
	private Node insert(Node rootNode,Node newNode){
		if(rootNode == null){
			return newNode;
		}
		System.out.println("inserting "+newNode.key);
		if(newNode.key.compareTo(rootNode.key)> 0){
			System.out.println("Going right");
				return	 rootNode.right = insert(rootNode.right,newNode);
			}
			else{
				System.out.println("Going left");
				return rootNode.left =  insert(rootNode.left,newNode);
			}
		
	}
	
	void insert(String key,String value){
//		System.out.println("Insert\n"+key+":"+value);
		Node newNode = new Node(key,value);
		if(root == null) root = newNode;
		else insert(root,newNode);
		
	}
	
	//return the value of the node having the same key as provided
	String getValue(String key){
		if(root == null) return "Dictonary is empty";
		Node temp = root;
		while(temp!=null){
			if(temp.key.compareTo(key) == 0) return temp.value;
			else if(key.compareTo(temp.key) < 0) temp = temp.left;
			else temp = temp.right;
		}
		return "Not found";
	}
	
	
	//display node using recursion ,pass root node as argument 
	private void display(Node node){
		if(node == null) return;
		else{
			display(node.left);
			System.out.println(node.key+" : "+node.value);
			display(node.right);
		}
	}
	
	//call the display function and provide the root node
	void display(){
		display(root);
	}
	
	private Node delete(Node root, String key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;
 
        /* Otherwise, recur down the tree */
        if (key.compareTo(root.key) < 0)
            root.left = delete(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = delete(root.right, key);
 
        // if key is same as root's 
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.key = minValue(root.right);
 
            // Delete the inorder successor
            root.right = delete(root.right, root.key);
        }
 
        return root;
    }
 
    private String minValue(Node root)
    {
        String minv = root.key;
        while (root.left != null) 
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    
    Node delete(String key){
    	return delete(root,key);
    }
}
