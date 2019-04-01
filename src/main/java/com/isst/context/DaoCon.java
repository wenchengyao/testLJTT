package com.isst.context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.oracle.OracleDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.isst.Application;

/**
 * 备份数据库数据
 * 
 * @throws Exception
 * @author ygg
 */
public class DaoCon extends Base{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource datasource;
	
	/**
	 * 备份数据库
	 * 
	 * @author ygg
	 * @throws Exception
	 */
	public void back() throws DatabaseUnitException, SQLException, IOException {
		//获取所有表名字
		List<String> mmd = jdbcTemplate.query(dballtablename, new ResultSetExtractor<List<String>>() {
			@Override
			public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<String> list = new ArrayList<String>();
				while (rs.next()) {
					list.add((String) rs.getObject(1));
				}
				return list;
			}
		});
		
		IDatabaseConnection c = new DatabaseConnection(datasource.getConnection());
		DatabaseConfig config = c.getConfig();
		if (dbdrivername.equals("oracle.jdbc.driver.OracleDriver")) {
			config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
		} else {
			config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
		}

		// 根据表名导出数据，并建立一个xml文件
		if (dbback) {
			for (String tableName : mmd) {// System.out.println(tableName);
				QueryDataSet backupDataSet = new QueryDataSet(c);
				backupDataSet.addTable(tableName);
				FileOutputStream fos = null;
				File file;
				file = new File(docpath + tableName + ".xml");
				fos = new FileOutputStream(file);
				FlatXmlDataSet.write(backupDataSet, fos);
				fos.close();
			}
		}
	}
		
	/**
	 * 指定数据源恢复表数据
	 * 
	 * @param tablenames
	 *            ：要恢复的表名
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 * @throws DatabaseUnitException
	 * @throws Exception
	 */
	public void recoverdatatable(String tablenames[]) throws Exception {
		IDatabaseConnection c = new DatabaseConnection(datasource.getConnection());
		//"set @@session.foreign_key_checks = 0"
		DatabaseConfig config = c.getConfig();
		if (dbdrivername.equals("oracle.jdbc.driver.OracleDriver")) {
			config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
		} else {
			config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
		}
		
//		config.setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);
		for (String tablename : tablenames) {
			if (dbdrivername.equals("oracle.jdbc.driver.OracleDriver")) {
				tablename = tablename.toUpperCase();
			}
			// Since release 2.4.7 we use a builder:
			FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
			builder.setColumnSensing(true);
			IDataSet backupData = builder.build(new File(docpath + tablename + ".xml"));
			DatabaseOperation.CLEAN_INSERT.execute(c, backupData);
		}
		c.close();
	}
	
	/***
	 * 指定数据源插入初始数据
	 * 
	 * @param tablenames
	 * @throws Exception
	 * @see [类、类#方法、类#成员]
	 */
	public void insertdatatable(String tablenames[]) throws Exception {
		ClassLoader classd = Application.class.getClassLoader();
		IDatabaseConnection c = new DatabaseConnection(jdbcTemplate.getDataSource().getConnection());
		DatabaseConfig config = c.getConfig();
		if (dbdrivername.equals("oracle.jdbc.driver.OracleDriver")) {
			config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
		} else {
			config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
		}
		Statement stmt = c.getConnection().createStatement();
		try {
			if (tablenames.length > 0) {
				for (int i = 0; i < tablenames.length; i++) {
					String tablename = tablenames[i];
					InputStream is = classd.getResourceAsStream("sqls/" + tablename + ".sql");
					InputStreamReader isr = new InputStreamReader(is, "UTF-8");
					BufferedReader br = new BufferedReader(isr);
					String line;
					while ((line = br.readLine()) != null) {
						// if oracle specified, timestamp string will be converted to 'to_date()'
						if (dbdrivername.equals("oracle.jdbc.driver.OracleDriver")) {
							line = sqlswitchtooracle(line);
						}
						stmt.execute(line);
					}
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
					c.close();
				} catch (SQLException e) {
					
				}
			}
		}
	}
	
	/**
	 * mysql数据库sql语句转换为oracle可以执行sql
	 */
	public static String sqlswitchtooracle(String sql) {
		String[] s = sql.split("'");
		StringBuffer sb = new StringBuffer();
		for (String str1 : s) {
			if (s.length > 1) {
				if (str1.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
					str1 = "to_date('" + str1 + "','yyyy-mm-dd hh24-mi-ss')";
				} else {
					str1 = str1 + "'";
				}
			}
			sb.append(str1);

		}
		String str1 = sb.toString().replaceAll("\'to_date", "to_date");
		if (!sql.substring(sql.length() - 1).equals("'") && s.length > 1) {
			str1 = str1.substring(0, str1.length() - 1);
		}
		return str1;
	}
}
