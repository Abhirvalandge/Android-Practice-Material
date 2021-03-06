package com.abhirva.backgrounddemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public class BG extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("AbhirvaBG","onPreExecute: ran");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("AbhirvaBG","onPostExecute: ran");
            Log.d("AbhirvaBG", s );
        }

        @Override
        protected String doInBackground(String... urls) {
            Log.d("AbhirvaBG","doInBackground: ran");
            String result = "";
            URL url;
            HttpURLConnection conn;
            try {
                url = new URL(urls[0]);
                conn = (HttpURLConnection) url.openConnection();
                InputStream in = conn.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();

                }
            }
            catch (Exception e){
                e.printStackTrace();
                return "Something went wrong";
            }
            return result;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BG myTask = new BG();
        myTask.execute("http://www.w3schools.com/");
    }

    public void leLo(View view){
        Toast.makeText(this, "Selfie le li mene", Toast.LENGTH_SHORT).show();
    }
}
