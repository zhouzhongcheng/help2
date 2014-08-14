package com.github.Yasenia.flea_school.server.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.Yasenia.flea_school.server.entity.Goods;
import com.github.Yasenia.flea_school.server.entity.GoodsType;
import com.github.Yasenia.flea_school.server.entity.School;
import com.github.Yasenia.flea_school.server.entity.User;
import com.github.Yasenia.flea_school.server.service.ICommonService;
import com.github.Yasenia.flea_school.server.service.IGoodsService;

/**
 * GoodsAction
 * 
 * @author Yasenia (458875608@qq.com)
 * */
@Controller
public class GoodsAction {
    /**
     * 用户访问 URL
     * */
    public static final String RELEASE_GOODS_URL = "/releaseGoods";
    
    /**
     * 视图名
     * */
    public static final String RELEASE_GOODS_VIEW = "goods/releaseGoods";
    public static final String RELEASE_SUCCESS_VIEW = "goods/releaseSuccess";
    
    /**
     * 表单提交请求 URL
     * */
    public static final String RELEASE_GOODS_ACTION = "/releaseGoodsAction";

    /**
     * service对象
     * */
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ICommonService commonService;

    /**
     * 用户访问发布商品 url，定向跳转至发布商品视图
     * */
    @RequestMapping(value = { RELEASE_GOODS_URL }, method = RequestMethod.GET)
    public String setUpReleaseGoods() {
        return RELEASE_GOODS_VIEW;
    }

    /**
     * 发布商品视图提交表单
     * 
     * @param goods 接收表单提交的商品关参数并封装为模型对象goods
     * @param user 从session中获取用户对象user
     * @param schoolId 接收表单提交的schoolId参数
     * @param goodsTypeId 接收表单提交的goodsTypeId参数
     * */
    @RequestMapping(value = { RELEASE_GOODS_ACTION }, method = RequestMethod.POST)
    public String submitReleaseGoods(@ModelAttribute("goods") Goods goods,
            @RequestParam("schoolId") Integer schoolId,
            @RequestParam("goodsTypeId") Integer goodsTypeId,
            HttpSession session,
            Model model) {
        User seller = (User) session.getAttribute("user");
        School school = commonService.findSchoolById(schoolId);
        GoodsType goodsType = commonService.findGoodsTypeById(goodsTypeId);
        goods.setSeller(seller);
        goods.setSchool(school);
        goods.setGoodsType(goodsType);
        goodsService.save(goods);
        return RELEASE_SUCCESS_VIEW;
    }
}
