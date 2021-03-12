package Dictonary;

/*
 * this class provide the node of the binary tree
 */
class Node{
	int key;
	String value;
	Node left;
	Node right;
	Node(int key,String value){
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
	BinMap(){
		root = null;
	}
	
	
	//insert Node to the binary tree contains key value pair ,required key and value
	void insert(int key,String value){
		Node newNode = new Node(key,value);
		if(root == null){
			root = newNode;
			return;
		}
		Node temp = root;
		while(temp.left!=null && temp.right!=null && temp.key != key){
			System.out.println("Printing"+temp.key);
			if(temp.key<key){
				temp = temp.right;
			}
			else{
				temp = temp.left;
			}
		}
		if(key < temp.key) temp.left = newNode;
		else if (key > temp.key) temp.right = newNode;
		else temp.value = value;
	}
	
	//return the value of the node having the same key as provided
	String getValue(int key){
		if(root == null) return "Dictonary is empty";
		Node temp = root;
		while(temp!=null){
			if(temp.key == key) return temp.value;
			else if(key<temp.key) temp = temp.left;
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
	
	private Node delete(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
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
 
    private int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null) 
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    
    Node delete(int key){
    	return delete(root,key);
    }
}
