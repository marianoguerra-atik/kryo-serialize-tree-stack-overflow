package com.gnandoo;

import java.util.HashMap;
import java.util.Map;

public class Node implements NodeBase {
	private final Map<String, NodeBase> childs;
	
	public Node() {
		this.childs = new HashMap<String, NodeBase>();
	}

	public void set(String key, Long value) {
		this.set(key, new Leaf(value));
	}

	public void set(String key, NodeBase child) {
		this.childs.put(key, child);
	}

	public NodeBase get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long value() {
		throw new IllegalArgumentException("can't get value on a node");
	}

	public String toString() {
		return "Node" + this.childs;
	}
}
