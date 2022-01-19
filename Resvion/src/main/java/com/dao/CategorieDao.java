package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Categorie;
import com.model.Livre;
import com.util.DBInteraction;

public class CategorieDao {

	
	public int addcategorie(String libelle)
	{
		DBInteraction.connect();
		String sql="insert into catagorie values(null,'"+libelle+"')";
		int nb=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}
	
	
	public int addlivre(String titre, String auteur, int idcat)
	{
		DBInteraction.connect();
		String sql="insert into livre values(null,'"+titre+"','"+auteur+"',"+idcat+")";
		int nb=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}
	
	public List<Categorie> allcat()
	{
		List<Categorie> cats=new ArrayList<Categorie>();
		DBInteraction.connect();
		String sql="select * from categorie";
		ResultSet rs = DBInteraction.select(sql);
		try {
			while(rs.next())
			{
				Categorie c=new Categorie();
				c.setId(rs.getInt("id"));
				c.setLibelle(rs.getString("libelle"));
				cats.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		return cats;
	}
	
	public List<Livre> livres(int idcat)
	{
		List<Livre> books=new ArrayList<Livre>();
		DBInteraction.connect();
		String sql="select * from livre where idcat="+idcat;
		ResultSet rs = DBInteraction.select(sql);
		try {
			while(rs.next())
			{
				Livre c=new Livre();
				c.setId(rs.getInt(1));
				c.setTitre(rs.getString(2));
				c.setAuteur(rs.getString(3));
				books.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		return books;
	}
	
	
	public List<Livre> alllivres()
	{
		List<Livre> books=new ArrayList<Livre>();
		DBInteraction.connect();
		String sql="select * from livre ";
		ResultSet rs = DBInteraction.select(sql);
		try {
			while(rs.next())
			{
				Livre c=new Livre();
				c.setId(rs.getInt(1));
				c.setTitre(rs.getString(2));
				c.setAuteur(rs.getString(3));
				books.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		return books;
	}
}
