import java.util.ArrayList;;

public class Students 
{
	private String id;
	private String name;
	private String major;
	private String birthdate;
	
	private String hello-jenkins;
	ArrayList <Courses> courses;
	 
	public Students(String id)
	{
		this.id=id;
		courses=new ArrayList<Courses>(10);
	}
	
	public String getID()
	{
		return id;
	}
	
	public static void setName(String name, String id, ArrayList<Students> students)
	{
		int indexstudent=findStd(id,students);
		if(indexstudent==-1)
		{
			System.out.println("Student doesn't exist");
			return;
		}	
		students.get(indexstudent).name=name;
	
	}
	
	public static String getName(String id,ArrayList<Students> students)
	{
		int indexstudent=findStd(id,students);
		if(indexstudent==-1)
		{
			return "Student doesn't exist";
		}
		return students.get(indexstudent).name;
	}
	
	public static void setMajor(String major, String id, ArrayList<Students> students)
	{
		int indexstudent=findStd(id,students);
		if(indexstudent==-1)
		{
			System.out.println("Student doesn't exist");
			return;
		}	
		students.get(findStd(id, students)).major=major;
	}
	
	public static String getMajor(String id, ArrayList<Students> students)
	{
		int indexstudent=findStd(id,students);
		if(indexstudent==-1)
		{
			return "Student doesn't exist";
		}	
		return students.get(findStd(id, students)).major;
	}
	
	public static void setBirthdate(String birthdate, String id, ArrayList<Students> students)
	{
		int indexstudent=findStd(id,students);
		if(indexstudent==-1)
		{
			System.out.println("Student doesn't exist");
			return;
		}	
		students.get(findStd(id, students)).birthdate=birthdate;
	}
	
	public static String getBirthdate(String id,ArrayList<Students> students)
	{
		int indexstudent=findStd(id,students);
		if(indexstudent==-1)
		{
			return "Student doesn't exist";
		}	
		return students.get(findStd(id, students)).birthdate;
	}
	
	public static int findStd(String id,ArrayList<Students> students)
	{
		int found=-1;
		for(int i=0;i<students.size();i++)
		{
			if(students.get(i).getID().equals(id))
				found=i;
		}
		return found;
	}
	
	public static double getAverage(String id, ArrayList<Students> students)
	{
		int count=0;
		double sum=0;
		
		for(int i=0;i<students.get(findStd(id, students)).courses.size();i++)
		{
			sum+=students.get(findStd(id, students)).courses.get(i).getGrade()*students.get(findStd(id,students)).courses.get(i).getCrh();
			count+=students.get(findStd(id,students)).courses.get(i).getCrh();
		}
		
		return sum/count;
	}
	
	public static int findCno(String cno, String id, ArrayList<Students> students)
	{ 
		int found=-1;
		
		for(int i=0;i<students.size();i++)
		{
			if(students.get(i).getID().equals(id))
			{
				int index=findStd(id,students);
				
				for(int j=0;j<students.get(index).courses.size();j++)
				{
					if(students.get(index).courses.get(j).getCno().equals(cno))
					{
						found=j;
					}
				}
				
			}
		}
		return found;
	}
	
	public static void setCourseCrh(String id, ArrayList<Students> students,String cno, int crh)
	{
		int indexstudent=findStd(id,students);
		if(indexstudent==-1)
		{
			System.out.println("Student doesn't exist");
			return;
		}
		
		int indexcourse=findCno(cno,id,students);
		if(indexcourse==-1)
		{
			System.out.println("Course doesn't exist");
			return;
		}
		
		students.get(indexstudent).courses.get(indexcourse).setCrh(crh);
	}
	
	public static void setCourseGrade(String id, ArrayList<Students> students, String cno, int grade)
	{
		int indexstudent=findStd(id,students);
		if(indexstudent==-1)
		{
			System.out.println("Student doesn't exist");
			return;
		}
		
		int indexcourse=findCno(cno,id,students);
		if(indexcourse==-1)
		{
			System.out.println("Course doesn't exist");
			return;
		}
		students.get(indexstudent).courses.get(indexcourse).setGrade(grade);
	}
	
}//Class Students
