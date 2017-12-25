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
 * 何为切面?在spring中一般为封装了扩展业务的一个对象,
 * 通常会使用@Aspect注解进行修饰.
 * 何为通知?Spring切面中用于定义扩展业务步骤的那个对象,
 * 例如:
 * @Before         前置通知
 * @AfterReturning 返回通知
 * @AfterThrowing  异常通知
 * @After          最终通知
 * @Around         环绕通知(自学)
 * 何为切入点?植入扩展业务的一个位置点(可以简单理解
 * 为要植入扩展业务的那些方法的集合).通常可以使用
 * @Pointcut进行定义
 * 何为连接点?一般指切入点中的某个方法,通常可以
 * 在扩展业务方法参数中使用JoinPoint类型进行定义
 * */
@Order(2)
@Aspect
@Service
public class LogAspect {
	/**通过@Pointcut注解定义切入点,通知上就可以直接
	 * 使用方法名作为切入点*/
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
 *    核心业务
 *    @AfterReturn 
 * }catch(Exception e){
 *    @AfterThrowing
 * }finally{
 *    @After
 * }
 */








