package cn.zoulj.listener;

import com.alibaba.fastjson.JSONArray;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class kafkaListener {

    @KafkaListener(topics = "test")
    public void getMessage(String message) {
        String msg = message;
        System.out.println(new Date() + ": " + msg);
    }
}
