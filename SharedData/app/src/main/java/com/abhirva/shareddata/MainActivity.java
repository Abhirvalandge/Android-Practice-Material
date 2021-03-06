package com.abhirva.shareddata;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         button = findViewById(R.id.button);
         textView = findViewById(R.id.textView2);
         editText = findViewById(R.id.editText);

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String msg = editText.getText().toString();

                 SharedPreferences shrd = getSharedPreferences("demo",MODE_PRIVATE);
                 SharedPreferences.Editor editor = shrd.edit();

                 editor.putString("str", msg);
                 editor.apply();
                 textView.setText(msg);
             }
         });

         // Get the value of Shared Preference back
        SharedPreferences getshared = getSharedPreferences("demo", MODE_PRIVATE);
        String value = getshared.getString("str", "Save a note and it will show up here");
        textView.setText(value);
    }
}
