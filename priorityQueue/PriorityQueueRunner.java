package priorityQueue;

public class PriorityQueueRunner {
	public static void main(String[] args) {
		MaxPriorityQueue mpq = new MaxPriorityQueue(14);
		System.out.println(mpq.getHighestPriority());	
		System.out.println(mpq.enQueue("job 1", 2));
		System.out.println(mpq.enQueue("job 2", 6));
		System.out.println(mpq.enQueue("job 3", 8));
		System.out.println(mpq.enQueue("job 4", 10));
		System.out.println(mpq.enQueue("job 5", 3));
		System.out.println(mpq.enQueue("job 6", 2));
		System.out.println(mpq.enQueue("job 7", 12));
		System.out.println(mpq.enQueue("job 8", 1));
		System.out.println(mpq.enQueue("job 9", 9));
		System.out.println(mpq.enQueue("job 10", 8));
		mpq.displayQueue();
		System.out.println();
		System.out.println(mpq.deQueueHighestPriority().toString());
		System.out.println(mpq.deQueueHighestPriority().toString());
		System.out.println();
		mpq.displayQueue();
		System.out.println();
		System.out.println(mpq.getHighestPriority());	
	}
}
