package com.example.gk.testloadurlopenapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        btn_go.setOnClickListener(this);
    }

    private void initView() {
        btn_go = (Button) findViewById(R.id.btn_go);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_go:
                SecondActivity.actionStart(MainActivity.this, "从onClick点击事件中跳转过来");
                break;
        }
    }
}
