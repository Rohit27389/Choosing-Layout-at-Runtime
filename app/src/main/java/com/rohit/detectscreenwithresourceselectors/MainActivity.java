package com.rohit.detectscreenwithresourceselectors;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    boolean viewBoolean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.showTime);
        ViewGroup viewGroup = findViewById(R.id.device_fragment);

        FloatingActionButton floatingActionButton=findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

        viewBoolean = (viewGroup != null);
        if (viewBoolean) {
            textView.setText("Using fragment side by side : True");
        } else {
            textView.setText("Using fragment side by side : False");
        }
    }

    private void show() {
        if (viewBoolean) {
            Detail_Fragment detail_fragment = new Detail_Fragment();
            getFragmentManager().beginTransaction().add(R.id.device_fragment, detail_fragment).commit();
        } else {
            Intent intent = new Intent(this, Detail_Activity.class);
            startActivity(intent);
        }
    }
}
