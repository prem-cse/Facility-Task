package com.example.facilitytask.model;

import com.google.gson.annotations.SerializedName;

public class OptionsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("icon")
	private String icon;

	@SerializedName("id")
	private String id;

	public String getName(){
		return name;
	}

	public String getIcon(){
		return icon;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"OptionsItem{" + 
			"name = '" + name + '\'' + 
			",icon = '" + icon + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}