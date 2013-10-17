package modelTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.Assert;
import main.AllAgainstAll;
import main.TableConnector;
import main.Tournament;
import main.VirtualDT;
import main.servicios.ConsultTournament;
import main.servicios.CreateTournament;
import main.servicios.DeleteTournament;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTournament {

	protected Tournament tournament;
	
	@Before
	public void setUp(){
		this.tournament = new AllAgainstAll("Torneo de verano");
	}
	
	@Test
	public void testSaveTournament() throws SQLException{
		main.DAOS.SessionManager.runInSession(new CreateTournament(this.tournament));
		Tournament tournamentQuerySQL = main.DAOS.SessionManager.runInSession(new ConsultTournament("Torneo de verano"));
		Assert.assertEquals(tournamentQuerySQL.getNameTournament(), "Torneo de verano");
	}
	
	@Test
	public void testDeleteTournament(){
		main.DAOS.SessionManager.runInSession(new CreateTournament(this.tournament));
		main.DAOS.SessionManager.runInSession(new DeleteTournament("Torneo de verano"));
		try{
		main.DAOS.SessionManager.runInSession(new ConsultTournament("Torneo de verano"));
		Assert.assertFalse(false);
		}catch(Exception e){
			Assert.assertTrue(true);
		}
	}
	
	@After
	public void tearDown() throws IOException, InterruptedException, SQLException{
		Runtime.getRuntime().exec("mysql new_schema -u root --password=root > matigenio.sql").waitFor();
	}
}
