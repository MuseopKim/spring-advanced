package hello.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    // 1.
    @Pointcut("execution(* hello.aop.order..*(..))")
    public void allOrder() {   // pointcut signature
    }

    // 2. class pattern - *Service
    @Pointcut("execution(* *..*Service.*(..))")
    public void allService() {
    }

    // 1 && 2
    @Pointcut("allOrder() && allService()")
    public void orderAndService() {

    }
}
