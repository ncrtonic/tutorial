package webtodo;

import org.junit.Assert;
import org.junit.Test;
import org.study.dao.UserDao;
import org.study.model.User;

public class Conn {
	
	@Test
	public void connTest() {
		UserDao dao = new UserDao();
		Assert.assertNotNull(dao.getConnection()); 
		
		
	}
	
	@Test
	public void userTest() {
		
		UserDao dao = new UserDao();
		User user = dao.confirmUser("song", "1111");
		
		Assert.assertNotNull(user);
		System.out.println(user.getUserid()+"-"+user.getPw()+"-"+user.getName());
	}

}
