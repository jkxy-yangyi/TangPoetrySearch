package com.jkxy.uitl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author 数据库连接类
 */
public class ConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	
	private static final ConnectionFactory factory = new ConnectionFactory();
	private Connection conn;
	
	static{
		Properties prop = new Properties();	//保存属性文件
		try {
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");	//读取属性中的内容
			prop.load(in);	//从输入流中读取属性列表
		} catch (Exception e) {
			System.out.println("配置文件读取错误");
		}
		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	
	private ConnectionFactory(){
		
	}
	
	public static ConnectionFactory getInstace(){
		return factory;
	}
	
	/*
	 * 获取数据库连接
	 */
	public Connection makeConnction(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
