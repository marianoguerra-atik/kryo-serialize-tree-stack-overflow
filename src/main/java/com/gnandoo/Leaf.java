package com.gnandoo;

public class Leaf<T> implements NodeBase<T> {
	private T _value;
	
	public Leaf(T value) {
		this._value = value;
	}

	public void set(String key, T value) {
		throw new IllegalArgumentException("can't set on a leaf: " + key + " -> " + value);
	}

	public void set(String key, NodeBase<T> child) {
		throw new IllegalArgumentException("can't set on a leaf: " + key + " -> " + child);
	}

	public NodeBase<T> get(String key) {
		throw new IllegalArgumentException("can't get on a leaf: " + key);
	}

	public T value() {
		return this._value;
	}

	public String toString() {
		return "Leaf(" + this._value + ")";
	}

}
