package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
import rw.ac.rca.webapp.dao.ParentDAO;
import rw.ac.rca.webapp.orm.Parent;

import java.util.List;

public class ParentDAOImpl extends DAO implements ParentDAO {

    public static ParentDAOImpl instance;

    public static ParentDAOImpl getInstance(){
        if (instance == null){
            return new ParentDAOImpl();
        }else {
            return instance;
        }
    }
    @Override
    public Parent saveParent(Parent parent) {
        try {
            begin();
            getSession().save(parent);
            commit();
            return parent;
        }catch (Exception e){

            System.out.println(e);
            rollback();
            return null;
        }
    }

    @Override
    public Parent updateParent(Parent parent) {
        try {
            begin();
            getSession().update(parent);
            commit();
            return parent;
        }catch (Exception e){
            rollback();
            return null;
        }
    }

    @Override
    public Parent saveOrUpdateParent(Parent parent) {
        try {
            begin();
            getSession().saveOrUpdate(parent);
            commit();
            return parent;
        }catch (Exception e){
            rollback();
            return null;
        }
    }

    @Override
    public boolean deleteParent(Parent parent) {
        try {
            begin();
            getSession().delete(parent);
            commit();
            return true;
        }catch (Exception e){
            rollback();
            return false;
        }
    }

    @Override
    public Parent getParentById(int parentId) {
        try {
            begin();
            Query query = getSession().createQuery("FROM parents WHERE id=ref");
            query
                    .setInteger("ref" , parentId);
            Parent parent = (Parent) query.uniqueResult();
            commit();
            return parent;
        }catch (Exception e){
            rollback();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Parent> getAllParents() {
        try {
            begin();
            Query query = getSession().createQuery("FROM Parent");
            List<Parent> parents =  query.list();
            commit();
            return parents;
        }catch (Exception e){
            rollback();
            return null;
        }
    }
}