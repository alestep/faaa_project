package com.example.wecharades.presenter;

public interface IFileCreator {
	public void writeInternal(String filename, Object save);
	public void wirteExternal(String filebane, Object save);
}
