package Homework2;

public class ContiguousArray { 
		
	public void maxnum(int a[]) {
	
	int sum =0;
	int maxsum =0;
	for (int i=0;i<a.length;i++)
	{
		sum=sum+a[i];
		if(sum<0)
		   {sum = 0; 
		    }
		else if (sum>maxsum)
			maxsum=sum;
	}
	System.out.println( " The sum is " + maxsum);	
}
	
}