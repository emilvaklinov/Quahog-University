package db;

import models.Course;
import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBStudent {

    private static Session session;
    private static Transaction transaction;

    public static List<Student> getLessons() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> students = null;
        try {
            Criteria cr = session.createCriteria(Course.class);
            cr.addOrder(Order.desc("Lesson"));
            students = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return students;
    }

    public static void addStudentToLesson(Student student, Lesson lesson) {
        student.addLessons(lesson);
        lesson.addStudent(student);
        DBHelper.update(lesson); // REMEMBER THIS WILL CASCADE UPDATE TO PROJECT
    }

    public static List<Lesson> getLesson(Student student) {
        List<Lesson> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Lesson.class);
            cr.createAlias("students", "student"); // ADDED
            cr.add(Restrictions.eq("student.id", student.getId())); // ADDED
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
