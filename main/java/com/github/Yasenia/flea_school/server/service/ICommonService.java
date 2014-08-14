package com.github.Yasenia.flea_school.server.service;

import java.util.List;

import com.github.Yasenia.flea_school.server.entity.GoodsType;
import com.github.Yasenia.flea_school.server.entity.Location;
import com.github.Yasenia.flea_school.server.entity.School;

public interface ICommonService {
    public School findSchoolById(Integer id);

    public School findSchoolByName(String name);
    
    public List<School> findSchoolByParrentId(Integer parrent_id);
    
    public List<School> findAllSchool();

    public Location findLocationById(Integer id);

    public Location findLocationByName(String name);

    public List<Location> findLocationByParrentId(Integer id);
    
    public List<Location> findAllLocation();
    
    public GoodsType findGoodsTypeById(Integer id);
    
    public GoodsType findGoodsTypeByName(String name);
    
    public List<GoodsType> findAllGoodsType();


}
