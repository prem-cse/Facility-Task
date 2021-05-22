package com.example.facilitytask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facilitytask.model.ExclusionsItem;
import com.example.facilitytask.model.FacilitiesItem;
import com.example.facilitytask.model.OptionsItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.FacilityViewHolder> {

    private final Context context;
    private final List<FacilitiesItem> facilitiesItems;
    private final List<List<ExclusionsItem>> exclusions;
    private final Map<String, String> checkedMap;

    public FacilityAdapter(Context context, List<FacilitiesItem> facilitiesItems, List<List<ExclusionsItem>> exclusions) {
        this.context = context;
        this.facilitiesItems = facilitiesItems;
        this.exclusions = exclusions;
        checkedMap = new HashMap<>();
    }

    @NonNull
    @Override
    public FacilityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new FacilityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FacilityViewHolder holder, int position) {
        holder.bind(facilitiesItems.get(position));
    }

    @Override
    public int getItemCount() {
        return facilitiesItems.size();
    }

    public class FacilityViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final RadioGroup radioGroup;

        public FacilityViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            radioGroup = itemView.findViewById(R.id.radio_group);
        }

        public void bind(FacilitiesItem item) {
            // set the name of the item
            name.setText(item.getName());
            // put the checked radio button Id of the current item
            checkedMap.put(item.getFacilityId(), "-1");
            // generate radio buttons
            List<OptionsItem> optionsItems = item.getOptions();
            RadioGroup.LayoutParams params;

            for (int i = 0; i < optionsItems.size(); i++) {
                RadioButton radioButton = new RadioButton(context);
                // Assuming option item Id to be unique otherwise we will use View.generateViewId()
                radioButton.setId(Integer.parseInt(optionsItems.get(i).getId()));
                radioButton.setText(optionsItems.get(i).getName());
                params = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                radioGroup.addView(radioButton, params);
            }

            // logic to perform exclusion checks
            radioGroup.setOnCheckedChangeListener((group, optionId) -> {

                RadioButton checkedRadioButton = group.findViewById(optionId);
                boolean isChecked = checkedRadioButton.isChecked();

                if (isChecked) {
                    if (conflicted(item.getFacilityId(), optionId)) {
                        new AlertDialog.Builder(context)
                                .setTitle("Permission Denied")
                                .setMessage("Sorry you can't select this option")

                                .setPositiveButton("Clear selection", (dialog, which) -> {
                                    checkedRadioButton.setChecked(false);
                                    checkedMap.replace(item.getFacilityId(), "-1");
                                })
                                .setCancelable(false)
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    } else {
                        // update checked option Id
                        checkedMap.replace(item.getFacilityId(), String.valueOf(optionId));
                    }

                }
            });
        }

        private boolean conflicted(String facilityId, int optionId) {
            for (List<ExclusionsItem> list : exclusions) {
                // Assuming it to be a pair of exclusions

                ExclusionsItem first = list.get(0);
                ExclusionsItem second = list.get(1);

                /*
                 * Check if any one of the pair is same as the selected component.
                 * If it is same then check if other excluded item of the pair is already selected previously or not.
                 * If excluded item is selected then we deny permission of selecting current component to the user.
                 */

                if (first.getFacilityId().equals(facilityId)) {
                    if (first.getOptionsId().equals(String.valueOf(optionId))) {
                        String alreadySelectedOptionId = checkedMap.get(second.getFacilityId());
                        if (alreadySelectedOptionId.equals(second.getOptionsId())) return true;
                    }
                } else if (second.getFacilityId().equals(facilityId)) {
                    if (second.getOptionsId().equals(String.valueOf(optionId))) {
                        String alreadySelectedOptionId = checkedMap.get(first.getFacilityId());
                        if (alreadySelectedOptionId.equals(first.getOptionsId())) return true;
                    }
                }

            }
            return false;
        }
    }
}
