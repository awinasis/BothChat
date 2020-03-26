package com.example.bothchat;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import id.ac.polinema.bothchat.R;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private View btnSend;
    private EditText editText;
    boolean myMessage = true;
    private List<Chat> ChatBubbles;
    private ArrayAdapter<Chat> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChatBubbles = new ArrayList<>();

        listView = (ListView) findViewById(R.id.message_list);
        btnSend = findViewById(R.id.btn_send_chat);
        editText = (EditText) findViewById(R.id.enter_msg);

        //set ListView adapter first
        adapter = new MessageAdapter(this, R.layout.item_message_received, ChatBubbles);
        listView.setAdapter(adapter);

        //event for button SEND
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Input your message !", Toast.LENGTH_SHORT).show();
                } else {
                    //add message to list
                    Chat ChatBubble = new Chat(editText.getText().toString(), true);
                    ChatBubbles.add(ChatBubble);

                    Chat ChatBubble2 = new Chat("OKE SAYANGKU", false );
                    ChatBubbles.add(ChatBubble2);

                    adapter.notifyDataSetChanged();
                    editText.setText("");
                    if (myMessage) {
                        myMessage = false;
                    } else {
                        myMessage = true;
                    }
                }
            }
        });
    }
}
