package com.situ.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.EasyUIDataGrid;
import com.situ.crm.common.ServletResponse;
import com.situ.crm.pojo.Product;
import com.situ.crm.service.IProductService;

@Controller
@RequestMapping(value="product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@RequestMapping(value="index")
	public String index () {
		return "product_manager";
	}
	
	@RequestMapping(value="pageList")
	@ResponseBody
	public EasyUIDataGrid pageList(Integer page, Integer rows,Product product) {
		return productService.pageList(product, rows, page);
	}
	
	@RequestMapping(value="add")
	@ResponseBody
	public ServletResponse add(Product product) {
		return productService.add(product);
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public ServletResponse delete(String ids) {
		return productService.delete(ids);
	}
	
	@RequestMapping(value="update")
	@ResponseBody
	public ServletResponse update(Product product) {
		return productService.update(product);
	}
}
