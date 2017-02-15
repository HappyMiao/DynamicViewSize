package com.dynamicviewsize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.imageloder.ImageLoader;

/**
 * @className: MainActivity
 * @classDescription: 根据后台返回的模板宽高比来动态设置模板高度
 * @author: miao
 * @createTime: 2017年2月15日
 */
public class MainActivity extends AppCompatActivity {

    //第一个模板
    private LinearLayout ll_model_one;
    //第二个模板
    private LinearLayout ll_model_two;
    //图片1
    private ImageView img1;
    //图片2
    private ImageView img2;
    //图片3
    private ImageView img3;
    //图片4
    private ImageView img4;
    //图片5
    private ImageView img5;
    //图片6
    private ImageView img6;
    //img url
    private String URL1 = "http://img.mbp.jianke.com/248a0ccff3d749a9d5408aa75e985067?q=";
    private String URL2 = "http://img.mbp.jianke.com/257ad3efb08d87b9e85354886ccd7dcd?q=";
    private String URL3 = "http://img.mbp.jianke.com/209fd3ec49998796246f9f0c1b705eff?q=";
    //模板宽高比
    private double ratio = 2.544;
    //屏幕宽
    private double screenWidth = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取屏幕宽度
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        //加载布局，并计算模板高度
        initView();
        //加载图片
        laodImg();
    }

    /**
     * laodImg 加载图片
     * @author miao
     * @createTime 2017年2月15日
     * @lastModify 2017年2月15日
     * @param
     * @return
     */
    private void laodImg() {
        ImageLoader.getInstance().load(this,img1,URL1);
        ImageLoader.getInstance().load(this,img2,URL2);
        ImageLoader.getInstance().load(this,img3,URL3);
        ImageLoader.getInstance().load(this,img4,URL1);
        ImageLoader.getInstance().load(this,img5,URL2);
        ImageLoader.getInstance().load(this,img6,URL3);
    }

    /**
     * initView
     * @author miao
     * @createTime 2017年2月15日
     * @lastModify 2017年2月15日
     * @param
     * @return
     */
    private void initView() {
        ll_model_one = (LinearLayout) findViewById(R.id.ll_model_one);
        ll_model_two = (LinearLayout) findViewById(R.id.ll_model_two);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);
        img6 = (ImageView) findViewById(R.id.img6);

        //计算并设置模板高度
        changeTemplateHeight(ll_model_two);
    }

    /**
     * changeTemplateHeight 动态计算并设置模板高度
     * @author miao
     * @createTime 2017年2月15日
     * @lastModify 2017年2月15日
     * @param
     * @return
     */
    public void changeTemplateHeight(LinearLayout layout){
        //计算模板高度
        double screenHeight = screenWidth / ratio;
        System.out.println("changeTemplateHeight screenHeight ="+screenHeight+"  screenWidth = "
                +screenWidth+"  ratio = " +ratio+"  int height = "+(int)screenHeight);
        //设置模板高度
        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) layout.getLayoutParams();
        params.height= (int) screenHeight;
        layout.setLayoutParams(params);
    }
}
