package com.zhenmei.althoughmgbutton.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ImageTextLongButton extends RelativeLayout {
    private Context mContext;

    private String icon;
    private String title;
    private int title_color;

    private int icon_color;
    private String arrow_right;
    private TextView tv_icon;
    private TextView tv_title;
    private TextView tv_arrow_right;
    private TextView close;


    private String _title;
    private String contentId = null;


    private TextView tv_desc;
    private Object object;

    public ImageTextLongButton(Context context) {
        super(context);

    }

    public ImageTextLongButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageTextLongButton);
        icon = typedArray.getString(R.styleable.ImageTextLongButton_ali_icon);
        title = typedArray.getString(R.styleable.ImageTextLongButton_ali_title);

        icon_color = typedArray.getColor(R.styleable.ImageTextLongButton_ali_icon_color, Color.BLACK);
        title_color = typedArray.getColor(R.styleable.ImageTextLongButton_ali_title_color, Color.BLACK);
        _title = title;
        arrow_right = typedArray.getString(R.styleable.ImageTextLongButton_ali_arrow_right);
        initView();

    }


    private void initView() {
        mContext = getContext();
        LayoutInflater.from(mContext).inflate(R.layout.image_text_long_button, this, true);
        tv_icon = findViewById(R.id.icon);
        tv_title = findViewById(R.id.title);
        tv_arrow_right = findViewById(R.id.arrow_right);
        tv_desc = findViewById(R.id.desc);
        close = findViewById(R.id.close);
        close.setVisibility(View.GONE);


        Typeface iconFont = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
        tv_icon.setTypeface(iconFont);
        tv_arrow_right.setTypeface(iconFont);

        close.setTypeface(iconFont);
        tv_icon.setText(icon);
        tv_title.setText(title);
        tv_arrow_right.setText(arrow_right);

        close.setTextColor(getResources().getColor(R.color.label_blue));

        close.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                closeClickCallBack.onclick(contentId, tv_title.getText().toString());

                tv_title.setText(_title);
                contentId = null;
                close.setVisibility(View.GONE);


                //变色
                tv_title.setTextColor(title_color);
                tv_icon.setTextColor(icon_color);

            }
        });

    }


    public void resetTitle() {
        tv_title.setText(_title);

    }

    public void setTitle(String text) {

        tv_title.setText(text);

    }

    public void setTitleFirst(String text) {
        setTitle(text);
        _title = text;

    }

    public void setIcon(String icon) {
        this.icon = icon;

        tv_icon.setText(icon);

    }

    public void setRightArrow(String arrow_right) {
        this.arrow_right = arrow_right;
        tv_arrow_right.setText(arrow_right);

    }


    public void setContent(String content, String id) {
        //隐藏desc
        tv_desc.setVisibility(View.GONE);
        close.setVisibility(View.VISIBLE);

        tv_title.setText(content);
        this.contentId = id;

        //变色
        tv_title.setTextColor(getResources().getColor(R.color.label_blue));
        tv_icon.setTextColor(getResources().getColor(R.color.label_blue));


    }


    private ImageTextLongButton.CloseClickCallBack closeClickCallBack;

    public void setCloseClickCallBack(ImageTextLongButton.CloseClickCallBack closeClickCallBack) {
        this.closeClickCallBack = closeClickCallBack;
    }

    public interface CloseClickCallBack {
        void onclick(String id, String name);
    }

}
