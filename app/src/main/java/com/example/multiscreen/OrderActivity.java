package com.example.multiplescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.capstone.R;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String message = intent.getStringExtra(com.example.multiscreen.MainActivity.MSG);

        // Set text inside texone pictview to message
        TextView textView = findViewById(R.id.orderText);
        textView.setText(message);



    }

    public void thankYou(View view) {
        Intent i = new Intent(this,ThankYou.class);
        startActivity(i);
    }

}