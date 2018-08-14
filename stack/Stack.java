package stack;

public interface Stack<T>{
	public boolean push(T pushedElement);
	public T pop();
	public boolean isEmpty();
	public T getTop();
}
