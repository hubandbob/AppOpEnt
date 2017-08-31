package android.sage.system.appopent;


import android.app.IntentService;
import android.content.Intent;

public class IntentKafkaService extends IntentService {
        public IntentKafkaService() {
            // Il faut passer une chaîne de caractères au superconstructeur
            super("UnNomAuHasard");
        }

        @Override
        protected void onHandleIntent(Intent intent) {
            // Gérer la requête
            /*
            Log.d(TAG, "Le compteur valait : " + intent.getIntExtra(MainActivity.EXTRA_COMPTEUR, -1));
            */

        }
    }
