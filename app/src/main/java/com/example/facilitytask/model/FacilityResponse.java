package com.example.facilitytask.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FacilityResponse{

	@SerializedName("exclusions")
	private List<ExclusionsItemItem> exclusions;

	@SerializedName("facilities")
	private List<FacilitiesItem> facilities;

	public List<ExclusionsItemItem> getExclusions(){
		return exclusions;
	}

	public List<FacilitiesItem> getFacilities(){
		return facilities;
	}
}