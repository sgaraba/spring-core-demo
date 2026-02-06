package md.utm2026.p3.service;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class TestDevService implements ITestService {
    @Override
    public void test(String name) {
        System.err.println("Hello World! DevTestService " + name);
    }
}
