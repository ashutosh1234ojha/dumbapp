package com.dummyapp.ViewTypeRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dummyapp.R;

import java.util.ArrayList;


/**
 * Created by Ashutosh on 13/6/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ArrayList<String> mList;
    private final int VIEW_HOLDER_FILLED = -2;
    private final int VIEW_HOLDER_EMPTY = -1;

    /**
     * Constructor of notification adapter
     *
     * @param mContext of activity or fragment
     */
    public RecyclerViewAdapter(final Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        mContext = parent.getContext();

        RecyclerView.ViewHolder viewHolder;
        View view;
        if (viewType == VIEW_HOLDER_EMPTY) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_empty, parent, false);
            viewHolder = new ViewHolderEmpty(view);

        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_view, parent, false);
            viewHolder = new ViewHolderFilled(view);

        }
        return viewHolder;

    }

    @Override
    public int getItemViewType(final int position) {
        if (mList == null || mList.size() == 0) {

            return VIEW_HOLDER_EMPTY;
        } else {
            return VIEW_HOLDER_FILLED;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


        switch (holder.getItemViewType()) {

            case VIEW_HOLDER_EMPTY:
                ViewHolderEmpty viewHolderEmpty = (ViewHolderEmpty) holder;
                viewHolderEmpty.tvEmpty.setText("Your this list is empty");
                break;
            case VIEW_HOLDER_FILLED:

                String value = mList.get(position);
                ViewHolderFilled viewHolderFilled = (ViewHolderFilled) holder;
                viewHolderFilled.tvItem.setText(mList.get(position));


                setOnClickListener(holder,value);

                break;


        }

    }

    private void setOnClickListener(final RecyclerView.ViewHolder holder, final String value) {

        ViewHolderFilled viewHolderFilled = (ViewHolderFilled) holder;
        viewHolderFilled.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Toast.makeText(mContext, value, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {

        if (mList == null || mList.size() == 0) {
            return 1;
        } else {
            return mList.size();
        }

    }

    /**
     * View holder class
     */
    public class ViewHolderFilled extends RecyclerView.ViewHolder {
        private TextView tvItem;
        private Button btn;

        /**
         * Constructor function
         *
         * @param itemView view
         */
        public ViewHolderFilled(final View itemView) {
            super(itemView);

            tvItem = (TextView) itemView.findViewById(R.id.tvItem);
            btn = itemView.findViewById(R.id.btn);

        }

    }

    /**
     * View holder class
     */
    public class ViewHolderEmpty extends RecyclerView.ViewHolder {
        private TextView tvEmpty;


        /**
         * Constructor function
         *
         * @param itemView view
         */
        public ViewHolderEmpty(final View itemView) {
            super(itemView);
            tvEmpty = (TextView) itemView.findViewById(R.id.tvEmpty);


        }

    }

    /**
     * Method to set data in list
     *
     * @param list
     */
    public void setData(final ArrayList<String> list) {

        mList = list;
        notifyDataSetChanged();
    }
}
