/**
 * 
 */
package com.artisans.inventory.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.artisans.inventory.service.api.ReportsService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * @author bjacob
 *
 */
@Component(value="reportService")
@Transactional(readOnly=true)
public class ReportsServiceImpl implements ReportsService {

	 @Autowired
	 private DataSource dataSource;
	 
	/**
	 * Method to generate the Invoice report
	 * @param jasperReport
	 * @param parameterMap
	 * @return
	 * @throws SQLException
	 * @throws JRException
	 * @throws IOException
	 */
	public JasperPrint generateJasperPrint(String jasperFile, Map<String, Object> parameterMap) throws SQLException, JRException, IOException {
		JasperPrint print = JasperFillManager.fillReport(jasperFile, parameterMap, dataSource.getConnection());
		return print;		 
	}	
}
