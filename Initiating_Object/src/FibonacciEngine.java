public class FibonacciEngine {
//	User-defined method
	public void printFibo(int n){// Reference Variable
		if (n <= 0) {
            System.out.println("[]");
            return;
        }
        if (n == 1) {
            System.out.println("[" + FirstNum + "]");
            return;
        }
        System.out.print("[" + FirstNum + ", " + SecondNum);// the fixed first two
        int prev = FirstNum;
        int curr = SecondNum;
        for (int i = 2; i < n; i++) {
            int next = prev + curr;// calculate from the third
            System.out.print(", " + next);
            prev = curr;
            curr = next;
        }
        System.out.println("]");
        
        System.out.println("The number is"+getFiboNum());
	}
	
	public void setFirstFibo(int n)// method
	{
	   FirstNum=n;
	}
	public void setSecondFibo(int n)
	{
	   SecondNum=n;
	}
//	private int FirstNum, SecondNum;
	
//	int FirstNum, SecondNum;
	public void initFibo(int n1 , int n2)// constructor
	{
	   FirstNum=n1;
	   SecondNum=n2; 
	}
	
	private static int FirstNum;
	private static int SecondNum;
	static int getFiboNum () {
		return FirstNum + SecondNum;
	} 
}
