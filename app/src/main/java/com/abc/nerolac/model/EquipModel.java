package com.abc.nerolac.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by abc on 18-Jan-17.
 */
public class EquipModel implements Parcelable {

    private String name;
    private int listImage;

    public EquipModel() {
    }

    public EquipModel(String name, int listImage) {
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

    public static Creator<EquipModel> CREATOR = new Creator<EquipModel>() {
        @Override
        public EquipModel createFromParcel(Parcel parcle) {

            EquipModel equipModel = new EquipModel();

            //awareModel.listId = parcle.readInt();
            equipModel.name = parcle.readString();
            equipModel.listImage = parcle.readInt();

            return equipModel;
        }

        @Override
        public EquipModel[] newArray(int size) {
            return new EquipModel[0];
        }
    };

}
