package com.jkxy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.jkxy.entity.Poetries;
import com.jkxy.entity.Poets;

/**
 * @author 作者查询接口
 */
public interface PoetsDao {
	public Poets poet(Connection conn,Integer id) throws SQLException;
	public List poetAuthor(Connection conn,String author) throws SQLException;
}
