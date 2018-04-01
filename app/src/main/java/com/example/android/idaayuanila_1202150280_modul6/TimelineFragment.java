package com.example.android.idaayuanila_1202150280_modul6;

import android.content.Context;

import android.net.Uri;

import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;


import com.google.firebase.database.DataSnapshot;

import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;


public class TimelineFragment extends Fragment {

    private ArrayList<DataModel> mUpload;

    private RecyclerView mRecycler;

    private TimelineAdapter mAdapter;


    private DatabaseReference mDatabaseRef;


    public TimelineFragment() {


    }

    @Override

    // class yang bisa kita gunakan untuk membuat java object view dari layout yang kita buat di xml
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {


        View layoutView = inflater.inflate(R.layout.fragment_timeline, container, false);

        mUpload = new ArrayList<>();


        int gridColumn = getResources().getInteger(R.integer.grid_column_count);

//mRecycler=new RecyclerView(getContext());
        mRecycler = (RecyclerView) layoutView.findViewById(R.id.timelinerecyler);
//ukurannya dibuat fix
        mRecycler.setHasFixedSize(true);
        //kita bisa memilih layout nya linear atau grid

        mRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        //inisialisasi database

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Image");
//ketika sudah konek dengan database nya

        mDatabaseRef.addValueEventListener(new ValueEventListener() {

            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
//untuk children dari folder image
                for (DataSnapshot post : dataSnapshot.getChildren()) {

                    DataModel model = post.getValue(DataModel.class);

                    mUpload.add(model);

                }

                mAdapter = new TimelineAdapter(getContext(), mUpload);

                mRecycler.setAdapter(mAdapter);

            }


            @Override

            public void onCancelled(DatabaseError databaseError) {


            }

        });

        return layoutView;

    }


}