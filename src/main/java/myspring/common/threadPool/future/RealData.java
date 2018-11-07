package myspring.common.threadPool.future;

import java.util.concurrent.Callable;

/**
 * 真实数据
 *
 * @author zhujiameng
 * @create 2018-06-07 9:24
 **/
public class RealData implements  Callable<String>{
    private String param;
    public RealData(){}
 //   protected  volatile String result;
    public RealData(String param){
        this.param=param;
   /*     StringBuffer sb=new StringBuffer();
        for (int i=0;i<10;i++){
            sb.append(param);
            try {
                Thread.sleep(100);
            }catch (Exception e){

            }
        }
        result=sb.toString();*/
    }
  /*  @Override
    public String getResult() {
        return result;
    }*/

    @Override
    public String call() throws Exception {
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<10;i++){
            sb.append(param);
            try {
                Thread.sleep(100);
            }catch (Exception e){

            }
        }
        return sb.toString();
    }
}
