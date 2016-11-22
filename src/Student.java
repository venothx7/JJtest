import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Student {
	private String First;
	private String Last;
	private String IDNumb;
	private double TotalCredit;
	private double GPA;
	private ArrayList<Courses> courses = new ArrayList<Courses> ();
	
	public Student(String last, String first){
		First = first;
		Last = last;
	}
	public Student (String First, String Last, String s){
		this.First = First;
		this.Last = Last;
		IDNumb = s;
	}
	public void setTotalclasses (double x){
		TotalCredit = x;
	}
	
	public void setGPA (double x){
		GPA = x;
	}
	
	public String getfirstName(){
		return First;
	}
	
	public String getlastName(){
		return Last;
	}
	
	public String getID(){
		return IDNumb;
	}
	
	public double calculateGrade(){
		double sumOfCredits = 0.0;
		double sumOfGrades = 0.0;
		for(int i = 0; i < courses.size();i++){
			sumOfCredits += courses.get(i).getAmountofCredits();
			sumOfGrades += courses.get(i).getAmountofCredits()* gradeConverter(courses.get(i).getGrade());
		}
		return sumOfGrades/sumOfCredits;
	}
	
	//convert letter grade to point system
	public double gradeConverter (String Grade){
		double gPoint = 0.0;
		switch (Grade){
			case "A+": gPoint=4.3;
			case "A": gPoint=4.0;
			case "A-": gPoint=3.7;
			case "B+": gPoint=3.4;
			case "B": gPoint=3.1;
			case "B-": gPoint=2.8;
			case "C+": gPoint=2.5;
			case "C": gPoint=2.2;
			case "C-": gPoint=1.9;
			case "D+": gPoint=1.6;
			case "D": gPoint=1.3;
			case "D-": gPoint=1.0;
			case "F": gPoint= 0.0;
		}
		return gPoint;
	}
	
	// Add Courses
	public void addCourse (String data){
		String [] info = data.split(",");
		if(info.length < 2 || info.length > 3){
			JOptionPane.showMessageDialog(null, "Invalid Course");
			return;
		}else{
			Courses myCourse = new Courses(info[0],info[1],info[2]);
			courses.add(myCourse);
		}
	}
	
	public void removeCourse (Courses x){
	
		for(int i = 0; i < courses.size(); i++){
			if(x.equals(courses.get(i))){
				System.out.println(courses.get(i));
				courses.remove(i);
				break;
			}
		}
	}
	
	public Courses [] showClasses (){
		Courses [] classes = new Courses [courses.size()];
		for (int i = 0; i < courses.size(); i++){
			classes[i] = courses.get(i);
		}
		return classes;
	}
	
	// Puts all of the classes into one String
	public String listOfClasses(){
		String sum = "";
		for (int i = 0; i < courses.size(); i++){
			sum+= courses.get(i) + "\n";
		}
		return sum;
	}
	
	//Returns All of the classes
	public String toString (){
		return First + ", " + Last;
	}
	
	public String studentData (){
		return First + ", " + Last + ", " + IDNumb + "\n" + listOfClasses()
				+ TotalCredit + ", " + GPA;
	}
}
