
public class Fib {
	private int size;
	private int[] lookup;
	public Fib(int size) {
		this.size=size;
		lookup = new int[size+1];
		for(int i=0;i<=size;i++) {
			lookup[i]=-1;
		}
	}
	public int fibAnswer(int n) {
		if(lookup[n]==-1) {
			if(n<=1) {
				lookup[n] = n;
			}
			else {
				lookup[n]=fibAnswer(n-1)+fibAnswer(n-2);
			}
		}
		return lookup[n];
		
	}
	public static void main(String[] args) {
		int n = 10;
		Fib fib = new Fib(n);
		System.out.println(fib.fibAnswer(n));
	}
}
