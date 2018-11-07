package myspring.lanaml;

import myspring.mobel.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;


/**
 * @author zhujiameng
 * @create 2018-06-27 13:51
 **/
public class LanamTest {

    public static void main(String [] args){
        List<User> list=new ArrayList<User>();
        list.add(new User(1,"2017-04-12 00:00:00"));
        list.add(new User(2,"2017-04-14 00:00:00"));
        list.add(new User(3,"2017-04-13 00:00:00"));
        list.add(new User(4,"2017-05-13 00:00:00"));
        list.add(new User(4,"2017-05-13 00:00:00"));


      //  List<User> collect = list.stream().filter(ll -> ll.getId() == 1).collect(Collectors.toList());
        //System.out.println(collect);
        //取出对象中的数据并滤重
        /*List<Integer> collect = list.stream().map(User::getId).distinct().collect(Collectors.toList());
        System.out.println("=="+collect);

        List<Integer> collect2 =new ArrayList<User>().stream().map(User::getId).distinct().collect(Collectors.toList());
        System.out.println("=="+collect2);

        List<Integer> collect1 = collect.stream().filter(item -> !collect2.contains(item)).collect(Collectors.toList());
        System.out.println("---得到差集 reduce1 (list1 - list2)---"+collect1);



        List<Integer> collect3 = collect2.stream().filter(item -> !collect.contains(item)).collect(Collectors.toList());
        System.out.println("---得到差集 reduce1 (list1 - list2)---"+collect3);*/
  /*      // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
        System.out.println("---得到差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out :: println);

        // 差集 (list2 - list1)
        List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(toList());
        System.out.println("---得到差集 reduce2 (list2 - list1)---");
        reduce2.parallelStream().forEach(System.out :: println);*/

    /*   list.sort((lhs, rhs) -> {
            if (lhs.getName().equals(rhs.getName())) {
                return lhs.getAge() - rhs.getAge();
            } else {
                return lhs.getName().compareTo(rhs.getName());
            }
        });*/
       // Comparator<User> comparator = (h1, h2) -> h1.getCreateTime().compareTo(h2.getCreateTime());//h1.compareTo(h2.getName());
        //(h1, h2) -> h1.getCreateTime().compareTo(h2.getCreateTime());

       // humans.sort(comparator.reversed());



    }
}
