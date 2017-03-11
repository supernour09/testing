package database;
import ui.Main;
import user.Account;
import user.Student;
import user.Teacher;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DBStudentTest {

	static DBStudent test = new DBStudent() {
	};
	@DataProvider(name = "test1")
	public static Object[][] usertest(){

	  	Account account = new Account("test1", "passtest1", "theTest1", "email@test1", 10, "male");
        Student student = new Student();
        student.setAccount(account);
        
		return new Object[][] {{1,student} ,{1,student} };

	}
	
	@Test(dataProvider = "test1")
  public void addStudent(int cnt, Student tmp ) {
		test.addStudent(tmp);
		Assert.assertEquals(cnt , test.getStudents().size()   );
  }
	
	
	@DataProvider(name = "test2")
	public static Object[][] Virfy(){

	  	Account account = new Account("test2", "passtest2", "theTest2", "email@test2", 10, "female");
        Student student = new Student();
        student.setAccount(account);
        test.addStudent(student);
		return new Object[][] {{true,"test2" ,"passtest2"} ,{true,"test1","passtest1"},
		{false,"test2" ,"passtest2ddd"} ,{false,"test2dds","passtest2"},
		{false,"test2sf" ,"passtest2ss"} 
		};

	}
	
	@Test(dataProvider = "test2")
	  public void verify(boolean res ,String us , String pas) {
	         Assert.assertEquals( res , test.verify(us, pas) );
	  }
	
}
