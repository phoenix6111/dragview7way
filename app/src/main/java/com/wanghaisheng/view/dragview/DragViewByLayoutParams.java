package com.wanghaisheng.view.dragview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: sheng on 2016/11/7 19:07
 * Email: 1392100700@qq.com
 */

public class DragViewByLayoutParams extends View {

    private int mLastX;
    private int mLastY;

    public DragViewByLayoutParams(Context context) {
        this(context,null);
    }

    public DragViewByLayoutParams(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DragViewByLayoutParams(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                mLastX = x;
                mLastY = y;
                break;

            case MotionEvent.ACTION_MOVE:

                int offsetX = x - mLastX;
                int offsetY = y - mLastY;

                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);
                break;

        }

        return true;
    }
}
