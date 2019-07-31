package noob;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ZYLin
 * @date 2019/7/11
 */
public class MsgProducer implements Runnable{
    private List<String> msgList = new ArrayList<>();

    @Override
    public void run() {
        try {
            Random random = new Random();
            while (true){
                Thread.sleep(1);
                synchronized (msgList){
                    msgList.add("msg:" + random.nextInt());
                    msgList.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getMsg(){
        synchronized (msgList){
            if (msgList.size() == 0){
                try {
                    msgList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return msgList.remove(0);
    }

}
