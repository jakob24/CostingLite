/**
 * 
 */
package com.artisans.inventory.service.api;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * @author bjacob
 *
 */
public interface ReportsService {

	
	/**
	 * Method to generate the Jasper Print
	 * @param jasperReport
	 * @param parameterMap
	 * @return
	 * @throws SQLException
	 * @throws JRException
	 * @throws IOException
	 */
	public JasperPrint generateJasperPrint(InputStream jasperFile, Map<String, Object> parameterMap) 
			throws SQLException, JRException, IOException ;	
}
