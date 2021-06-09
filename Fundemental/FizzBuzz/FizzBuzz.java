public class FizzBuzz {
    
	
    public static void fizzBuzz(int number) {
	if (number%3 ==0 && number%5 ==0) {
		System.out.println("FizzBuzz"); 

	}

        else if (number%3 ==0) {
		System.out.println("fizz"); // 3

	}
 	else if (number%5 ==0) {
		System.out.println("Buzz"); // 5

	}

	

    }

public static void main(String[] args) {
	fizzBuzz(15) ;   
	}
}
