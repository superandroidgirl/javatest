package javatest.iristai.com.javatest.locationinfo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import javatest.iristai.com.javatest.GlideApp;
import javatest.iristai.com.javatest.R;
import javatest.iristai.com.javatest.retrofit.javamodel.planetinfo.PlanetRootResultResults;
import javatest.iristai.com.javatest.utils.GlideRoundTransform;


public class PlanetITemViewholder extends RecyclerView.ViewHolder{

    private TextView mName;
    private TextView mPlanetAlsoKnown;
    private TextView mLocationMemo;
    private ImageView mImageView;
    private View mView;
    private PlanetListRecyclerAdapter.OnItemClickListener mListener;

    public PlanetITemViewholder(View itemView, PlanetListRecyclerAdapter.OnItemClickListener listener) {
        super(itemView);
        mView = itemView;
        mListener = listener;

        mName = mView.findViewById(R.id.location_name);
        mPlanetAlsoKnown = mView.findViewById(R.id.location_info);
        mLocationMemo = mView.findViewById(R.id.location_memo);
        mImageView = mView.findViewById(R.id.imageView);
    }

    public void refreshItem(final PlanetRootResultResults item) {
        if (item == null) return;

        mName.setText(item.getF_Name_Ch());
        mPlanetAlsoKnown.setText(item.getF_AlsoKnown());
        mLocationMemo.setVisibility(View.GONE);

        GlideApp.with(itemView.getContext())
                .load(item.getF_Pic01_URL())
                .fitCenter()
                .placeholder(R.drawable.default_img)
                .transform(new GlideRoundTransform(2))
                .centerCrop()
                .into(mImageView);

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(item);
            }
        });

        }

}
