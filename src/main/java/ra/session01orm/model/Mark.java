package ra.session01orm.model;


import javax.persistence.*;

@Entity
public class Mark {
    @EmbeddedId
    private MarkId markId;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "studentId")
    private Student student;
    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name = "subjectId")
    private Subject subject;

    private Double point;

    public Mark() {
    }

    public MarkId getMarkId() {
        return markId;
    }

    public void setMarkId(MarkId markId) {
        this.markId = markId;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
