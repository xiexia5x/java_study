package com.heima.travel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heima.travel.mapper.FavoriteMapper;
import com.heima.travel.mapper.RouteMapper;
import com.heima.travel.pojo.Favorite;
import com.heima.travel.pojo.Route;
import com.heima.travel.pojo.User;
import com.heima.travel.service.FavoriteService;
import com.heima.travel.vo.PageBean;
import com.heima.travel.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author laofang
 * @description
 * @date 2021-06-20
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Autowired
    private RouteMapper routeMapper;

    @Override
    public ResultInfo isFavoriteByRid(Integer rid) {
        //1.从当前session中获取用户信息
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        User curUser = (User) session.getAttribute("CUR_USER");
        if (null==curUser) {
            return new ResultInfo(false,"用户未登录");
        }
        //不采取，增大数据库io的开销 浪费内存
//        Favorite favorite=this.favoriteMapper.isFavoriteByRid(curUser.getUid(),rid);
//        if (null==favorite) {
//            //用户未收藏
//            return new ResultInfo(true,false,null);
//        }
         Integer count =this.favoriteMapper.countFavorite(curUser.getUid(),rid);
        if (count==0) {
            //用户未收藏
            return new ResultInfo(true,false,null);
        }
        return new ResultInfo(true,true,null);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public ResultInfo addFavorite(Integer rid) {
        //1.获取当前的用户对象
        //1.从当前session中获取用户信息
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        User curUser = (User) session.getAttribute("CUR_USER");
        if (null==curUser) {
            return new ResultInfo(false,0,"用户未登录");
        }
        //查询，确定当前用户是否收藏了对应路线
        Integer count = favoriteMapper.countFavorite(curUser.getUid(), rid);
        if (count>0) {
            return new ResultInfo(false,"用户已收藏");
        }
        //向收藏表添加数据
        this.favoriteMapper.addFavorite(curUser.getUid(),rid);
        //更新路线的收藏树龄
        this.routeMapper.updateCount(rid,1);
        //获取旅游路线的收藏数量
        Integer fCount=this.routeMapper.findCountByRoutId(rid);
        return new ResultInfo(true,fCount,null);
    }

    @Override
    public ResultInfo findFavoriteByPage(Integer curPage) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        User curUser = (User) session.getAttribute("CUR_USER");
        if (null==curUser) {
            return new ResultInfo(false,"用户未登录");
        }
        PageHelper.startPage(curPage,12);
        List<Favorite> favoriteList= this.favoriteMapper.findFavorites(curUser.getUid());
        if (CollectionUtils.isEmpty(favoriteList)) {
            return new ResultInfo(false,"用户未收藏路线");
        }
        PageInfo<Favorite> pageInfo = new PageInfo<>(favoriteList);
        PageBean<Favorite> pageBean = new PageBean<>();
        pageBean.setTotalPage(pageInfo.getPages());
        pageBean.setPageSize(pageInfo.getPageSize());
        pageBean.setPrePage(pageInfo.getPrePage());
        pageBean.setNextPage(pageInfo.getNextPage());
        pageBean.setCurPage(pageInfo.getPageNum());
        pageBean.setData(favoriteList);
        pageBean.setCount(pageInfo.getTotal());
        return new ResultInfo(true,pageBean,null);
    }
}
