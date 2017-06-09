package com.jack.slideruler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Edit date 2017/5/18
 * Author:lifei
 * Description:
 */
public class Mview extends ViewGroup {
    public Mview(Context context) {
        this(context, null);
    }

    public Mview(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Mview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        drawText(canvas);
    }

    private void drawText(Canvas canvas) {
        String text = "你好世界";
//        int baseLineY = (int) TypedValue.applyDimension(
//                TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        int baseLineX = 0;
        int baseLineY = 100;

        //设置paint
        Paint paint = new Paint();
        paint.setTextSize(120); //以px为单位
        paint.setTextAlign(Paint.Align.LEFT);

        //画text所占的区域
        Paint.FontMetricsInt fm = paint.getFontMetricsInt();
        int top = baseLineY + fm.top;
        int bottom = baseLineY + fm.bottom;
        int width = (int) paint.measureText(text);
        Rect rect = new Rect(baseLineX, top, baseLineX + width, bottom);

        paint.setColor(Color.GREEN);
        canvas.drawRect(rect, paint);

        //画最小矩形
        Rect minRect = new Rect();
        paint.getTextBounds(text, 0, text.length(), minRect);
        minRect.top = baseLineY + minRect.top;
        minRect.bottom = baseLineY + minRect.bottom;
        paint.setColor(Color.RED);
        canvas.drawRect(minRect, paint);

        //写文字
        paint.setColor(Color.BLACK);
        canvas.drawText(text, baseLineX, baseLineY, paint);
        System.out.println("-----------------------" + fm.bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(),
                widthMeasureSpec), getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();
        int childMeasureWidth = 0;
        int childMeasureHeight = 0;
        int layoutWidth = 0;//初始值,子控件总宽度
        int layoutHeight = 0;
        int maxChildHeight = 0;
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            childMeasureWidth = child.getMeasuredWidth();
            childMeasureHeight = child.getMeasuredHeight();
            //如果一行没有排满，继续往右排列
            if (layoutWidth < getWidth()) {
                l = layoutWidth;
                r = l + childMeasureWidth;
                t = childMeasureHeight;
                b = t + childMeasureHeight;
                System.out.println("--------111111111111");
            } else {
                l = 0;
                layoutHeight += maxChildHeight;
                maxChildHeight = 0;

                l = layoutWidth;
                r = l + childMeasureWidth;
                t = layoutHeight;
                b = t + childMeasureHeight;
                System.out.println("--------222222222");
            }
            layoutWidth += childMeasureWidth;//宽度累加
            if (childMeasureHeight > maxChildHeight) {
                maxChildHeight = childMeasureHeight;
            }
            child.layout(l, t, r, b);
        }

    }

}
