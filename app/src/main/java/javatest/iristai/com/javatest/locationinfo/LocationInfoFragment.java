package javatest.iristai.com.javatest.locationinfo;

import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import javatest.iristai.com.javatest.MainActivity;
import javatest.iristai.com.javatest.base.RetrofitFragment;
import javatest.iristai.com.javatest.retrofit.javamodel.category.CategoryListRootResultResults;
import javatest.iristai.com.javatest.retrofit.javamodel.planet.PlanetRoot;

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

    }
}
