package com.yu.ssm.dao;

import com.yu.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProductDao {
    //根据id查询产品
    @Select("select * from product where id=#{id}")
     Product findById(String Id) throws Exception;

    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
     void save(Product product);
}
