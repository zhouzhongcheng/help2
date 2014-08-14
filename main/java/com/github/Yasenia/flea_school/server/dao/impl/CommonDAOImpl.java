package com.github.Yasenia.flea_school.server.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.github.Yasenia.flea_school.server.dao.ICommonDAO;
import com.github.Yasenia.flea_school.server.entity.GoodsType;
import com.github.Yasenia.flea_school.server.entity.Location;
import com.github.Yasenia.flea_school.server.entity.School;

@Repository("commonDAO")
public class CommonDAOImpl implements ICommonDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public School findSchoolById(Integer id) {
        School result = em.find(School.class, id);
        return result;
    }

    @Override
    public School findSchoolByName(String name) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<School> findAllSchool() {
        String queryString = "SELECT S FROM School S";

        Query query = em.createQuery(queryString);
        List<School> result = query.getResultList();

        return result;
    }

    @Override
    public Location findLocationById(Integer id) {
        Location result = em.find(Location.class, id);
        return result;
    }

    @Override
    public Location findLocationByName(String name) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Location> findAllLocation() {
        String queryString = "SELECT L FROM Location L";

        Query query = em.createQuery(queryString);
        List<Location> result = query.getResultList();

        return result;
    }

    @Override
    public GoodsType findGoodsTypeById(Integer id) {
        GoodsType result = em.find(GoodsType.class, id);
        return result;
    }

    @Override
    public GoodsType findGoodsTypeByName(String name) {
        return null;
    }

    @Override
    public List<GoodsType> findAllGoodsType() {
        return null;
    }

}
