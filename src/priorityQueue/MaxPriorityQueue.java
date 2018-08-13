package priorityQueue;

/**
 * MaxPriorityQueue Priority Queue is an extension of queue with following properties.
 *  Every item has a priority associated with it.
 *  An element with high priority is dequeued before an element with low priority.
 *  If two elements have the same priority, they are served according to their order in the queue.
 * @implements interface IPriorityQueue 
 * @author Surbhi singh
 *
 */
public class MaxPriorityQueue implements IPriorityQueue {
	private Item QueueArray[];
	private int noOfElements;
	private int capacity;
	
	/**
	 * constructor to initiate an array for priority queue represents
	 * @param capacity
	 */
	public MaxPriorityQueue(int capacity) {
		this.capacity = capacity;
		QueueArray = new Item[capacity];
		noOfElements = 0;
	}

	/**
	 * enQueue element in the priority queue, elements are stored in ascending order based on their priority
	 * @param data of the element to be enQueued
	 * @param priority of the element to be enQueued
	 */
	@Override
	public boolean enQueue(String data, int priority) {
		Item newItem = new Item(data, priority);	
		if(noOfElements == capacity){
			return false;
		}
		int index;
		if(noOfElements == 0) {
			QueueArray[0]=newItem;
			noOfElements++;
			return true;
		}
		//QueueArray[++noOfElements] = newItem;
		for (index = 0; index < noOfElements ; index++) {
			if(QueueArray[index].getPriority() < newItem.getPriority()) {
				continue;
			}
			else {
				for(int index2 = noOfElements - 1 ; index2 >= index ; index2--) {
					QueueArray[index2 + 1] = QueueArray[index2];
				}
				break;
			}
		}
		QueueArray[index]=newItem;
		noOfElements++;
		return true;
	}

	/**
	 * @return Priority of element with highest priority
	 */
	@Override
	public String getHighestPriority() {
		if(isEmpty()) {
			throw new AssertionError();
		}
		return QueueArray[noOfElements - 1].toString();
	}


	/**
	 * removes element from priority queue with highest priority
	 * @return String reprsentation of dequeued element 
	 */
	@Override
	public Item deQueueHighestPriority() {
		if(isEmpty()) {
			throw new AssertionError();
		}
		int lastIndex = noOfElements-1;
		Item item = QueueArray[lastIndex];
		QueueArray[lastIndex] = null;
		noOfElements--;
		return item;
	}
	
	/**
	 * @return true if there are no elements in the queue,else false
	 */
	@Override
	public boolean isEmpty() {
			return getSize() == 0;
	}
	
	/**
	 * @return no of elements in the queue
	 */
	@Override
	public int getSize() {
		return noOfElements;
	}
	
	/**
	 * display elements in the priority queue
	 */
	public void displayQueue() {
		for (int i = 0; i < noOfElements; i++) {
			System.out.println(QueueArray[i].toString());
		}
	}

	public int getPriorityAt(int index) {
		if(index < QueueArray.length) {
			return QueueArray[index].getPriority();
		}
		return -1;
	}
}
