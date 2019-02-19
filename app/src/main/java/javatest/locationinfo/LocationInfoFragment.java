package javatest.iristai.com.javatest.locationinfo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import javatest.iristai.com.javatest.MainActivity;
import javatest.iristai.com.javatest.base.RetrofitFragment;
import javatest.iristai.com.javatest.retrofit.javamodel.category.CategoryListRootResultResults;
import javatest.iristai.com.javatest.retrofit.javamodel.planet.PlanetRoot;
import javatest.iristai.com.javatest.utils.Config;

public class LocationInfoFragment extends RetrofitFragment {

    private CategoryListRootResultResults mItemData;
    private MainActivity mActivity;
    private RecyclerView rvListView;
    private PlanetListRecyclerAdapter mAdapter;

    private ArrayList<PlanetRoot> mResults= new ArrayList<>();
    private ProgressBar progressBar;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mItemData = getArguments().getParcelable(Config.BUNDLE_LOCATION_INFO);
    }
}
