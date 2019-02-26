package com.zhenmei.althoughmgbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.zhenmei.althoughmgbutton.lib.BaseButton;
import com.zhenmei.althoughmgbutton.lib.CommonLabel;
import com.zhenmei.althoughmgbutton.lib.LabelInfo;
import com.zhenmei.althoughmgbutton.lib.LabelSelector;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String LOGTAG = "zhenmei";

    private BaseButton btn;

    private LabelSelector ls;

    private CommonLabel cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = findViewById(R.id.btn);
        btn.setCustomCallBack(new BaseButton.CustomCallBack() {
            @Override
            public void onclick(View v, boolean isCheck) {
                Log.i(LOGTAG, "www");
            }
        });

        ls = findViewById(R.id.ls);
        cl = findViewById(R.id.cl);

        List<LabelInfo> list = new ArrayList<>();
        LabelInfo labelInfo1 = new LabelInfo("1", "初来乍到，不懂就问");
        LabelInfo labelInfo2 = new LabelInfo("2", "呼叫现场怪，帮我看看");
        LabelInfo labelInfo3 = new LabelInfo("3", "寻找附近有没有这种地方");
        LabelInfo labelInfo4 = new LabelInfo("4", "自问自答，我是地头蛇");

        list.add(labelInfo1);
        list.add(labelInfo2);
        list.add(labelInfo3);
        list.add(labelInfo4);

        ls.loadLabel(list);


        cl.setClickable(true);


    }
}
