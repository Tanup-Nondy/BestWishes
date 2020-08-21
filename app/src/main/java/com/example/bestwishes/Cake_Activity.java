package com.example.bestwishes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Cake_Activity extends AppCompatActivity {
    Typeface c1,c2,c3,c4,c5,c6,ch1,ch2,h1,l1,l2,l3,s1,s2,s3,s4,s5;
    Button b1,b2,b3,b4,b5,b6,b7,b8,draw;
    ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8;
    EditText et;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_);
        c1=Typeface.createFromAsset(getAssets(),"fonts/cake1.ttf");
        c2=Typeface.createFromAsset(getAssets(),"fonts/cake2.ttf");
        c3=Typeface.createFromAsset(getAssets(),"fonts/cake3.ttf");
        c4=Typeface.createFromAsset(getAssets(),"fonts/cake4.TTF");
        c5=Typeface.createFromAsset(getAssets(),"fonts/cake5.ttf");
        c6=Typeface.createFromAsset(getAssets(),"fonts/cake6.ttf");
        ch1=Typeface.createFromAsset(getAssets(),"fonts/christmas1.ttf");
        ch2=Typeface.createFromAsset(getAssets(),"fonts/christmas2.ttf");
        h1=Typeface.createFromAsset(getAssets(),"fonts/heart1.ttf");
        l1=Typeface.createFromAsset(getAssets(),"fonts/love1.ttf");
        l2=Typeface.createFromAsset(getAssets(),"fonts/love2.ttf");
        l3=Typeface.createFromAsset(getAssets(),"fonts/love3.otf");
        s1=Typeface.createFromAsset(getAssets(),"fonts/spiral1.ttf");
        s2=Typeface.createFromAsset(getAssets(),"fonts/spiral2.ttf");
        s3=Typeface.createFromAsset(getAssets(),"fonts/spiral3.ttf");
        s4=Typeface.createFromAsset(getAssets(),"fonts/spiral6.ttf");
        s5=Typeface.createFromAsset(getAssets(),"fonts/spriral2.ttf");
        //TextView tv=findViewById(R.id.tv_h1);
       // tv.setTypeface(c1);
        iv1=findViewById(R.id.imview1);
        iv2=findViewById(R.id.imview2);
        iv3=findViewById(R.id.imview3);
        iv4=findViewById(R.id.imview4);
        iv5=findViewById(R.id.imview5);
        iv6=findViewById(R.id.imview6);
        iv7=findViewById(R.id.imview7);
        iv8=findViewById(R.id.imview8);
        draw=findViewById(R.id.btn_draw);
        b1=findViewById(R.id.btn_share1);
        b2=findViewById(R.id.btn_share2);
        b3=findViewById(R.id.btn_share3);
        b4=findViewById(R.id.btn_share4);
        b5=findViewById(R.id.btn_share5);
        b6=findViewById(R.id.btn_share6);
        b7=findViewById(R.id.btn_share7);
        b8=findViewById(R.id.btn_share8);
        et=findViewById(R.id.et_name);
        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=et.getText().toString();
                Bitmap img1 = BitmapFactory.decodeResource(getResources(), R.drawable.b1).copy(Bitmap.Config.ARGB_8888, true);
                Bitmap img2 = BitmapFactory.decodeResource(getResources(), R.drawable.b3).copy(Bitmap.Config.ARGB_8888, true);
                Bitmap img3 = BitmapFactory.decodeResource(getResources(), R.drawable.b10).copy(Bitmap.Config.ARGB_8888, true);
                Bitmap img4 = BitmapFactory.decodeResource(getResources(), R.drawable.b11).copy(Bitmap.Config.ARGB_8888, true);
                Bitmap img5 = BitmapFactory.decodeResource(getResources(), R.drawable.bday6).copy(Bitmap.Config.ARGB_8888, true);
                Bitmap img6 = BitmapFactory.decodeResource(getResources(), R.drawable.bday7).copy(Bitmap.Config.ARGB_8888, true);
                Bitmap img7 = BitmapFactory.decodeResource(getResources(), R.drawable.bday9).copy(Bitmap.Config.ARGB_8888, true);
                Bitmap img8 = BitmapFactory.decodeResource(getResources(), R.drawable.bday14).copy(Bitmap.Config.ARGB_8888, true);
                Canvas canvas1 = new Canvas(img1);
                Canvas canvas2 = new Canvas(img2);
                Canvas canvas3 = new Canvas(img3);
                Canvas canvas4 = new Canvas(img4);
                Canvas canvas5 = new Canvas(img5);
                Canvas canvas6 = new Canvas(img6);
                Canvas canvas7 = new Canvas(img7);
                Canvas canvas8 = new Canvas(img8);
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setTextSize(getResources().getDimension(R.dimen.twenty));
                paint.setColor(getResources().getColor(android.R.color.white));
                paint.setTypeface(c1);
                //canvas.rotate(270);
                //canvas1.drawText("Happy", 122, img1.getHeight() - 10, paint);
                canvas1.drawText("Happy", 250, 275, paint);
                canvas1.drawText("BirthDay", 280, 315, paint);
                canvas1.drawText(name, 290, 355, paint);
                iv1.setImageBitmap(img1);

                paint.setTextSize(getResources().getDimension(R.dimen.thirty));
                paint.setTypeface(c2);
                canvas7.drawText("Happy", 250, 275, paint);
                canvas7.drawText("Birthday", 260, 315, paint);
                canvas7.drawText(name, 270, 355, paint);
                iv7.setImageBitmap(img7);

                paint.setColor(getResources().getColor(R.color.chocolate));
                paint.setTypeface(ch2);
                canvas3.drawText("H.B.D", 255, 100, paint);
                canvas3.drawText(name, 265, 410, paint);
                iv3.setImageBitmap(img3);

                paint.setColor(getResources().getColor(android.R.color.white));
                paint.setTypeface(ch1);
                paint.setTextSize(getResources().getDimension(R.dimen.thirty));
                canvas8.drawText("Happy", 215, 230, paint);
                canvas8.drawText("Birthday", 250, 280, paint);
                canvas8.drawText(name, 290, 330, paint);
                iv8.setImageBitmap(img8);

                paint.setTextSize(getResources().getDimension(R.dimen.thirty));
                paint.setColor(getResources().getColor(R.color.chocolate));
                paint.setTypeface(ch2);
                canvas2.drawText("Happy", 240, 290, paint);
                canvas2.drawText("Birthday", 250, 340, paint);
                canvas2.drawText(name, 270, 380, paint);
                iv2.setImageBitmap(img2);

                paint.setTypeface(ch2);
                canvas4.drawText("H.B.D", 260, 330, paint);
                canvas4.drawText(name, 280, 390, paint);
                iv4.setImageBitmap(img4);

                paint.setColor(getResources().getColor(android.R.color.holo_blue_dark));
                paint.setTypeface(ch2);
                canvas5.drawText(name, 370, 350, paint);
                iv5.setImageBitmap(img5);

                paint.setColor(getResources().getColor(android.R.color.holo_red_light));
                paint.setTypeface(ch2);
                canvas6.drawText(name, 250, 320, paint);
                iv6.setImageBitmap(img6);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
