package com.abhirva.photoframe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String [] names = {"MacLaptop", "Smart City Project", "Office", "India", "Startup"};
    ImageButton prev, next;
    ImageView pic;
    TextView text;
    int currentImage = 0;
    // 0-1-2-3-4-0-1-2-3-4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void prev(View v){
        text = findViewById(R.id.text);
        String idX = "pic" + currentImage;
        int x = this.getResources().getIdentifier(idX, "id",getPackageName());
        pic = findViewById(x);
        pic.setAlpha(0f);

        currentImage = (5 + currentImage - 1) % 5;
        String idY = "pic" + currentImage;
        int y = this.getResources().getIdentifier(idY, "id",getPackageName());
        pic = findViewById(y);
        pic.setAlpha(1f);

        text.setText(names[currentImage]);
    }
    public void next(View v){
        text = findViewById(R.id.text);
        String idX = "pic" + currentImage;
        int x = this.getResources().getIdentifier(idX, "id",getPackageName());
        pic = findViewById(x);
        pic.setAlpha(0f);

        currentImage = (currentImage + 1) % 5;
        String idY = "pic" + currentImage;
        int y = this.getResources().getIdentifier(idY, "id",getPackageName());
        pic = findViewById(y);
        pic.setAlpha(1f);

        text.setText(names[currentImage]);

    }
}
