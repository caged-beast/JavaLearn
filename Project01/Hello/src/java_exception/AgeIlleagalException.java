package java_exception;
//自定义异常对象
public class AgeIlleagalException extends RuntimeException{
    public AgeIlleagalException() {
    }

    public AgeIlleagalException(String message) {
        super(message);
    }
}
