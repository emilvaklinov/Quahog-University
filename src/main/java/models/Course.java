package models;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    private int id;
    private String title;
    private int level;
    private List<Student> member;
    private List<Lesson> lessons;


    public Course() { }

    public Course( String title, int level) {
        this.id = id;
        this.title = title;
        this.level = level;
        this.member = new ArrayList<Student>();
        this.lessons = new ArrayList<Lesson>();


    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "levels")
    public int getLevel() {
        return level;
    }

    public void setLevels(int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    public List<Student> getMember() {
        return member;
    }

    public void setMember(List<Student> member) {
        this.member = member;
    }

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}