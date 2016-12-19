package org.slabs.fc.chatstarter.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import org.slabs.fc.chatstarter.R;
import org.slabs.fc.chatstarter.adapter.ChatMessageAdapter;
import org.slabs.fc.chatstarter.model.ChatMessage;
import org.slabs.fc.chatstarter.ui.MonitoringEditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView mChatMessagesRecyclerView;
    private ChatMessageAdapter mChatMessageAdapter;

    private MonitoringEditText mChatEditText;
    private ImageButton mEmoImageButton, mSendImageButton ;

    private List<ChatMessage> mMessageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (initChatBarUI()){
            mSendImageButton.setOnClickListener(MainActivity.this);
            mEmoImageButton.setOnClickListener(MainActivity.this);
        }

        mMessageList = new CopyOnWriteArrayList<>();

        mChatMessagesRecyclerView = (RecyclerView) findViewById(R.id.chat_msg_rv);
        mChatMessagesRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mChatMessageAdapter = new ChatMessageAdapter(MainActivity.this, mMessageList);
        mChatMessagesRecyclerView.setAdapter(mChatMessageAdapter);


    }

    private boolean initChatBarUI(){
        try{
            mChatEditText = (MonitoringEditText) findViewById(R.id.chat_edit_text);
            mEmoImageButton = (ImageButton) findViewById(R.id.chat_emoticon_button);
            mSendImageButton = (ImageButton) findViewById(R.id.chat_send_button);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.chat_send_button : {
                generateDummyMsg();
            }case R.id.chat_emoticon_button : {
                Snackbar.make(view, "Not Yet implemented...", Snackbar.LENGTH_SHORT);
            }
        }
    }

    private void generateDummyMsg() {
        try {
            if (mChatEditText.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "Message can not be empty...", Toast.LENGTH_SHORT).show();
            } else {
                mMessageList.add(new ChatMessage(mChatEditText.getText().toString(), sentDate(new Date())));
                mChatMessageAdapter.notifyDataSetChanged();
                mChatEditText.setText("");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String sentDate(Date date){
        DateFormat inputFormatter1 = new SimpleDateFormat("HH:mm");
        return inputFormatter1.format(date);
    }
}
