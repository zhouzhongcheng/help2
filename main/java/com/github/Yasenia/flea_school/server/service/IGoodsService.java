package com.github.Yasenia.flea_school.server.service;

import java.util.List;

import com.github.Yasenia.flea_school.server.entity.Goods;

public interface IGoodsService {
    public void save(Goods goods);

    public List<Goods> findGoodsBySchoolId(Integer schoolId);
    
    public List<Goods> findAll(int... rowStartIdxAndCount);
    
}
