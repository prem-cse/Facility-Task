package com.example.facilitytask.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Facility{

	@SerializedName("exclusions")
	private List<ExclusionsItemItem> exclusions;

	@SerializedName("facilities")
	private List<FacilitiesItem> facilities;

	public void setExclusions(List<ExclusionsItemItem> exclusions){
		this.exclusions = exclusions;
	}

	public List<ExclusionsItemItem> getExclusions(){
		return exclusions;
	}

	public void setFacilities(List<FacilitiesItem> facilities){
		this.facilities = facilities;
	}

	public List<FacilitiesItem> getFacilities(){
		return facilities;
	}

	@Override
 	public String toString(){
		return 
			"Facility{" + 
			"exclusions = '" + exclusions + '\'' + 
			",facilities = '" + facilities + '\'' + 
			"}";
		}
}