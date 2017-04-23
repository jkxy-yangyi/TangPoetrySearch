package com.jkxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jkxy.dao.PoetriesDao;
import com.jkxy.entity.Poetries;
import com.jkxy.entity.Poets;

public class PoetriesDaoImpl implements PoetriesDao{
	/**
	 * @param 标题查询诗歌
	 * @return List集合
	 */
	@Override
	public List titleSearchList(Connection conn, String title)
			throws SQLException {
		PreparedStatement ps = conn
				.prepareCall("select * from poetries where title=?");
        List poes = new ArrayList();
        ps.setString(1,title);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Poetries poe = setPoetries(rs);
			Poets poests = new PoetsDaoImpl().poet(conn, poe.getPoet_id());
			poe.setName(poests.getName());
			poes.add(poe);
		}
		return poes;
	}

	private Poetries setPoetries(ResultSet rs) throws SQLException {
		Poetries poe = new Poetries();
		poe.setId(rs.getInt(1));
		poe.setPoet_id(rs.getInt(2));
		poe.setContent(rs.getString(3));
		poe.setTitle(rs.getString(4));
		if (rs.getDate(5) != null)
			poe.setCreated_at(rs.getDate(5));
		if (rs.getDate(6) != null)
			poe.setUpdated_at(rs.getDate(6));
		return poe;
	}

	/**
	 * 标题和ID查询诗歌
	 * @param title
	 * @param id
	 * @return Poetries实体
	 */
	@Override
	public Poetries titleSearch(Connection conn, String title, Integer id)
			throws SQLException {
		PreparedStatement ps = conn
				.prepareCall("select * from poetries where poet_id=? and title=?");
		ps.setInt(1,id);
		ps.setString(2,title);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			Poetries poe = setPoetries(rs);
			return poe;
		}else {
			return null;
		}
	}

	/**
	 * 根据作者ID号查询所有的诗歌
	 * @param id
	 * @param name
	 * @return List集合
	 */
	@Override
	public List authorList(Connection conn, Integer id, String name)
			throws SQLException {
		PreparedStatement ps = conn
				.prepareCall("select * from poetries where poet_id=?");
		List poes = new ArrayList();
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Poetries poe = setPoetries(rs);
			poe.setName(name);
			poes.add(poe);
		}
		return poes;
	}

	/**
	 * 根据诗歌内容查询
	 * @param body
	 * @return Poetries实体
	 */
	@Override
	public Poetries bodySearch(Connection conn, String body)
			throws SQLException {
		PreparedStatement ps = conn
				.prepareCall("select * from poetries where content like '%" + body + "%' ");
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			Poetries poe = setPoetries(rs);
			return poe;
		}else {
			return null;
		}
	}

	
}
