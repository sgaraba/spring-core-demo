package md.utm2026.p3.service;


import md.utm2026.p3.service.dto.UserCreatEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class TestProdService implements ITestService {
    @Override
    public void test(String name) {
        System.err.println("Hello World! ProdTestService" + name);
    }

    @EventListener
    public void on(UserCreatEvent event){
        System.err.println("TestProdService recive UserCreatEvent : " + event);
    }
}
