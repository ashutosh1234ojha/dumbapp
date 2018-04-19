package com.dummyapp.contacts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dummyapp.R;

import java.util.List;


/**
 * Created by Ashutosh on 13/6/17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private Context mContext;
    private List<String> contactList;

    /**
     * Constructor of notification adapter
     *
     * @param mContext of activity or fragment
     */
    public ContactAdapter(final Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tvDateCell.setText(contactList.get(holder.getAdapterPosition()));


    }


    @Override
    public int getItemCount() {

        return contactList != null ? contactList.size() : 0;
    }

    /**
     * View holder class
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvDateCell;

        /**
         * Constructor function
         *
         * @param itemView view
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvDateCell = (TextView) itemView.findViewById(R.id.tvDateCell);

        }

        @Override
        public void onClick(final View v) {

        }
    }

    /**
     * Method to set data in list
     *
     * @param list list of items to be shown in recycler view
     */
    public void setData(final List<String> list) {
        this.contactList = list;
        notifyDataSetChanged();
    }
}
