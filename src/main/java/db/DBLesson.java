package db;

import models.Course;
import models.Lesson;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBLesson {

    private static Session session;

    public static List<Lesson> getStudent(Lesson lesson) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> result = null;
        try {
            Criteria cr = session.createCriteria(Course.class);
            cr.createAlias("lessons", "lesson");
            cr.add(Restrictions.eq("lesson.id", lesson.getId()));
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
