package com.abhirva.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class displayContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Rname");
        String phone = intent.getStringExtra("Rphone");

        TextView nameTextView = findViewById(R.id.displayName);
        nameTextView.setText(name);

        TextView phoneTextView = findViewById(R.id.displayPhone);
        phoneTextView.setText(phone);
    }
}
