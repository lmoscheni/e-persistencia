package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;

public class HomeUser {

	protected TableConnector bd;

	public HomeUser(){
		this.bd = new TableConnector();
	}
	
	protected boolean userExist(String userName) throws Exception{
		boolean ret = false;
		Connection connection = this.bd.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE UserName=?");
		statement.setString(1, userName);
		ResultSet resultSet = statement.executeQuery();
		ret = resultSet.next();
		connection.close();
		return ret;
	}
	
	protected void save(String userName,String name,String surname,String email,String birth,String password) throws Exception{
		Connection connection = new TableConnector().getConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (Name,UserName,Surname,Email,Password,Birth) VALUES (?,?,?,?,?,?)");

		statement.setString(1, name);
		statement.setString(2, userName);
		statement.setString(3, surname);
		statement.setString(4, email);
		statement.setString(5, password);
		statement.setString(6, birth);
		
		int registrosModificados = statement.executeUpdate();
		System.out.println("Lineas Modificadas" + registrosModificados);
		connection.close();
	}
	
	public boolean isSamePassword(String userName, String password) throws Exception{
		Connection connection = new TableConnector().getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT UserName,Password FROM Users WHERE UserName=? AND Password=?");
		statement.setString(1,userName);
		statement.setString(2,password);
		ResultSet res = statement.executeQuery();
		String user = null;
		String passwordd = null;
		while(res.next()){
			user = res.getString("UserName");
			passwordd = res.getString("Password");
		}
		if (user.equals(userName) && passwordd.equals(password)){
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}
	
	public void changeUserPassword(String userName, String password) throws Exception{
		Connection connection = new TableConnector().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE Users SET Password=? WHERE UserName=?");
		statement.setString(1, password);
		statement.setString(2, userName);
		statement.executeUpdate();
		connection.close();
	}
	
	boolean isSameCode(String userName, String code) throws Exception{
		boolean ret = false;
		Connection connection = new TableConnector().getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT UserName,Code FROM Users WHERE UserName=? AND Code=?");
		statement.setString(1,userName);
		statement.setString(2,code);
		ResultSet res = statement.executeQuery();
		String user = null;
		String codee = null;
		while(res.next()){
			user = res.getString("UserName");
			codee = res.getString("Code");
		}
		if (user.equals(userName) && codee.equals(code)){
			ret = true;
		}
		connection.close();
		return ret;
	}
}
