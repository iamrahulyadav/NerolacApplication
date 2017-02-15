package com.abc.nerolac.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by abc on 20-Jan-17.
 */
public class AssistModel implements Parcelable {

    private String name;
    private int listImage;

    public AssistModel() {
    }

    public AssistModel(String name, int listImage) {
        this.name = name;
        this.listImage = listImage;
    }

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

    public static Creator<AssistModel> CREATOR = new Creator<AssistModel>() {
        @Override
        public AssistModel createFromParcel(Parcel parcle) {

            AssistModel assistModel= new AssistModel();

            //awareModel.listId = parcle.readInt();
            assistModel.name = parcle.readString();
            assistModel.listImage = parcle.readInt();

            return assistModel;
        }

        @Override
        public AssistModel[] newArray(int size) {
            return new AssistModel[0];
        }
    };

}
