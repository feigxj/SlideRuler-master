package com.jack.slideruler;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.view.View.generateViewId;

public class MainActivity extends Activity {

    private SlideRuler slideruler;
    private TextView data_tv;
    private TextView _tv;
    private TextView actionBar;
    private Button btn;
    private Mview mview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initView();
//        return;
//        slideruler = (SlideRuler) findViewById(R.id.slideruler);
//        mview = (Mview) findViewById(R.id.mview);
//        data_tv = (TextView) findViewById(R.id.data);
//        _tv = (TextView) findViewById(R.id.tv);
//        actionBar = (TextView) findViewById(R.id.actionBar);
//        btn = (Button) findViewById(R.id.btn);
//        slideruler.setSlideRulerDataInterface(new SlideRulerDataInterface() {
//            @Override
//            public void getText(String data) {
//                data_tv.setText(data);
//            }
//        });
//        for (int i = 0; i < 15; i++) {
//            TextView textView = new TextView(this);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.WRAP_CONTENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT);
//            textView.setText("你好" + i);
//            mview.addView(textView, params);
//        }


//        _tv.postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                StringBuilder sb = new StringBuilder();
//
//                //状态栏方法1
//                Rect frame = new Rect();
//                getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
//                int statusBarHeight = frame.top;
//
//                //获取文字高度
//                int textHeight = actionBar.getMeasuredHeight();
//
//
//                //标题栏包括状态栏
//                int contentTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
//                //statusBarHeight是上面所求的状态栏的高度
//                int titleBarHeight = contentTop - statusBarHeight;
//
//                sb.append("0.状态栏高度:" + getStatusBarHeight() + "\n");
//                sb.append("1.状态栏高度:" + statusBarHeight + "\n");
//                sb.append("标题栏高度(不包括状态栏，过时了):" + titleBarHeight + "\n");
////                sb.append("ActionBar高度:" + getSupportActionBar().getHeight() + "\n");//android.support.v7.app.AppCompatActivity包下的
//
//                sb.append("1.textview高度:" + actionBar.getMeasuredHeight() + "\n");//在设置了文字之后是一样的
//                sb.append("2.textview高度:" + actionBar.getHeight() + "\n");
//
//                sb.append("父控件相对于它的父控件左上角位置:");
//                sb.append(((ViewGroup) _tv.getParent()).getLeft() + "," + ((ViewGroup) _tv.getParent()).getTop() + "\n");
//                sb.append("\n当前控件在相对父控件左上角位置:" + _tv.getLeft() + "," + _tv.getTop() + "\n");
//                int[] loc1 = new int[2];
//                int[] loc2 = new int[2];
//                _tv.getLocationInWindow(loc1);//控件相对于窗口左上角位置，只有在弹出对话框中有区别
//                _tv.getLocationOnScreen(loc2);//控件相对于屏幕左上角位置,
//                sb.append("\n当前控件相对于窗口左上角位置");
//                sb.append("\ngetLocationInWindow" + "(" + loc1[0] + "," + loc1[1] + ")\n");
//                sb.append("\n当前控件相对于屏幕左上角位置");
//                sb.append("\ngetLocationOnScreen" + "(" + loc2[0] + "," + loc2[1] + ")\n");
//
//
//                _tv.setText(sb.toString());
//            }
//        }, 5000);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                final TextView tv = new TextView(MainActivity.this);
//                builder.setView(tv);
//                builder.create().show();
//                /**
//                 * View.getLocationInWindow()和
//                 * View.getLocationOnScreen()在window占据全部screen时，返回值相同，
//                 * 不同的典型情况是在Dialog中时。
//                 * 当Dialog出现在屏幕中间时，
//                 * View.getLocationOnScreen()取得的值要比View.getLocationInWindow()取得的值要大。
//                 */
//                tv.postDelayed(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        // TODO Auto-generated method stub
//                        StringBuilder SB = new StringBuilder();
//                        int[] loc1 = new int[2];
//                        int[] loc2 = new int[2];
//                        tv.getLocationInWindow(loc1);
//                        tv.getLocationOnScreen(loc2);
//                        SB.append("当前控件相对于窗口左上角位置");
//                        SB.append("\ngetLocationInWindow" + "(" + loc1[0] + "," + loc1[1] + ")\n");
//                        SB.append("\n当前控件相对于屏幕左上角位置");
//                        SB.append("\ngetLocationOnScreen" + "(" + loc2[0] + "," + loc2[1] + ")\n");
//                        tv.setText(SB.toString());
//                    }
//                }, 1000);
//            }
//        });
    }

    private void initView() {
        initParent(initLinearLayout(), initRelativeLayout());

    }

    /**
     * 添加
     *
     * @param view
     */
    private void initParent(View... view) {
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.BLACK);

        LinearLayout.MarginLayoutParams layoutParams = new LinearLayout.MarginLayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(0, 50, 0, 0);//源头的父控件不能设置margin
        layout.setLayoutParams(layoutParams);
        layout.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < view.length; i++) {
            layout.addView(view[i]);
        }

        setContentView(layout);


    }

    /**
     * 父布局是linear
     */
    private LinearLayout initLinearLayout() {
        //子控件
        Button button = new Button(this);
        button.setText("我是按钮(线性)");
        button.setId(generateViewId());

        TextView textView = new TextView(this);
        textView.setText("我是文字(线性)");
        textView.setBackgroundColor(Color.WHITE);
        textView.setId(generateViewId());
        //父布局
        LinearLayout linearLayout = new LinearLayout(this);
        //设置属性
        linearLayout.setBackgroundColor(Color.RED);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        //设置父控件尺寸
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                200);
        layoutParams.setMargins(0, 50, 0, 0);
        //控件自身内容的，layout_gravity相对于父控件的位置
        layoutParams.gravity = Gravity.CENTER_VERTICAL;
        linearLayout.setLayoutParams(layoutParams);
        //父控件内边距
        linearLayout.setPadding(50, 0, 0, 0);
        //设置button 的布局参数
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.MATCH_PARENT);
        buttonParams.weight = 1;
        //设置textview的布局参数
        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        //设置textview宽度
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());

        textView.setWidth(px);
        //添加
        linearLayout.addView(button, buttonParams);
        linearLayout.addView(textView, textParams);

        return linearLayout;
    }

    /**
     * 相对布局
     *
     * @return
     */
    private RelativeLayout initRelativeLayout() {
        //子控件
        Button button = new Button(this);
        button.setText("我是按钮(相对布局)");
        button.setId(generateViewId());

        TextView textView = new TextView(this);
        textView.setText("我是文字(相对布局)");
        textView.setBackgroundColor(Color.YELLOW);
        textView.setId(generateViewId());

        //父布局
        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setBackgroundColor(Color.GRAY);
        //设置父布局参数
        RelativeLayout.LayoutParams relayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        //设置Button的布局参数
        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);

        //设置TextView的布局参数
        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.RIGHT_OF, button.getId());
//        textParams.setMargins(120, 0, 0, 0);
        textParams.addRule(RelativeLayout.CENTER_VERTICAL);
        //相对于父控件的位置
        textParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        //将布局添加到父容器中
        myLayout.removeAllViews();
        myLayout.setPadding(20, 20, 20, 20);
        //一个控件只能add到一个控件上
        myLayout.addView(button, buttonParams);
        myLayout.addView(textView, textParams);

        return myLayout;

    }

    private ViewGroup.MarginLayoutParams getLayoutParams(View view) {
        if (view.getLayoutParams() instanceof ViewGroup.LayoutParams) {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            return params;
        }
        return null;

    }

    /**
     * 获取状态栏高度——方法1
     */

    private int getStatusBarHeight() {

        int statusBarHeight1 = -1;
        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight1;

    }

    /**
     * 获得屏幕高度
     *
     * @return
     */
    private int getDensityHeight(Context context) {
        Display display = ((WindowManager) context.
                getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        //屏幕宽高
        int wrapcontentWidth = display.getWidth();

        int wrapcontentHeight = display.getHeight();
        return wrapcontentHeight;
    }

    /**
     * 获得屏幕高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        int wrapcontentHeight = outMetrics.heightPixels;
        int wrapcontentWidth = outMetrics.widthPixels;
        return wrapcontentHeight;
    }

}
