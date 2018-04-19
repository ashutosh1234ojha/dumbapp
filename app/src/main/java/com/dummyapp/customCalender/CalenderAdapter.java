package com.dummyapp.customCalender;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.dummyapp.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cl-macmini-86 on 8/21/17.
 */

public class CalenderAdapter extends BaseAdapter {

    ArrayList<Task> cells = new ArrayList<>();
    List<Date> eventDates = new ArrayList<>();
    Context context;

    private static LayoutInflater inflater = null;

    public CalenderAdapter(Context context) {
        // TODO Auto-generated constructor stub

        this.context = context;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return cells == null ? 0 : cells.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder {
        TextView tvDateCell;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView;

        // today
        Date today = new Date();

        rowView = inflater.inflate(R.layout.layout_item, null);
        holder.tvDateCell = (TextView) rowView.findViewById(R.id.tvDateCell);

        holder.tvDateCell.setText(cells.get(position).getDate().getDate() + "");

        if(eventDates.get(0).getDate()==cells.get(position).getDate().getDate()&&
                eventDates.get(0).getMonth()==cells.get(position).getDate().getMonth()&&
                eventDates.get(0).getYear()==cells.get(position).getDate().getYear()){
            holder.tvDateCell.setBackgroundColor(ContextCompat.getColor(context,R.color.colorAccent));
        }else {
            holder.tvDateCell.setBackgroundColor(ContextCompat.getColor(context,R.color.colorWhite));
        }

        if(cells.get(position).getDate().getMonth()!=today.getMonth()&&cells.get(position).getDate().getYear()!=today.getYear()){
            holder.tvDateCell.setTextColor(ContextCompat.getColor(context, R.color.color_hint_text));
        }else {
            holder.tvDateCell.setTextColor(ContextCompat.getColor(context, R.color.colorBlue));
        }

//        if (cells.get(position).isChecked()) {
//            holder.tvDateCell.setTextColor(ContextCompat.getColor(context, R.color.colorBlue));
//        } else {
//            holder.tvDateCell.setTextColor(ContextCompat.getColor(context, R.color.colorBlack));
//        }


        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked " + cells.get(position).getDate().getDate() + "", Toast.LENGTH_SHORT).show();

                Task task = cells.get(position);
                task.setChecked(true);
                notifyDataSetChanged();
            }
        });

        return rowView;
    }


    public void setData(final ArrayList<Task> cells,final List<Date> eventDates) {
        this.cells = cells;
        this.eventDates = eventDates;
        notifyDataSetChanged();
    }
}
