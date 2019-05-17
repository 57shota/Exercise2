package Model;


import java.io.Serializable;


/**
 *
 * @author sho
 */
public class Student implements Serializable{
    private String id;
    private String firstName;
    private String lastName;
    private String course;

    public Student(String id, String firstName, String lastName, String course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student detail:\n\n" + "id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + ", course: " + course;
    }
    
    
}


