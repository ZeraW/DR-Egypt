package com.example.mohmedmostafa.dregypt.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohmedmostafa.dregypt.R;
import com.example.mohmedmostafa.dregypt.ui.activities.DetailsProducts;
import com.example.mohmedmostafa.dregypt.utils.ProductsModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdsAdapter extends RecyclerView.Adapter<ProductAdsAdapter.MyViewHolder> {
    final String basicImgUrl = "http://gms-sms.com:89";
    private Context mContext;
    private ArrayList<ProductsModel> mArrayList;
    int LastPosition = -1;
    RecyclerViewClickListener ClickListener;

    public ProductAdsAdapter() {
    }

    public ProductAdsAdapter(Context mContext, ArrayList<ProductsModel> mArrayList) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
    }

    public void setClickListener(RecyclerViewClickListener clickListener) {
        this.ClickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_products, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ProductsModel currentItem = mArrayList.get(position);
        final String id = currentItem.getIdz();
        final String title= currentItem.getTitlez();
        final String description= currentItem.getDescription();
        final String price= currentItem.getPrice();
        final String status= currentItem.getStatus();
        final String image= currentItem.getImage();
        final String address= currentItem.getAddress();
        final String created_at= currentItem.getCreated_at();
        final String phone_1= currentItem.getPhone_1();
        final String phone_2= currentItem.getPhone_2();

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailsProducts.class);
                intent.putExtra("pro_id",id);
                intent.putExtra("pro_title",title);
                intent.putExtra("pro_description",description);
                intent.putExtra("pro_price",price);
                intent.putExtra("pro_status",status);
                intent.putExtra("pro_image",image);
                intent.putExtra("pro_address",address);
                intent.putExtra("pro_created_at",created_at);
                intent.putExtra("pro_phone_1",phone_1);
                intent.putExtra("pro_phone_2",phone_2);

                mContext.startActivity(intent);

            }
        });

        holder.ProductTitle.setText(title);
        holder.ProductPrice.setText(price+"$");
        holder.ProductStatus.setText(status);
        Picasso.with(mContext).load(image).fit().centerCrop().into(holder.imageView);


        //setAnimation(holder.cardView,position);
    }


    @Override
    public int getItemCount() {
        if (mArrayList == null || mArrayList.size() == 0)
            return 0;
        return mArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView ProductTitle, ProductDesc, ProductPrice, ProductStatus, ProductsMoreDetails;
        ImageView imageView;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ProductTitle = itemView.findViewById(R.id.Products_title);
            ProductPrice = itemView.findViewById(R.id.Products_Price);
            ProductStatus = itemView.findViewById(R.id.Products_Status);
            imageView = itemView.findViewById(R.id.Products_Img);
            ProductsMoreDetails = itemView.findViewById(R.id.Products_More_Details);
            cardView = itemView.findViewById(R.id.Products_cardView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (ClickListener != null)
                ClickListener.ItemClicked(view, getAdapterPosition());
        }

        public void clearAnimation() {
            cardView.clearAnimation();
        }
    }

    public interface RecyclerViewClickListener {

        public void ItemClicked(View v, int position);
    }

    private void setAnimation(View viewToAnimate, int position) {

        if (position > LastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            LastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.clearAnimation();
    }


}

