package com.github.Yasenia.flea_school.server.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.github.Yasenia.flea_school.server.dao.IUserDAO;
import com.github.Yasenia.flea_school.server.entity.User;

@Repository("userDAO")
public class UserDAOImpl implements IUserDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public void delete(User user) {
        user = em.getReference(User.class, user.getId());
        em.remove(user);
    }

    public User update(User user) {
        User result = em.merge(user);
        return result;
    }

    public User findById(Integer id) {
        User result = em.find(User.class, id);
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<User> findByProperty(String propertyName, Object propertyValue,
            int... rowStartIdxAndCount) {
        String queryString = "SELECT u FROM User u WHERE u." + propertyName
                + " = :propertyValue";
        Query query = em.createQuery(queryString);

        query.setParameter("propertyValue", propertyValue);

        if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
            int rowStartIdx = rowStartIdxAndCount[0];
            query.setFirstResult(rowStartIdx);
            if (rowStartIdxAndCount.length > 1) {
                int rowCount = rowStartIdxAndCount[1];
                query.setMaxResults(rowCount);
            }
        }

        List<User> result = query.getResultList();

        return result;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll(int... rowStartIdxAndCount) {
        String queryString = "SELECT u FROM User u";

        Query query = em.createQuery(queryString);

        if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
            int rowStartIdx = rowStartIdxAndCount[0];
            query.setFirstResult(rowStartIdx);
            if (rowStartIdxAndCount.length > 1) {
                int rowCount = rowStartIdxAndCount[1];
                query.setMaxResults(rowCount);
            }
        }

        List<User> result = query.getResultList();

        return result;
    }

}
