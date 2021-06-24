package com.heima.travel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heima.travel.mapper.RouteMapper;
import com.heima.travel.pojo.Route;
import com.heima.travel.service.RouteService;
import com.heima.travel.vo.PageBean;
import com.heima.travel.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author laofang
 * @description
 * @date 2021-06-19
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteMapper routeMapper;


    @Override
    public ResultInfo routeCareChoose() {
        //1.获取人气前四
        PageHelper.startPage(1,4);
        List<Route> popularityRoutes= this.routeMapper.popularityRoutes();
        //2.获取最新的旅游路线前4
        PageHelper.startPage(1,4);
        List<Route> newRoutes= this.routeMapper.newRoutes();
        //3.获取主题路由线路前四
        PageHelper.startPage(1,4);
        List<Route> themesRoutes= this.routeMapper.themesRoutes();
        //组装数组
        HashMap<String, List<Route>> data = new HashMap<>();
        data.put("news",newRoutes);
        data.put("popularity",popularityRoutes);
        data.put("themes",themesRoutes);
        return new ResultInfo(true,data,null);
    }

    @Override
    public ResultInfo findRouteList(Integer cid, Integer curPage, String rname) {
        PageHelper.startPage(curPage,8);
        List<Route> routes= this.routeMapper.findRouteList(cid,rname);
        PageInfo<Route> pageInfo = new PageInfo<>(routes);
        PageBean<Route> pageBean = new PageBean<>();
        pageBean.setTotalPage(pageInfo.getPages());
        pageBean.setPageSize(pageInfo.getPageSize());
        pageBean.setPrePage(pageInfo.getPrePage());
        pageBean.setNextPage(pageInfo.getNextPage());
        pageBean.setCurPage(pageInfo.getPageNum());
        pageBean.setData(routes);
        pageBean.setCount(pageInfo.getTotal());
        return new ResultInfo(true,pageBean,null);
    }


    @Override
    public ResultInfo findRouteInfoByRid(Integer rid) {
        //1.根据旅游路线id查询路线信息
        Route route= this.routeMapper.findRouteInfoByRid(rid);
        if (null==route) {
            //抛异常，交给异常管理器统一处理
            throw new RuntimeException(rid+"对应的旅游路线不存在");
        }
        return new ResultInfo(true,route,null);
    }

    @Override
    public ResultInfo findRoutesFavoriteRank(Integer curPage, String rname, Double startPrice, Double endPrice) {
        //使用分页插件实现分页
        PageHelper.startPage(curPage,8);
        List<Route> routes= this.routeMapper.findRoutesFavoriteRank(rname,startPrice,endPrice);
        if (CollectionUtils.isEmpty(routes)) {
            return new ResultInfo(false,"查询不到列表信息");
        }
        PageInfo<Route> pageInfo = new PageInfo<>(routes);
        PageBean<Route> pageBean = new PageBean<>();
        pageBean.setTotalPage(pageInfo.getPages());
        pageBean.setPageSize(pageInfo.getPageSize());
        pageBean.setPrePage(pageInfo.getPrePage());
        pageBean.setNextPage(pageInfo.getNextPage());
        pageBean.setCurPage(pageInfo.getPageNum());
        pageBean.setData(routes);
        pageBean.setCount(pageInfo.getTotal());
        return new ResultInfo(true,pageBean,null);
    }
}
