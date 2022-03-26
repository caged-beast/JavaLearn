package java_IO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

//使用ObjectInputStream实现对象的反序列化
public class ObjectInputStreamTest {
    public static void main(String[] args) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Hello/obj.txt"));
        Object o = ois.readObject();
        System.out.println(o);
        ois.close();
    }
}
