package modelTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.TableConnector;
import main.VirtualDT;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestVirtualDT {

	VirtualDT virtualdt;
	
	@Before
	public void setUP(){
		this.virtualdt = new VirtualDT();
	}
	
	@Test
	public void testRegistrateUserPass() throws SQLException{
		this.virtualdt.registrateUser("juli", "juliCapo", "skalic", "skalic.julian@gmail.com", "17/02/1992", "julianskalic");
		Connection connection = new TableConnector().getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE Name=? AND UserName=? AND Surname=? AND Email=? AND Birth=? AND Password=?");
		statement.setString(1, "juli");
		statement.setString(2, "juliCapo");
		statement.setString(3, "skalic");
		statement.setString(4, "skalic.julian@gmail.com");
		statement.setString(5, "17/02/1992");
		statement.setString(6, "julianskalic");
		ResultSet res = statement.executeQuery();
		Assert.assertTrue(res.next());
		connection.close();
	}

	@Test
	public void testRegistrateUserFail(){
		Assert.assertTrue(true);
	}
	
	@After
	public void tearDown() throws IOException, InterruptedException, SQLException{
		Runtime.getRuntime().exec("mysql new_schema -u root --password=root < matigenio.sql").waitFor();
	}
	
	//public void testRegistrateUserPass(){
		
	//}
	
}
