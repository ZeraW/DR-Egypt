package com.example.mohmedmostafa.dregypt.ui.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohmedmostafa.dregypt.R;
import com.squareup.picasso.Picasso;

public class DetailsProducts extends AppCompatActivity {
    ImageView imageView;
    TextView TXTdescription, TXTprice, TXTaddress, TXTcreated_at, TXTphone_1;
    String idz, titlez, description, price, status, image, address, created_at, phone_1, phone_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_products);
        Initialize();
        getExtra();
        Deploy();




    }

    private void Initialize() {
        imageView = findViewById(R.id.IMG_ProductDetails);
        TXTdescription = findViewById(R.id.Desc_ProductDetails);
        TXTprice = findViewById(R.id.Price_ProductDetails);
        TXTaddress = findViewById(R.id.Address_ProductDetails);
        TXTcreated_at = findViewById(R.id.Date_ProductDetails);
        TXTphone_1 = findViewById(R.id.Phone_ProductDetails);
    }

    private void getExtra() {
        Intent intent = getIntent();
        idz = intent.getStringExtra("pro_id");
        titlez = intent.getStringExtra("pro_title");
        description = intent.getStringExtra("pro_description");
        price = intent.getStringExtra("pro_price");
        status = intent.getStringExtra("pro_status");
        image = intent.getStringExtra("pro_image");
        address = intent.getStringExtra("pro_address");
        created_at = intent.getStringExtra("pro_created_at");
        phone_1 = intent.getStringExtra("pro_phone_1");
        phone_2 = intent.getStringExtra("pro_phone_2");

    }

    private void Deploy(){
        TXTdescription.setText(description);
        TXTprice.setText(price+"$");
        TXTaddress.setText(address);
        TXTcreated_at.setText(created_at);
        TXTphone_1.setText(phone_1);
        Picasso.with(this).load(image).fit().centerCrop().into(imageView);
    }
}
