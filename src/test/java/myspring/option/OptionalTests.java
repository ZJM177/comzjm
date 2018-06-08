package myspring.option;

import java.util.Optional;

/**
 * @author zhujiameng
 * @create 2018-06-07 18:26
 **/
public class OptionalTests {

    public static void main(String [] args){
        System.out.println(Optional.ofNullable("12").orElse("11  "));
    }
}
