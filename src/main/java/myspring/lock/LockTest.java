package myspring.lock;

/**
 * @author zhujiameng
 * @create 2018-08-13 12:38
 **/
public class LockTest {
    private static final int circle=200000000;
    
    public static void main(String[] args){
        long start = System.currentTimeMillis();

        for (int i = 0; i < circle; i++) {
            create("java","p");
        }

        long cost = System.currentTimeMillis()-start;
        System.out.println("create cost:"+cost);
    }
//6242  5624  10669
    private static String create(String java, String p) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(java);
        stringBuffer.append(p);
        return stringBuffer.toString();
    }
}
