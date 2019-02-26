package com.zhenmei.althoughmgbutton.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

public class LabelSelector extends LinearLayout {

    private CommonLabel selectedLabel = null;

    private RecyclerView recyclerView;

    private LabelAdapter labelAdapter;

    private String icon;
    private String title;
    private String arrow_right;


    private Context mContext;


    private ImageTextLongButton itlong_btn;

    public LabelSelector(Context context) {
        super(context);

    }

    public LabelSelector(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageTextLongButton);

        icon = typedArray.getString(R.styleable.ImageTextLongButton_ali_icon);
        title = typedArray.getString(R.styleable.ImageTextLongButton_ali_title);
        arrow_right = typedArray.getString(R.styleable.ImageTextLongButton_ali_arrow_right);
        initView();

    }

    public void setIcon(String icon) {
        itlong_btn.setIcon(icon);

    }


    public void setRightArrow(String title) {
        itlong_btn.setRightArrow(title);

    }


    private void initView() {
        mContext = getContext();
        LayoutInflater.from(mContext).inflate(R.layout.label_selector_layout, this, true);
        itlong_btn = findViewById(R.id.itlong_btn);
        itlong_btn.setTitleFirst(title);

        setRightArrow(arrow_right);
        setIcon(icon);
        recyclerView = findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);

        labelAdapter = new LabelAdapter(R.layout.list_item_label, null);
        recyclerView.setAdapter(labelAdapter);


        labelAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                LabelInfo labelInfo = (LabelInfo) adapter.getItem(position);


                itlong_btn.setContent(labelInfo.getName(), labelInfo.getId());

                if (selectedLabel != null) {
                    selectedLabel.setSelected(false);
                }

                selectedLabel = view.findViewById(R.id.cl);
                selectedLabel.setSelected(true);


            }
        });


        itlong_btn.setCloseClickCallBack(new ImageTextLongButton.CloseClickCallBack() {
            @Override
            public void onclick(String id, String name) {

                selectedLabel.setSelected(false);
            }
        });


    }


    public void loadLabel(List<LabelInfo> labelInfos) {
        labelAdapter.setNewData(labelInfos);
    }

}
