package com.example.demo.mapper;

import com.example.demo.entity.GoodsList;

import java.util.List;


public interface GoodsListMapper {


    int insertGoodsAll(GoodsList goodsList);

    int updateGoodsAll(GoodsList goodsList);

    int deleteGoodsById(Long goodsId);

    List<GoodsList> selectGoodsList(GoodsList goodsList);


}
