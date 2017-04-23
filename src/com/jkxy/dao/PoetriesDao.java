package com.jkxy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.jkxy.entity.Poetries;
import com.jkxy.entity.Poets;

/**
 * @author 诗歌查询接口
 */
public interface PoetriesDao {
	public List titleSearchList(Connection conn,String title) throws SQLException;
	public Poetries titleSearch(Connection conn,String title,Integer id) throws SQLException;
	public List authorList(Connection conn,Integer id,String name) throws SQLException;
	public Poetries bodySearch(Connection conn,String body) throws SQLException;
}
