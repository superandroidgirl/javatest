package javatest.iristai.com.javatest.locationinfo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import javatest.iristai.com.javatest.MainActivity;
import javatest.iristai.com.javatest.R;
import javatest.iristai.com.javatest.base.RetrofitFragment;
import javatest.iristai.com.javatest.planetdetail.PlanetDetailFragment;
import javatest.iristai.com.javatest.retrofit.api.ApiClient;
import javatest.iristai.com.javatest.retrofit.api.Subscriber;
import javatest.iristai.com.javatest.retrofit.javamodel.category.CategoryListRootResultResults;
import javatest.iristai.com.javatest.retrofit.javamodel.planetinfo.PlanetRoot;
import javatest.iristai.com.javatest.retrofit.javamodel.planetinfo.PlanetRootResultResults;
import javatest.iristai.com.javatest.utils.Config;

public class LocationInfoFragment extends RetrofitFragment {

    private CategoryListRootResultResults mItemData;
    private MainActivity mActivity;
    private RecyclerView rvListView;
    private PlanetListRecyclerAdapter mAdapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<PlanetRootResultResults> mResults= new ArrayList<>();
    private ProgressBar progressBar;
    private View rootView;

    interface OnItemClickListener {
        void onClickWeb(String urlString);
    }

    public static LocationInfoFragment newInstance(CategoryListRootResultResults categoryListRootResultResults) {
        LocationInfoFragment fragment = new LocationInfoFragment();
        //recordList = data;
        Bundle args = new Bundle();
        args.putParcelable(Config.BUNDLE_LOCATION_INFO, categoryListRootResultResults);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItemData = getArguments().getParcelable(Config.BUNDLE_LOCATION_INFO);
        mActivity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.location_info_layout, container, false);
            initView();
        }

        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null)
            parent.removeView(rootView);

        return rootView;
    }

    private void initView() {
        progressBar = rootView.findViewById(R.id.progressbar);
        rvListView = rootView.findViewById(R.id.planet_list_recyclerview);

        mAdapter = new PlanetListRecyclerAdapter(new PlanetListRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(PlanetRootResultResults item) {
                //go to planet detail
                mActivity.replaceFragment(PlanetDetailFragment.newInstance(item), "PlanetDetailFragment", true, true);

            }
        }, new OnItemClickListener() {
            @Override
            public void onClickWeb(String urlString) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlString)));
            }
        });

        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvListView.setLayoutManager(layoutManager);
        rvListView.setHasFixedSize(true);
        rvListView.setAdapter(mAdapter);

        callPlanetListAPI();
    }

    private void callPlanetListAPI() {
        addCompositeDisposable(ApiClient.getPlanetList(mItemData.getE_Name()).subscribeWith(new Subscriber<PlanetRoot>(){

            @Override
            public void onNext(PlanetRoot responseData) {
                progressBar.setVisibility(View.GONE);

                if (responseData.getResult().getResults() != null && responseData.getResult().getResults().size() > 0) {
                    mResults = responseData.getResult().getResults();
                    mAdapter.refreshData(mResults, mItemData);
                } else {
                    mAdapter.refreshData(mResults, mItemData);
                }


            }

            @Override
            public void onError(Throwable throwable) {
                super.onError(throwable);
                progressBar.setVisibility(View.GONE);
                mAdapter.refreshData(mResults, mItemData);
            }
        }));
    }

    @Override
    public void onResume() {
        super.onResume();
        mActivity.setTitle(mItemData.getE_Name());
        mActivity.setBurger(false);
    }
}
