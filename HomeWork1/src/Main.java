import java.util.*;

public class Main 
{

	public static void main(String[] args) 
	{
		
		ArrayList<Students> students=new ArrayList<Students>(10);
		System.out.println("___________________________________________________________________________________");
		System.out.println("|New student: new <ID>                                                             |");
		System.out.println("|Set name for student: set <ID> <\"name\">                                           |");
		System.out.println("|Set major for student: set <ID> <\"major\">                                         |");
		System.out.println("|Set birthdate for student: set <ID> <\"birthdate\">                                 |");
		System.out.println("|Get name for student: get <ID> <\"name\">                                           |");
		System.out.println("|Get major for student: get <ID> <\"major\">                                         |" );
		System.out.println("|Get birthdate for student: get <ID> <\"birthdate\">                                 |");
		System.out.println("|Add course to a student: addcourse <ID> <course#>                                 |");
		System.out.println("|Set Credit Hours for a course: setcourse <ID> <course#> <\"crh\"> <#credit hours>   |");
		System.out.println("|Set Grade for a course: setcourse <ID> <course#> <\"grade\"> <#grade>               |");
		System.out.println("|Get average of all grade for a student: getaverage <ID>                           |");
		System.out.println("|Quit the program: quit                                                            |");
		System.out.println("____________________________________________________________________________________");
	
		Scanner input=new Scanner(System.in);
		String command=input.nextLine();
		command = command.toLowerCase();
		String []tokenslow=command.split(" ");
		
		while(!(tokenslow[0].equals("quit")))
		{
			if(tokenslow[0].equals("new"))
			{
				if(tokenslow.length < 2) 
				{
					System.out.println("Inavlid number of arguments!");
				}
				
				else if((-1 < Students.findStd(tokenslow[1],students)))
						System.out.println("Student already created!");
				else 
				{
					Students n=new Students(tokenslow[1]);
					students.add(n);
				}	
			}
			
			else if(tokenslow[0].equals("set"))
			{
				for(int i = 4; i < tokenslow.length; i++) {
					tokenslow[3]+=(" "+ tokenslow[i]);
				}
				
				if(tokenslow.length < 4)
				{
					System.out.println("Not enough arguments!");
				}
				
				if(tokenslow[2].equals("name"))
				{
					Students.setName(tokenslow[3],tokenslow[1],students);
				}
				
				if(tokenslow[2].equals("major"))
				{
					Students.setMajor(tokenslow[3], tokenslow[1], students);
				}
				
				if(tokenslow[2].equals("birthdate"))
				{
					Students.setBirthdate(tokenslow[3], tokenslow[1], students);
				}
			}
			
			else if(tokenslow[0].equals("get"))
			{
				
				if(tokenslow.length <= 4)
				{
					System.out.println("Not enough arguments!");
				}
				
				if(tokenslow[2].equals("name"))
				{
					System.out.println(Students.getName(tokenslow[1], students));
				}
				
				if(tokenslow[2].equals("major"))
				{
					System.out.println(Students.getMajor(tokenslow[1], students));
				}
				
				if(tokenslow[2].equals("birthdate"))
				{
					System.out.println(Students.getBirthdate(tokenslow[1], students));
				}
			}
			
			else if(tokenslow[0].equals("addcourse"))
			{
				if(tokenslow.length < 3)
				{
					System.out.println("Invalid number of arguments!");
				}
				
				else
				{
				Courses c = new Courses(tokenslow[2]);
				students.get(Students.findStd(tokenslow[1],students)).courses.add(c);
				}
			}
			
			else if(tokenslow[0].equals("setcourse"))
			{
				if(tokenslow.length <= 4)
				{
					System.out.println("Not enough arguments!");
				}
				
				else if(tokenslow[3].equals("crh"))
				{
					Students.setCourseCrh(tokenslow[1], students, tokenslow[2], Integer.parseInt(tokenslow[4]));
				}
				
				else if(tokenslow[3].equals("grade"))
				{
					Students.setCourseGrade(tokenslow[1], students, tokenslow[2], Integer.parseInt(tokenslow[4]));
				}
				
				else System.out.println("Not a valid command!");
			}
			
			else if(tokenslow[0].equals("getaverage"))
			{
				System.out.println(Students.getAverage(tokenslow[1], students));
			}
			
			else if(tokenslow[0].equals("delete"))
			{
				if(Students.findStd(tokenslow[1],students)==-1)
					System.out.println("Student doesn't exist!");
				
				else
				students.remove(Students.findStd(tokenslow[1], students));
			}
			
			else if(tokenslow[0].equals("print"))
			{
				if(tokenslow.length < 2)
					System.out.println("You must enter an ID!");
				
				else if(Students.findStd(tokenslow[1],students)==-1)
				{
					System.out.println("Student doesn't exist!");
				}
				
				else 
				{
				System.out.println("Output: ");
				System.out.printf(" ID: %S\n Name: %S\n Major: %S\n Birthdate: %S\n Averge: %S\n",tokenslow[1],Students.getName(tokenslow[1], students),
						Students.getMajor(tokenslow[1], students),Students.getBirthdate(tokenslow[1], students),Students.getAverage(tokenslow[1], students));
				System.out.println("CNO\t\t\tCredit Hours\t\t\tGrade");
				
				for(Students student:students)
				{
					for(int i=0;i<student.courses.size();i++)
					{	
					System.out.print(student.courses.get(i).getCno()+"\t\t\t"+student.courses.get(i).getCrh()+"\t\t\t\t"+student.courses.get(i).getGrade()+"\n");
					}
				}
				}
			}
			
			else System.out.println("Invalid command!\n Please enter a valid command.");
			command=input.nextLine();
			command = command.toLowerCase();
			tokenslow=command.split(" ");
			
		}//While
		System.out.println("Goodbye!");
		input.close();
		
	}//Main
}//Class