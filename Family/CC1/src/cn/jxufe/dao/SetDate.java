package cn.jxufe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.jxufe.test.Family;
import cn.jxufe.test.People;

public class SetDate {
	private Statement statement;
	private DataBase db = new DataBase();
	public void addData(Family family){
		
		try {
			statement = db.getCon().createStatement();
			String sql3 = "insert into people(people,son) values('123','321')";
			statement.addBatch(sql3);
			statement.executeBatch();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public Family queryData(People people){
		Family family = new Family();
		try {
			String sql = "select * from people where people='"+people.getName()+"'";
			ResultSet resultSet  = statement.executeQuery(sql);
			while (resultSet.next()) {
				family.setSon(new People(resultSet.getString("son")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.print(family.getSon().get(0).getName());
		return family;
	}
}
