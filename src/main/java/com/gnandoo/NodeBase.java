package com.gnandoo;

public interface NodeBase {
	public void set(String key, Long value);
	public void set(String key, NodeBase child);
	public NodeBase get(String key);
	
	public Long value();
}
