package org.slabs.fc.chatstarter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import org.slabs.fc.chatstarter.R;
import org.slabs.fc.chatstarter.holder.ThemMessageHolder;
import org.slabs.fc.chatstarter.holder.ViewHolder;
import org.slabs.fc.chatstarter.model.ChatMessage;

import java.util.List;

public class ChatMessageAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<ChatMessage> mMessageList;
    private Context mContext;
    private boolean isMe = false;
    public ChatMessageAdapter(Context mContext, List<ChatMessage> mMessageList){
        this.mContext = mContext;
        this.mMessageList = mMessageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = View.inflate(mContext, R.layout.chat_them_container, null);
        return new ThemMessageHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ThemMessageHolder messageHolder = (ThemMessageHolder) holder;
        messageHolder.mMessageTextView.setText(mMessageList.get(position).getMessage());
        messageHolder.mSentAtTextView.setText(mMessageList.get(position).getSentAt());
        Log.e("MSG_TEXT", mMessageList.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    public void clearData() {
        mMessageList.clear(); //clear list
        this.notifyDataSetChanged();
    }
}
