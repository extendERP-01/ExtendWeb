package nirmalya.aathithya.webmodule.production.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractXlsView;
 
import nirmalya.aathithya.webmodule.production.model.ProductionPipeScrapModel;

public class ProductionExcelScrapReport extends AbstractXlsView {

	Logger logger = LoggerFactory.getLogger(ProductionExcelScrapReport.class);

	@Override
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("Method : buildExcelDocument starts");
		try {

			List<ProductionPipeScrapModel> scrapList = (List<ProductionPipeScrapModel>) model.get("scrapList");
			HSSFSheet realSheet = ((HSSFWorkbook) workbook).createSheet("Account Ledger Report");

			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();

			font.setBold(true);
			font.setColor(HSSFColor.RED.index);

			style.setFont(font);

			realSheet.setDefaultColumnWidth(20);
			HSSFRow row = realSheet.createRow(0);
			HSSFCell cell = row.createCell(0);

			row.getCell(0).setCellStyle(style);
			cell.setCellValue("Sl No.");

			cell = row.createCell(1);
			row.getCell(1).setCellStyle(style);
			cell.setCellValue("Mother Coil Batch");

			cell = row.createCell(2);
			row.getCell(2).setCellStyle(style);
			cell.setCellValue("Mother  Coil Thickness");

			cell = row.createCell(3);
			row.getCell(3).setCellStyle(style);
			cell.setCellValue("Slit Batch");

			cell = row.createCell(4);
			row.getCell(4).setCellStyle(style);
			cell.setCellValue("Slit Sub Batch");

			cell = row.createCell(5);
			row.getCell(5).setCellStyle(style);
			cell.setCellValue(" Slit Width");

			cell = row.createCell(6);
			row.getCell(6).setCellStyle(style);
			cell.setCellValue("Slit Quantity");

			cell = row.createCell(7);
			row.getCell(7).setCellStyle(style);
			cell.setCellValue("Pipe Size");

			cell = row.createCell(8);
			row.getCell(8).setCellStyle(style);
			cell.setCellValue("Scrap1 Wt");

			cell = row.createCell(9);
			row.getCell(9).setCellStyle(style);
			cell.setCellValue("Scrap2 Wt");

			cell = row.createCell(10);
			row.getCell(10).setCellStyle(style);
			cell.setCellValue("Scrap3 Wt");

			cell = row.createCell(11);
			row.getCell(11).setCellStyle(style);
			cell.setCellValue("Scrap1 Quantity");

			cell = row.createCell(12);
			row.getCell(12).setCellStyle(style);
			cell.setCellValue("Scrap2 Quantity");

			cell = row.createCell(13);
			row.getCell(13).setCellStyle(style);
			cell.setCellValue("Scrap3 Quantity");

			int i = 1;
			int j = 1;
			for (ProductionPipeScrapModel m : scrapList) {
				row = realSheet.createRow(i++);

				cell = row.createCell(0);
				cell.setCellValue(j++);

				cell = row.createCell(1);
				cell.setCellValue(m.gettMotherCoilBatch());

				cell = row.createCell(2);
				cell.setCellValue(m.gettMotherCoilThickness());

				cell = row.createCell(3);
				cell.setCellValue(m.gettPipeSlitBatch());

				cell = row.createCell(4);
				cell.setCellValue(m.getSlitSubGroup());

				cell = row.createCell(5);
				cell.setCellValue(m.gettPipeSlitWidth());

				cell = row.createCell(6);
				cell.setCellValue(m.gettPipeSlitQty());

				cell = row.createCell(7);
				cell.setCellValue(m.gettPipeSize());

				cell = row.createCell(8);
				cell.setCellValue(m.getScrapWt1());

				cell = row.createCell(9);
				cell.setCellValue(m.getScrapWt2());

				cell = row.createCell(10);
				cell.setCellValue(m.getScrapWt3());

				cell = row.createCell(11);
				cell.setCellValue(m.getScrapQty1());

				cell = row.createCell(12);
				cell.setCellValue(m.getScrapQty2());

				cell = row.createCell(13);
				cell.setCellValue(m.getScrapQty3());

			}
			logger.info("Method : buildExcelDocument ends");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
