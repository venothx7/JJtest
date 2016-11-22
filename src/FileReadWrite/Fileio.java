package FileReadWrite;
import java.io.*;
import java.util.Scanner;

/**
 * Created by Venoth on 11/22/2016.
 */
public class Fileio {

    public static void main(String[] args) {
        String filename ="Names.txt";

        //File Object
        File f1p = new File(filename);

        // Writes into file at the start or at the end
        try{
            //PrintWriter
            PrintWriter pw1 = new PrintWriter(filename);
            PrintWriter pw2 = new PrintWriter(f1p);
            pw1.println("John");
            pw1.println("Sue");
            pw1.println("Mary");
            pw1.close();
            //overwrites the previous file
            pw1= new PrintWriter(filename);
            pw1.println("Sue");
            pw1.println("Mary");
            pw1.close();

            //open the file to append, ADD to the end
            FileWriter fw1 = new FileWriter(f1p, true);
            fw1.write("Nancy");
            fw1.close();

        }
        catch(Exception e){
            System.out.println(" Problem With File");
        }
        // READS the file
        try {
            Scanner in = new Scanner(f1p);
            while(in.hasNext()){
                String input = in.nextLine();
                System.out.println(input);
            }
            in.close();
        }
        catch (Exception e){
            System.out.println("Problem with File 2");
        }

        //Scanner
        File f2p = new File("grades.txt");
        double grade, totalGrades = 0.0, Average;
        try {
            Scanner in = new Scanner(f2p);
            int count =0;
            while(in.hasNext()){
                String n1 = in.nextLine().trim();
                if (n1.equals("")){
                    continue;
                }
                grade = Double.parseDouble(n1);
                totalGrades += grade;
                count++;
            }
            in.close();
            Average = totalGrades/ count;
            System.out.println("Average is: " + Average);


        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }

}
