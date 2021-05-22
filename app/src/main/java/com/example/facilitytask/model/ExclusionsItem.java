package com.example.facilitytask.model;

import com.google.gson.annotations.SerializedName;

public class ExclusionsItem {

	@SerializedName("options_id")
	private String optionsId;

	@SerializedName("facility_id")
	private String facilityId;

	public String getOptionsId(){
		return optionsId;
	}

	public String getFacilityId(){
		return facilityId;
	}

	@Override
 	public String toString(){
		return 
			"ExclusionsItem{" +
			"options_id = '" + optionsId + '\'' + 
			",facility_id = '" + facilityId + '\'' + 
			"}";
		}
}