package android.sage.system.appopent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;
import android.sage.system.appopent.ConsumerThread;
import android.widget.Toast;


public class LotsADeplacerActivity extends AppCompatActivity {
    private static Scanner in;
    private static boolean stop = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lots_a_deplacer);

        // glossaire
        Context context = getApplicationContext();
        ImageView blueMarker = (ImageView) findViewById(R.id.blue_marker);
        ImageView redMarker = (ImageView) findViewById(R.id.red_marker);

        // --------------- via un service -------------------
        //création du service
        /*
        Intent i = new Intent(LotsADeplacerActivity.this, IntentKafkaService.class);
        startService(i);
*/
        in = new Scanner(System.in);
        String topicName = "test";
        String groupId = "test-consumer-group";

        ConsumerThread consumerRunnable = new ConsumerThread(topicName,groupId);
        consumerRunnable.start();
        /*String line = "";
        while (!line.equals("exit")) {
            line = in.next();
        }
        consumerRunnable.getKafkaConsumer().wakeup();
        System.out.println("Stopping consumer .....");
        try {
            consumerRunnable.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ConsumerRecords<String, String> records = consumerRunnable.getRecordedMessages();
        for (ConsumerRecord<String, String> record : records) {
            String s = record.value();
            //System.out.println(record.value());
            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        }*/

        // cuisine sur la map
        blueMarker.setPadding(dpToPx(66, context), dpToPx(32, context), 0, 0);
        redMarker.setPadding(dpToPx(89, context), dpToPx(32, context), 0, 0);
    }

    public static int dpToPx(int dp, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }


}
