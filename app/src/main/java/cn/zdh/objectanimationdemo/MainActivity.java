package cn.zdh.objectanimationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout iv1;
    ImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1 = (LinearLayout) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);


    }


    //第一张图片动画
    public void t1(View view) {
        setAnim1();
    }

    private void setAnim1() {
        //翻转动画 (动画控件；        什么动画：动画名称 比如翻转动画为rotation，rotationY是X还是Y主要看动画以X为中心翻转还是Y；         翻转角度:从多到多少 顺时针为正逆时针为负）
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(iv1, "rotationX", 0f, 25f);
        rotationAnimator.setDuration(200);//动画必须设置时间；


        //透明度动画 (动画控件；        什么动画：动画名称 比如透明动画为alpha；         透明度:从多少到多少）
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(iv1, "alpha", 1f, 0.5f);
        alphaAnimator.setDuration(200);//动画必须设置时间；


        //缩放动画 (动画控件；        什么动画：动画名称 比如缩放动画为scaleX 和 scaleY；         缩放:从多少到多少）//1f为本身
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(iv1, "scaleX", 1f, 0.8f);
        scaleXAnimator.setDuration(300);//动画必须设置时间；

        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(iv1, "scaleY", 1f, 0.8f);
        scaleYAnimator.setDuration(300);//动画必须设置时间；


        //翻转动画 (动画控件；        什么动画：动画名称 比如翻转动画为rotation，rotationY是X还是Y主要看动画以X为中心翻转还是Y；         翻转角度:从多到多少 顺时针为正逆时针为负）
        ObjectAnimator UnRotationAnimator = ObjectAnimator.ofFloat(iv1, "rotationX", 25f, 0f);//0f为本身
        UnRotationAnimator.setDuration(200);//动画必须设置时间；
        UnRotationAnimator.setStartDelay(200);//延迟执行

        //平移动画 (动画控件；        什么动画：动画名称 比如平移动画为translation，rotationY是X还是Y主要看动画以X为中心翻转还是Y；         翻转角度:从多到多少 顺时针为正逆时针为负）
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(iv1, "translationY", 0f, -iv1.getHeight() * 0.1f);//因为缩放到0.8，剩下的0.2上下个占一半所以上移空间为0.1f
        translationYAnimator.setDuration(200);//动画必须设置时间；

        /**
         * 在最后动画执行完监听
         */
        translationYAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);

                setAnim2();

            }
        });


        //多个动画连续起来
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rotationAnimator, alphaAnimator, scaleXAnimator, scaleYAnimator, UnRotationAnimator, translationYAnimator);

        animatorSet.start();
    }

    /**
     * 动画
     */
    private void setAnim2() {
        iv2.setVisibility(View.VISIBLE);
        //平移动画 (动画控件；        什么动画：动画名称 比如平移动画为translation，rotationY是X还是Y主要看动画以X为中心翻转还是Y；         翻转角度:从多到多少 顺时针为正逆时针为负）
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(iv2, "translationY", iv2.getHeight() * 2f, -1f);//因为缩放到0.8，剩下的0.2上下个占一半所以上移空间为0.1f
        translationYAnimator.setDuration(500);//动画必须设置时间；
        translationYAnimator.start();
    }


    //第二张图片动画
    public void t2(View view) {
        setUnAnim2();
        setUnAnim1();

    }

    private void setUnAnim2() {
        //平移动画 (动画控件；        什么动画：动画名称 比如平移动画为translation，rotationY是X还是Y主要看动画以X为中心翻转还是Y；         翻转角度:从多到多少 顺时针为正逆时针为负）
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(iv2, "translationY", 1f, iv2.getHeight() * 2f);//因为缩放到0.8，剩下的0.2上下个占一半所以上移空间为0.1f
        translationYAnimator.setDuration(500);//动画必须设置时间；
        translationYAnimator.start();
    }

    private void setUnAnim1() {
        //翻转动画 (动画控件；        什么动画：动画名称 比如翻转动画为rotation，rotationY是X还是Y主要看动画以X为中心翻转还是Y；         翻转角度:从多到多少 顺时针为正逆时针为负）
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(iv1, "rotationX", 0f, -25f);
        rotationAnimator.setDuration(200);//动画必须设置时间；


        //透明度动画 (动画控件；        什么动画：动画名称 比如透明动画为alpha；         透明度:从多少到多少）
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(iv1, "alpha", 0.5f, 1f);
        alphaAnimator.setDuration(200);//动画必须设置时间；


        //缩放动画 (动画控件；        什么动画：动画名称 比如缩放动画为scaleX 和 scaleY；         缩放:从多少到多少）//1f为本身
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(iv1, "scaleX", 0.8f, 1f);
        scaleXAnimator.setDuration(300);//动画必须设置时间；

        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(iv1, "scaleY", 0.8f, 1f);
        scaleYAnimator.setDuration(300);//动画必须设置时间；


        //翻转动画 (动画控件；        什么动画：动画名称 比如翻转动画为rotation，rotationY是X还是Y主要看动画以X为中心翻转还是Y；         翻转角度:从多到多少 顺时针为正逆时针为负）
        ObjectAnimator UnRotationAnimator = ObjectAnimator.ofFloat(iv1, "rotationX", -25f, 0f);//0f为本身
        UnRotationAnimator.setDuration(200);//动画必须设置时间；
        UnRotationAnimator.setStartDelay(200);//延迟执行

        //平移动画 (动画控件；        什么动画：动画名称 比如平移动画为translation，rotationY是X还是Y主要看动画以X为中心翻转还是Y；         翻转角度:从多到多少 顺时针为正逆时针为负）
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(iv1, "translationY", 0f, -iv1.getHeight() * 0.1f);//因为缩放到0.8，剩下的0.2上下个占一半所以上移空间为0.1f
        translationYAnimator.setDuration(200);//动画必须设置时间；

        /**
         * 在最后动画执行完监听
         */
        translationYAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);

                setAnim2();

            }
        });


        //多个动画连续起来
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rotationAnimator, alphaAnimator, scaleXAnimator, scaleYAnimator, UnRotationAnimator, translationYAnimator);

        animatorSet.start();
    }


}
