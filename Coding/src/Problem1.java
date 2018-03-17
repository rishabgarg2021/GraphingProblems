import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		int year=0;
		int month=0;
		int day=0;
		char special='\0';
		String words[] = new String[3];
		while (sc.hasNext()) {
			String read = sc.nextLine();
		    words = read.split("\\s+");
		    
			words[1] = words[1].replaceAll("[^a-zA-Z]+"," ");
		
			words[0]=words[0].replaceAll("[^0-9]+", " ");
			
			String[] newWord0 =new String[3];
			newWord0=words[0].split("\\s+");
			String[] newWord1 =new String[3];
			newWord1=words[1].split("\\s+");
		
			for(int i=0;i<3;i++) {
				if(newWord1[i].equals("yyyy")) {
					year=Integer.parseInt(newWord0[i]);
				}
				if(newWord1[i].equals("mm")) {
					month=Integer.parseInt(newWord0[i]);
				}
				if(newWord1[i].equals("dd")) {
					day=Integer.parseInt(newWord0[i]);
				}
			}
			
			for(int k=0;k<words[2].length();k++) {
				if(!Character.isAlphabetic(words[2].charAt(k))) {
					special=words[2].charAt(k);
				}
				
			}
		
		
			words[2]=words[2].replaceAll("[^A-Za-z0-9 ]+", " ");
			String[] newWord2 =new String[3];
			newWord2=words[2].split("\\s+");
			
			String dayn = String.format("%02d", day);
			String monthn=String.format("%02d", month);
			for(int i=0;i<3;i++) {
				
				if(newWord2[i].equals("yyyy")) {
					if(i!=2) {
						System.out.print(Integer.toString(year)+special);
					}
					else {
						System.out.print(Integer.toString(year));
					}
				}
				if(newWord2[i].equals("mm")) {
					
					
					if(i!=2) {
						System.out.print(monthn+""+special);
					}
					else {
						System.out.print(monthn);
					}
				}
				if(newWord2[i].equals("dd")) {
					if(i!=2) {
						System.out.print(dayn+special);
					}
					else {
						System.out.print(dayn);
					}
				}
			}
			System.out.println();
			
			
			
		}
	}
}
