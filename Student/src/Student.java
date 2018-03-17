public class Student{

 

    public static final int NUM_GRADES = 5;

 

    private String name;

    private int[] grades;

 

    public Student(String name){

        this.name = name;

        this.grades = new int[NUM_GRADES];

    }

 

    public String getName(){

        return this.name;

    }

   

    public int getGrade(int i){

        return this.grades[i – 1];

    }

 

    public void setGrade(int i, int newGrade){

        this.grades[i - 1] = newGrade;

    }

 

    public String toString(){

        /*

        Format: Name on the first line

        and all grades on the second line,

        separated by spaces.

        */

        String result = this.name + '\n';

        for (int grade : this.grades)

            result += Integer.toString(grade) + ' ';

        return result;

    }
    public static void main(String[] args) {



 
	
	Student s = new Student("Mary");
	
	for (int i = 1; i <= Student.NUM_GRADES; i++)
	
	    s.setGrade(i, 100);
	
	System.out.println(s);
	    }

}

 
