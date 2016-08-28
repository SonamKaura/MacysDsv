//http://www.careerbless.com/samplecodes/java/beginners/sorting/BubbleSortAscending.php
package Testdata;

public class Sorting {
	
	
	public static void main(String a[])
    {
        //Numbers which need to be sorted
        int numbers[] = {23,5,23,1,7,12,3,34,0};
 
        //Displaying the numbers before sorting
        System.out.print("Before sorting, numbers are ");
        for(int i = 0; i < numbers.length; i++)
        {
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
 
        //Sorting in ascending order using bubble sort
        bubbleSortInAscendingOrder(numbers);
 
        //Displaying the numbers after sorting
        System.out.print("Before sorting, numbers are ");
        for(int i = 0; i < numbers.length; i++)
        {
            System.out.print(numbers[i]+" ");
        }
 
    }
 
    //This method sorts the input array in asecnding order
 
    public static void bubbleSortInAscendingOrder( int numbers[])
    {
        int temp;
 
        for(int i = 0; i < numbers.length; i++)
        {
            for(int j = 1; j < (numbers.length -i); j++)
            {
                //if numbers[j-1] > numbers[j], swap the elements
                if(numbers[j-1] > numbers[j])
                {
                    temp = numbers[j-1];
                    numbers[j-1]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
    }
	
	/*//declaring global variable
	public static int size;
	
	public static void main(String args[])
	{
		int numbers[]={12, 34, 56, 67};
		int size=numbers.length;
		for ( int i=0;i<=size;i++)
		{
			System.out.println("Numbers need to be sorted are:"+numbers[i]);
					}
		 System.out.println();
		
		sortednum(numbers);
		// Displaying the numbers after sorting are
		for(int i=0;i<=size;i++)
		{
		System.out.println("Sorted Numbers are:"+numbers[i]);
		}
		
	}
	
	public static void sortednum(int numbers[])
	{
		int temp;
		for (int i=0;i<=size;i++)
		{
			for (int j=1;j<=size;j++)
			{
			
				if(numbers[j-1]>numbers[j])
				{
					temp=numbers[j-1];
					numbers[j-1]=numbers[j];
					numbers[j]=temp;
					                   
				}
			}
		}
		*/
	}
	
	


