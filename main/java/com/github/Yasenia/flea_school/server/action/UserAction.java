package com.github.Yasenia.flea_school.server.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.Yasenia.flea_school.server.entity.Goods;
import com.github.Yasenia.flea_school.server.entity.Location;
import com.github.Yasenia.flea_school.server.entity.School;
import com.github.Yasenia.flea_school.server.entity.User;
import com.github.Yasenia.flea_school.server.exception.DBException;
import com.github.Yasenia.flea_school.server.service.ICommonService;
import com.github.Yasenia.flea_school.server.service.IGoodsService;
import com.github.Yasenia.flea_school.server.service.IUserService;

/**
 * UserAction
 * 
 * @author Yasenia (458875608@qq.com)
 * */
@Controller
public class UserAction {
    /**
     * 用户访问 URL
     * */
    public static final String REGISTER_URL = "/register";
    public static final String LOGIN_URL = "/login";
    public static final String HOME_URL = "/home";
    public static final String LOGOUT_URL = "/logout";
    public static final String USER_CENTER_URL = "/userCenter";
    public static final String BASE_INFORMATION_URL = "/baseInformation";
    public static final String MORE_INFORMATION_URL = "/moreInformation";
    
    
    /**
     * 视图名
     * */
    public static final String REGISTER_VIEW = "user/register";
    public static final String LOGIN_VIEW = "user/login";
    public static final String HOME_VIEW = "user/home";
    public static final String USER_CENTER_VIEW = "user/userCenter";
    public static final String REGISTER_SUCCESS_VIEW = "user/registerSuccess";
    public static final String BASE_INFORMATION_VIEW = "user/baseInformation";
    public static final String MORE_INFORMATION_VIEW = "user/moreInformation";
    
    /**
     * 表单提交请求 URL
     * */
    public static final String REGISTER_ACTION = "/registerAction";
    public static final String LOGIN_ACTION = "/loginAction";
    public static final String BASE_INFORMATION_ACTION = "/baseInformationAction";
    public static final String MORE_INFORMATION_ACTION = "/moreInformationAction";
    /**
     * service对象
     * */
    @Autowired
    private IUserService userService;
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ICommonService commonService;

    
    /**
     * 初始化模型对象中参数"user"
     * */
    @ModelAttribute("user")
    public User initUser() {
        User user = new User();
        return user;
    }

    /**
     * 用户访问注册url，定向跳转至注册视图
     * */
    @RequestMapping(value = REGISTER_URL, method = RequestMethod.GET)
    public ModelAndView setUpRegister() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(REGISTER_VIEW);
        List<Location> locationList = commonService.findLocationByParrentId(0);
        mv.addObject("locationList", locationList);
        return mv;
    }
    
    /**
     * 用户访问登录url，定向跳转至登录视图
     * */
    @RequestMapping(value = LOGIN_URL, method = RequestMethod.GET)
    public String setUpLogin() {
        return LOGIN_VIEW;
    }    
    
    /**
     * 用户访问主页面url，定向跳转至主页面视图
     * */
    @RequestMapping(value = {HOME_URL, ""}, method = RequestMethod.GET)
    public ModelAndView setUpHome(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(HOME_VIEW);
        
        User user = (User) session.getAttribute("user");
        List<Goods> goodsList = null;
        if (user != null && user.getId() != null) {
            Integer schoolId = user.getSchool().getId();
            goodsList = goodsService.findGoodsBySchoolId(schoolId);
        }
        else {
            goodsList = goodsService.findAll(0, 20);
        }
        
        mv.addObject("user", user);
        mv.addObject("goodsList", goodsList);
        return mv;
    }
    
    /**
     * 用户访问退出登录url，定向跳转至主页
     * */
    @RequestMapping(value = LOGOUT_URL, method = RequestMethod.GET)
    public String setUpLogout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect: " + HOME_URL;
    }
    
    /**
     * 用户访问用户中心url，定向跳转至用户中心视图
     * */
    @RequestMapping(value = USER_CENTER_URL, method = RequestMethod.GET)
    public ModelAndView setUpUserCenter(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(USER_CENTER_VIEW);
        
        User user = (User) session.getAttribute("user");
        mv.addObject("user", user);
        
        return mv;
    }
    
    /**
     * 用户访问基本资料url，定向跳转至基本资料视图
     * */
    @RequestMapping(value = BASE_INFORMATION_URL, method = RequestMethod.GET)
    public ModelAndView setUpBaseInformation(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(BASE_INFORMATION_VIEW);
        
        User user = (User) session.getAttribute("user");
        Location area = null;
        Location city = null;
        Location province = null;
        
        Location location = user.getLocation();
        if (location == null || location.getId() == 0) {
        }
        else if (location.getParrentLocation().getId() == 0) {
            province = location;
        }
        else if (location.getParrentLocation().getParrentLocation().getId() == 0) {
            city = location;
            province = location.getParrentLocation();
        }
        else {
            area = location;
            city = location.getParrentLocation();
            province = location.getParrentLocation().getParrentLocation();
        }
        
        School school = user.getSchool();
        Location schoolLocation = school.getParrentLocation();
        
        mv.addObject("user", user);
        mv.addObject("area", area);
        mv.addObject("city", city);
        mv.addObject("province", province);
        mv.addObject("school", school);
        mv.addObject("schoolLocation", schoolLocation);
        
        return mv;
    }
    /**
     * 用户访问详细资料url，定向跳转至详细资料视图
     * */
    @RequestMapping(value = MORE_INFORMATION_URL, method = RequestMethod.GET)
    public ModelAndView setUpMoreInformation(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(MORE_INFORMATION_VIEW);
        
        User user = (User) session.getAttribute("user");
        mv.addObject("user", user);
        
        return mv;
    }

    /**
     * 注册视图提交表单
     * 
     * @param user 接收表单提交的用户相关参数并封装为模型对象user
     * @param schoolId 接收表单提交的schoolId参数
     * */
    @RequestMapping(value = REGISTER_ACTION, method = RequestMethod.POST)
    public String submitRegister(@ModelAttribute("registUser") User user,
            @RequestParam("schoolId") Integer schoolId) {
        // 获取注册学校信息
        School school = commonService.findSchoolById(schoolId);
        user.setSchool(school);
        try {
            userService.save(user);
        } catch (DBException ex) {
            return REGISTER_VIEW;
        }
        return REGISTER_SUCCESS_VIEW;
    }

    /**
     * 登录视图提交表单
     * */
    @RequestMapping(value = LOGIN_ACTION, method = RequestMethod.POST)
    public String submitLogin(@ModelAttribute(value = "loginUser") User user,
            HttpSession session) {
        boolean flag = false;
        
        // 获取真实用户信息
        User realUser = userService.findByUserName(user.getUserName());
        
        if (realUser == null) {
            flag = false;
        }
        else if (!realUser.getPassword().equals(user.getPassword())) {
            flag = false;
        }
        // 若密码正确，则将真实用户信息放入session，并转至主页
        else {
            session.setAttribute("user", realUser);
            flag = true;
        }
        if (flag) {
            return "redirect: " + HOME_URL;
        }
        else {
            return LOGIN_VIEW;
        }
    }
    
    
    /**
     * 修改资料视图提交表单
     * */
    @RequestMapping(value = BASE_INFORMATION_ACTION, method = RequestMethod.POST)
    public String submitEditInformation(@ModelAttribute(value = "editUser") User user,
            @RequestParam("schoolId") Integer schoolId,
            @RequestParam("provinceId") Integer provinceId,
            @RequestParam("cityId") Integer cityId,
            @RequestParam("areaId") Integer areaId,
            HttpSession session) {
        
        // 获取真实用户信息
        Integer realUserId = ((User) session.getAttribute("user")).getId();
        User realUser = userService.findById(realUserId);
        
        // 设置真实姓名
        String realName = user.getRealName().trim();
        if (realName != null && !realName.equals("")) {
            realUser.setRealName(realName);
        }
        
        // 设置性别
        Integer sex = user.getSex();
        if (sex != null) {
            realUser.setSex(sex);
        }
        
        // 设置学校
        School school = commonService.findSchoolById(schoolId);
        realUser.setSchool(school);
        
        // 设置所在地
        Location location = null;
        if (areaId != -1) {
            location = commonService.findLocationById(areaId);
        }
        else if (cityId != -1) {
            location = commonService.findLocationById(cityId);
        }
        else if (provinceId != -1) {
            location = commonService.findLocationById(provinceId);
        }
        if (location != null) {
            realUser.setLocation(location);
        }
        
        // 更新用户信息
        userService.update(realUser);
        
        // 更新session
        session.setAttribute("user", realUser);
        
        return "redirect: " + BASE_INFORMATION_URL;
    }
}
