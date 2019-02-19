package javatest.iristai.com.javatest.retrofit.javamodel.category;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryListRoot implements Parcelable {

    public static final Creator<CategoryListRoot> CREATOR = new Creator<CategoryListRoot>() {
        @Override
        public CategoryListRoot createFromParcel(Parcel source) {
            CategoryListRoot var = new CategoryListRoot();
            var.result = source.readParcelable(CategoryListRootResult.class.getClassLoader());
            return var;
        }

        @Override
        public CategoryListRoot[] newArray(int size) {
            return new CategoryListRoot[size];
        }
    };
    private CategoryListRootResult result;

    public CategoryListRootResult getResult() {
        return this.result;
    }

    public void setResult(CategoryListRootResult result) {
        this.result = result;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.result, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
