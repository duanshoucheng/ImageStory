package com.shoucheng.imagestory;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shoucheng.imagestory.adapter.ImageAdapter;
import com.shoucheng.imagestory.bean.PicInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 17-8-16.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.mRecycler)
    RecyclerView mRecycler;
    @BindView(R.id.gridImg)
    ImageView gridImg;

    private Context context;
    private List<PicInfo> mDatas = new ArrayList<>();
    private ImageAdapter mImageAdapter;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();

        mImageAdapter = new ImageAdapter(context, mDatas);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        mRecycler.setLayoutManager(manager);
        mRecycler.setAdapter(mImageAdapter);
        mRecycler.setHasFixedSize(true);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
    }

    @OnClick(R.id.gridImg)
    public void onViewClicked() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        mRecycler.setLayoutManager(gridLayoutManager);
        int childCount = mRecycler.getChildCount();

        for (int i = 0; i < childCount; i++) {
            ImageAdapter.ImageHolder holder = (ImageAdapter.ImageHolder) mRecycler.findViewHolderForAdapterPosition(i);
            //这里循环检查已存在的holder
            if (holder != null) {
                holder.setHight(holder.itemView.getHeight() / 2);
                holder.setPicDescVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void initData() {
        PicInfo picInfo01 = new PicInfo();
        picInfo01.setInfo("高原湖泊风景 图片");
        picInfo01.setPicUrl("http://img.taopic.com/uploads/allimg/140326/235113-1403260U22059.jpg");
        mDatas.add(picInfo01);

        PicInfo picInfo02 = new PicInfo();
        picInfo02.setInfo("不知道明年的今天，我是否还在等待 阳光下的风景");
        picInfo02.setPicUrl("http://p3.wmpic.me/article/2017/08/15/1502776007_MflfjbCT.jpg");
        mDatas.add(picInfo02);

        PicInfo picInfo03 = new PicInfo();
        picInfo03.setInfo("不是假装沉默，只是无力诉说 ");
        picInfo03.setPicUrl("http://p1.wmpic.me/article/2017/08/16/1502864763_aRXLLQUq.jpg");
        mDatas.add(picInfo03);

        PicInfo picInfo04 = new PicInfo();
        picInfo04.setInfo("相由心生，一个人若脸上有气质，远比穿一身名牌更美，更帅，更受人肯定。想拥有它您甚至不必花一毛钱，只需注意自己的脾气、端正自己的品格、净化自己的思想、充实自己的内在……无形之中，您的谈吐、态度、举止…都会烙印上一股清新而脱俗的标签。");
        picInfo04.setPicUrl("http://p1.wmpic.me/article/2017/08/16/1502864763_atoWrkZl.jpg");
        mDatas.add(picInfo04);

        PicInfo picInfo05 = new PicInfo();
        picInfo05.setInfo("无论任何时候，一个人都不可以让自己的精神萎瑟，给自己贴上失败者的标签。水到穷处，看似路已走到了尽头，心会生出绝望，只是不经意间抬头看天上，才发现云已涌起，那水不是已化作满天的云了吗?这样看来绝望只是另一个希望的开始，变换一下角度，改变一下思路，另一片广阔的天地就会在眼前呈现出来。");
        picInfo05.setPicUrl("http://p1.wmpic.me/article/2017/08/16/1502864763_hTVGOlya.jpg");
        mDatas.add(picInfo05);

        PicInfo picInfo06 = new PicInfo();
        picInfo06.setInfo("你总有一天要明白，有些人，你从一开始想死他了，后来你想他死了。勿需挂念，终有弱水替沧海。做人要善良，无所谓你是前任或者现任。你没有必要折磨你自己，还生生在别人心里留下一个傻逼的标签。");
        picInfo06.setPicUrl("http://p1.wmpic.me/article/2017/08/16/1502864763_hKwSXLow.jpg");
        mDatas.add(picInfo06);

        PicInfo picInfo07 = new PicInfo();
        picInfo07.setInfo("　不要给那些你不了解的人和事轻易下定义，贴标签，尽管有时它们看起来很怪异不同，尝试一点点打开你的心灵。记住，头脑在打开的时候才会工作，高级的愚痴就是轻易拒绝那些你一点也不了解的事。");
        picInfo07.setPicUrl("http://p1.wmpic.me/article/2017/08/16/1502864763_BkRKfbZc.jpg");
        mDatas.add(picInfo07);

        PicInfo picInfo08 = new PicInfo();
        picInfo08.setInfo("　不要给那些你不了解的人和事轻易下定义，贴标签，尽管有时它们看起来很怪异不同，尝试一点点打开你的心灵。记住，头脑在打开的时候才会工作，高级的愚痴就是轻易拒绝那些你一点也不了解的事。");
        picInfo08.setPicUrl("http://p1.wmpic.me/article/2017/08/16/1502864763_GpbwaVeJ.jpg");
        mDatas.add(picInfo08);

        PicInfo picInfo09 = new PicInfo();
        picInfo09.setInfo("不要顽固地把哭泣当作一个人脆弱的标签，当你累了，苦了，受伤了的时候哭泣是一种精神的良药，能让你哭过之后重振精神面对生活。人需要坚强也需要开释。");
        picInfo09.setPicUrl("http://p1.wmpic.me/article/2017/08/16/1502864763_GpbwaVeJ.jpg");
        mDatas.add(picInfo09);

        PicInfo picInfo10 = new PicInfo();
        picInfo10.setInfo("普通人的爱情，以及我们需要看到爱情普通的那一面。今天之所以有人感觉爱情有点奢侈，有点稀缺，恐怕是因为他们给爱情贴上了标签，或者把爱情渲染得过于文艺或特别了。");
        picInfo10.setPicUrl("http://p2.wmpic.me/article/2017/08/16/1502864764_YwCDFAbv.jpg");
        mDatas.add(picInfo10);

        PicInfo picInfo11 = new PicInfo();
        picInfo11.setInfo("相由心生，一个人若脸上有气质，远比穿上一身名牌更美，更帅，更受人肯定。想拥有它您甚至不必花一毛钱，只需注意自己的脾气、端正自己的品格、净化自己的思想、充实自己的内在……无形之中，您的谈吐、态度、举止都会烙印上一股清新而脱俗的标签。");
        picInfo11.setPicUrl("http://p2.wmpic.me/article/2017/08/16/1502864764_icEvfrpA.jpg");
        mDatas.add(picInfo11);

        PicInfo picInfo12 = new PicInfo();
        picInfo12.setInfo("可以相信爱情，乐意听男人的甜言蜜语。但是务必保证一只耳朵进另一只耳朵出，切莫把这些毒药放在心里。认真游戏，但必须牢记只能游戏。优秀的男人固然值得珍惜，如果是挂上已婚的标签，记住这不是你能消费的起的，看看，然后不带一丝眷恋的离开。");
        picInfo12.setPicUrl("http://p2.wmpic.me/article/2017/08/16/1502864764_zhHNqfyE.jpg");
        mDatas.add(picInfo12);

        PicInfo picInfo13 = new PicInfo();
        picInfo13.setInfo("勿持才自傲，要虚怀若谷，勿卖弄口才，要多思慎言，勿拼命外显，要韬光养晦，勿高高在上，要保持低调，勿趾高气扬，要不显不炫，勿直来直去，要融方于圆，勿你争我斗，要远离是非，勿拿放不起，要能屈能伸，勿争破头颅，要有进有退。");
        picInfo13.setPicUrl("http://p3.wmpic.me/article/2017/08/16/1502864501_SEeINhuY.jpg");
        mDatas.add(picInfo13);

        PicInfo picInfo14 = new PicInfo();
        picInfo14.setInfo("人生最大的投资，不是房子，不是股票，是人，跟什么人交往，跟随什么人，交什么样的朋友是对人生影响最大的。");
        picInfo14.setPicUrl("http://p3.wmpic.me/article/2017/08/16/1502864501_xGUKCSut.jpg");
        mDatas.add(picInfo14);

        PicInfo picInfo15 = new PicInfo();
        picInfo15.setInfo("同样一件事情的发生，有的人感到非常痛苦，有的人能够接受。因为这两者的忍耐能力不同，有忍耐能力的人才容易成功。");
        picInfo15.setPicUrl("http://p3.wmpic.me/article/2017/08/16/1502864501_JJbwubXH.jpg");
        mDatas.add(picInfo15);

        PicInfo picInfo16 = new PicInfo();
        picInfo16.setInfo("时光静好，我站在季节的转角处，闭目遥想，你的身影在眼前浮现，还是那么忧郁的眼神，微微上扬的嘴角，那一抹暖心的微笑，这个时候我却感觉眼角有一丝冰凉，我知道，我又为你落泪了，我以为自己无休止的去忙一些事情，就会搁浅对你所有的回忆，殊不知，我的心又开始痛了，我又脆弱了，一个人的时候，终于还是熬不住了，没有你的天空，是如此寂寞。");
        picInfo16.setPicUrl("http://p3.wmpic.me/article/2017/08/01/1501571960_IQrcUXfj.jpg");
        mDatas.add(picInfo16);

        PicInfo picInfo17 = new PicInfo();
        picInfo17.setInfo("什么是爱上？一句话就可以解释，那就是离不开啊。不管是吵架也好，生气也好，困难也好。无论发生了什么，无论对方有什么缺点。就算你有万千种想要离开的理由，但就是离不开，那就是深深的爱上了。所以，当有人轻易的放弃，那就是不够爱你。因为越深的爱，就越是分不开。");
        picInfo17.setPicUrl("http://p3.wmpic.me/article/2017/08/01/1501571960_XWbKpCKx.jpg");
        mDatas.add(picInfo17);

        PicInfo picInfo18 = new PicInfo();
        picInfo18.setInfo("爱，如同一场两个人过水洼的游戏。每天都有大大小小的、明明暗暗的水洼，等着去趟去迈。为深爱的女人趟湿了鞋子的男人，一定是幸福的。被呵护的女人，也一定是幸福的。因为她亲眼看到了，真真切切的爱在脚下快乐飞溅着。");
        picInfo18.setPicUrl("http://p3.wmpic.me/article/2017/08/03/1501740563_HBvEWvax.jpg");
        mDatas.add(picInfo18);

        PicInfo picInfo19 = new PicInfo();
        picInfo19.setInfo("人们最害怕的是无常的变化，要学习适应环境的变化，在变化中另找创新，并不是停留在变化的痛苦中。");
        picInfo19.setPicUrl("http://p3.wmpic.me/article/2017/08/16/1502864501_CjvwLabt.jpg");
        mDatas.add(picInfo19);

        PicInfo picInfo20 = new PicInfo();
        picInfo20.setInfo("人们最害怕的是无常的变化，要学习适应环境的变化，在变化中另找创新，并不是停留在变化的痛苦中。");
        picInfo20.setPicUrl("http://p3.wmpic.me/article/2017/08/16/1502864501_CjvwLabt.jpg");
        mDatas.add(picInfo20);

        PicInfo picInfo21 = new PicInfo();
        picInfo21.setInfo("美丽的花虽然会凋谢，可是盛开的时刻值得欣赏。要在美好的时候创造出美好的东西，人生才会充满意义。");
        picInfo21.setPicUrl("http://p3.wmpic.me/article/2017/08/16/1502864501_yYzuXBrw.jpg");
        mDatas.add(picInfo21);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
