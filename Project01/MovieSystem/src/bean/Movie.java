package bean;

import java.util.Date;

public class Movie {
    private String name;
    private String star;//主演
    private double score;
    private String time;//时长
    private double price;
    private int remains;//余票
    private Date date;//上映时间

    public Movie() {
    }

    public Movie(String name, String star, double score, String time, double price, int remains, Date date) {
        this.name = name;
        this.star = star;
        this.score = score;
        this.time = time;
        this.price = price;
        this.remains = remains;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String  getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRemains() {
        return remains;
    }

    public void setRemains(int remains) {
        this.remains = remains;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
