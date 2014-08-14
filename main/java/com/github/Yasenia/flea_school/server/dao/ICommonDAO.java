package com.github.Yasenia.flea_school.server.dao;

import java.util.List;

import com.github.Yasenia.flea_school.server.entity.GoodsType;
import com.github.Yasenia.flea_school.server.entity.Location;
import com.github.Yasenia.flea_school.server.entity.School;

public interface ICommonDAO {

    public School findSchoolById(Integer id);

    public School findSchoolByName(String name);
    
    public List<School> findAllSchool();

    public Location findLocationById(Integer id);

    public Location findLocationByName(String name);    

    public List<Location> findAllLocation();

    public GoodsType findGoodsTypeById(Integer id);

    public GoodsType findGoodsTypeByName(String name);
    
    public List<GoodsType> findAllGoodsType();

}
