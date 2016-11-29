package com.sxs.external.webapp.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxs.external.dao.mapper.AssetsLiabilitiesMapper;
import com.sxs.external.dao.model.AssetsLiabilities;

@RestController
@RequestMapping(value = "/assetsLiabilities")
public class AssetsLiabilitiesController {

	@Autowired
	private AssetsLiabilitiesMapper assetsLiabilitiesMapper;
	
	@RequestMapping(value = "/edit")
	public String editUserInfo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		long begin = System.currentTimeMillis();
		InputStream is = null;
		try {
			// 读取文件
			is = new FileInputStream("/home/资产负债率2.xls");
			// 将文件流解析成 POI 文档
			POIFSFileSystem fs = new POIFSFileSystem(is);
			// 再将 POI 文档解析成 Excel 工作簿
			HSSFWorkbook hwb = new HSSFWorkbook(fs);
			HSSFRow row = null;
	        HSSFCell cell = null;
	        // 得到第 1 个工作簿
	        HSSFSheet sheet = hwb.getSheetAt(0);
	        // 得到这一行一共有多少列
	        int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
	        // 得到最后一行的坐标
	        Integer lastRowNum = sheet.getLastRowNum()+2;
	        List<AssetsLiabilities> assetsLiabilitiesList = new ArrayList<AssetsLiabilities>();
	        AssetsLiabilities assetsLiabilities = null;
	        String cellValue = null;
	        // 从第 2 行开始读
	        for(int i=3; i<=lastRowNum; i++){
	        	row = sheet.getRow(i);
	        	if(row!=null){
		        	assetsLiabilities = new AssetsLiabilities();
		        	assetsLiabilities.setStkcd(row.getCell(0)==null?"":row.getCell(0).toString());
		        	assetsLiabilities.setAccper(new SimpleDateFormat("yyyy-MM-dd").parse(row.getCell(1)==null?"":row.getCell(1).toString()));
		        	assetsLiabilities.setTyprep(row.getCell(2)==null?"":row.getCell(2).toString());
		        	assetsLiabilities.setIndcd(row.getCell(3)==null?"":row.getCell(3).toString());
		        	assetsLiabilities.setF011201a(new BigDecimal(row.getCell(4)==null?"0":row.getCell(4).toString()));
		        	assetsLiabilitiesMapper.insertAssetsLiabilities(assetsLiabilities);
	        	}
	        }
			long end = System.currentTimeMillis();
			System.out.println((begin-end)/(1000));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "false";
		}
		return "true";
	}
}
