package priorityQueue;

public interface IPriorityQueue{

	public boolean enQueue(String data, int priority);
	public String getHighestPriority();
	public String deQueueHighestPriority();
	public boolean isEmpty();
	public int getSize();
}
