import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;

public class studentDriver {
	
	private String fileName = "file.txt";
	private int maxStudents = 25;
	private int counter = 0;
	private Student [] myStudents = new Student [25];
	
	
	public void LoadData (String textFile){
		fileName  = textFile;
	try {
			BufferedReader file = new BufferedReader (
					new InputStreamReader ( new FileInputStream (fileName)));
			try {
				String data = file.readLine();
				
				while (data != null && counter < 25){
					String [] info = data.split(",");
					Student newStudent = new Student (info[0],info[1],info[2]);
					data = file.readLine();
					while(!data.equals("-999")){
						newStudent.addCourse(data);
						data = file.readLine();
					}
					
					// If the data reads -999
					// Go toe the Next line and store total credits and GPA in student class
					data = file.readLine();
					String [] newInfo = data.split(",");
					newStudent.setTotalclasses(Double.parseDouble(newInfo[0]));
					newStudent.setGPA(Double.parseDouble(newInfo[1]));
					
					myStudents[counter] = newStudent;
					counter++;
					data = file.readLine();
				}
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String Display(){
		String sum ="Welcome \n\n";
		for(int i = 0; i < counter; i++){
			sum += myStudents[i].toString() + "\n";
		}
		return sum;
	}
	
	public void AddStudents(){
		while(true){
			String info = JOptionPane.showInputDialog("Would you like to type in another Student \n 1 for yes, 0 for no");
			if (info.equals("0")){
				break;
			}else{
				String newData = JOptionPane.showInputDialog("Please type in student name in format lastname firstname \n EX: Bitchass Venoth ");
				String [] data = newData.split(" ");
				Student newStudent = new Student(data[0],data[1]);
				myStudents[counter] = newStudent;
				counter++;
			}
		}
	}
	
	// finds student
	public void DeleteStudent(){
		// does this work??
	    Student input = (Student) JOptionPane.showInputDialog(null, "Please select a student to be deleted...",
		        "List of Students", JOptionPane.QUESTION_MESSAGE, null, // Use
		                                                                // default
		                                                                // icon
		        myStudents, // Array of choices
		        myStudents[0]);
	    
	   DeleteStudent(input);
	}
	
	/**
	 * @param x
	 */
	private void DeleteStudent (Student x){
		int holdIdx = 0;
		for (int i = --counter; i >= 0; i--){
			holdIdx = i;
			if(myStudents[i].equals(x)){
				myStudents[i] = null;
				break;
			}
		}
		fixStudents (holdIdx);
	}
	
	// Problem with this method
	private void fixStudents(int index){
		if(index == counter){
			System.out.println("Does it come in here.??");
			return;
		}else{
			System.out.println("Value for index is " + index 
					+ "\nValue for counter is: " + counter);
			
			int j = counter - index;
			
			while (j > 0){
				myStudents[index] = myStudents[++index];
				j--;
			}
		}
	}
	
	public String displayInfo(){
		String first = JOptionPane.showInputDialog("Please type first name");
		String last = JOptionPane.showInputDialog("Please type last name");

		Student temp = search(first, last);
		
		if(temp == null){
			JOptionPane.showMessageDialog(null,"Student Is not in database");
			return"";
		}else{
			return temp.studentData();
		}
	}
	
	public String addCourse (){
		String first = JOptionPane.showInputDialog("Please type first name");
		String last = JOptionPane.showInputDialog("Please type last name");
		
		Student temp = search(first, last);
		
		if(temp == null){
			JOptionPane.showMessageDialog(null,"Student Is not in database");
			return"";
		}else{
			String x = JOptionPane.showInputDialog(null,"Please type in name of the Course ex: \n Course name,Credits,Grade");
			temp.addCourse(x);
			return temp.studentData();
		}
	}

	
	// Finish This
	public String deleteCourse(){
		String first = JOptionPane.showInputDialog("Please type first name");
		String last = JOptionPane.showInputDialog("Please type last name");
		
		Student temp = search(first, last);
		
		if(temp == null){
			JOptionPane.showMessageDialog(null,"Student Is not in database");
			return "";
		}else{
			Courses [] studentCourses = temp.showClasses();
		    Courses input =  (Courses) JOptionPane.showInputDialog(null, "Please select a student to be deleted...",
			        "List of Courses", JOptionPane.QUESTION_MESSAGE, null, // Use
			                                                                // default
			                                                                // icon
			        studentCourses, // Array of choices
			        studentCourses[0]);
		    
		    temp.removeCourse(input);
		    return temp.studentData();
		    
		}
		
		
	}

	public Student search (String first, String last){
		for(int i = 0; i < counter; i++){
			if(myStudents[i].getlastName().equalsIgnoreCase(first) && myStudents[i].getfirstName().equalsIgnoreCase(last)){
				return myStudents[i];
			}
		}
		return null;
	}
	
	public void writeToTextFile(){
		PrintWriter writer;
		try {
			writer = new PrintWriter("newFile.txt", "UTF-8");
			for(int i = 0; i < counter; i++){	
				writer.println(myStudents[i].studentData() );
			}
			
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
}
