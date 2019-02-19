package javatest.iristai.com.javatest.retrofit.api;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ObservableUtils {
    public static <T> ObservableTransformer<T, T> schedulersHandling() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable.retry(2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }

        };
    }
}
