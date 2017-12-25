package service.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.TeamService;


public class TestTeamService {
	private ClassPathXmlApplicationContext ctx;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext(
		"applicationContext.xml");
	}
	@Test
	public void testSaveObject(){
		//1.获得bean对象
		TeamService teamService=(TeamService)
		//获取的这个对象为一个代理对象
		ctx.getBean("teamServiceImpl",
				TeamService.class);
		//2.执行bean对象相关业务
		//底层通过代理对象执行具体业务
		teamService.saveObject(null);
	}
	@After
	public void destroy(){
		ctx.close();
	}
	
}







