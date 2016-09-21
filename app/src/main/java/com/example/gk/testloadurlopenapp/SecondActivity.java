package com.example.gk.testloadurlopenapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String CONTENT = "content";

    private TextView txt_result;

    /**
     * 显示意图
     *
     * @param activity 活动
     * @param content  传递的内容
     */
    public static void actionStart(Activity activity, String content) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra(CONTENT, content);
        activity.startActivity(intent);
    }

    /**
     * 隐式意图
     *
     * @param activity 活动
     * @param content  传递的内容
     */
    public static void actionStart1(Activity activity, String content) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        Uri uri = Uri.parse("com.imgod.testdeeplink://app内隐式跳转"+content);
        intent.setData(uri);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        initValue();
    }

    //如果有app有多个界面需要deeplink的话:
    //本来想host传递一个json串,然后在进行各种解析 相应跳转的呢.没想到把json串,放进host,拿不全,看来这种方式走不通
    //那么我们就可以在每个需要deeplink的界面分别指定不同的协议,然后在分别处理
    private void initValue() {
        Intent comeIntent = getIntent();
        if (null != comeIntent) {
            Uri uri = comeIntent.getData();
            //如果一个界面需要deeplink的话,也可以全走隐式意图进行跳转
            if (null != uri) {//隐式意图过来
                String txt = txt_result.getText().toString() + uri.getHost();
                txt_result.setText(txt);
            } else {//显示意图过来
                String content = comeIntent.getStringExtra(CONTENT);
                String txt = txt_result.getText().toString() + content;
                txt_result.setText(txt);
            }
        }
    }

    private void initView() {
        txt_result = (TextView) findViewById(R.id.txt_result);
    }
}
