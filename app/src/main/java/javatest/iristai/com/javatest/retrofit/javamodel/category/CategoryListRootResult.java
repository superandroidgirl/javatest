package javatest.iristai.com.javatest.retrofit.javamodel.category;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class CategoryListRootResult implements Parcelable {

    private int offset;
    private int limit;
    private int count;
    private String sort;
    private ArrayList<CategoryListRootResultResults> results = new ArrayList<>();

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public ArrayList<CategoryListRootResultResults> getResults() {
        return this.results;
    }

    public void setResults(ArrayList<CategoryListRootResultResults> results) {
        this.results = results;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.offset);
        dest.writeInt(this.limit);
        dest.writeInt(this.count);
        dest.writeString(this.sort);
        dest.writeTypedList(this.results);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CategoryListRootResult> CREATOR = new Creator<CategoryListRootResult>() {
        @Override
        public CategoryListRootResult createFromParcel(Parcel source) {
            CategoryListRootResult var = new CategoryListRootResult();
            var.offset = source.readInt();
            var.limit = source.readInt();
            var.count = source.readInt();
            var.sort = source.readString();
            var.results = source.createTypedArrayList(CategoryListRootResultResults.CREATOR);
            return var;
        }

        @Override
        public CategoryListRootResult[] newArray(int size) {
            return new CategoryListRootResult[size];
        }
    };
}
