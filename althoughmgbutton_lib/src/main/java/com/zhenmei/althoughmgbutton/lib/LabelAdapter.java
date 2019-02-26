package com.zhenmei.althoughmgbutton.lib;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class LabelAdapter extends BaseQuickAdapter<LabelInfo, BaseViewHolder> {


    public LabelAdapter(@LayoutRes int layoutResId, @Nullable List<LabelInfo> data) {
        super(layoutResId, data);

    }


    @Override
    protected void convert(BaseViewHolder helper, LabelInfo item) {

        CommonLabel commonLabel = helper.getView(R.id.cl);
        commonLabel.setTitle(item.getName());
        // helper.setText(R.id.cl, item.getName());


    }


}
