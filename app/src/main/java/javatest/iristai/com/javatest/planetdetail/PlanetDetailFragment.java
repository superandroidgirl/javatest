package javatest.iristai.com.javatest.planetdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import javatest.iristai.com.javatest.GlideApp;
import javatest.iristai.com.javatest.MainActivity;
import javatest.iristai.com.javatest.R;
import javatest.iristai.com.javatest.base.RetrofitFragment;
import javatest.iristai.com.javatest.retrofit.javamodel.planetinfo.PlanetRootResultResults;
import javatest.iristai.com.javatest.utils.Config;
import javatest.iristai.com.javatest.utils.GlideRoundTransform;

public class PlanetDetailFragment extends RetrofitFragment {

    private PlanetRootResultResults mItemData;
    private MainActivity mActivity;
    private ImageView mPlanetImg;
    private TextView mPlanetName;
    private TextView mPlanetEnName;
    private TextView mAlsoKnownText;
    private TextView mBriefText;
    private TextView mFeatureText;
    private TextView mFuntionTextView;
    private TextView mLastUpdate;
    private View rootView;

    public static PlanetDetailFragment newInstance(PlanetRootResultResults planetRootResultResults) {
        PlanetDetailFragment fragment = new PlanetDetailFragment();
        //recordList = data;
        Bundle args = new Bundle();
        args.putParcelable(Config.BUNDLE_PLANET_DETAIL, planetRootResultResults);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
        mItemData = getArguments().getParcelable(Config.BUNDLE_PLANET_DETAIL);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.planet_detail_layout, container, false);
            initView();
        }

        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null)
            parent.removeView(rootView);

        return rootView;
    }

    private void initView() {
        mPlanetImg = rootView.findViewById(R.id.planet_img);
        mPlanetName = rootView.findViewById(R.id.planet_name);
        mPlanetEnName = rootView.findViewById(R.id.planet_en_name);
        mAlsoKnownText = rootView.findViewById(R.id.also_known_text);
        mBriefText = rootView.findViewById(R.id.planet_brief_text);
        mFeatureText = rootView.findViewById(R.id.planet_feature_text);
        mFuntionTextView = rootView.findViewById(R.id.planet_funtion_text);
        mLastUpdate = rootView.findViewById(R.id.lastupdate_time);

        initData();
    }

    private void initData() {
        mPlanetName.setText(mItemData.getF_Name_Ch());
        mPlanetEnName.setText(mItemData.getF_Name_En());
        mAlsoKnownText.setText(mItemData.getF_AlsoKnown());
        mBriefText.setText(mItemData.getF_Brief());
        mFeatureText.setText(mItemData.getF_Feature());
        mFuntionTextView.setText(mItemData.getF_FunctionApplication());
        mLastUpdate.setText(mItemData.getF_Update());

        GlideApp.with(rootView.getContext())
                .load(mItemData.getF_Pic01_URL())
                .fitCenter()
                .placeholder(R.drawable.default_img)
                .transform(new GlideRoundTransform(2))
                .centerCrop()
                .into(mPlanetImg);
    }

    @Override
    public void onResume() {
        super.onResume();
        mActivity.setTitle(mItemData.getF_Name_Ch());
        mActivity.setBurger(false);
    }
}
