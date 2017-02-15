package com.abc.nerolac.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by abc on 17-Jan-17.
 */
public class AwareModel implements Parcelable{

    //private int listId;
    private String name;
    private int listImage;

    public AwareModel() {
    }

    public AwareModel(String name, int listImage) {
        //this.listId = listId;
        this.name = name;
        this.listImage = listImage;
    }

    /*public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getListImage() {
        return listImage;
    }

    public void setListImage(int listImage) {
        this.listImage = listImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {

        //parcel.writeInt(this.listId);
        parcel.writeString(this.name);
        parcel.writeInt(this.listImage);
    }

    public static Creator<AwareModel> CREATOR = new Creator<AwareModel>() {
        @Override
        public AwareModel createFromParcel(Parcel parcle) {

            AwareModel awareModel = new AwareModel();

            //awareModel.listId = parcle.readInt();
            awareModel.name = parcle.readString();
            awareModel.listImage = parcle.readInt();

            return awareModel;
        }

        @Override
        public AwareModel[] newArray(int size) {
            return new AwareModel[0];
        }
    };
}
