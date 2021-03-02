package cn.zoulj;

import cn.zoulj.producer.KafkaProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaTest2 {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Test
    public void sendMsg() throws InterruptedException {
        String topic = "topic";
        for (int i = 0; i < 10; i++) {
            kafkaProducerService.sendMessage(topic, "hello kafka" + i);
            Thread.sleep(5);
        }
        Thread.sleep(Integer.MAX_VALUE);
    }
}
