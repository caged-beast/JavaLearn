package java_test;


public class UserService {
    public String login(String name, String password) {
        if (name.equals("admin") && password.equals("123456"))
            return "登录成功";
        else
            return "登录失败";
    }
    public void selectEmp(){
//        System.out.println(10/0);
        System.out.println("输出所有人信息");
    }
}
