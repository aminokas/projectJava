package data;

import java.io.Serializable;

public class UserBuy implements Serializable {
    private Long id;
    private Long user_id;
    private String coffee_type;
    private int count;
    private int totalsum;

    public UserBuy() {
    }

    public UserBuy(Long id, Long user_id, String coffee_type, int count, int totalsum) {
        this.id = id;
        this.user_id = user_id;
        this.coffee_type = coffee_type;
        this.count = count;
        this.totalsum = totalsum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getCoffee_type() {
        return coffee_type;
    }

    public void setCoffee_type(String coffee_type) {
        this.coffee_type = coffee_type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(int totalsum) {
        this.totalsum = totalsum;
    }
}

