package ra.session01orm.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class MarkId implements Serializable{
    @Column(name = "studentId")
    private  String studentId;
    @Column(name = "subjectId")
    private String subjectId;

    public MarkId() {
    }

    public MarkId(String studentId, String subjectId) {
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
}
