package com.qxr.base.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelImportUtils {

	// @描述：是否是2003的excel，返回true是2003
	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}

	// @描述：是否是2007的excel，返回true是2007
	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}

	/**
	 * 验证EXCEL文件
	 * 
	 * @param filePath
	 * @return
	 */
	public static boolean validateExcel(String filePath) {
		if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
			return false;
		}
		return true;
	}
	/**
	 * 获得Workbook工作薄对象
	 * @param fileName excel文件名
	 * @return
	 * @throws IOException 
	 */
	public static Workbook getWorkbook(String fileName, MultipartFile file) throws IOException{
		Workbook wb = null;
		//判断是否是excel文件
		if(validateExcel(fileName)){
			//获得excel文件io流
			InputStream is = file.getInputStream();
			//判断excel类型(2003:xls/2007:xlsx)
			if (isExcel2003(fileName)) {
				//2003
				wb = new HSSFWorkbook(is);
			}else if(isExcel2007(fileName)){
				//2007
				wb=new XSSFWorkbook(is);
			}
		}
		return wb;
	}
	/**
	 * 得到文件里数据
	 * @throws IOException 
	 * */
	public static List<BaseMap> getFileInfo(String fileName, MultipartFile file) throws IOException{
		List<BaseMap> list = new ArrayList<BaseMap>();
		Workbook work = getWorkbook(fileName, file);
		Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }
                BaseMap map = new BaseMap();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    map.put("var"+y, cell);
                }
                list.add(map);
            }
        }
        work.close();
		return list;
	}
}
