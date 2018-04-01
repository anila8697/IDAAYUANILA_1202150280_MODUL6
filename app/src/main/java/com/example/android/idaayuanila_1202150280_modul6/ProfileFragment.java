package com.example.android.idaayuanila_1202150280_modul6;

import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;


import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.DataSnapshot;

import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;


public class ProfileFragment extends Fragment {

    private ArrayList<ProfileModel> mUpload;

    private RecyclerView mRecycler;

    private ProfileAdapter mAdapter;


    private DatabaseReference mDatabaseRef;


    public ProfileFragment() {
    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        // class yang bisa kita gunakan untuk membuat java object view dari layout yang kita buat di xml
        View layoutView = inflater.inflate(R.layout.fragment_profile, container, false);


        mUpload = new ArrayList<>();


        int gridColumn = getResources().getInteger(R.integer.grid_column_count);


        mRecycler = (RecyclerView) layoutView.findViewById(R.id.profilerecycler);

        //ukurannya dibuat fix
        mRecycler.setHasFixedSize(true);

        //kita bisa memilih layout nya linear atau grid
        mRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));

        //inisialisasi database
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Image");

        //ketika sudah konek dengan database nya
        mDatabaseRef.addValueEventListener(new ValueEventListener() {

            @Override

            //untuk mengubah data
            public void onDataChange(DataSnapshot dataSnapshot) {
            //untuk menghilangkan dulu baru di upload agar data nya tidak tumpang tindih
                mUpload.clear();
                //untuk children dari folder image
                for (DataSnapshot post : dataSnapshot.getChildren()) {

                    ProfileModel timelineData = post.getValue(ProfileModel.class);


                    String userMail = MainActivity.email;

                    String dataMail = String.valueOf(timelineData.getmEmail());

                    if (dataMail.equals(userMail)) {

                        mUpload.add(timelineData);

                    }

                }

                mAdapter = new ProfileAdapter(getContext(), mUpload);

                mRecycler.setAdapter(mAdapter);

            }


            @Override

            public void onCancelled(DatabaseError databaseError) {


            }

        });


        return layoutView;


    }
}





