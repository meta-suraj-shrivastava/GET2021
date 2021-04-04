package graph;

public class Node<T> {
	public T data;
	public Node<T> next;

	public Node(T data) {
		if(data==null) {
			throw new NullPointerException("Data passed is null");
		}
		this.data = data;
		this.next = null;
	}

}