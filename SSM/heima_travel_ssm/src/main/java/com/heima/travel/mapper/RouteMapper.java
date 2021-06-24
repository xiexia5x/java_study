package com.heima.travel.mapper;

import com.heima.travel.pojo.Route;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface RouteMapper {
    List<Route> popularityRoutes();

    List<Route> newRoutes();

    List<Route> themesRoutes();

    List<Route> findRouteList(@Param("cid") Integer cid,@Param("rname") String rname);

    Route findRouteInfoByRid(Integer rid);

    void updateCount(@Param("rid") Integer rid,@Param("count") int count);

    /**
     * 根据路线的id查询收藏的数量
     * @param rid
     * @return
     */
    Integer findCountByRoutId(Integer rid);

    List<Route> findRoutesFavoriteRank(@Param("rname") String rname,@Param("startPrice") Double startPrice,@Param("endPrice") Double endPrice);
}
