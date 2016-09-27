package com.gnandoo;

import java.util.HashMap;
import java.util.Map;

public class Node<T> implements NodeBase<T> {
	private final Map<String, NodeBase<T>> childs;
	
	public Node() {
		this.childs = new HashMap<String, NodeBase<T>>();
	}

	public void set(String key, T value) {
		this.set(key, new Leaf<T>(value));
	}

	public void set(String key, NodeBase<T> child) {
		this.childs.put(key, child);
	}

	public NodeBase<T> get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public T value() {
		throw new IllegalArgumentException("can't get value on a node");
	}

	public String toString() {
		return "Node" + this.childs;
	}
}
