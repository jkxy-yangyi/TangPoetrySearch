package com.jkxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jkxy.dao.PoetsDao;
import com.jkxy.entity.Poets;

public class PoetsDaoImpl implements PoetsDao{
	/**
     * 根据作者ID查询作者
     * @param id
     * @return Poets实体
     */
	@Override
	public Poets poet(Connection conn, Integer id) throws SQLException {
		PreparedStatement ps = conn
				.prepareCall("select * from poets where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			Poets poets = setPoetry(rs);
			return poets;
		}
		else{
			return null;
		}
	}

	/**
	 * 根据作者姓名查询作者所有诗歌名称
	 * @param author
	 * @return List集合
	 */
	@Override
	public List poetAuthor(Connection conn, String author) throws SQLException {
		PreparedStatement ps = conn
				.prepareCall("select * from poets where name=?");
		ps.setString(1, author);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			Poets poets = setPoetry(rs);
			List list = new PoetriesDaoImpl().authorList(conn, poets.getId(), poets.getName());
			return list;
		}else {
			return null;
		}
	}

	private Poets setPoetry(ResultSet rs) throws SQLException {
		Poets poets = new Poets();
		poets.setId(rs.getInt(1));
		poets.setName(rs.getString(2));
		poets.setCreated_at(rs.getDate(3));
		poets.setUpdated_at(rs.getDate(4));
		return poets;
	}
}
