
public class AddNumberToN {
	private int []dp;
	private int n;
	public AddNumberToN(int n) {
		this.n=n;
		dp=new int[n+1];
		for(int i=0;i<=n;i++) {
			dp[i]=-1;
			
		}
	}
	
	
	public int waysToFormN(int n,int u,int v ,int w) {
		if(n<0) {
			return 0;
		}
		else if(n==0) {
			return 1;
		}
		else if (dp[n]!=-1) {
			return dp[n];
		}
		
		return dp[n]=waysToFormN(n-u,u,v,w) +waysToFormN(n-v,u,v,w)+waysToFormN(n-w, u, v, w);
		
	}
	public static void main(String []args) {
		AddNumberToN ways = new AddNumberToN(7);
		System.out.println(ways.waysToFormN(7, 2, 3, 5));
	}
}
