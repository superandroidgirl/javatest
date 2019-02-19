package javatest.iristai.com.javatest.retrofit.javamodel.category;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryListRootResultResults implements Parcelable {

    private String E_Pic_URL;
    private String E_Info;
    private String E_Category;
    private String E_Memo;
    private String E_no;
    private String E_Name;
    private int _id;
    private String E_URL;
    private String E_Geo;

    public String getE_Pic_URL() {
        return this.E_Pic_URL;
    }

    public void setE_Pic_URL(String E_Pic_URL) {
        this.E_Pic_URL = E_Pic_URL;
    }

    public String getE_Info() {
        return this.E_Info;
    }

    public void setE_Info(String E_Info) {
        this.E_Info = E_Info;
    }

    public String getE_Category() {
        return this.E_Category;
    }

    public void setE_Category(String E_Category) {
        this.E_Category = E_Category;
    }

    public String getE_Memo() {
        return this.E_Memo;
    }

    public void setE_Memo(String E_Memo) {
        this.E_Memo = E_Memo;
    }

    public String getE_no() {
        return this.E_no;
    }

    public void setE_no(String E_no) {
        this.E_no = E_no;
    }

    public String getE_Name() {
        return this.E_Name;
    }

    public void setE_Name(String E_Name) {
        this.E_Name = E_Name;
    }

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getE_URL() {
        return this.E_URL;
    }

    public void setE_URL(String E_URL) {
        this.E_URL = E_URL;
    }

    public String getE_Geo() {
        return this.E_Geo;
    }

    public void setE_Geo(String E_Geo) {
        this.E_Geo = E_Geo;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.E_Pic_URL);
        dest.writeString(this.E_Info);
        dest.writeString(this.E_Category);
        dest.writeString(this.E_Memo);
        dest.writeString(this.E_no);
        dest.writeString(this.E_Name);
        dest.writeInt(this._id);
        dest.writeString(this.E_URL);
        dest.writeString(this.E_Geo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CategoryListRootResultResults> CREATOR = new Creator<CategoryListRootResultResults>() {
        @Override
        public CategoryListRootResultResults createFromParcel(Parcel source) {
            CategoryListRootResultResults var = new CategoryListRootResultResults();
            var.E_Pic_URL = source.readString();
            var.E_Info = source.readString();
            var.E_Category = source.readString();
            var.E_Memo = source.readString();
            var.E_no = source.readString();
            var.E_Name = source.readString();
            var._id = source.readInt();
            var.E_URL = source.readString();
            var.E_Geo = source.readString();
            return var;
        }

        @Override
        public CategoryListRootResultResults[] newArray(int size) {
            return new CategoryListRootResultResults[size];
        }
    };
}
