 package com.example.mohmedmostafa.dregypt.ui.adapters;

import android.content.Context;
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

import java.util.ArrayList;

 public class BeautyCentersAdapter extends RecyclerView.Adapter<BeautyCentersAdapter.MyViewHolder>  {
    final String basicImgUrl="http://gms-sms.com:89";
     ArrayList  arrayList;
    Context context;
    int  LastPosition=-1;
    RecyclerViewClickListener ClickListener ;


    public BeautyCentersAdapter(){}
    public BeautyCentersAdapter(ArrayList arrayList, Context context){
        this.arrayList =new ArrayList();
        this.arrayList = arrayList;
        this.context=context;
    }


    public void setClickListener(RecyclerViewClickListener clickListener){
        this.ClickListener= clickListener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_hospitals,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        //setAnimation(holder.cardView,position);
    }


    @Override
    public int getItemCount() {
        if(arrayList==null||arrayList.size()==0)
            return 0;
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        ImageView imageView;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(ClickListener!=null)
                ClickListener.ItemClicked(view ,getAdapterPosition());
        }

        public void clearAnimation()
        {
            cardView.clearAnimation();
        }
    }

    public interface RecyclerViewClickListener
    {

        public void ItemClicked(View v, int position);
    }

    private void setAnimation(View viewToAnimate, int position)
    {

        if (position > LastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
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

