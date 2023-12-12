package ra.session01orm.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Entity
public class Student {
    @Id
    @Column(length = 4, name = "studentId")
    private  String studentId;
    @Column(length = 100,name = "studentName")
    private String studentName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthDay")
    private Date birthDay;
    private Boolean gender;
    @Column( columnDefinition = "text")
    private String address;

    @Column(length = 45,name = "phoneNumber")
    private String phoneNumber;
    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
    private List<Mark> markList;

    public Student() {
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }
}
