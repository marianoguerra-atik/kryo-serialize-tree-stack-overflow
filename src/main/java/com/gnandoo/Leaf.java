package com.gnandoo;

public class Leaf implements NodeBase {
	private Long _value;
	
	public Leaf(Long value) {
		this._value = value;
	}
	
	public Leaf() {
	}

	public void set(String key, Long value) {
		throw new IllegalArgumentException("can't set on a leaf: " + key + " -> " + value);
	}

	public void set(String key, NodeBase child) {
		throw new IllegalArgumentException("can't set on a leaf: " + key + " -> " + child);
	}

	public NodeBase get(String key) {
		throw new IllegalArgumentException("can't get on a leaf: " + key);
	}

	public Long value() {
		return this._value;
	}
	
	public void setValue(Long value) {
		this._value = value;
	}

	public String toString() {
		return "Leaf(" + this._value + ")";
	}

}
