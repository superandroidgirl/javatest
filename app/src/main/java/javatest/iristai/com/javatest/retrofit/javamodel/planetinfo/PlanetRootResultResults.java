package javatest.iristai.com.javatest.retrofit.javamodel.planetinfo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PlanetRootResultResults implements Parcelable {
    public static final Creator<PlanetRootResultResults> CREATOR = new Creator<PlanetRootResultResults>() {
        @Override
        public PlanetRootResultResults createFromParcel(Parcel source) {
            PlanetRootResultResults var = new PlanetRootResultResults();
            var.F_Name_Ch = source.readString();
            var.F_pdf02_ALT = source.readString();
            var.F_Name_En = source.readString();
            var.F_Voice01_URL = source.readString();
            var.F_Name_Latin = source.readString();
            var.F_Pic04_URL = source.readString();
            var.F_Summary = source.readString();
            var.F_Brief = source.readString();
            var.F_Location = source.readString();
            var.F_pdf02_URL = source.readString();
            var.F_Voice01_ALT = source.readString();
            var.F_Pic03_ALT = source.readString();
            var.F_Voice02_URL = source.readString();
            var.F_Voice02_ALT = source.readString();
            var.F_Pic01_URL = source.readString();
            var.F_Pic02_ALT = source.readString();
            var.F_FunctionApplication = source.readString();
            var.F_Keywords = source.readString();
            var.F_Family = source.readString();
            var.F_CID = source.readString();
            var.F_Pic01_ALT = source.readString();
            var.F_Pic02_URL = source.readString();
            var.F_Update = source.readString();
            var.F_Voice03_URL = source.readString();
            var.F_Code = source.readString();
            var.F_Voice03_ALT = source.readString();
            var.F_Pic03_URL = source.readString();
            var.F_Vedio_URL = source.readString();
            var.F_pdf01_ALT = source.readString();
            var.F_AlsoKnown = source.readString();
            var.F_pdf01_URL = source.readString();
            var._id = source.readInt();
            var.F_Feature = source.readString();
            var.F_Pic04_ALT = source.readString();
            var.F_Genus = source.readString();
            var.F_Geo = source.readString();
            return var;
        }

        @Override
        public PlanetRootResultResults[] newArray(int size) {
            return new PlanetRootResultResults[size];
        }
    };
    private String F_Name_Ch;
    private String F_pdf02_ALT;
    private String F_Name_En;
    private String F_Voice01_URL;
    private String F_Name_Latin;
    private String F_Pic04_URL;
    private String F_Summary;
    private String F_Brief;
    private String F_Location;
    private String F_pdf02_URL;
    private String F_Voice01_ALT;
    private String F_Pic03_ALT;
    private String F_Voice02_URL;
    private String F_Voice02_ALT;
    private String F_Pic01_URL;
    private String F_Pic02_ALT;
    @SerializedName("F_Function&Application")
    private String F_FunctionApplication;
    private String F_Keywords;
    private String F_Family;
    private String F_CID;
    private String F_Pic01_ALT;
    private String F_Pic02_URL;
    private String F_Update;
    private String F_Voice03_URL;
    private String F_Code;
    private String F_Voice03_ALT;
    private String F_Pic03_URL;
    private String F_Vedio_URL;
    private String F_pdf01_ALT;
    private String F_AlsoKnown;
    private String F_pdf01_URL;
    private int _id;
    private String F_Feature;
    private String F_Pic04_ALT;
    private String F_Genus;
    private String F_Geo;

    public String getF_Name_Ch() {
        return this.F_Name_Ch;
    }

    public void setF_Name_Ch(String F_Name_Ch) {
        this.F_Name_Ch = F_Name_Ch;
    }

    public String getF_pdf02_ALT() {
        return this.F_pdf02_ALT;
    }

    public void setF_pdf02_ALT(String F_pdf02_ALT) {
        this.F_pdf02_ALT = F_pdf02_ALT;
    }

    public String getF_Name_En() {
        return this.F_Name_En;
    }

    public void setF_Name_En(String F_Name_En) {
        this.F_Name_En = F_Name_En;
    }

    public String getF_Voice01_URL() {
        return this.F_Voice01_URL;
    }

    public void setF_Voice01_URL(String F_Voice01_URL) {
        this.F_Voice01_URL = F_Voice01_URL;
    }

    public String getF_Name_Latin() {
        return this.F_Name_Latin;
    }

    public void setF_Name_Latin(String F_Name_Latin) {
        this.F_Name_Latin = F_Name_Latin;
    }

    public String getF_Pic04_URL() {
        return this.F_Pic04_URL;
    }

    public void setF_Pic04_URL(String F_Pic04_URL) {
        this.F_Pic04_URL = F_Pic04_URL;
    }

    public String getF_Summary() {
        return this.F_Summary;
    }

    public void setF_Summary(String F_Summary) {
        this.F_Summary = F_Summary;
    }

    public String getF_Brief() {
        return this.F_Brief;
    }

    public void setF_Brief(String F_Brief) {
        this.F_Brief = F_Brief;
    }

    public String getF_Location() {
        return this.F_Location;
    }

    public void setF_Location(String F_Location) {
        this.F_Location = F_Location;
    }

    public String getF_pdf02_URL() {
        return this.F_pdf02_URL;
    }

    public void setF_pdf02_URL(String F_pdf02_URL) {
        this.F_pdf02_URL = F_pdf02_URL;
    }

    public String getF_Voice01_ALT() {
        return this.F_Voice01_ALT;
    }

    public void setF_Voice01_ALT(String F_Voice01_ALT) {
        this.F_Voice01_ALT = F_Voice01_ALT;
    }

    public String getF_Pic03_ALT() {
        return this.F_Pic03_ALT;
    }

    public void setF_Pic03_ALT(String F_Pic03_ALT) {
        this.F_Pic03_ALT = F_Pic03_ALT;
    }

    public String getF_Voice02_URL() {
        return this.F_Voice02_URL;
    }

    public void setF_Voice02_URL(String F_Voice02_URL) {
        this.F_Voice02_URL = F_Voice02_URL;
    }

    public String getF_Voice02_ALT() {
        return this.F_Voice02_ALT;
    }

    public void setF_Voice02_ALT(String F_Voice02_ALT) {
        this.F_Voice02_ALT = F_Voice02_ALT;
    }

    public String getF_Pic01_URL() {
        return this.F_Pic01_URL;
    }

    public void setF_Pic01_URL(String F_Pic01_URL) {
        this.F_Pic01_URL = F_Pic01_URL;
    }

    public String getF_Pic02_ALT() {
        return this.F_Pic02_ALT;
    }

    public void setF_Pic02_ALT(String F_Pic02_ALT) {
        this.F_Pic02_ALT = F_Pic02_ALT;
    }

    public String getF_FunctionApplication() {
        return this.F_FunctionApplication;
    }

    public void setF_FunctionApplication(String F_FunctionApplication) {
        this.F_FunctionApplication = F_FunctionApplication;
    }

    public String getF_Keywords() {
        return this.F_Keywords;
    }

    public void setF_Keywords(String F_Keywords) {
        this.F_Keywords = F_Keywords;
    }

    public String getF_Family() {
        return this.F_Family;
    }

    public void setF_Family(String F_Family) {
        this.F_Family = F_Family;
    }

    public String getF_CID() {
        return this.F_CID;
    }

    public void setF_CID(String F_CID) {
        this.F_CID = F_CID;
    }

    public String getF_Pic01_ALT() {
        return this.F_Pic01_ALT;
    }

    public void setF_Pic01_ALT(String F_Pic01_ALT) {
        this.F_Pic01_ALT = F_Pic01_ALT;
    }

    public String getF_Pic02_URL() {
        return this.F_Pic02_URL;
    }

    public void setF_Pic02_URL(String F_Pic02_URL) {
        this.F_Pic02_URL = F_Pic02_URL;
    }

    public String getF_Update() {
        return this.F_Update;
    }

    public void setF_Update(String F_Update) {
        this.F_Update = F_Update;
    }

    public String getF_Voice03_URL() {
        return this.F_Voice03_URL;
    }

    public void setF_Voice03_URL(String F_Voice03_URL) {
        this.F_Voice03_URL = F_Voice03_URL;
    }

    public String getF_Code() {
        return this.F_Code;
    }

    public void setF_Code(String F_Code) {
        this.F_Code = F_Code;
    }

    public String getF_Voice03_ALT() {
        return this.F_Voice03_ALT;
    }

    public void setF_Voice03_ALT(String F_Voice03_ALT) {
        this.F_Voice03_ALT = F_Voice03_ALT;
    }

    public String getF_Pic03_URL() {
        return this.F_Pic03_URL;
    }

    public void setF_Pic03_URL(String F_Pic03_URL) {
        this.F_Pic03_URL = F_Pic03_URL;
    }

    public String getF_Vedio_URL() {
        return this.F_Vedio_URL;
    }

    public void setF_Vedio_URL(String F_Vedio_URL) {
        this.F_Vedio_URL = F_Vedio_URL;
    }

    public String getF_pdf01_ALT() {
        return this.F_pdf01_ALT;
    }

    public void setF_pdf01_ALT(String F_pdf01_ALT) {
        this.F_pdf01_ALT = F_pdf01_ALT;
    }

    public String getF_AlsoKnown() {
        return this.F_AlsoKnown;
    }

    public void setF_AlsoKnown(String F_AlsoKnown) {
        this.F_AlsoKnown = F_AlsoKnown;
    }

    public String getF_pdf01_URL() {
        return this.F_pdf01_URL;
    }

    public void setF_pdf01_URL(String F_pdf01_URL) {
        this.F_pdf01_URL = F_pdf01_URL;
    }

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getF_Feature() {
        return this.F_Feature;
    }

    public void setF_Feature(String F_Feature) {
        this.F_Feature = F_Feature;
    }

    public String getF_Pic04_ALT() {
        return this.F_Pic04_ALT;
    }

    public void setF_Pic04_ALT(String F_Pic04_ALT) {
        this.F_Pic04_ALT = F_Pic04_ALT;
    }

    public String getF_Genus() {
        return this.F_Genus;
    }

    public void setF_Genus(String F_Genus) {
        this.F_Genus = F_Genus;
    }

    public String getF_Geo() {
        return this.F_Geo;
    }

    public void setF_Geo(String F_Geo) {
        this.F_Geo = F_Geo;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.F_Name_Ch);
        dest.writeString(this.F_pdf02_ALT);
        dest.writeString(this.F_Name_En);
        dest.writeString(this.F_Voice01_URL);
        dest.writeString(this.F_Name_Latin);
        dest.writeString(this.F_Pic04_URL);
        dest.writeString(this.F_Summary);
        dest.writeString(this.F_Brief);
        dest.writeString(this.F_Location);
        dest.writeString(this.F_pdf02_URL);
        dest.writeString(this.F_Voice01_ALT);
        dest.writeString(this.F_Pic03_ALT);
        dest.writeString(this.F_Voice02_URL);
        dest.writeString(this.F_Voice02_ALT);
        dest.writeString(this.F_Pic01_URL);
        dest.writeString(this.F_Pic02_ALT);
        dest.writeString(this.F_FunctionApplication);
        dest.writeString(this.F_Keywords);
        dest.writeString(this.F_Family);
        dest.writeString(this.F_CID);
        dest.writeString(this.F_Pic01_ALT);
        dest.writeString(this.F_Pic02_URL);
        dest.writeString(this.F_Update);
        dest.writeString(this.F_Voice03_URL);
        dest.writeString(this.F_Code);
        dest.writeString(this.F_Voice03_ALT);
        dest.writeString(this.F_Pic03_URL);
        dest.writeString(this.F_Vedio_URL);
        dest.writeString(this.F_pdf01_ALT);
        dest.writeString(this.F_AlsoKnown);
        dest.writeString(this.F_pdf01_URL);
        dest.writeInt(this._id);
        dest.writeString(this.F_Feature);
        dest.writeString(this.F_Pic04_ALT);
        dest.writeString(this.F_Genus);
        dest.writeString(this.F_Geo);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
