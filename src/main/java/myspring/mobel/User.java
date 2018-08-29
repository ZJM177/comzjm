package myspring.mobel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhujiameng
 * @create 2018-06-01 11:36
 **/
@Data
@Setter
@Getter
public class User {
    private String username;
    private String password;
    private int age;
    private int id;
    private String createTime;

    public User(int id, String createTime) {
        this.id = id;
        this.createTime = createTime;
    }

}
