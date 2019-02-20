package javatest.iristai.com.javatest.locationlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import javatest.iristai.com.javatest.MainActivity;
import javatest.iristai.com.javatest.R;
import javatest.iristai.com.javatest.base.RetrofitFragment;
import javatest.iristai.com.javatest.locationinfo.LocationInfoFragment;
import javatest.iristai.com.javatest.retrofit.api.ApiClient;
import javatest.iristai.com.javatest.retrofit.api.Subscriber;
import javatest.iristai.com.javatest.retrofit.javamodel.category.CategoryListRoot;
import javatest.iristai.com.javatest.retrofit.javamodel.category.CategoryListRootResultResults;

public class LocationListFragment extends RetrofitFragment {

    private MainActivity mActivity;
    private RecyclerView rvListView;
    private TextView mNoData;
    private LocationRecyclerAdapter mAdapter;
    private ArrayList<CategoryListRootResultResults> mResults = new ArrayList<>();
    private ProgressBar progressBar;
    private LinearLayoutManager layoutManager;
    private View rootView;

    public static LocationListFragment newInstance(){
        return new LocationListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.locationlist_layout, container, false);
            initView();
        }

        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null)
            parent.removeView(rootView);

        return rootView;
    }

    private void initView() {
        mNoData = rootView.findViewById(R.id.no_data_text);
        progressBar = rootView.findViewById(R.id.progressbar);
        rvListView = rootView.findViewById(R.id.recycler_layout);

        mAdapter = new LocationRecyclerAdapter(new LocationRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CategoryListRootResultResults item) {
                mActivity.replaceFragment(
                        LocationInfoFragment.newInstance(item),
                        "LocationInfoFragment",
                        true,
                        true);
            }
        });

        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvListView.setLayoutManager(layoutManager);
        rvListView.setHasFixedSize(true);
        rvListView.setAdapter(mAdapter);

        callLocationListAPI();
    }

    private void callLocationListAPI() {

        addCompositeDisposable(ApiClient.getCategoryList().subscribeWith(new Subscriber<CategoryListRoot>() {

            @Override
            public void onNext(CategoryListRoot responseData) {
                progressBar.setVisibility(View.GONE);
                mNoData.setVisibility(View.GONE);
                if (responseData.getResult().getResults() != null && responseData.getResult().getResults().size() > 0) {
                    mResults = responseData.getResult().getResults();
                    mAdapter.refreshData(mResults);
                } else {
                    mNoData.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void onError(Throwable throwable) {
                super.onError(throwable);
                progressBar.setVisibility(View.GONE);
                mNoData.setVisibility(View.VISIBLE);
            }
        }));
    }

    @Override
    public void onResume() {
        super.onResume();
        mActivity.setTitle(getString(R.string.main_title));
        mActivity.setBurger(true);
    }
}
