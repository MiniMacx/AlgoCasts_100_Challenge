package noob;

/**
 * @author ZYLin
 * @date 2019/7/11
 */
public class MainT {
    public static void main(String[] args) {
        MsgProducer p = new MsgProducer();
        Thread prod = new Thread(p);
        prod.start();
        Thread consumer1 = new Thread(new MsgConsumer("C1", p));
        Thread consumer2 = new Thread(new MsgConsumer("C2", p));
        Thread consumer3 = new Thread(new MsgConsumer("C3", p));
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
