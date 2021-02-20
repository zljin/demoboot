package cn.zoulj.listener;

import com.alibaba.fastjson.JSONArray;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaListener {

    @KafkaListener(topics = "log")
    public void getMessage(String message) {
        byte[] arr = JSONArray.parseObject(message, byte[].class);
        System.out.println(arr);
    }
}
