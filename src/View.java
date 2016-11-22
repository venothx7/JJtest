import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class View {
	private JFrame frame;
	private JMenuBar menuBar;
	private JTextArea orginalText = new JTextArea();
	private String name = "The School";
	private studentDriver driver = new studentDriver();
	
	public View (){
		makeGui();
	}
	private void makeGui(){

		frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenuBar();
		frame.setJMenuBar(menuBar);
		orginalText.setEditable(false);
		frame.add(orginalText);
		
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	
	private void createMenuBar(){
		theHandler handles = new theHandler ();
	    menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu ("File");
		JMenuItem loadItem = new JMenuItem("Load File");
		loadItem.addActionListener(handles);
		JMenuItem addStudent = new JMenuItem("Add New Student");
		addStudent.addActionListener(handles);
		JMenuItem deleteStudent = new JMenuItem("Delete Student");
		deleteStudent.addActionListener(handles);
		JMenuItem displayStudent = new JMenuItem("Display Students Info");
		displayStudent.addActionListener(handles);
		JMenuItem addCourse = new JMenuItem("Add Course");
		addCourse.addActionListener(handles);
		JMenuItem deleteCourse = new JMenuItem("Delete Course");
		deleteCourse.addActionListener(handles);
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(handles);
		JMenuItem quit = new JMenuItem("Quit");
		quit.addActionListener(handles);
		
		fileMenu.add(loadItem);
		fileMenu.add(addStudent);
		fileMenu.add(deleteStudent);
		fileMenu.add(displayStudent);
		fileMenu.add(addCourse);
		fileMenu.add(deleteCourse);
		fileMenu.add(save);	
		fileMenu.add(quit);

		menuBar.add(fileMenu);
	}

	private class theHandler implements ActionListener{
		studentDriver driver = new studentDriver();
		public void actionPerformed (ActionEvent event){
			String whatAction = event.getActionCommand();
			
			if(whatAction.equals("Quit"))
				System.exit(0);
			if(whatAction.equals("Load File")){
				String input = JOptionPane.showInputDialog(null,"Type in a text file");
				driver.LoadData(input);
				String info = driver.Display();
				orginalText.setText("");
				orginalText.append(info);
				return;
			}
			
			if(whatAction.equals("Add New Student")){
				driver.AddStudents();
				String info = driver.Display();
				orginalText.setText("");
				orginalText.append(info);
				return;
			}
			
			if(whatAction.equals("Delete Student")){
				driver.DeleteStudent();
				String info = driver.Display();
				orginalText.setText("");
				orginalText.append(info);
				System.out.println("This is it "+info);
				return;
			}
			
			if(whatAction.equals("Display Students Info")){
				// Choose a Student and Display there information
				String info  = driver.displayInfo();
				orginalText.setText("");
				orginalText.append(info);
			}
			
			if(whatAction.equals("Add Course")){
				// Choose a Student, Then add the Course
				String info = driver.addCourse();
				orginalText.setText("");
				orginalText.append(info);
				return;
			}
			
			if(whatAction.equals("Delete Course")){
				// Choose a Student and Delete a course
				String info = driver.deleteCourse();
				orginalText.setText("");
				orginalText.append(info);
				return;
			}
			
			if(whatAction.equals("Save")){
				JOptionPane.showMessageDialog(null, "File has been saved to newFile.txt");
				driver.writeToTextFile();
				return;
			}
			
		}
	}
}
