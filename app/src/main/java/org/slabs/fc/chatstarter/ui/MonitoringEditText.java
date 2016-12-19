package org.slabs.fc.chatstarter.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class MonitoringEditText extends EditText {
    private final Context mContext;

    public MonitoringEditText(Context context) {
        super(context);
        this.mContext = context;
    }

    public MonitoringEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public MonitoringEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public boolean onTextContextMenuItem(int i) {

        return super.onTextContextMenuItem(i);
    }
}
