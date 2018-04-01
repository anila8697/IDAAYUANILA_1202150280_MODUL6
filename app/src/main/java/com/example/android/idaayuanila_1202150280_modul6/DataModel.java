package com.example.android.idaayuanila_1202150280_modul6;



public class DataModel {
    private String mTitle;
    private String mCaption;
    private String mUrl;
    private String mUid;
    private String mEmail;
public DataModel(){}

public DataModel(String Title,String Caption,String Url, String Uid,String Email){
        mTitle=Title;
        mCaption=Caption;
        mEmail=Email;
        mUid=Uid;
        mUrl=Url;



}

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmCaption() {
        return mCaption;
    }

    public void setmCaption(String mCaption) {
        this.mCaption = mCaption;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmUid() {
        return mUid;
    }

    public void setmUid(String mUid) {
        this.mUid = mUid;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}

