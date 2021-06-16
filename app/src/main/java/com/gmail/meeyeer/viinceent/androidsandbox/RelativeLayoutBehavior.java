package com.gmail.meeyeer.viinceent.androidsandbox;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;

public class RelativeLayoutBehavior extends CoordinatorLayout.Behavior<RelativeLayout> {

    public RelativeLayoutBehavior(Context context, AttributeSet attrs) {
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        child.setTranslationY(translationY);
        return true;
    }

//    @Override
//    public boolean onInterceptTouchEvent(CoordinatorLayout parent, RelativeLayout child,
//                                         MotionEvent ev) {
//        return !(parent != null && child != null && ev != null)
//                || super.onInterceptTouchEvent(parent, child, ev);
//    }

}