package areaName;

import java.io.File;
import java.io.FileWriter;

import jxl.*;

public class Xls {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		Sheet sheet;
		Workbook book;
		String cell_id, cell_county, cell_city, cell_province;
		int id_province, id_city;
		int last = -1;
		int lastcity = -1;
		try {
			book = Workbook.getWorkbook(new File("areaid_v.xls"));
			sheet = book.getSheet(0);
				
			for(i=1; i<=2567; i++) {
				cell_id = sheet.getCell(0,i).getContents();
				cell_county = sheet.getCell(2,i).getContents();
				cell_city = sheet.getCell(4,i).getContents();
				cell_province = sheet.getCell(6,i).getContents();
				
				// province
				FileWriter writeP = new FileWriter("city.xml", true);
				String provinceId = cell_id.substring(3,5);
				id_province = Integer.parseInt(provinceId);
				
				if(id_province != last) {
					if(i==1) {
						writeP.write(provinceId+"|"+cell_province);
						
					} else {
						writeP.write("," +provinceId+"|"+cell_province);
					}
					writeP.close();	
				}
				
				// city	
				FileWriter writeC = new FileWriter("city"+provinceId+".xml", true);
				String cityId = cell_id.substring(5,7);
				id_city = Integer.parseInt(cityId);
				if(id_city != lastcity || last != id_province) {
					if(i==1 || last != id_province){
						writeC.write(cell_id.substring(3,7)+"|"+cell_city);
					} else {
						writeC.write(","+cell_id.substring(3,7)+"|"+cell_city);
					}
					writeC.close();
				}
				//County
				FileWriter writeT = new FileWriter("city"+cell_id.substring(3,7)+".xml", true);
				//String countyId = cell_id.substring(7,9);
				if(i==1 || last != id_province || lastcity != id_city) {
					writeT.write(cell_id.substring(3,9)+"|" + cell_county);
				} else {
					writeT.write(","+cell_id.substring(3,9)+"|"+cell_county);
				}
				writeT.close();
				//update the last province and last city
				last = id_province;
				lastcity = id_city;	
			}
            book.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
