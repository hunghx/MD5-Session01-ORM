package ra.session01orm.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subject {
    @Id
    @Column(length = 4,name = "subjectId")
    private String subjectId;
    @Column(length = 45,name = "subjectName")
    private String subjectName;
    
    private Integer priority;
    @OneToMany(mappedBy = "subject" ,fetch = FetchType.LAZY)
    private List<Mark> markList;

    public Subject() {
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public List<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }
}