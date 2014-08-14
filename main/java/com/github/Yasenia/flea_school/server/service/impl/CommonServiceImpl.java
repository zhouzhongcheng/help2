package com.github.Yasenia.flea_school.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.Yasenia.flea_school.server.dao.ICommonDAO;
import com.github.Yasenia.flea_school.server.entity.GoodsType;
import com.github.Yasenia.flea_school.server.entity.Location;
import com.github.Yasenia.flea_school.server.entity.School;
import com.github.Yasenia.flea_school.server.service.ICommonService;

@Service("commonService")
public class CommonServiceImpl implements ICommonService {
    @Autowired
    private ICommonDAO commonDAO;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public School findSchoolById(Integer id) {
        School school = commonDAO.findSchoolById(id);
        return school;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public School findSchoolByName(String name) {
        return null;
    }

    @Override
    public List<School> findSchoolByParrentId(Integer parrent_id) {
        Location parrentLocation = commonDAO.findLocationById(parrent_id);
        List<School> result = parrentLocation.getChildrenSchool();
        return result;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<School> findAllSchool() {
        List<School> result = commonDAO.findAllSchool();
        return result;
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Location findLocationById(Integer id) {
        return commonDAO.findLocationById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Location findLocationByName(String name) {
        return null;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Location> findLocationByParrentId(Integer parrent_id) {
        Location parrentLocation = commonDAO.findLocationById(parrent_id);
        List<Location> result = parrentLocation.getChildrenLocation();
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Location> findAllLocation() {
        List<Location> result = commonDAO.findAllLocation();
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public GoodsType findGoodsTypeById(Integer id) {
        GoodsType goodsType = commonDAO.findGoodsTypeById(id);
        return goodsType;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public GoodsType findGoodsTypeByName(String name) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<GoodsType> findAllGoodsType() {
        return null;
    }


}
