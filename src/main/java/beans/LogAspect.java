package beans;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
/**
 * ��Ϊ����?��spring��һ��Ϊ��װ����չҵ���һ������,
 * ͨ����ʹ��@Aspectע���������.
 * ��Ϊ֪ͨ?Spring���������ڶ�����չҵ������Ǹ�����,
 * ����:
 * @Before         ǰ��֪ͨ
 * @AfterReturning ����֪ͨ
 * @AfterThrowing  �쳣֪ͨ
 * @After          ����֪ͨ
 * @Around         ����֪ͨ(��ѧ)
 * ��Ϊ�����?ֲ����չҵ���һ��λ�õ�(���Լ����
 * ΪҪֲ����չҵ�����Щ�����ļ���).ͨ������ʹ��
 * @Pointcut���ж���
 * ��Ϊ���ӵ�?һ��ָ������е�ĳ������,ͨ������
 * ����չҵ�񷽷�������ʹ��JoinPoint���ͽ��ж���
 * */
@Order(2)
@Aspect
@Service
public class LogAspect {
	/**ͨ��@Pointcutע�ⶨ�������,֪ͨ�ϾͿ���ֱ��
	 * ʹ�÷�������Ϊ�����*/
	@Pointcut("bean(teamServiceImpl)")
	public void method(){}
	@Before("method()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=
		joinPoint.getSignature().getName();
		System.out.println("@Before..."+methodName);
	}
	@AfterThrowing("method()")
	public void throwMethod(){
		System.out.println("@AfterThrowing...");
	}
	@AfterReturning("bean(teamServiceImpl)")
	public void returnMethod(){
		System.out.println("@AfterReturning....");
	}
	@After("bean(teamServiceImpl)")
	public void afterMethod(){
		System.out.println("@After...");
	}
}
/**
 * try{
 *    @Before
 *    ����ҵ��
 *    @AfterReturn 
 * }catch(Exception e){
 *    @AfterThrowing
 * }finally{
 *    @After
 * }
 */








