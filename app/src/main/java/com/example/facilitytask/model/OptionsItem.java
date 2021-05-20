package com.example.facilitytask.model;

import com.google.gson.annotations.SerializedName;

public class OptionsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("icon")
	private String icon;

	@SerializedName("id")
	private String id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setId(String id){
		this.id = id;
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