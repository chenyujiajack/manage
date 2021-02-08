package com.yu.ssm.dao;

import com.yu.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    @Select("SELECT * FROM traveller WHERE id IN (SELECT travellerId FROM order_traveller WHERE orderId=#{ordersId})")
     List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
