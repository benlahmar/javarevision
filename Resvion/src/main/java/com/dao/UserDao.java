package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;
import com.util.DBInteraction;

public class UserDao {

	public int inscription(String nom, String log, String pass)
	{
		DBInteraction.connect();
		String sql="insert into user values(null,'"+nom+"','"+log+"','"+pass+"')";
		int nb = DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}
	
	
	public int inscription(User u)
	{
		DBInteraction.connect();
		String sql="insert into user values(null,'"+u.getNom()+"','"+u.getLog()+"','"+u.getPass()+"')";
		int nb = DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}
	
	public User authentification(String log, String pass)
	{
		User u=null;
		DBInteraction.connect();
		String sql="select * from user where log='"+log+"' and pass='"+pass+"'";
		ResultSet rs = DBInteraction.select(sql);
		try {
			if(rs.next())
			{
				u=new User(rs.getString("nom"), rs.getString("log"), rs.getString("pass"));
				u.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		return u;
	}
	
}
