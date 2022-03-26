package run;

import bean.Customer;
import bean.Merchant;
import bean.Movie;
import bean.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SystemStart {
    public static final List<User> ALL_USER = new ArrayList<>();//用户信息
    public static final Map<Merchant, List<Movie>> ALL_MOVIE = new HashMap<>();//影片信息
    public static final Scanner SYS_SC = new Scanner(System.in);//读取键盘输入
    public static User curUser = new User();//当前登录的用户
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static {//初始化静态数据
        Customer c1 = new Customer("CagedBeast", "123456", "chw", 'm', "18379964087", 2000.0);
        Customer c2 = new Customer("Aurora", "123456", "zjq", 'f', "13527507615", 2000.0);
        Merchant m1 = new Merchant("merchant1", "123123", "CHW", 'm', "10086", 20000.0, "飞扬影城", "正佳广场");
        Merchant m2 = new Merchant("merchant2", "123123", "ZJQ", 'f', "10085", 20000.0, "天河电影城", "天娱广场");
        ALL_USER.add(c1);
        ALL_USER.add(c2);
        ALL_USER.add(m1);
        ALL_USER.add(m2);
        ALL_MOVIE.put(m1, new ArrayList<>());
        ALL_MOVIE.put(m2, new ArrayList<>());
    }

    public static void main(String[] args) {
        showMenu();

    }

    private static void showMenu() {
        while (true) {
            System.out.println("------------困兽电影系统-------------");
            System.out.println("1.用户登录");
            System.out.println("2.商家入驻");
            System.out.println("3.用户注册");
            System.out.println("4.退出");
            System.out.println("\n请选择您要进行的操作:");
            String sel = SYS_SC.nextLine();
            switch (sel) {
                case "1":
                    showLoginMenu();
                    break;
                case "2":

                    break;
                case "3":
                    break;
                case "4":
                    System.out.println("欢迎下次使用!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误，请重新输入!");
            }
        }
    }

    private static void showLoginMenu() {
        while (true) {
            System.out.println("------------困兽电影系统登录界面-------------");
            System.out.println("请输入您的账户名");
            String name = SYS_SC.nextLine();
            System.out.println("请输入您的密码");
            String password = SYS_SC.nextLine();
            User user = getUserByName(name);
            if (user != null) {//存在该用户
                if (user.getPassword().equals(password)) {
                    curUser = user;
                    if (user instanceof Customer) {
                        showCustomerMenu();
                        return;//返回主菜单
                    } else {
                        showMerchantMenu();
                        return;//返回主菜单
                    }
                } else {
                    System.out.println("密码错误!");
                }
            } else {
                System.out.println("该用户不存在，请先注册!");
            }
        }
    }

    private static User getUserByName(String name) {
        for (User u : ALL_USER) {     //遍历用户信息检查该用户是否存在
            if (u.getLogName().equals(name))
                return u;
        }
        return null;
    }

    private static void showMerchantMenu() {
        while (true) {
            System.out.println("------------困兽电影系统商家界面-------------");
            System.out.println("尊敬的" + curUser.getRealName() +
                    (curUser.getSex() == 'm' ? "先生" : "女士") + ",欢迎登录困兽电影系统!");
            System.out.println("1.展示影院信息");
            System.out.println("2.上架电影");
            System.out.println("3.下架电影");
            System.out.println("4.修改电影");
            System.out.println("5.退出");
            System.out.println("\n请选择您要进行的操作:");
            String sel = SYS_SC.nextLine();
            switch (sel) {
                case "1":
                    showCinemaInfo();
                    break;
                case "2":
                    addMovie();
                    break;
                case "3":
                    deleteMovie();
                    break;
                case "4":
                    updateMovie();
                    break;
                case "5":
                    System.out.println("欢迎下次使用!");
                    return;
                default:
                    System.out.println("输入有误，请重新输入!");
            }
        }
    }

    private static void updateMovie() {
        System.out.println("--------------修改影片-----------------");
        Merchant m = (Merchant) curUser;
        List<Movie> movies = ALL_MOVIE.get(m);
        System.out.println("请输入要修改的影片的名称:");
        String name = SYS_SC.nextLine();
        Movie movie = getMovieByName(name);
        if (movie != null) {
            System.out.println("请输入修改后的影片的名称:");
            String movieName = SYS_SC.nextLine();
            System.out.println("请输入修改后的影片的主演:");
            String star = SYS_SC.nextLine();
            System.out.println("请输入修改后的影片的评分:");
            double score = Double.valueOf(SYS_SC.nextLine());
            System.out.println("请输入要添加的影片的时长:");
            String time = SYS_SC.nextLine();
            System.out.println("请输入修改后的影片的票价:");
            double price = Double.valueOf(SYS_SC.nextLine());
            System.out.println("请输入修改后的影片的余票:");
            int remains = Integer.valueOf(SYS_SC.nextLine());
            Date date = null;
            while (date == null) {
                try {
                    System.out.println("请输入修改后的影片的上映时间:(如2022-02-02 22:22:22)");
                    date = sdf.parse(SYS_SC.nextLine());
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("输入的日期格式有误!");
                }
            }
            ALL_MOVIE.get(curUser).remove(movie);
            ALL_MOVIE.get(curUser).add(new Movie(name, star, score, time, price, remains, date));
            System.out.println("已成功修改影片《" + movie.getName() + "》相关信息");
        } else {
            System.out.println("您的影院尚未上架该影片!");
        }
    }

    private static void deleteMovie() {
        System.out.println("--------------下架影片-----------------");
        Merchant m = (Merchant) curUser;
        List<Movie> movies = ALL_MOVIE.get(m);
        System.out.println("请输入要删除的影片的名称:");
        String name = SYS_SC.nextLine();
        Movie movie = getMovieByName(name);
        if (movie != null) {
            ALL_MOVIE.get(curUser).remove(movie);
            System.out.println("已成功删除影片《" + movie.getName() + "》");
        } else {
            System.out.println("您的影院尚未上架该影片!");
        }
    }

    private static Movie getMovieByName(String name) {
        Merchant m = (Merchant) curUser;
        List<Movie> movies = ALL_MOVIE.get(m);
        for (Movie movie : movies) {
            if (movie.getName().contains(name)) {
                System.out.println("请问你要操作的电影是叫《" + movie.getName() + "》吗? Y/N");
                String ans = SYS_SC.nextLine();
                if (ans.equals("Y"))
                    return movie;
            }
        }
        return null;
    }

    private static void addMovie() {
        System.out.println("------------上架电影-------------------");
        Merchant m = (Merchant) curUser;
        List<Movie> movies = ALL_MOVIE.get(m);
        System.out.println("请输入要添加的影片的名称:");
        String name = SYS_SC.nextLine();
        System.out.println("请输入要添加的影片的主演:");
        String star = SYS_SC.nextLine();
        System.out.println("请输入要添加的影片的评分:");
        double score = Double.valueOf(SYS_SC.nextLine());
        System.out.println("请输入要添加的影片的时长:");
        String time = SYS_SC.nextLine();
        System.out.println("请输入要添加的影片的票价:");
        double price = Double.valueOf(SYS_SC.nextLine());
        System.out.println("请输入要添加的影片的余票:");
        int remains = Integer.valueOf(SYS_SC.nextLine());
        Date date = null;
        while (date == null) {
            try {
                System.out.println("请输入要添加的影片的上映时间:(如2022-02-02 22:22:22)");
                date = sdf.parse(SYS_SC.nextLine());
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("输入的日期格式有误!");
            }
        }
        ALL_MOVIE.get(m).add(new Movie(name, star, score, time, price, remains, date));
        System.out.println("影片《" + name + "》添加成功");
    }

    private static void showCinemaInfo() {
        System.out.println("-----------------影院信息-------------------");
        Merchant m = (Merchant) curUser;
        System.out.println(m.getShopName() + "\t\t电话:" + m.getPhone() + "\t\t地址:"
                + m.getShopAddr() + "\t\t余额:" + m.getBalance());
        List<Movie> movies = ALL_MOVIE.get(m);
        System.out.println();
        if (movies.size() > 0) {
            System.out.println("名称\t\t主演\t\t评分\t\t时长\t\t票价\t\t余票\t\t上映时间");
            for (Movie movie : movies) {
                System.out.println(movie.getName() + "\t\t" + movie.getStar() + "\t\t" + movie.getScore()
                        + "\t\t" + movie.getTime() + "\t\t" + movie.getPrice() + "\t\t" + movie.getRemains()
                        + "\t\t" + movie.getDate());
            }
        } else
            System.out.println("当前影院没有正在上映的电影!");
    }

    private static void showCustomerMenu() {
        while (true) {
            System.out.println("------------困兽电影系统用户界面-------------");
            System.out.println("尊敬的" + curUser.getRealName() +
                    (curUser.getSex() == 'm' ? "先生" : "女士") + ",欢迎登录困兽电影系统!");
            System.out.println("1.展示全部影片信息");
            System.out.println("2.根据电影名称查询电影");
            System.out.println("3.评分");
            System.out.println("4.购票");
            System.out.println("5.退出");
            System.out.println("\n请选择您要进行的操作:");
            String sel = SYS_SC.nextLine();
            switch (sel) {
                case "1":
                    showAllMovies();
                    break;
                case "2":
                    lookForMovie();
                    break;
                case "3":
                    break;
                case "4":
                    buyTicket();
                    break;
                case "5":
                    System.out.println("欢迎下次使用!");
                    return;
                default:
                    System.out.println("输入有误，请重新输入!");
            }
        }
    }

    private static void buyTicket() {
        showAllMovies();
        System.out.println("请输入您要购买的影票所在影院的名称:");
        String shopName = SYS_SC.nextLine();

    }

    private static void lookForMovie() {
        System.out.println("-----------查找电影---------------");
        while (true) {
            System.out.println("请输入要查找的影片的名称:");
            String name = SYS_SC.nextLine();
            ALL_MOVIE.forEach(((merchant, movies) -> {
                for(Movie movie:movies){
                    if(movie.getName().contains(name)){
                        System.out.println(merchant.getShopName() + "\t\t电话:" + merchant.getPhone()
                                + "\t\t地址:" + merchant.getShopAddr());
                        System.out.println("\t\t\t名称\t\t主演\t\t评分\t\t时长\t\t票价\t\t余票\t\t上映时间");
                        System.out.println("\t\t\t" + movie.getName() + "\t\t" + movie.getStar() + "\t\t" + movie.getScore()
                                + "\t\t" + movie.getTime() + "\t\t" + movie.getPrice() + "\t\t" + movie.getRemains()
                                + "\t\t" + movie.getDate());
                        return;
                    }
                }
            }));
            System.out.println("未找到,是否继续查找? Y/N");
            String ans = SYS_SC.nextLine();
            if(ans.equals("N"))
                break;
        }
    }

    private static void showAllMovies() {
        System.out.println("--------------影片信息------------------");
        ALL_MOVIE.forEach(((merchant, movies) -> {
            System.out.println(merchant.getShopName() + "\t\t电话:" + merchant.getPhone()
                    + "\t\t地址:" + merchant.getShopAddr());
            System.out.println("\t\t\t名称\t\t主演\t\t评分\t\t时长\t\t票价\t\t余票\t\t上映时间");

            for (Movie movie : movies) {
                System.out.println("\t\t\t" + movie.getName() + "\t\t" + movie.getStar() + "\t\t" + movie.getScore()
                        + "\t\t" + movie.getTime() + "\t\t" + movie.getPrice() + "\t\t" + movie.getRemains()
                        + "\t\t" + movie.getDate());
            }
        }));
    }
}
