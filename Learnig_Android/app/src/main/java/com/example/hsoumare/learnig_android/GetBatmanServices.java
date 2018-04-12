package com.example.hsoumare.learnig_android;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.nfc.Tag;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static android.content.ContentValues.TAG;
import static java.lang.System.in;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class GetBatmanServices extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_get_all_Batman = "com.example.hsoumare.learnig_android.action.get_all_Batman";

    public GetBatmanServices() {
        super("GetBatmanServices");
    }

    /**
     * Starts this service to perform action get_all_Batman with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionget_all_Batman(Context context) {
        Intent intent = new Intent(context, GetBatmanServices.class);
        intent.setAction(ACTION_get_all_Batman);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            handleActionBatman();
            if (ACTION_get_all_Batman.equals(action)) {
                handleActionBatman();
            }
        }
    }


    private void handleActionBatman() {
        Log.d(TAG, "thread service name :" + Thread.currentThread().getName());
        URL url =null;
        try {
            url= new URL("http://www.omdbapi.com/?s=batman&apikey=647cabe");
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                copyInputStreamToFile(conn.getInputStream(),
                        new File(getCacheDir(),"batman.json"));
                Log.d(TAG, "batmanmovies json downloaded !");

            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent());
    }

    private void copyInputStreamToFile(InputStream inputStream, File file) {
        try {
            Log.i("TAG", "copyinputstream");
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=inputStream.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
