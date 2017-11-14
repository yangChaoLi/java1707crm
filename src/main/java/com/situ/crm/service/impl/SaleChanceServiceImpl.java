package com.situ.crm.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.crm.common.EasyUIDataGrid;
import com.situ.crm.common.ServletResponse;
import com.situ.crm.dao.SaleChanceMapper;
import com.situ.crm.pojo.SaleChance;
import com.situ.crm.pojo.SaleChanceExample;
import com.situ.crm.pojo.SaleChanceExample.Criteria;
import com.situ.crm.service.ISaleChanceService;
import com.situ.crm.uitl.Util;

@Service
public class SaleChanceServiceImpl implements ISaleChanceService {

	@Autowired
	private SaleChanceMapper saleChanceDao;
	
	public EasyUIDataGrid pageList(SaleChance saleChance, Integer rows, Integer page, Date startTime, Date endTime) {
		EasyUIDataGrid dataGrid = new EasyUIDataGrid();
		
		SaleChanceExample example =  new SaleChanceExample();
		Criteria createCriteria = example.createCriteria();
		//配置分页
		PageHelper.startPage(page, rows);
		if (StringUtils.isNotEmpty(saleChance.getCustomerName())) {
			//查询的条件
			createCriteria.andCustomerNameLike(Util.formatLike(saleChance.getCustomerName()));
		}
		if (StringUtils.isNotEmpty(saleChance.getOverview())) {
			//查询的条件
			createCriteria.andOverviewLike(Util.formatLike(saleChance.getOverview()));
		}
		if (StringUtils.isNotEmpty(saleChance.getCreateMan())) {
			//查询的条件
			createCriteria.andCreateManLike(Util.formatLike(saleChance.getCreateMan()));
		}
		if (saleChance.getStatus() != null) {
			createCriteria.andStatusEqualTo(saleChance.getStatus());
		}
		if (startTime != null && endTime != null) {
			createCriteria.andCreateTimeBetween(startTime, endTime);
			
		} 
		List<SaleChance> saleChanceList = saleChanceDao.selectByExample(example);
		PageInfo<SaleChance> pageInfo = new PageInfo<SaleChance>(saleChanceList);
		int total = (int)pageInfo.getTotal();
		
		dataGrid.setTotal(total);
		dataGrid.setRows(saleChanceList);
		
		return dataGrid;
	}

	public ServletResponse add(SaleChance saleChance) {
		String assignMan = saleChance.getAssignMan();
		System.out.println(assignMan);
		if (assignMan != null && !"".equals(assignMan)) {//判断是否分配了指派人
			saleChance.setStatus(1);
			saleChance.setDevResult(1);
		} else {
			saleChance.setStatus(0);
			saleChance.setDevResult(0);
		}
		
		int result = saleChanceDao.insert(saleChance);
		if (result > 0) {
			return ServletResponse.creatSuccess("添加成功");
		}
		return ServletResponse.creatError("添加失败");
	}

	public ServletResponse delete(String ids) {
		String[] idStr = ids.split(",");
		int result = 0;
		for (String id : idStr) {
			 result += saleChanceDao.deleteByPrimaryKey(Integer.parseInt(id));
		}
		if (result > 0) {
			return ServletResponse.creatSuccess("删除成功");
		}
		return ServletResponse.creatError("删除失败");
	}

	public ServletResponse update(SaleChance saleChance) {
		String assignMan = saleChance.getAssignMan();
		System.out.println(assignMan);
		if (assignMan != null && !"".equals(assignMan)) {//判断是否分配了指派人
			saleChance.setStatus(1);
			saleChance.setDevResult(1);
		} else {
			saleChance.setStatus(0);
			saleChance.setDevResult(0);
		}
		int result = saleChanceDao.updateByPrimaryKey(saleChance);
		if (result > 0) {
			return ServletResponse.creatSuccess("修改成功");
		}
		return ServletResponse.creatError("修改失败");
	}
	
	public ServletResponse findById(Integer id) {
		
		SaleChance saleChance = saleChanceDao.findById(id);
		if (saleChance != null) {
			return ServletResponse.creatSuccess(saleChance);
		}
		return ServletResponse.creatError();
	}

	public ServletResponse updateDevResult(Integer saleChanceId, Integer devResult) {
		SaleChanceExample example = new SaleChanceExample();
		SaleChance saleChance = new SaleChance();
		saleChance.setDevResult(devResult);
		example.createCriteria().andIdEqualTo(saleChanceId);
		int result = saleChanceDao.updateByExampleSelective(saleChance, example);
		if (result > 0) {
			return ServletResponse.creatSuccess("执行成功");
		}
		return ServletResponse.creatError("执行失败");
	}

	public void exportExcel(ServletOutputStream outputStream) {
		List<SaleChance> list = saleChanceDao.selectByExample(new SaleChanceExample());
		try {
			// 1、创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 1.1、创建合并单元格对象
			CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 4);// 起始行号，结束行号，起始列号，结束列号

			// 1.2、头标题样式
			HSSFCellStyle style1 = createCellStyle(workbook, (short) 16);

			// 1.3、列标题样式
			HSSFCellStyle style2 = createCellStyle(workbook, (short) 13);

			// 2、创建工作表
			HSSFSheet sheet = workbook.createSheet("用户列表");
			// 2.1、加载合并单元格对象
			sheet.addMergedRegion(cellRangeAddress);
			// 设置默认列宽
			sheet.setDefaultColumnWidth(25);

			// 3、创建行
			// 3.1、创建头标题行；并且设置头标题
			HSSFRow row1 = sheet.createRow(0);
			HSSFCell cell1 = row1.createCell(0);
			// 加载单元格样式
			cell1.setCellStyle(style1);
			cell1.setCellValue("用户列表");

			// 3.2、创建列标题行；并且设置列标题
			HSSFRow rowHead = sheet.createRow(1);
			String[] titles = { "编号", "客户名称", "概要", "联系人", "联系电话","创建人","创建时间","状态" };
			for (int i = 0; i < titles.length; i++) {
				HSSFCell cell2 = rowHead.createCell(i);
				// 加载单元格样式
				cell2.setCellStyle(style2);
				cell2.setCellValue(titles[i]);
			}

			// 4、操作单元格；将用户列表写入excel
			if (list != null) {
				for (int j = 0; j < list.size(); j++) {
					HSSFRow row = sheet.createRow(j + 2);//创建行
					HSSFCell cellId = row.createCell(0);//创建第一个单元格
					cellId.setCellValue(list.get(j).getId());//赋值给第一个单元格
					HSSFCell cellName = row.createCell(1);
					cellName.setCellValue(list.get(j).getCustomerName());
					HSSFCell cellOverview = row.createCell(2);
					cellOverview.setCellValue(list.get(j).getOverview());
					HSSFCell cell14 = row.createCell(3);
					cell14.setCellValue(list.get(j).getLinkMan());
					HSSFCell cellLinkPhone = row.createCell(4);
					cellLinkPhone.setCellValue(list.get(j).getLinkPhone());
					HSSFCell cellCreateMan = row.createCell(5);
					cellCreateMan.setCellValue(list.get(j).getCreateMan());
					HSSFCell cellCreateTime = row.createCell(6);
					if (list.get(j).getCreateTime() != null) {
						cellCreateTime.setCellValue(list.get(j).getCreateTime());
					} else {
						cellCreateTime.setCellValue("");
					}
					HSSFCell cellStatus = row.createCell(7);
					if (list.get(j).getStatus() != null && list.get(j).getStatus() == 1) {
						cellStatus.setCellValue("已分配");
					} else {
						cellStatus.setCellValue("未分配");
					}
				}
			}
			// 5、输出
			workbook.write(outputStream);
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建单元格样式
	 * 
	 * @param workbook
	 *            工作簿
	 * @param fontSize
	 *            字体大小
	 * @return 单元格样式
	 */
	private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontSize) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
		// 创建字体
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗字体
		font.setFontHeightInPoints(fontSize);
		// 加载字体
		style.setFont(font);
		return style;
	}

}
