package javatest.iristai.com.javatest.base;

import android.support.v4.app.Fragment;

import io.reactivex.disposables.Disposable;

public class RetrofitFragment extends Fragment {

    private static CompositeDisposableHelper mCompositeDisposableHelper = new CompositeDisposableHelper();

    public void addCompositeDisposable(Disposable d) {
        mCompositeDisposableHelper.add(d);
    }

    public void clearCompositeDisposable(Disposable d) {
        mCompositeDisposableHelper.clear();
    }

    public void hasCompositeDisposable() {
        mCompositeDisposableHelper.hasCompositeDisposables();
    }

    @Override
    public void onStop() {
        super.onStop();
        mCompositeDisposableHelper.clear();
    }
}
