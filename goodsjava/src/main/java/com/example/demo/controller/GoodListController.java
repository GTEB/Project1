package com.example.demo.controller;

import com.example.demo.entity.GoodsList;
import com.example.demo.entity.User;
import com.example.demo.mapper.GoodsListMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.Response;
import com.example.demo.utils.UploadUtils;
import com.example.demo.web.controller.BaseController;
import com.example.demo.web.domain.AjaxResult;
import com.example.demo.web.page.TableDataInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @CreateTime: 2023-05-24  17:10
 * @Description: TODO
 */
@RestController
@RequestMapping(value = "/goods")
@Slf4j
public class GoodListController extends BaseController {
    @Autowired
    private GoodsListMapper goodsListMapper;

    @PostMapping(value="/insertGoodsAll")
    @ResponseBody
    public Response insertGoodsAll(GoodsList goodsList){
        int i = goodsListMapper.insertGoodsAll(goodsList);
        if(i != 1){
            return Response.failed("新增失败");
        }
        return Response.success();
    }
    /*
     **查询商品表数据
     */
    @PostMapping (value="/selectGoodsList")
    @ResponseBody
    public TableDataInfo selectGoodsList(GoodsList goodsList){

        startPage();
        List<GoodsList> GoodsList = goodsListMapper.selectGoodsList(goodsList);
        return getDataTable(GoodsList);
    }
    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file)
    {
            String filePath = UploadUtils.upload(file);
            return AjaxResult.success(filePath);

    }

    @PostMapping (value="/updateGoodsAll")
    @ResponseBody
    public Response updateGoodsAll(GoodsList goodsList){

        int a= goodsListMapper.updateGoodsAll(goodsList);
        if(a != 1){
            return Response.failed("修改失败");
        }
        return Response.success();
    }
    @PostMapping (value="/deleteGoodsById")
    @ResponseBody
    public Response deleteGoodsById(Long goodsId){

        int a = goodsListMapper.deleteGoodsById(goodsId);
        if(a != 1){
            return Response.failed("删除失败");
        }
        return Response.success();

    }




}
