package com.yu.ssm.service;

import com.yu.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface IProductService {

     List<Product> findAll() throws Exception;

     void save(Product product) throws Exception;

}
