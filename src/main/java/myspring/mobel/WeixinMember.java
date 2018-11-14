package myspring.mobel;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author zhujiameng
 * @create 2018-11-08 14:08
 **/
@Data
@Setter
@Getter
@NoArgsConstructor
@Alias("member")//别名
public class WeixinMember {
    private int id;
    private Date createTime;
    private Date updateTime;
    private boolean isDeleted;
    private String memberCode;
    private String openId;
    private String mobile;
    private int source;
    private int type;

    private String appId;

    private int invitationCode;

    private int gender;

    private String name;

    private String email;
    private String joinDate;
    private Date registerTime;
    private String recommendCode;
    private Double income;
    private int marry;
    private String job;
    private String memberLevel;

    private String operator;
    private String employeeCode;
    private String counterCode;
}
