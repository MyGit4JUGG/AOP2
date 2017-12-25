package beans;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
@Order(1)
@Aspect
@Service
public class PermissionAspect {

	   @Before("execution(* beans.*.*(..))")
	   public void checkPermission(){
		   System.out.println("进行权限检测");
	   }
}
