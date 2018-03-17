import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();

		int xstart = 0;
		float total = 0;
		for (int i = 0; i < testcases; i++) {
			total = 0;
			int gates = sc.nextInt();

			int x[] = new int[gates + 1];
			float y[] = new float[gates + 1];
			x[0] = 0;
			y[0] = sc.nextInt();
			float y2[] = new float[gates + 1];
			y2[0] = y[0];
			for (int j = 1; j <= (gates); j++) {
				xstart++;

				x[j] = xstart;
				y[j] = (float) sc.nextInt();

				y2[j] = sc.nextInt();

			}
			for (int h = 0; h < gates; h++) {
				
				if(h+1==gates) {
					int point2=-1;
					if((point2 = giveNextPointP2(y, y2, h ,(int)y[h])) >= 0){
						total+=1;
						
					}
					else {

						if (y2[h + 1] < y[h]) { 
							
							float ad = ((y2[h + 1] - y[h]) * (y2[h + 1] - y[h])) + 1;
							ad = (float) Math.sqrt(ad);
							total += ad;

						} else {

							float ad = (y[h + 1] - y[h]) * (y[h + 1] - y[h]) + 1;
							ad = (float) Math.sqrt(ad);
							total += ad;

						}
					
					}
					break;
				}
				if (h + 2 <= gates) {
					if ((y2[h + 1] >= y[h] && y[h + 1] <= y2[h])) {// h+1 parallel point found and h+2 also
						int point1 = -1;
						int point2 = -1;

						if ((point1 = giveNextPointP(y, y2, h)) >= 0) {
							if ((point2 = giveNextPointP2(y, y2, h + 1,point1)) >= 0) {
								float check = 1+ (point2 - y[h]) * (point2 - y[h]);
								check = (float) Math.sqrt(check);
								check += 1;
								float direct = 1 + (point2 - point1) * (point2 - point1);
								direct = (float) Math.sqrt(direct);
								direct += 1;

								if (direct >= check) {
									total += check;

								} else {
									total += direct;
								}

								h = h + 1;

								y2[h + 1] = point2; 
								y[h + 1] = point2;
							}
						}

					}

				}

				else {
					
//					float check1=1+ (y[h+2] - y2[h ]) * (y[h+1] - y2[h ]);
//					float check2=1 + (y[h+1] - y[h ]) * (y[h+1] - y[h ]);
//					float check3=1 + (y[h+1] - y[h ]) * (y[h+1] - y[h ]);
//					float check4=1 + (y[h+1] - y[h ]) * (y[h+1] - y[h ]);
//					check = (float)Math.sqrt(check);
//					direct = (float)Math.sqrt(direct);
//					
//					if((y2[h]-y[h])+check<=direct) {
//						System.out.println(total+"if");
//						total+=(y2[h]-y[h])+check;
//				

					if (y2[h + 1] < y[h]) { 
						
						float ad = ((y2[h + 1] - y[h]) * (y2[h + 1] - y[h])) + 1;
						ad = (float) Math.sqrt(ad);
						total += ad;

					} else {

						float ad = (y[h + 1] - y[h]) * (y[h + 1] - y[h]) + 1;
						ad = (float) Math.sqrt(ad);
						total += ad;

					}
				}
			}

			System.out.println(total );
		}
	}

	private static int giveNextPointP2(float[] y, float[] y2, int index, int point1) {
		int h = index;
		if(point1<=y2[h+1] && point1>=y[h+1]) {
			return point1;
		}
		h=index;
		for (int z = (int) y[h]; z <= y2[h + 1]; z++) {
			if (z <= y2[h + 1] && z >= y[h + 1]) {// found next line point in parallel points
				return z;
			}
		}
		return -1;
	}

	public static int giveNextPointP(float[] y, float[] y2, int index) {

		int h = index;
		for (int z = (int) y[h]; z <= y2[h + 1]; z++) {
			if (z <= y2[h + 1] && z >= y[h + 1]) {// found next line point in parallel points
				return z;
			}
		}
		return -1;
	}

}
