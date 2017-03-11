package game;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import game.Field;
import game.Game;

public class FieldTest {
	static Field f=new Field();
	@DataProvider(name="test")
	public static Object[][] numbers(){
		String s1="game",s2="game",s3="NoName";
		Game G1=new Game();
		G1.setName(s1);
		Game G2=new Game();
		G2.setName(s2);
		f.addGame(G1);	// hase indx=0
		f.addGame(G2);	// hase indx=1
		return new Object[][] {{0,s1},{1,s2},{-1,s3}};
	}
	@Test(dataProvider="test")
  public void search(int ecpected,String name) {

		Assert.assertEquals(ecpected, f.search(name));
		Assert.assertEquals(ecpected, f.search(name));
		Assert.assertEquals(ecpected, f.search(name));
    //throw new RuntimeException("Test not implemented");
  }
}
