package jiezhang.console;

import jiezhang.console.controller.TestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = TestController.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestTemp {
    @Autowired
    private TestController testController;

    @Test
    public void test1() {
//        testController.test();
    }
}
