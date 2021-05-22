package com.example.facilitytask.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FacilitiesItem{

	@SerializedName("name")
	private String name;

	@SerializedName("options")
	private List<OptionsItem> options;

	@SerializedName("facility_id")
	private String facilityId;

	public String getName(){
		return name;
	}

	public List<OptionsItem> getOptions(){
		return options;
	}

	public String getFacilityId(){
		return facilityId;
	}

	@Override
 	public String toString(){
		return 
			"FacilitiesItem{" + 
			"name = '" + name + '\'' + 
			",options = '" + options + '\'' + 
			",facility_id = '" + facilityId + '\'' + 
			"}";
		}
}