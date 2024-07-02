package guvidsa;
import java.util.HashMap;


public class fiboMemoization {
	private HashMap<Integer, Long> memo = new HashMap<>();
	
	public long fib(int n) {
        if (n <= 1) return n;

        // Check if the result is already computed
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Compute the result and store it in the memoization table
        long result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fiboMemoization fibRecursive = new fiboMemoization();
        int n = 10;
        System.out.println("Fibonacci of " + n + " is: " + fibRecursive.fib(n));
	}

}
