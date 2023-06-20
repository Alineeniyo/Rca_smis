package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
import rw.ac.rca.webapp.dao.MarkDAO;
import rw.ac.rca.webapp.orm.Mark;

import java.util.List;

public class MarkDAOImpl extends  DAO implements MarkDAO {


    private  static  MarkDAOImpl instance;


    public static  MarkDAOImpl getInstance() {
        if(instance == null) {
            return  new MarkDAOImpl();
        }else {
            return  instance;
        }
    }
    @Override
    public Mark saveMark(Mark mark) {
        try {
            begin();
            getSession().save(mark);
            commit();
            return mark;
        } catch (Exception e) {
            rollback();
            return null;
        }

    }

    @Override
    public Mark updateMark(Mark mark) {
        try {
            begin();
            getSession().update(mark);
            commit();
            return mark;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public Mark saveOrUpdateMark(Mark mark) {
        try {
            begin();
            getSession().saveOrUpdate(mark);
            commit();
            return mark;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public boolean deleteMark(Mark mark) {
        try {
            begin();
            Query query = getSession().createQuery(
                    "from marks where id= :ref");
            query.setInteger("ref", mark.getId());
            Mark mark1 = (Mark) query.uniqueResult();
            getSession().delete(mark1);
            commit();
            return true;

        } catch (Exception e) {
            rollback();
            return false;
        }
    }

    @Override
    public Mark getMarkById(int markId) {
        try {
            begin();
            Query query = getSession().createQuery(
                    "from marks where id= :ref");
            query.setInteger("ref", markId);
            Mark mark = (Mark) query.uniqueResult();
            commit();
            return mark;
        } catch (Exception e) {
            rollback();
            return null;

        }
    }

    @Override
    public List<Mark> getAllMarks() {
        try {
            begin();
            Query query = getSession().createQuery("from Mark");
            List<Mark> marks = query.list();
            commit();
            return marks;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }
}
