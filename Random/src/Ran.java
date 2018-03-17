import java.util.Random;



public class Ran {
	public static void main(String[] args)
	{
		Random r = new Random();
	
		for(int i=0;i<100000;i++) {
			System.out.print(r.nextInt(100)+" ");
		}

			double score = Math.pow(14+5-8, 1.1);
			System.out.println();
			System.out.println(score+"here");
	}
}
