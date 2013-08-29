package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;

import Exceptions.SQLException;

public class HomeUser {

	protected TableConnector bd;

	public HomeUser(){
		this.bd = new TableConnector();
	}
	
	protected boolean userExist(String userName){
		boolean ret = false;
		try{
			Connection connection = this.bd.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE UserName=?");
			statement.setString(1, userName);
			ResultSet resultSet = statement.executeQuery();
			ret = resultSet.next();
			connection.close();
		}catch(Exception e){
			throw new SQLException(e);
		}
		return ret;
	}
	
	protected void save(String name,String userName,String surname,String email,String birth,String password, String code, boolean validation){
		try{
			Connection connection = new TableConnector().getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (Name,UserName,Surname,Email,Password,Birth,CodeValidation,Validation) VALUES (?,?,?,?,?,?,?,?)");
			statement.setString(1, name);
			statement.setString(2, userName);
			statement.setString(3, surname);
			statement.setString(4, email);
			statement.setString(5, password);
			statement.setString(6, birth);
			statement.setString(7, code);
			statement.setBoolean(8, validation);
			statement.executeUpdate();
			connection.close();
		}catch(Exception e){
			throw new SQLException(e);
		}
	}
	
	public boolean isSamePassword(String userName, String password){
		boolean ret = false;
		try{
			Connection connection = new TableConnector().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT UserName,Password FROM Users WHERE UserName=? AND Password=?");
			statement.setString(1,userName);
			statement.setString(2,password);
			ResultSet res = statement.executeQuery();
			String user;
			String passwordd;
			if(res.next()){
				user = res.getString("USerName");
				passwordd = res.getString("Password");
				if (user.equals(userName) && passwordd.equals(password)){
					ret = true;
				}
			}
			connection.close();
		}catch(Exception e){
			throw new SQLException(e);
		}
		return ret;
	}
	
	public void changeUserPassword(String userName, String password){
		try{
			Connection connection = new TableConnector().getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE Users SET Password=? WHERE UserName=?");
			statement.setString(1, password);
			statement.setString(2, userName);
			statement.executeUpdate();
			connection.close();
		}catch(Exception e){
			throw new SQLException(e);
		}
	}
	
	boolean isSameCode(String userName, String code){
		boolean ret = false;
		try{
			Connection connection = new TableConnector().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT UserName,CodeValidation FROM Users WHERE UserName=? AND CodeValidation=?");
			statement.setString(1,userName);
			statement.setString(2,code);
			ResultSet res = statement.executeQuery();
			ret = res.next();
			connection.close();
		}catch(Exception e){
			throw new SQLException(e);
		}
		return ret;
	}
	
	public void validate(String userName){
		try{
			Connection connection = new TableConnector().getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE Users SET Validation=? WHERE UserName=?");
			statement.setBoolean(1,true);
			statement.setString(2,userName);
			statement.executeUpdate();
			connection.close();
		}catch(Exception e){
			throw new SQLException(e);
		}
	}
}
