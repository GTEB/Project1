package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:
 * @CreateTime:
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsList {

    private  Long goodsId;
    private  String goodsName;
    private  int number;
    private  int price;
    private  String type;
    private  String picture;
    private  String remark;
    private  String createTime;

}
