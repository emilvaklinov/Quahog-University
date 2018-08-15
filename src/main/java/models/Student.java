package models;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    private int id;
    private String name;
    private int age;
    private int enrolment_number;
    private List<Lesson> lessons;
    private Mentor mentor;


    public Student() {
    }

    public Student(String name, int age, int enrolment_number, Mentor mentor) {
        this.name = name;
        this.age = age;
        this.enrolment_number = enrolment_number;
        this.lessons = new ArrayList<Lesson>();
        this.mentor = mentor;
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "enrolment_number")
    public int getEnrolment_number() {
        return enrolment_number;
    }

    public void setEnrolment_number(int enrolment_number) {
        this.enrolment_number = enrolment_number;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "lessons",
            joinColumns = {@JoinColumn(name = "student_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "lesson_id", nullable = false, updatable = false)})

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @OneToOne(mappedBy = "student", fetch = FetchType.LAZY)
    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public void addLessons(Lesson lesson){
        this.lessons.add(lesson);}
}
