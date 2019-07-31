package noob;

/**
 * @author ZYLin
 * @date 2019/7/11
 */
public class MsgConsumer implements Runnable {

    private String consumerName;

    private MsgProducer producer;

    public MsgConsumer(String consumerName, MsgProducer producer) {
        this.consumerName = consumerName;
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true){
            String msg = producer.getMsg();
            System.out.println(consumerName + "  getContent:" + msg);
        }
    }
}
