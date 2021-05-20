package com.example.facilitytask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facilitytask.model.FacilitiesItem;

import java.util.List;

public class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.FacilityViewHolder>  {

    private Context context;
    private List<FacilitiesItem> facilitiesItemList;

    public FacilityAdapter(Context context, List<FacilitiesItem> facilitiesItemList) {
        this.context = context;
        this.facilitiesItemList = facilitiesItemList;
    }

    @NonNull
    @Override
    public FacilityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new FacilityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FacilityViewHolder holder, int position) {
        holder.bind(facilitiesItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FacilityViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private RadioGroup radioGroup;

        public FacilityViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            radioGroup = itemView.findViewById(R.id.radio_group);
        }

        public void bind(FacilitiesItem item) {
            name.setText(item.getName());
            int options = item.getOptions().size();
            radioGroup.setOrientation(LinearLayout.HORIZONTAL);

            for (int i = 1; i <= options; i++) {
                RadioButton rbn = new RadioButton(context);
                rbn.setId(View.generateViewId());
                rbn.setText("RadioButton" + i);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
                rbn.setLayoutParams(params);
                radioGroup.addView(rbn);
            }
        }
    }
}
