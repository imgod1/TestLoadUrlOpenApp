package com.example.gk.testloadurlopenapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String CONTENT = "content";

    private TextView txt_result;

    public static void actionStart(Activity activity, String content) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra(CONTENT, content);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        String content = getIntent().getStringExtra(CONTENT);
        txt_result = (TextView) findViewById(R.id.txt_result);
        String txt = txt_result.getText().toString() + content;
        txt_result.setText(txt);
    }
}
