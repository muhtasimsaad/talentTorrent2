package com.example.talenttorrent.adapters;


import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.talenttorrent.R;
import com.example.talenttorrent.models.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class trainingAdapter extends BaseExpandableListAdapter {
    private ArrayList<training> trainings =new ArrayList<>();

    private Context context;
    private List<String> expandableListTitle;
    private HashMap<String, List<String>> expandableListDetail;

    public trainingAdapter(Context context, List<String> expandableListTitle,
                      HashMap<String, List<String>> expandableListDetail, ArrayList<training>arr) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
        this.trainings =arr;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .get(expandedListPosition);

    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expanded_view, null);
        }
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.tvChildItem);
        expandedListTextView.setText(expandedListText);
        //ImageView iv = (ImageView) convertView.findViewById(R.id.imgItem);


        //iv.setVisibility(View.GONE);

        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(final int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        //generate the view for each group as well as initiate the button functions


        final String listTitle = (String) getGroup(listPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.training_row, null);
        }

        TextView budget=convertView.findViewById(R.id.budget);
        TextView header = (TextView) convertView.findViewById(R.id.header);
        TextView price = (TextView) convertView.findViewById(R.id.price);
        header.setTypeface(null, Typeface.BOLD);

        String[] temp=listTitle.split("<>");
        header.setText(temp[0]);
        budget.setText(temp[1]);
        price.setText(temp[2]);



        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }



}
