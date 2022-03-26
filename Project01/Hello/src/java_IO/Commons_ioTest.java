package java_IO;
//使用commons-io的API
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Commons_ioTest {
    public static void main(String[] args) throws IOException {
//        FileUtils.copyFile(new File("Hello/ps.txt"),new File("F:/test/ps.txt"));
        //JAVA官方也开发了java.nio.file来处理IO
        Files.copy(Path.of("Hello/ps.txt"),Path.of("F:/test/ps.txt"));
    }
}
