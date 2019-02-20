package javatest.iristai.com.javatest.retrofit.javamodel.planetinfo;

import android.os.Parcel;
import android.os.Parcelable;

public class PlanetRoot implements Parcelable {
    public static final Creator<PlanetRoot> CREATOR = new Creator<PlanetRoot>() {
        @Override
        public PlanetRoot createFromParcel(Parcel source) {
            PlanetRoot var = new PlanetRoot();
            var.result = source.readParcelable(PlanetRootResult.class.getClassLoader());
            return var;
        }

        @Override
        public PlanetRoot[] newArray(int size) {
            return new PlanetRoot[size];
        }
    };
    private PlanetRootResult result;

    public PlanetRootResult getResult() {
        return this.result;
    }

    public void setResult(PlanetRootResult result) {
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
