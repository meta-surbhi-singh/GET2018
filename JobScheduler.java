import java.util.InputMismatchException;
import java.util.Scanner;

public class JobScheduler {
    static Scanner sc=new Scanner(System.in);
	public int totaltime;
	public int noOfProcess;
	public int[][] process;
	public int waitingTime[];
	public int completionTime[];
	public int turnAroundTime[];
	
	
	public JobScheduler() throws InputMismatchException
	{   System.out.println("Enter no .of Processes..");
	    noOfProcess=sc.nextInt();
		process=new int[noOfProcess][2];
	    waitingTime=new int[noOfProcess];
	    completionTime=new int[noOfProcess];
	    turnAroundTime=new int[noOfProcess];
	}
	
	public void setProcess() throws InputMismatchException
	{
		System.out.println("Enter arrival time and burst time of processes in seconds");
		for(int i=0; i<noOfProcess; i++){
			for(int j=0; j<2; j++) //j<2 for two entries each for an process for arrival as well as burst time
			{
				process[i][j] = sc.nextInt();
			}
			System.out.println("\n");
		}
	}
	public void displayProcessDetails()
	{
		System.out.println("Details of processes ");
		for(int i=0; i<noOfProcess; i++)
		 { System.out.println("Process "+ (i+1));
		   System.out.print("Arrival time : "+ getArrivalTime(i));
		   System.out.println("  Burst time : "+ getBurstTime(i));
		 }
		   System.out.println("\n");
	}
	
	public int getArrivalTime(int index)
	{
		return process[index][0];
	}
	
	public int getBurstTime(int index)
	{
		return process[index][1];
	}
	
	public void findWaitingTime()
	{   int totalBurst=0;
	    int timeDiff;
	  for(int i=0;i<noOfProcess;i++)
	    { timeDiff= totalBurst-getArrivalTime(i);
		  if(timeDiff<0)
	    	{waitingTime[i]=0;
	    	 totalBurst-=timeDiff;
	    	}
		  else
		   {waitingTime[i]=timeDiff;
		    totalBurst+=getBurstTime(i);    
		   }
		 }
	  }
	public void findCompletionTime()
	{   
		 for(int i=0;i<noOfProcess;i++)
		 {
			completionTime[i]=getArrivalTime(i)+getBurstTime(i)+waitingTime[i]; 
		 }	 
	 }
		
	
	public void findTurnAroundTime()
	{
		 for(int i=0;i<noOfProcess;i++)
		 {
			turnAroundTime[i]=completionTime[i]-getArrivalTime(0); 
		 }	 
 
	}
	
	
	public void displayCompletionTime()
	{
		System.out.println("Completion time of processes ");
		for(int i=0; i<noOfProcess; i++)
		 { System.out.print("Process "+ (i+1));
		   System.out.println("  Completion time : "+ completionTime[i]);
		 }
		   System.out.println("\n");
	}
	
	public void displayWaitingTime()
	{
		System.out.println("Waiting time of processes ");
		for(int i=0; i<noOfProcess; i++)
		 { System.out.print("Process "+ (i+1));
		   System.out.println("  Waiting time : "+ waitingTime[i]);
		   
		 }
		   System.out.println("\n");
	}
	
	public void displayTurnAroundTime()
	{
		System.out.println("Turn around time of processes ");
		for(int i=0; i<noOfProcess; i++)
		 { System.out.print("Process "+ (i+1));
		   System.out.println("  Turn around time : "+ turnAroundTime[i]);
		   
		 }
		   System.out.println("\n");
	}
	
	public int findAverageWaitingTime() throws ArithmeticException
	{   int sumWaitingTime=0;
	    for(int i=0; i<noOfProcess; i++) 
	    { sumWaitingTime+=waitingTime[i];
	    }
	    return sumWaitingTime/noOfProcess;
	}
	public int findMaximumWaiting()
	{   int maxWaitingTime=waitingTime[0];
	    for(int i=1; i<noOfProcess; i++)
	    {
	    	if(waitingTime[i]>maxWaitingTime)
	    		maxWaitingTime=waitingTime[i];
	    }
		return maxWaitingTime;
	}
	
	public static void main(String[] args) 
	{
	try {
	
	JobScheduler jS=new JobScheduler();
	jS.setProcess();
	jS.displayProcessDetails();
	jS.findWaitingTime();
	jS.displayWaitingTime();
	jS.findCompletionTime();
	jS.displayCompletionTime();
	jS.findTurnAroundTime();
	jS.displayTurnAroundTime();
	System.out.println("The Average waiting time for these "+jS.noOfProcess+ " processes is "+ jS.findAverageWaitingTime() +" seconds.");
	System.out.println("The Maximum waiting time for any process is "+jS.findMaximumWaiting() +" seconds.");
	}
	catch(InputMismatchException imm)
	{
		System.out.println("Please enter integer values as seconds");
	}
	catch(ArithmeticException ae)
	{
		System.out.println("No. of processes has to be more than 0..");
	}
	}
		 
}
