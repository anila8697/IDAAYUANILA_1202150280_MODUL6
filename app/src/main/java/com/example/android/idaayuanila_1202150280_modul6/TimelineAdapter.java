package com.example.android.idaayuanila_1202150280_modul6;

import android.content.Context;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;



import com.squareup.picasso.Picasso;



import java.util.ArrayList;





public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ImageViewHolder> {

    private ArrayList<DataModel> mTimeline;

    private Context mContext;

    private DataModel mCurrentUpload;



    TimelineAdapter(Context context, ArrayList<DataModel> timeline){

        mTimeline = timeline;

        mContext = context;

    }



    @Override
    //untuk membuat view holder
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_timeline, parent, false);

        return new TimelineAdapter.ImageViewHolder(view);

    }



    @Override
    //untuk menghold semua content
    public void onBindViewHolder(TimelineAdapter.ImageViewHolder holder, int position) {

        mCurrentUpload = mTimeline.get(position);

        holder.mTitle.setText(mCurrentUpload.getmTitle());

        holder.mCaption.setText(mCurrentUpload.getmCaption());

        holder.mEmail.setText(mCurrentUpload.getmEmail());

        Picasso.get()

                .load(mCurrentUpload.getmUrl())

                .fit()



                .into(holder.mImage);



    }



    @Override

    public int getItemCount() {

        return mTimeline.size();

    }



    public class ImageViewHolder extends RecyclerView.ViewHolder{



        public TextView mEmail;

        private TextView mTitle;

        private TextView mCaption;

        private ImageView mImage;



        public ImageViewHolder(View itemView) {

            super(itemView);



            mEmail = itemView.findViewById(R.id.email);

            mTitle = itemView.findViewById(R.id.titlePost);

            mCaption = itemView.findViewById(R.id.captionPost);

            mImage = itemView.findViewById(R.id.imageViewUploaded);

        }

    }

}
