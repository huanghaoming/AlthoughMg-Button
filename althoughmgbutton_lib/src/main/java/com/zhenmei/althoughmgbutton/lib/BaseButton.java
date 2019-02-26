package com.zhenmei.althoughmgbutton.lib;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

public class BaseButton extends RelativeLayout {
    private boolean isCheck = false;


    private Context mContext;


    public BaseButton(Context context) {
        super(context);
    }

    public BaseButton(Context context, AttributeSet attrs) {
        super(context, attrs);


        initView();

    }


    private void initView() {
        mContext = getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.button_style_one, this, true);


        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //在按钮的点击事件中调用接口的方法
                if (customCallBack != null) {

                    isCheck = !isCheck;

                    customCallBack.onclick(v, isCheck);
                }

            }
        });


        GradientDrawable bgcDrawable = new GradientDrawable();
        GradientDrawable pBgcDrawable = new GradientDrawable();

        bgcDrawable.setCornerRadius(30);
        StateListDrawable stateListDrawable = new StateListDrawable();
        bgcDrawable.setColor(getResources().getColor(R.color.red));

        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pBgcDrawable);
        pBgcDrawable.setCornerRadius(30);
        pBgcDrawable.setColor(getResources().getColor(R.color.yellow));

        stateListDrawable.addState(new int[]{}, bgcDrawable);
        setBackgroundDrawable(stateListDrawable);

    }

    private CustomCallBack customCallBack;

    public void setCustomCallBack(CustomCallBack customCallBack) {
        this.customCallBack = customCallBack;
    }

    public interface CustomCallBack {
        void onclick(View v, boolean isCheck);
    }
}
