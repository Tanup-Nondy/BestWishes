package com.example.bestwishes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShowMessage_Activity extends AppCompatActivity {
    private RecyclerView rv;
    private DatabaseReference ref;
    Button copy,share;
    String ms,catNam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message_);
        catNam=getIntent().getStringExtra("cat_nam");
        ref= FirebaseDatabase.getInstance().getReference().child(catNam);
        ref.keepSynced(true);
        rv=findViewById(R.id.rv_sms);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<Message_Model> options =
                new FirebaseRecyclerOptions.Builder<Message_Model>()
                        .setQuery(ref, Message_Model.class)
                        .build();
        FirebaseRecyclerAdapter<Message_Model,MessageViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Message_Model, MessageViewHolder>
                (options) {

            @Override
            protected void onBindViewHolder(@NonNull MessageViewHolder holder, int position, @NonNull Message_Model model) {
                holder.setMessage(model.getMessage());
            }

            @NonNull
            @Override
            public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout,parent,false);
                return new MessageViewHolder(view);
            }
        };
        firebaseRecyclerAdapter.startListening();
        rv.setAdapter(firebaseRecyclerAdapter);

    }
    public  class MessageViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            mView=itemView;
        }
        public void setMessage(String msg){
            final TextView tvms=mView.findViewById(R.id.tv_msg);
            tvms.setText(msg);
            Button copy=mView.findViewById(R.id.btn_copy);
            Button share=mView.findViewById(R.id.btn_share);
            copy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text=tvms.getText().toString();
                    ClipboardManager cm=(ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                    ClipData clipData=ClipData.newPlainText("Data",text);
                    cm.setPrimaryClip(clipData);
                    Toast.makeText(getApplicationContext(),"Message copied to clipboard!",Toast.LENGTH_SHORT).show();
                }
            });
            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text=tvms.getText().toString();
                    Intent share=new Intent();
                    share.setAction(Intent.ACTION_SEND);
                    share.putExtra(Intent.EXTRA_TEXT,text);
                    share.setType("text/plain");
                    startActivity(share);
                }
            });
        }
    }

}
