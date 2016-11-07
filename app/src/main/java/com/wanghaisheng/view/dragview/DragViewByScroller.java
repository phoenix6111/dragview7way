package com.wanghaisheng.view.dragview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Author: sheng on 2016/11/7 22:18
 * Email: 1392100700@qq.com
 */

public class DragViewByScroller extends View {

    private Scroller mScroller;
    private int mLastX;
    private int mLastY;

    public DragViewByScroller(Context context) {
        this(context,null);
    }

    public DragViewByScroller(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DragViewByScroller(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mScroller = new Scroller(context);

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

                ((View)getParent()).scrollBy(-offsetX,-offsetY);

                break;

            case MotionEvent.ACTION_UP:
                View parent = (View) getParent();
                mScroller.startScroll(parent.getScrollX(),parent.getScrollY(),
                        -parent.getScrollX(),-parent.getScrollY(),1000);

                invalidate();
                break;

        }

        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();

        if(mScroller.computeScrollOffset()) {

            ((View)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());

            invalidate();

        }
    }
}
