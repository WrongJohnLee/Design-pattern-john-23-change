package cn.guoguo.design;

import cn.guoguo.design.策略模式.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testPattern() {
		Random random = new Random();
		for (int j = 0;j < 10; j++) {
			Employee employee = new Employee(random.nextInt(3));
			for (int i = 0; i < 10; i++) {
				employee.work(random.nextInt(5));
				employee.doSomething();
			}
		}
	}

}
