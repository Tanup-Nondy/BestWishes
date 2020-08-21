package com.example.bestwishes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Options_Activity extends AppCompatActivity {
    String ms;
    Button anvs;
    ImageButton anv,bir,bro,coup,fri,fun,gf,hus,mar,par,pro,sis;
    DatabaseReference ref,ref2;
    long count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_);
        //((MainActivity)getApplicationContext()).setActionBarTitle("Home");
        getSupportActionBar().setTitle("Message Options");
        anvs=findViewById(R.id.iv_Anniversary);
        bir=findViewById(R.id.iv_Birthday);
        bro=findViewById(R.id.iv_Brother);
        coup=findViewById(R.id.iv_Couple);
        fri=findViewById(R.id.iv_Friends);
        fun=findViewById(R.id.iv_Funny);
        gf=findViewById(R.id.iv_GF);
        hus=findViewById(R.id.iv_Husband);
        mar=findViewById(R.id.iv_Marriage);
        par=findViewById(R.id.iv_Parents);
        sis=findViewById(R.id.iv_Sister);
        pro=findViewById(R.id.iv_Propose);
        anvs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ShowMessage_Activity.class);
                i.putExtra("cat_nam","Anniversary");
                startActivity(i);
            }
        });
        bir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ShowMessage_Activity.class);
                i.putExtra("cat_nam","Birthday");
                startActivity(i);
            }
        });
        bro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ShowMessage_Activity.class);
                i.putExtra("cat_nam","Brother");
                startActivity(i);
            }
        });
        coup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ShowMessage_Activity.class);
                i.putExtra("cat_nam","Couple");
                startActivity(i);

            }
        });
        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ShowMessage_Activity.class);
                i.putExtra("cat_nam","Friends");
                startActivity(i);

            }
        });
        fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ShowMessage_Activity.class);
                i.putExtra("cat_nam","Funny");
                startActivity(i);

            }
        });
        gf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ShowMessage_Activity.class);
                i.putExtra("cat_nam","Gf");
                startActivity(i);

            }
        });
        hus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ShowMessage_Activity.class);
                i.putExtra("cat_nam","Husband");
                startActivity(i);

            }
        });
        mar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ShowMessage_Activity.class);
                i.putExtra("cat_nam","Marriage");
                startActivity(i);

            }
        });
        par.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ShowMessage_Activity.class);
                i.putExtra("cat_nam","Parent");
                startActivity(i);

            }
        });
        sis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ShowMessage_Activity.class);
                i.putExtra("cat_nam","Sister");
                startActivity(i);

            }
        });
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ShowMessage_Activity.class);
                i.putExtra("cat_nam","Propose");
                startActivity(i);

            }
        });
    }
    /*public void OpenActivity(String dname){
        ref= FirebaseDatabase.getInstance().getReference().child(dname);
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                count=dataSnapshot.getChildrenCount();
                ms=dataSnapshot.child("1").getValue().toString();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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
        ref2=FirebaseDatabase.getInstance().getReference().child(dname).child("1");
        ref2.addValueEventListener(new ValueEventListener() {
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
        String s=String.valueOf(count);
        Intent i=new Intent(getApplicationContext(), ShowMessage_Activity.class);
        i.putExtra("cat_nam","Anniversary");
        i.putExtra("ms",ms);
        i.putExtra("count",s);
        startActivity(i);
    }*/
}
