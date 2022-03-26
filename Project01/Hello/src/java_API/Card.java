package java_API;

public class Card implements Comparable {
    private String literal;//值
    private String color;//花色
    private int priority;//牌的大小,3的priority值最小,为1

    public Card() {
    }

    public Card(String literal, String color, int priority) {
        this.literal = literal;
        this.color = color;
        this.priority = priority;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return literal + color;
    }

    @Override
    public int compareTo(Object o) {
        return this.priority - ((Card) o).priority;//牌的大小比较，从小到大理牌
    }
}
