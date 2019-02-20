package javatest.iristai.com.javatest.retrofit.javamodel.planetinfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class PlanetRootResult implements Parcelable {
    public static final Creator<PlanetRootResult> CREATOR = new Creator<PlanetRootResult>() {
        @Override
        public PlanetRootResult createFromParcel(Parcel source) {
            PlanetRootResult var = new PlanetRootResult();
            var.offset = source.readInt();
            var.limit = source.readInt();
            var.count = source.readInt();
            var.sort = source.readString();
            var.results = source.createTypedArrayList(PlanetRootResultResults.CREATOR);
            return var;
        }

        @Override
        public PlanetRootResult[] newArray(int size) {
            return new PlanetRootResult[size];
        }
    };
    private int offset;
    private int limit;
    private int count;
    private String sort;
    private ArrayList<PlanetRootResultResults> results ;

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

    public ArrayList<PlanetRootResultResults> getResults() {
        return this.results;
    }

    public void setResults(ArrayList<PlanetRootResultResults> results) {
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
}
