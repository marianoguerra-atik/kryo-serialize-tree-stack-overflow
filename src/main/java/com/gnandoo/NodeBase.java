package com.gnandoo;

public interface NodeBase<T> {
	public void set(String key, T value);
	public void set(String key, NodeBase<T> child);
	public NodeBase<T> get(String key);
	
	public T value();
}
