import java.util.Scanner;

public class JobScheduler {
    static Scanner sc=new Scanner(System.in);
	public int totaltime;
	public int noOfProcess;
	public int[][] process;
	public int waitingTime[];
	public int completionTime[];
	public int turnAroundTime[];
	public int averageWaitingTime;
	
	public JobScheduler(int noOfProcess)
	{  
		this.noOfProcess=noOfProcess;
		process=new int[noOfProcess][2];
	    waitingTime=new int[noOfProcess];
	    completionTime=new int[noOfProcess];
	    turnAroundTime=new int[noOfProcess];
	}
	
	public void setProcess()
	{
		System.out.println("Enter arrival time and burst time of processes ");
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
		  if(timeDiff<=0)
	    	{waitingTime[i]=0;
	    	 totalBurst+=timeDiff;
	    	}
		  else
		   {waitingTime[i]=timeDiff;
		      for(int j=1;j<=i;j++) 
		        { totalBurst+=getBurstTime(i);
		        }
		   }
		 }
	  }
	public void displayWaitingTime()
	{
		System.out.println("Waiting time of processes ");
		for(int i=0; i<noOfProcess; i++)
		 { System.out.println("Process "+ (i+1));
		   System.out.print("Waiting time : "+ waitingTime[i]);
		   
		 }
		   System.out.println("\n");
	}
	public static void main(String[] args) 
	{
	System.out.println("Enter no .of Processes..");
	int nOfP=sc.nextInt();
	JobScheduler jS=new JobScheduler(nOfP);
	jS.setProcess();
	jS.displayProcessDetails();
	jS.findWaitingTime();
	jS.displayWaitingTime();
	}
		 
}

