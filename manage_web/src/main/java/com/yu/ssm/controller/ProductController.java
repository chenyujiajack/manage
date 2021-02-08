package com.yu.ssm.controller;


import com.yu.ssm.domain.Product;


import com.yu.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
   @Autowired
    private IProductService productService;

   @RequestMapping("/save")
   public String save(Product product) throws Exception {
       productService.save(product);
       return "redirect:findAll";

   }


    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {

        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list");

        return mv;

    }

}
