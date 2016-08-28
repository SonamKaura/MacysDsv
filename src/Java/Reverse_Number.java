package Java;



public class Reverse_Number {
 
    public int reverseNumber(int number){
         
        int reverse = 0;
        while(number != 0){
            reverse = (reverse*10)+(number%10);
            number = number/10;
        }
        return reverse;
    }
     
    public static void main(String a[]){
    	Reverse_Number nr = new Reverse_Number();
        System.out.println("Result: "+nr.reverseNumber(17868));
    }
}



