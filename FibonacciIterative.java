package guvidsa;

public class FibonacciIterative {
	
	public long fib(int n) {
        if (n <= 1) return n;

        long[] fibTable = new long[n + 1];
        fibTable[0] = 0;
        fibTable[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibTable[i] = fibTable[i - 1] + fibTable[i - 2];
        }

        return fibTable[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 FibonacciIterative fibIterative = new FibonacciIterative();
	        int n = 50;
	        System.out.println("Fibonacci of " + n + " is: " + fibIterative.fib(n));
	}

}
