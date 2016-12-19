package org.slabs.fc.chatstarter.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Arshay on 12/18/2016.
 */
public class ChatThemTextView extends TextView {

    public ChatThemTextView(Context context) {
        super(context);
    }

    public ChatThemTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChatThemTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        ViewGroup.MarginLayoutParams margins = ViewGroup.MarginLayoutParams.class.cast(getLayoutParams());
        int margin = 15;
        margins.topMargin = margin;
        margins.bottomMargin = margin;
        margins.leftMargin = margin;
        margins.rightMargin = margin;
        setLayoutParams(margins);
    }
}
