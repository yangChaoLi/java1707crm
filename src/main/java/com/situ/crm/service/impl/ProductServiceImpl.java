package com.situ.crm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.crm.common.EasyUIDataGrid;
import com.situ.crm.common.ServletResponse;
import com.situ.crm.dao.ProductMapper;
import com.situ.crm.pojo.Product;
import com.situ.crm.pojo.ProductExample;
import com.situ.crm.service.IProductService;
import com.situ.crm.uitl.Util;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductMapper productDao;
	
	public EasyUIDataGrid pageList(Product product, Integer rows, Integer page) {
		EasyUIDataGrid dataGrid = new EasyUIDataGrid();
		
		ProductExample example =  new ProductExample();
		//配置分页
		PageHelper.startPage(page, rows);
		//执行查询
		if (StringUtils.isNotEmpty(product.getName())) {
			//查询的条件
			example.createCriteria().andNameLike(Util.formatLike(product.getName()));
		}
		List<Product> productList = productDao.selectByExample(example);
		
		PageInfo<Product> pageInfo = new PageInfo<Product>(productList);
		int total = (int)pageInfo.getTotal();
		
		dataGrid.setTotal(total);
		dataGrid.setRows(productList);
		
		return dataGrid;
	}

	public ServletResponse add(Product product) {
		int result = productDao.insert(product);
		if (result > 0) {
			return ServletResponse.creatSuccess("添加成功");
		}
		return ServletResponse.creatError("添加失败");
	}

	public ServletResponse delete(String ids) {
		String[] idStr = ids.split(",");
		int result = 0;
		for (String id : idStr) {
			 result += productDao.deleteByPrimaryKey(Integer.parseInt(id));
		}
		if (result > 0) {
			return ServletResponse.creatSuccess("删除成功");
		}
		return ServletResponse.creatError("删除失败");
	}

	public ServletResponse update(Product product) {
		int result = productDao.updateByPrimaryKey(product);
		if (result > 0) {
			return ServletResponse.creatSuccess("修改成功");
		}
		return ServletResponse.creatError("修改失败");
	}

}
