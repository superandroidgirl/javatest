package javatest.iristai.com.javatest.locationlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import javatest.iristai.com.javatest.GlideApp;
import javatest.iristai.com.javatest.R;
import javatest.iristai.com.javatest.retrofit.javamodel.category.CategoryListRootResultResults;
import javatest.iristai.com.javatest.utils.GlideRoundTransform;


public class LocationItemViewholder extends RecyclerView.ViewHolder{

    private TextView mName;
    private TextView mLocationInfo;
    private TextView mLocationMemo;
    private ImageView mImageView;
    private View mView;
    private LocationRecyclerAdapter.OnItemClickListener mListener;

    public LocationItemViewholder(View itemView, LocationRecyclerAdapter.OnItemClickListener listener) {
        super(itemView);
        mView = itemView;
        mListener = listener;
        mName = mView.findViewById(R.id.location_name);
        mLocationInfo = mView.findViewById(R.id.location_info);
        mLocationMemo = mView.findViewById(R.id.location_memo);
        mImageView = mView.findViewById(R.id.imageView);

    }

    public void refreshItem(final CategoryListRootResultResults item) {
        if (item == null) return;

        mName.setText(item.getE_Name());
        mLocationInfo.setText(item.getE_Info());
        if (item.getE_Memo().isEmpty()) {
            mLocationMemo.setText(mView.getContext().getString(R.string.no_memo_string));
        } else {
            mLocationMemo.setText(item.getE_Memo());
        }

        GlideApp.with(itemView.getContext())
                .load(item.getE_Pic_URL())
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
