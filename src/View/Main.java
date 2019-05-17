package View;

import Model.Student;
import Model.BinaryProcess;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;


/**
 *
 * @author sho
 */
public class Main {

    final static String fileName = "Student.bin";
    static ArrayList<Student> students;
    
    public static void main(String[] args) {
        students = new ArrayList<>();
        students = readData();
        menuProcess();
        
    }
    
    public static void menuProcess() {
        int choice = menu();
        int quit = 0;
        while(choice != 6) {
            switch(choice) {
                case 1:
                    students.add(createStudent());
                    break;
                case 2:
                    sortAndDisplay(choice);
                    break;
                case 3:
                    sortAndDisplay(choice);
                    break;
                case 4:
                    searchBy();
                    break;
                case 5:
                    searchBy();
                case -99:
                    JOptionPane.showMessageDialog(null,
                                                 "You must enter something, 6 to exit", 
                                                 "ERROR",
                                                 JOptionPane.ERROR_MESSAGE);
                    break;
                case -100:
                    JOptionPane.showMessageDialog(null,
                                                 "You have selected cancel");
                    break;			
                default:
                    JOptionPane.showMessageDialog(null,
                                                 "Not a valid option, select again"); 
            }
            choice = menu();
        }
        saveData(students);
    }
    
    public static int menu() {
        String options = "1. Input Student detailss"
                + "\n2. Sort and display by Last name"
                + "\n3.	Sort and display by course"
                + "\n4.	Search by ID"
                + "\n5.	Search by Last Name"
                + "\n\n6. Save and Exit";
        String userSelection = JOptionPane.showInputDialog(null, 
                                                           options,
                                                           "Student", 
                                                           JOptionPane.PLAIN_MESSAGE);
        int option = validateSelection(userSelection); 
        return option;
    }
    
    public static int validateSelection(String selection) {
        if(selection == null)
            return -100;
        if(selection.length() < 1)
            return - 99;
        if(selection.length() > 1)
            return -101;
        if((int)selection.charAt(0) < 49 ||(int)selection.charAt(0) > 54)
            return -101;
        else
            return Integer.parseInt(selection);	 
    }
    
    public static void displayStudents(ArrayList<Student> Students) {
        String output = "STUDENT DETAILS\n\n";
        for(Student obj : Students){
            output += obj + "\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }
    
    public static Student createStudent() {
        Student student;
        String id;
        String first;
        String last;
        String course;
        
        id = JOptionPane.showInputDialog("Enter student ID");
        first = JOptionPane.showInputDialog("Enter student first name");
        last = JOptionPane.showInputDialog("Enter student last name");
        course = JOptionPane.showInputDialog("Enter student course");
        
        student = new Student(id, first, last, course);
        return student;
    }
    
    public static void sortAndDisplay(int choice) {
        final int last = 2;
        final int course = 3;
        switch(choice) {
            case last:
                Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return s1.getLastName().compareTo(s2.getLastName());
                    }
                });
                displayStudents(students);
                break;
            case course:
                Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return s1.getCourse().compareTo(s2.getCourse());
                    }
                });
                displayStudents(students);
                break;
            default:
                break;
        }
    }
    
    public static void searchBy() {
        
    }
    
    public static ArrayList<Student> readData(){
        ArrayList<Student> students = new ArrayList<>();
        try{
           students = BinaryProcess.readStudentData(fileName);
        }
        catch(FileNotFoundException fnfEx){
            System.err.println("Problem with the patients.bin file");
            JOptionPane.showMessageDialog(null, "File \"Students.bin\" will be created");
        }
        catch(NotSerializableException nsEx){
            System.err.println("A class has not been serialised");
        }
        catch(IOException ioEx){
            System.err.println("Problem with reading data from file");
        }
   
        return students;
    }
    
    public static void saveData(ArrayList<Student> list){
        try{
            BinaryProcess.saveStudentData(fileName, list);
        }
        catch(FileNotFoundException fnfEx){
            System.err.println("Problem with the binary file");
        }
        catch(NotSerializableException nsEx){
            System.err.println("A class has not been serialised");
        }
        catch (IOException ioEx){
            System.err.println("Issue(s) with saving data to file");
        }
        
    }
    
}
