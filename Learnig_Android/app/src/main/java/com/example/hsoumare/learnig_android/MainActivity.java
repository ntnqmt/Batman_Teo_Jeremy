package com.example.hsoumare.learnig_android;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationCompat.Builder notif = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setContentTitle("Bienvenue")
                .setAutoCancel(true);
        /*.setPriority(Notification.PRIORITY_HIGH)
                .setContentText("Cette application est en cours de developpement")*/


        Button bt_hw=(Button)findViewById(R.id.btn_batman_begins);
        bt_hw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Batman begins", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), secondactivity.class);
                startActivity(intent);

            }
        });

        Button bt_hw1=(Button)findViewById(R.id.superman);
        bt_hw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Batman vs superman : Dawn of justice", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), secondactivity.class);
                startActivity(intent);

            }
        });

        Button bt_hw2=(Button)findViewById(R.id.batman);
        bt_hw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Batman", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), secondactivity.class);
                startActivity(intent);

            }
        });

        Button bt_hw3=(Button)findViewById(R.id.returns);
        bt_hw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Batman returns", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), secondactivity.class);
                startActivity(intent);

            }
        });

        Button bt_hw4=(Button)findViewById(R.id.forever);
        bt_hw4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Batman forever", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), secondactivity.class);
                startActivity(intent);

            }
        });

        Button bt_hw5=(Button)findViewById(R.id.robin);
        bt_hw5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Batman and robin", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), secondactivity.class);
                startActivity(intent);

            }
        });

        Button bt_hw6=(Button)findViewById(R.id.legobatman);
        bt_hw6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "The LEGO Batman movie", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), secondactivity.class);
                startActivity(intent);

            }
        });

        Button bt_hw7=(Button)findViewById(R.id.animated);
        bt_hw7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Batman: The animated series", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), secondactivity.class);
                startActivity(intent);

            }
        });

        Button bt_hw8=(Button)findViewById(R.id.redhood);
        bt_hw8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Batman: under the red hood", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), secondactivity.class);
                startActivity(intent);

            }
        });

        Button bt_hw9=(Button)findViewById(R.id.darkknight);
        bt_hw9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Batman: the dark knight returns", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), secondactivity.class);
                startActivity(intent);

            }
        });

        Button bt_hn=(Button)findViewById(R.id.lala);
        bt_hn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification notif = new NotificationCompat.Builder(MainActivity.this)
                    .setContentTitle("Plus de films sur allocine").setSmallIcon(android.R.drawable.gallery_thumb).build();
                NotificationManager manager = (NotificationManager) getSystemService(MainActivity.this.NOTIFICATION_SERVICE);
                manager.notify(0,notif);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        new MenuInflater(this).inflate(R.menu.menu_main,menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option:
                Toast.makeText(MainActivity.this, "Option non disponible", Toast.LENGTH_SHORT).show();
                break;
            case R.id.favoris:
                Toast.makeText(MainActivity.this, " ajouter vos favoris", Toast.LENGTH_SHORT).show();
                break;
            case R.id.quitter:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
