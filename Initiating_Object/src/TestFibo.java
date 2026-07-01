public class TestFibo {// This is the main class that is called with the main function
	public static void main(String args[]){// Reference Variable
		System.out.println("Hello Everyone! "); 
		FibonacciEngine E1 = new FibonacciEngine();// Call the Fibonacci Engine
		
		E1.setFirstFibo(1);// method
		E1.setSecondFibo(2);
		
		E1.initFibo(1,2);
		
		E1.printFibo(20);// print first 20 Fibonacci numbers
	}
}
