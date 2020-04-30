package com.example.seemanto.cgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonone,buttontwo,buttonthree,buttonfour;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonone = findViewById(R.id.secondbuttonID);
        buttontwo = findViewById(R.id.thirdbuttonID);
        buttonthree = findViewById(R.id.fourthbuttonID);
        buttonfour = findViewById(R.id.fifthbuttonID);

        textView = findViewById(R.id.textviewID);
        imageView = findViewById(R.id.logoID);

    }

    public void processone(View v)
    {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    public void processtwo(View v)
    {
        Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
        startActivity(intent);
    }

    public void fourthprocess(View v)
    {
        Intent intent = new Intent(MainActivity.this,FourthActivity.class);
        startActivity(intent);
    }

    public void fifthprocess(View view)
    {
        Intent intent = new Intent(MainActivity.this,FifthActivity.class);
        startActivity(intent);
    }
}
