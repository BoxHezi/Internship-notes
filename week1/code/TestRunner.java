import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;

public class TestRunner {

    public static void main (String[] args) {
        JunitTest01 test01 = new JunitTest01();
        Result result = JUnitCore.runClasses(test01.getClass());

        List<Failure> failures = result.getFailures();
        for (Failure failure : failures) {
            System.out.println("Failure: " + failure.toString());
        }

        // 根据源码，当失败数 == 0时，wasSuccessful（）返回true
        if (result.wasSuccessful()) {
            System.out.println("All Test Passed!");
        }
    }

}
