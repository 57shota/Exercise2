package Model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author sho
 */
public class BinaryProcess {
    public static ArrayList<Student> readStudentData(String file) throws FileNotFoundException, IOException{
        
        ArrayList<Student> list = new ArrayList<>();
        FileInputStream fin = new FileInputStream(file);
        DataInputStream din = new DataInputStream(fin);
        Student student;
        
        while(din.available() > 0) { 
            student = new Student(din.readUTF(), din.readUTF(), din.readUTF(), din.readUTF());
            list.add(student);
        }
        return list;
    }

    public static void saveStudentData(String file, ArrayList<Student> list) throws FileNotFoundException, IOException{
        
        FileOutputStream fos = new FileOutputStream(file);
        DataOutputStream dos = new DataOutputStream(fos);
        
        for(Student student: list){
            dos.writeUTF(student.getId());
            dos.writeUTF(student.getFirstName());
            dos.writeUTF(student.getLastName());
            dos.writeUTF(student.getCourse());
        }
        dos.close();
    }
}
