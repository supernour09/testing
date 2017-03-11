package game;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TemplateTest {
	
	static Template tmp = new Template();
	
  @DataProvider(name = "test")
  public static Object[][] numbers()
  {
	  ArrayList<String> question1 = new ArrayList<>(3);
	  question1.add("what is your name?");
	  question1.add("Mazen,Nour,Ahmed,Mahmoud");
	  question1.add("Mazen");
	  
	  tmp.addQuestion("what is your name?", "Mazen,Nour,Ahmed,Mahmoud", "Mazen");
	  
	  ArrayList<String> question2 = new ArrayList<>(3);
	  question2.add("what is your age?");
	  question2.add("22,21,25,20");
	  question2.add("20");
	  
	  tmp.addQuestion("what is your age?", "22,21,25,20", "20");
	  
	  ArrayList<String> question3 = new ArrayList<>(3);
	  question3.add("what is your grade?");
	  question3.add("X,Y,Z,F");
	  question3.add("A");
	  
	  
	  return new Object[][]{ {true,question1,0}
							,{true,question2,1}
							,{false,question3,5} };
  }

  @Test(dataProvider = "test")
  public void getQuestion(boolean ret , ArrayList<String> question,int indx) {
	  Assert.assertEquals(ret, tmp.getQuestion(indx).get(0).equals( question.get(0)   ));
  }
}
