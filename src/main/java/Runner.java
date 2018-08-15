import db.DBCourse;
import db.DBHelper;
import db.DBLesson;
import db.DBStudent;
import models.Course;
import models.Lesson;
import models.Mentor;
import models.Student;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Course course1 = new Course("IT", 7);
        DBHelper.save(course1);

        Mentor mentor1 = new Mentor("Vicky");
        DBHelper.save(mentor1);
        Mentor mentor2 = new Mentor("Mike");
        DBHelper.save(mentor2);

        Student student1 = new Student("Camila", 22, 01010, mentor1, course1);
        DBHelper.save(student1);
        Student student2 = new Student("Allen", 27, 01011, mentor2, course1);
        DBHelper.save(student2);
        Student student3 = new Student("Pamela", 20, 01012, mentor2, course1);
        DBHelper.save(student3);
        Student student4 = new Student("Kat", 30, 01013, mentor1, course1);
        DBHelper.save(student4);
        Student student5 = new Student("Robby", 25, 01014, mentor1, course1);
        DBHelper.save(student5);

        Lesson lesson1 = new Lesson("SQL", 2, course1);
        DBHelper.save(lesson1);
        Lesson lesson2 = new Lesson("Java", 1, course1);
        DBHelper.save(lesson2);



        List<Lesson> availableLessonsStudent1 = DBStudent.getLesson(student1);

        DBStudent.addStudentToLesson(student1, lesson1);
        DBStudent.addStudentToLesson(student2, lesson1);
        DBStudent.addStudentToLesson(student3, lesson1);
        DBStudent.addStudentToLesson(student1, lesson2);

        List<Lesson> course1Lessons = DBCourse.getLessonsOf(course1);
        List<Student> course1Students = DBCourse.getStudentsOf(course1);

//        List<Student> lesson1Students  = DBLesson.getStudent(lesson1);
//        List<Lesson> student1Lessons  = DBStudent.getLesson(student1);
    }

}