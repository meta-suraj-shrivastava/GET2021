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
	private Node insert(Node rootNode,String key, String value){
		if(rootNode == null){
			rootNode = new Node(key,value);
			return rootNode;
		}
		if(key.compareTo(rootNode.key)> 0){
				rootNode.right = insert(rootNode.right,key,value);
			}
			else{
				rootNode.left =  insert(rootNode.left,key,value);
			}
		return rootNode;
		
	}
	
	
	//insert Node to the BST
	void insert(String key,String value){
		root =  insert(root,key,value);
		
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
	
	
	//Delete node from the BST
	//@params - root:Node , key:String
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
 
	//return the minValue of the right subTree
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
    
    //Delete the node from the user
    //@param - Key:String
    void delete(String key){
    	root = delete(root,key);
    }


    //print all the key Value pairs of map lies between upperBound and LowerBound both inclusive 
    //@param - lowerBound:String ,upperBound:String
	public void getKeyPairsBetween(String lowerBound, String upperBound) {
		getKeyPairsBetween(root,lowerBound,upperBound);
		
	}


	//method overloading to provide the root node of the tree as an argument
	private void getKeyPairsBetween(Node root, String lowerBound, String upperBound) {
		if(root == null) return;
		else{
				getKeyPairsBetween(root.left, lowerBound, upperBound);
				if(root.key.compareTo(lowerBound) >= 0 && root.key.compareTo(upperBound) <= 0)
					System.out.println(root.key+":"+root.value);
				getKeyPairsBetween(root.right, lowerBound, upperBound);
				
				
			
		}
		
	}
}
