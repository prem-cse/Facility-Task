package com.example.facilitytask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facilitytask.model.FacilitiesItem;
import com.example.facilitytask.model.OptionsItem;

import java.util.List;

public class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.FacilityViewHolder> {

    private Context context;
    private List<FacilitiesItem> facilitiesItemList;

    public FacilityAdapter(Context context, List<FacilitiesItem> facilitiesItemList) {
        this.context = context;
        this.facilitiesItemList = facilitiesItemList;
    }

    @NonNull
    @Override
    public FacilityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new FacilityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FacilityViewHolder holder, int position) {
        holder.bind(facilitiesItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return facilitiesItemList.size();
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
            List<OptionsItem> optionsItems = item.getOptions();
            RadioGroup.LayoutParams params;
            for (int i = 0; i < optionsItems.size(); i++) {
                RadioButton radioButton = new RadioButton(context);
                radioButton.setId(View.generateViewId());
                radioButton.setText(optionsItems.get(i).getName());
                params = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                radioGroup.addView(radioButton, params);
            }
        }
    }
}
