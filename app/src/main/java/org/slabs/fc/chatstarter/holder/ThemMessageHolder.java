package org.slabs.fc.chatstarter.holder;

import android.view.View;
import android.widget.TextView;

import org.slabs.fc.chatstarter.R;
import org.slabs.fc.chatstarter.ui.ChatThemTextView;

public class ThemMessageHolder extends ViewHolder {

    public TextView mTitleTexView, mSentAtTextView;
    public ChatThemTextView mMessageTextView;
    
    public ThemMessageHolder(View itemView) {
        super(itemView);
        mTitleTexView = (TextView) itemView.findViewById(R.id.chat_title);
        mMessageTextView = (ChatThemTextView) itemView.findViewById(R.id.chat_text);
        mSentAtTextView = (TextView) itemView.findViewById(R.id.chat_time);
    }
}