package javatest.iristai.com.javatest.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class CompositeDisposableHelper {

    private CompositeDisposable  mCompositeDisposable = new CompositeDisposable();

    public void add(Disposable d) {
        mCompositeDisposable.add(d);
    }

    public void clear() {
        mCompositeDisposable.clear();
    }

    public Boolean hasCompositeDisposables() {
        return mCompositeDisposable.size() > 0;
    }

    public void remove(Disposable d) {
        mCompositeDisposable.remove(d);
    }
}
