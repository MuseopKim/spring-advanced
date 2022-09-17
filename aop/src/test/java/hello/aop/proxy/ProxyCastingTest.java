package hello.aop.proxy;

import hello.aop.member.MemberService;
import hello.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

@Slf4j
public class ProxyCastingTest {

    @Test
    void JDKProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(false);    // JDK Dynamic Proxy

        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();

        // Impossible to JDK Dynamic Proxy to cast type into concrete class
        MemberServiceImpl castingMemberService = (MemberServiceImpl) memberServiceProxy;
    }

    @Test
    void CGLibProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true);    // CGLIB

        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();

        // Possible to CGLIB proxy to cast type into concrete class
        MemberServiceImpl castingMemberService = (MemberServiceImpl) memberServiceProxy;
    }
}
