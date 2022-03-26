package java_logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    public static final Logger LOGGER = LoggerFactory.getLogger("Test.class");
    public static void main(String[] args) {
        try {
            LOGGER.debug("main方法开始执行");
            LOGGER.info("第二行：");
            int a = 10;
            int b = 0;
            LOGGER.trace("a="+a);
            LOGGER.trace("b="+b);
            System.out.println(a/b);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("功能异常,"+e);
        }
    }
}
