package myspring.common.threadPool.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhujiameng
 * @create 2018-06-08 13:02
 **/
public class Master {
    protected Queue<Object> workquene=new ConcurrentLinkedQueue<>();
    protected Map<String,Thread> threadMap=new HashMap<>();
    protected Map<String,Object> resultMap=new ConcurrentHashMap<>();
    public boolean isComplete(){
        for (Map.Entry<String,Thread> entry:threadMap.entrySet()){
            if(entry.getValue().getState()!=Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }

    public Master(Worker woker,int count) {
        woker.setWorkQueue(workquene);
        woker.setResultMap(resultMap);
       for (int i=0;i<count;i++){
           threadMap.put(Integer.toString(i),new Thread(woker,Integer.toString(i)));
       }
    }

    public void submit(Object b){
        workquene.add(b);

    }

    public Map<String,Object> getResultMap(){
        return resultMap;
    }

    public void execute(){
        for (Map.Entry<String,Thread> entry:threadMap.entrySet()){
            entry.getValue().start();
        }
    }
    public static void main(String[] a){
        Master master = new Master(new PlusWorker(), 5);
        for (int i=0;i<100;i++){
            master.submit(i);
        }
        master.execute();
        int re=0;
        Map<String, Object> resultMap = master.getResultMap();
        while (resultMap.size()>0|| !master.isComplete()){
            Set<String> keys = resultMap.keySet();
            String key=null;
            for (String k:keys){
                key=k;
                break;
            }
            Integer i=null;
            if (key!=null){i=(Integer)resultMap.get(key);}
            if(i!=null){re+=i;}
            if(key!=null){
                resultMap.remove(key);
            }

        }
    }

}
