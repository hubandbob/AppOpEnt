package android.sage.system.appopent;

import android.content.Context;
import android.widget.Toast;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by elsalamblin on 31/08/2017.
 */

public class ConsumerThread extends Thread{

    private String topicName;
    private String groupId;
    private KafkaConsumer<String,String> kafkaConsumer;
    private ConsumerRecords<String, String> recordedMessages;

    public ConsumerThread(String topicName, String groupId){
        this.topicName = topicName;
        this.groupId = groupId;
    }
    public void run() {

        Properties configProperties = new Properties();
        configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.11:9092");
        configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        configProperties.put(ConsumerConfig.CLIENT_ID_CONFIG, "simple");

        //Figure out where to start processing messages from
        kafkaConsumer = new KafkaConsumer<String, String>(configProperties);
        /*kafkaConsumer.subscribe(Arrays.asList(topicName));
        //Start processing messages
        try {
            while (true) {
                this.recordedMessages = kafkaConsumer.poll(100);
                /*
                for (ConsumerRecord<String, String> record : this.recordedMessages) {
                    String s = record.value();
                    System.out.println(record.value());

                }

            }
        }catch(WakeupException ex){
            System.out.println("Exception caught " + ex.getMessage());
        }finally{
            kafkaConsumer.close();
            System.out.println("After closing KafkaConsumer");
        }*/
    }
    public KafkaConsumer<String,String> getKafkaConsumer(){
        return this.kafkaConsumer;
    }

    public ConsumerRecords<String, String> getRecordedMessages() {
        return recordedMessages;
    }

    public void setRecordedMessages(ConsumerRecords<String, String> recordedMessages) {
        this.recordedMessages = recordedMessages;
    }
}
