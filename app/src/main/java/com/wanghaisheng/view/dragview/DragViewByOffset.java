package com.wanghaisheng.view.dragview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Author: sheng on 2016/11/7 16:16
 * Email: 1392100700@qq.com
 */

public class DragViewByOffset extends View {

    private int mLastX;
    private int mLastY;


    public DragViewByOffset(Context context) {
        super(context,null);
    }

    public DragViewByOffset(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DragViewByOffset(Context context, AttributeSet attrs, int defStyleAttr) {
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

                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);

                break;

        }

        return true;
    }
}
