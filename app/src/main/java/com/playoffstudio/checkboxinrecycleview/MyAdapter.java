package com.playoffstudio.checkboxinrecycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomView> {

    public Context context;
    public ArrayList<MyPojo> myPojoArrayList;
    boolean[] checkedStatus;
    public ArrayList<String> selectedItems;

    public MyAdapter(Context context, ArrayList<MyPojo> myPojoArrayList) {
        this.context = context;
        this.myPojoArrayList = myPojoArrayList;
        checkedStatus = new boolean[myPojoArrayList.size()];
        selectedItems = new ArrayList<>();
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_adapter, viewGroup, false);

        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomView holder, int position) {
        MyPojo myPojo = myPojoArrayList.get(position);

        holder.name.setText("" + myPojo.getName());

        if (myPojo.isSelect()) {
            checkedStatus[holder.getAdapterPosition()] = true;
            holder.checkBox.setChecked(true);
        }

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkedStatus[holder.getAdapterPosition()] = true;
                } else {
                    checkedStatus[holder.getAdapterPosition()] = false;
                }
            }
        });
    }


    public ArrayList<String> getItemPositions() {
        selectedItems.clear();
        for (int i = 0; i < checkedStatus.length; i++) {

            if (checkedStatus[i] == true) {
                selectedItems.add("" + myPojoArrayList.get(i).getName());
            }
        }

        return selectedItems;
    }

    @Override
    public int getItemCount() {
        return myPojoArrayList.size();
    }


    public class CustomView extends RecyclerView.ViewHolder {


        @BindView(R.id.tvName)
        TextView name;

        @BindView(R.id.chkSelected)
        CheckBox checkBox;


        public CustomView(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
