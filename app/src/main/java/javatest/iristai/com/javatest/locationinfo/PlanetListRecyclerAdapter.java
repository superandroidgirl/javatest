package javatest.iristai.com.javatest.locationinfo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import javatest.iristai.com.javatest.R;
import javatest.iristai.com.javatest.retrofit.javamodel.category.CategoryListRootResultResults;
import javatest.iristai.com.javatest.retrofit.javamodel.planetinfo.PlanetRootResultResults;

public class PlanetListRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE_HEADER = 0;
    private static final int ITEM_TYPE_MIDDLE = 1;
    private static final int ITEM_TYPE_CONTENT = 2;
    private static final int mHeaderCount = 1;
    private static final int mMiddleCount = 1;
    private ArrayList<PlanetRootResultResults> mResultLists = new ArrayList();
    private OnItemClickListener mListener;
    private LocationInfoFragment.OnItemClickListener mWebListener;
    private CategoryListRootResultResults mItemData;

    interface OnItemClickListener {
        void onItemClick(PlanetRootResultResults item);
    }

    public PlanetListRecyclerAdapter(OnItemClickListener listener, LocationInfoFragment.OnItemClickListener weblistener) {
        mListener = listener;
        mWebListener = weblistener;
    }

    public void refreshData(ArrayList<PlanetRootResultResults> resultResults, CategoryListRootResultResults itemdata) {
        mResultLists = resultResults;
        mItemData = itemdata;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == ITEM_TYPE_HEADER) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.locationinfo_header, viewGroup, false);
            viewHolder = new HeaderViewholder(v, mWebListener);
        } else if (viewType == ITEM_TYPE_CONTENT) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.location_list_item, viewGroup, false);
            viewHolder = new PlanetITemViewholder(v, mListener);
        } else if (viewType == ITEM_TYPE_MIDDLE) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.location_info_middle_text, viewGroup, false);
            viewHolder = new MiddleViewholder(v);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof HeaderViewholder) {
            ((HeaderViewholder) viewHolder).refreshItem(mItemData);
        } else if (viewHolder instanceof MiddleViewholder) {}
        else if (viewHolder instanceof PlanetITemViewholder) {
            ((PlanetITemViewholder) viewHolder).refreshItem(mResultLists.get(i - 2));
        }


    }

    @Override
    public int getItemCount() {
        if (mResultLists.size() > 0) {
            return mResultLists.size() + 2;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderCount != 0 && position < mHeaderCount) {
            return ITEM_TYPE_HEADER;
        } else if (mMiddleCount != 0 && mResultLists.size() > 0 && position == 1) {
            return ITEM_TYPE_MIDDLE;
        } else {
            return ITEM_TYPE_CONTENT;
        }
    }
}
