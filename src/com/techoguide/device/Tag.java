package com.techoguide.device;

import java.util.BitSet;
import java.util.List;

public class Tag {
	
	private String name;
	private String info;
	private List<BitSet> keys;
	private List<BitSet> baseTokens;
	private List<BitSet> baseIndicators;
	
	public Tag( String name, String info, List<BitSet> keys, List<BitSet> baseTokens, List<BitSet> baseIndicators )
	{
		this.name = name;
		this.info = info;
		this.keys = keys;
		this.baseTokens = baseTokens;
		this.baseIndicators = baseIndicators;
	}
	
	public Tag() {}

	public String getName() {
		return name;
	}

	public Tag setName(String name) {
		this.name = name;
		return this;
	}

	public String getInfo() {
		return info;
	}

	public Tag setInfo(String info) {
		this.info = info;
		return this;
	}

	public List<BitSet> getKeys() {
		return keys;
	}

	public Tag setKeys(List<BitSet> keys) {
		this.keys = keys;
		return this;
	}

	public List<BitSet> getBaseTokens() {
		return baseTokens;
	}

	public Tag setBaseTokens(List<BitSet> baseTokens) {
		this.baseTokens = baseTokens;
		return this;
	}

	public List<BitSet> getBaseIndicators() {
		return baseIndicators;
	}

	public Tag setBaseIndicators(List<BitSet> baseIndicators) {
		this.baseIndicators = baseIndicators;
		return this;
	}
	
	
	

}
