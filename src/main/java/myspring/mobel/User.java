package myspring.mobel;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author zhujiameng
 * @create 2018-06-01 11:36
 **/
@Data
@Setter
@Getter
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private int age;
    private int id;
    private String createTime;
    private BigDecimal money;

    public User(int id, String createTime) {
        this.id = id;
        this.createTime = createTime;
    }

}
