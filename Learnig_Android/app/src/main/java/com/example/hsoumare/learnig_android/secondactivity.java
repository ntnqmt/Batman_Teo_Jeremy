package com.example.hsoumare.learnig_android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class secondactivity extends AppCompatActivity {
    protected JSONObject batman;
    public static final String BATMAN_UPDATE = "com.octip.cours.inf4042_11.BATMAN_UPDATE";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.secondactivity );

        IntentFilter intentFilter = new IntentFilter ( BATMAN_UPDATE );
        LocalBroadcastManager.getInstance ( this ).registerReceiver ( new BatmanUpdate (), intentFilter );
        GetBatmanServices.startActionget_all_Batman(getApplicationContext());
        batman = getBatmanFromFile();
        Log.i("JSON 1",batman.toString());


        String url = "";
        if (batman != null) {
            url = batman.toString();
            Log.e("json url", url);
        }
        ((TextView) findViewById(R.id.testjson)).setText(url);
    }

    public class BatmanUpdate extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d ( "tag", "received");

            batman = getBatmanFromFile();
            Log.i("JSON 1",batman.toString());
        }

    }

    public JSONObject getBatmanFromFile() {
        try {
            InputStream is = new FileInputStream( getCacheDir () + "/" + "batman.json" );
            byte[] buffer = new byte[is.available ()];
            is.read ( buffer );
            is.close ();
            Log.i("JSON",new String ( buffer, "UTF-8" ));
            return new JSONObject ( new String ( buffer, "UTF-8" ) ); // construction du tableau
        } catch (IOException e) {
            e.printStackTrace ();
            return new JSONObject ();
        } catch (JSONException e) {
            e.printStackTrace ();
            return new JSONObject ();
        }
    }


    public class BatmanAdapter extends RecyclerView.Adapter <BatmanAdapter.BatmanHolder> {

        public BatmanAdapter(JSONObject batman_json){
            batman = batman_json;
        }

        @Override
        public BatmanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_batman_element, null, false);
            return new BatmanHolder ( view );
        }

        @Override
        public void onBindViewHolder(BatmanHolder holder, int position) {
            /*
            try {
                String actualBier = batman.getJSONObject(position).getString("name");
                holder.name.setText(actualBier);
            } catch (JSONException e) {
                e.printStackTrace();
            }*/
        }

        @Override
        public int getItemCount() {
            return batman.length();
        }


        public void setNewBatman(JSONObject jsonArray)
        {
            batman = jsonArray;
            notifyDataSetChanged();
        }

        public class BatmanHolder extends RecyclerView.ViewHolder {
            public TextView name;

            public BatmanHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.rv_batman_element_name);
                name.setText("fazefaze");
            }
        }
    }
}


