
public class Courses {
	private String CourseNumber;
	private double AmountOfCredits;
	private String Grade;
	
	public Courses (String course, String credits, String grade ){
		CourseNumber = course;
		AmountOfCredits = Double.parseDouble(credits);
		Grade = grade;
	}
	public String getCourseNumber(){
		return CourseNumber;
	}
	public double getAmountofCredits(){
		return AmountOfCredits;
	}
	public String getGrade(){
		return Grade;
	}
	public String toString (){
		return  CourseNumber + ", " + AmountOfCredits 
				+ ", " + Grade;
	}
	private boolean checkID(){
		return true;
	}
	
}
