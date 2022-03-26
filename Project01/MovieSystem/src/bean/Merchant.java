package bean;

public class Merchant extends User{
    private String shopName;
    private String shopAddr;

    public Merchant() {
    }

    public Merchant(String logName, String password, String realName, char sex, String phone, double balance, String shopName, String shopAddr) {
        super(logName, password, realName, sex, phone, balance);
        this.shopName = shopName;
        this.shopAddr = shopAddr;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddr() {
        return shopAddr;
    }

    public void setShopAddr(String shopAddr) {
        this.shopAddr = shopAddr;
    }
}
