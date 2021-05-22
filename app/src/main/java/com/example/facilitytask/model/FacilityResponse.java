package com.example.facilitytask.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FacilityResponse{

	@SerializedName("exclusions")
	private List<List<ExclusionsItemItem>> exclusions;

	@SerializedName("facilities")
	private List<FacilitiesItem> facilities;

	public List<List<ExclusionsItemItem>> getExclusions(){
		return exclusions;
	}

	public List<FacilitiesItem> getFacilities(){
		return facilities;
	}

	@Override
 	public String toString(){
		return 
			"FacilityResponse{" + 
			"exclusions = '" + exclusions + '\'' + 
			",facilities = '" + facilities + '\'' + 
			"}";
		}
}