package com.example.bestwishes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Message_Activity extends AppCompatActivity {
    private DatabaseReference ref,ref2;
    ImageButton next,prev,copy,share;
    TextView tvms,tvmsn;
    String ms,catNam,cms;
    long count,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_);
        next=findViewById(R.id.btn_next);
        prev=findViewById(R.id.btn_prev);
        copy=findViewById(R.id.btn_copy);
        share=findViewById(R.id.btn_share);
        tvms=findViewById(R.id.tv_message);
        tvmsn=findViewById(R.id.tv_mesnum);
        tvmsn.setText("1");
        catNam=getIntent().getStringExtra("cat_nam");
        c=1;
        ref= FirebaseDatabase.getInstance().getReference().child(catNam);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //String id=dataSnapshot.child("Id").getValue().toString();
                count=dataSnapshot.getChildrenCount();
                //ms=dataSnapshot.child("1").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref= FirebaseDatabase.getInstance().getReference().child(catNam).child("1");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //String id=dataSnapshot.child("Id").getValue().toString();
                //count=dataSnapshot.getChildrenCount();
                ms=dataSnapshot.getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        cms= String.valueOf(count);
        tvmsn.setText("1/"+cms);
        tvms.setText(ms);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=c+1;
                if(c<=count) {

                    final String nm = String.valueOf(c);
                    ref = FirebaseDatabase.getInstance().getReference().child(catNam);
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            //String id=dataSnapshot.child("Id").getValue().toString();
                            //count=dataSnapshot.getChildrenCount();
                            ms = dataSnapshot.child(nm).getValue().toString();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                    tvmsn.setText(c + "/" + count);
                    tvms.setText(ms);
                }
                else{
                    c=c-1;
                }
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=c-1;
                if(c>=1) {
                    final String nm = String.valueOf(c);
                    Log.d("Ms",c+"  "+nm);
                    ref = FirebaseDatabase.getInstance().getReference().child(catNam);
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            //String id=dataSnapshot.child("Id").getValue().toString();
                            //count=dataSnapshot.getChildrenCount();
                            ms = dataSnapshot.child(nm).getValue().toString();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    tvmsn.setText(c + "/" + count);
                    tvms.setText(ms);
                }
                else{
                    c=c+1;
                }
            }
        });
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
