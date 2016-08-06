package com.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JavaCollection {
	List addrList;
	Set addrSet;
	Map addrMap;
	Properties addrProp;

	public List getAddrList() {
		System.out.println("List Elements :" + addrList);
		return addrList;
	}

	public void setAddrList(List addrList) {
		this.addrList = addrList;
	}

	public Set getAddrSet() {
		System.out.println("Set Elements :" + addrSet);
		return addrSet;
	}

	public void setAddrSet(Set addrSet) {
		this.addrSet = addrSet;
	}

	public Map getAddrMap() {
		System.out.println("Map Elements :" + addrMap);
		return addrMap;
	}

	public void setAddrMap(Map addrMap) {
		this.addrMap = addrMap;
	}

	public Properties getAddrProp() {
		System.out.println("Prop Elements :" + addrProp);
		return addrProp;
	}

	public void setAddrProp(Properties addrProp) {
		this.addrProp = addrProp;
	}

}
