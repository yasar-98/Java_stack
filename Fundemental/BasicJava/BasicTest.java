import java.util.Arrays;  

public class BasicTest {
    public static void main(String[] args) {
        BasicJava test = new BasicJava();
		//test.print255();
		//test.printOdd255();
		//test.printSum255();
		int[] myArray = {1, 2, 3, 4, 5};
		//test.arrayLoop(myArray);
		//test.arrayMax(myArray);
		//test.printAvg(myArray);
		//test.arrayOdd255();		
		//test.printGreaterY(myArray,8);		
		//int[] sqr= test.printSquare(myArray);	
		//System.out.println(Arrays.toString(sqr));
		//int[] neg= test.eliminateNeg(myArray);	
		//System.out.println(Arrays.toString(neg));
		//test.printMaxMinAvg(myArray);
		int[] shift= test.shiftValue(myArray);	
		System.out.println(Arrays.toString(shift));

	}
}