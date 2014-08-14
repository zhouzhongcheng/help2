package com.github.Yasenia.flea_school.server.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.Yasenia.flea_school.server.dao.IGoodsDAO;
import com.github.Yasenia.flea_school.server.entity.Goods;
import com.github.Yasenia.flea_school.server.service.IGoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private IGoodsDAO goodsDAO;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Goods goods) {
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE, 30);
        Date validDate = cal.getTime();
        
        goods.setReleaseDate(currentDate);
        goods.setAlterDate(currentDate);
        goods.setValidDate(validDate);
        
        goods.setState(Goods.SELLING);
        goodsDAO.save(goods);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Goods> findGoodsBySchoolId(Integer schoolId) {
        List<Goods> goodsList = goodsDAO.findGoodsBySchoolId(schoolId);
        return goodsList;
    }

    @Override
    public List<Goods> findAll(int... rowStartIdxAndCount) {
        List<Goods> goodsList = goodsDAO.findAll(rowStartIdxAndCount);
        return goodsList;
    }
}
