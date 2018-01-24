package learn.customer.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
    public static final long Serializableid=114545l;
    private  String username;
    private Long userId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
