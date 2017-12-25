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
		//1.���bean����
		TeamService teamService=(TeamService)
		//��ȡ���������Ϊһ���������
		ctx.getBean("teamServiceImpl",
				TeamService.class);
		//2.ִ��bean�������ҵ��
		//�ײ�ͨ���������ִ�о���ҵ��
		teamService.saveObject(null);
	}
	@After
	public void destroy(){
		ctx.close();
	}
	
}







