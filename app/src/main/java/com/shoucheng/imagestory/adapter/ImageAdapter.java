package com.shoucheng.imagestory.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shoucheng.imagestory.R;
import com.shoucheng.imagestory.bean.PicInfo;
import com.shoucheng.imagestory.toast.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 17-8-16.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {
    private Context context;
    private List<PicInfo> mDatas;
    public ImageAdapter(Context context, List<PicInfo> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.picture_item, parent, false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(final ImageHolder holder, int position) {
        PicInfo mPicInfo = mDatas.get(position);
        Glide.with(context).load(mPicInfo.getPicUrl()).into(holder.picImg);
        holder.picInfo.setText(mPicInfo.getInfo());
        holder.picInfo.setVisibility(View.VISIBLE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.snackBar(holder.itemView, "打开详情页面");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ImageHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.picImg)
        ImageView picImg;
        @BindView(R.id.picInfo)
        TextView picInfo;
        public ImageHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setHight(int hight) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) picImg.getLayoutParams();
            params.height = hight;
            picImg.requestLayout();
        }

        public void setPicDescVisibility(int visibility) {
            picInfo.setVisibility(visibility);
            itemView.requestLayout();
        }
    }
}
