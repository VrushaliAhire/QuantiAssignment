package Quantinsti;

import java.util.ArrayList;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> multipleOf3 = new ArrayList<Integer>();
		ArrayList<Integer> multipleOf5 = new ArrayList<Integer>();
		int Additionfor3 = 0;
		int Additionfor5 = 0;
		
		int num;
		for( num =0; num < 1000 ; num++)
		{
	        if(num % 3 == 0)
	        {
	            multipleOf3.add(num);
	            Additionfor3 += num;
	        }
	        else
	        	if(num % 5 == 0)
	        {
	            multipleOf5.add(num);
	            Additionfor5 += num;
	        }
	        
	    }
		System.out.println(Additionfor3 + Additionfor5);
		
		
	}

}
