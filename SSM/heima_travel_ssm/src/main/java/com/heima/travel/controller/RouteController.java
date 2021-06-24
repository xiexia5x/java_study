package com.heima.travel.controller;

import com.heima.travel.service.RouteService;
import com.heima.travel.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laofang
 * @description
 * @date 2021-06-19
 */
@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    /**
     * 获取人气 主题 最新的旅游线路集合前4
     * @return
     */
    @PostMapping("/routeCareChoose")
    public ResultInfo routeCareChoose(){
      return this.routeService.routeCareChoose();
    }

    @PostMapping("/findRouteList")
    public ResultInfo findRouteList(
           @RequestParam(value = "cid",required = false) Integer cid,
           @RequestParam(value = "curPage",required = false,defaultValue = "1") Integer curPage,
           @RequestParam(value = "rname",required = false) String rname){
        ResultInfo result=this.routeService.findRouteList(cid,curPage,rname);
        return result;
    }

    @PostMapping("/findRouteByRid")
    public ResultInfo findRouteByRid(Integer rid){
        return this.routeService.findRouteInfoByRid(rid);
    }

    @PostMapping("/findRoutesFavoriteRank")
    public ResultInfo findRoutesFavoriteRank(
            @RequestParam(value = "curPage",required = false,defaultValue = "1") Integer curPage,
            @RequestParam(value = "rname",required = false) String rname,
            @RequestParam(value = "startPrice",required = false)  Double startPrice,
            @RequestParam(value = "endPrice",required = false)  Double endPrice){
        return  this.routeService.findRoutesFavoriteRank(curPage,rname,startPrice,endPrice);
    }


}
