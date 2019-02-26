package com.zhenmei.althoughmgbutton.lib;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CommonLabel extends RelativeLayout {
    private TextView title;
    private Context mContext;
    private ColorStateList title_style;

    public CommonLabel(Context context) {
        super(context);
    }

    public CommonLabel(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommonLabel);
        title_style = typedArray.getColorStateList(R.styleable.CommonLabel_cl_title_style);
        initView();

    }

    private void initView() {
        mContext = getContext();
        LayoutInflater.from(mContext).inflate(R.layout.common_label_layout, this, true);

        title = findViewById(R.id.title);
        GradientDrawable bgcDrawable = new GradientDrawable();
        GradientDrawable pBgcDrawable = new GradientDrawable();

        bgcDrawable.setCornerRadius(10);
        StateListDrawable stateListDrawable = new StateListDrawable();
        bgcDrawable.setColor(getResources().getColor(R.color.label_gray));

        pBgcDrawable.setCornerRadius(10);
        pBgcDrawable.setColor(getResources().getColor(R.color.label_blue));
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pBgcDrawable);

        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, pBgcDrawable);

        stateListDrawable.addState(new int[]{}, bgcDrawable);


        if (title_style == null) {
            ColorStateList csl = getResources().getColorStateList(R.color.common_label_text_style);
            title.setTextColor(csl);

        } else {

            title.setTextColor(title_style);

        }

        setBackgroundDrawable(stateListDrawable);

    }


    public void setTitle(String str) {
        title.setText(str);
    }
}
