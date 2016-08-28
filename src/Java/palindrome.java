package Java;

public class palindrome {
	public static void main(String []args)
	{
		String str1[]={"x","y","z"};
		String str2[]={"","",""};
		System.out.println("String Length is "+str1.length);

		for(int i=str1.length-1,j=0;i>=0;i--,j++)
		{
			str2[j]=str1[i];
		}
		
		for(int i=0;i<str2.length;i++)
		{
			System.out.println(str2[i]);
			
		}
		
	}

}
