package Node;

public class Node<T>
{
private T data;
private Node<T> link;

public Node(T data){  
this.data=data;
}

public Node<T> getLink() {
	return link;
}

public T getData() {
	return data;
}

public void setLink(Node<T> nptr) {
	link=nptr;
}

}
