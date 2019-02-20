package javatest.iristai.com.javatest.locationinfo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import javatest.iristai.com.javatest.GlideApp;
import javatest.iristai.com.javatest.R;
import javatest.iristai.com.javatest.retrofit.javamodel.category.CategoryListRootResultResults;
import javatest.iristai.com.javatest.utils.GlideRoundTransform;


public class HeaderViewholder extends RecyclerView.ViewHolder{

    private TextView mInfoTextView;
    private TextView mInfoMemoTextView;
    private TextView mInfoCategoryTextView;
    private ImageView mInfoImg;
    private TextView mOpenWebview;
    private View mView;
    private LocationInfoFragment.OnItemClickListener mListener;

    public HeaderViewholder(View itemView, LocationInfoFragment.OnItemClickListener listener) {
        super(itemView);
        mView = itemView;
        mListener = listener;

        mInfoTextView = mView.findViewById(R.id.info_text);
        mInfoMemoTextView = mView.findViewById(R.id.memo_text);
        mInfoCategoryTextView = mView.findViewById(R.id.category_text);
        mInfoImg = mView.findViewById(R.id.info_img);
        mOpenWebview = mView.findViewById(R.id.open_in_webview);
    }

    public void refreshItem(final CategoryListRootResultResults item) {
        if (item == null) return;

        mInfoTextView.setText(item.getE_Info());
        mInfoMemoTextView.setText(item.getE_Memo());
        mInfoCategoryTextView.setText(item.getE_Category());

        GlideApp.with(itemView.getContext())
                .load(item.getE_Pic_URL())
                .fitCenter()
                .placeholder(R.drawable.default_img)
                .transform(new GlideRoundTransform(2))
                .centerCrop()
                .into(mInfoImg);

        if (item.getE_URL() != null && !item.getE_URL().isEmpty()) {
            mOpenWebview.setVisibility(View.VISIBLE);
        } else {
            mOpenWebview.setVisibility(View.GONE);
        }

        mOpenWebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClickWeb(item.getE_URL());
            }
        });

        }

}
