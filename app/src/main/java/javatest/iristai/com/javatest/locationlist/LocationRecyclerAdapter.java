package javatest.iristai.com.javatest.locationlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import javatest.iristai.com.javatest.R;
import javatest.iristai.com.javatest.retrofit.javamodel.category.CategoryListRootResultResults;

public class LocationRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<CategoryListRootResultResults> mResultLists = new ArrayList();
    private OnItemClickListener mListener;

    interface OnItemClickListener {
        void onItemClick(CategoryListRootResultResults item);
    }

    public LocationRecyclerAdapter(OnItemClickListener listener) {
        mListener = listener;
    }

    public void refreshData(ArrayList<CategoryListRootResultResults> resultResults) {
        mResultLists = resultResults;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.location_list_item, viewGroup, false);
        return new LocationItemViewholder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((LocationItemViewholder) viewHolder).refreshItem(mResultLists.get(i));
    }

    @Override
    public int getItemCount() {
        return mResultLists.size();
    }
}
