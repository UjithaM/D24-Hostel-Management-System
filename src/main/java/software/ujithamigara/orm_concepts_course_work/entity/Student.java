package software.ujithamigara.orm_concepts_course_work.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Table(name = "student")
@Entity
public class Student {

    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "gender")
    private String gender;

    public Student() {
    }

    public Student(String studentId, String studentName, String address, String contactNumber, Date dob, String gender) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.dob = dob;
        this.gender = gender;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
