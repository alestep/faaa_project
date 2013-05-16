package com.example.wecharades;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;

public class DownloadFile extends AsyncTask<Void, Long, Boolean> {

	DropboxAPI<AndroidAuthSession> dDBApi;
	Context dContext;
	private final  ProgressDialog uDialog;
	private long dFileLen;
	long bytess;

	public DownloadFile(Context context,
			DropboxAPI<AndroidAuthSession> mDBApi) {
		dDBApi=mDBApi;
		dContext=context.getApplicationContext();
		uDialog = new ProgressDialog(context);
		uDialog.setMax(100);
		uDialog.setMessage("Downloading Image");
		uDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		uDialog.show();
	}

	@Override
	protected Boolean doInBackground(Void... params) {

		String path1= Environment.getExternalStorageDirectory()+"/log.txt";
		BufferedOutputStream out=null;
		try {
			File file = new File(path1);
			out = new BufferedOutputStream(new FileOutputStream(file));
			dDBApi.getFile("/log.txt", null,out, null);
		} catch (DropboxException e) {
			Log.e("DbExampleLog", "Something went wrong while downloading.");
		} catch (FileNotFoundException e) {
			Log.e("DbExampleLog", "File not found.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {}
			}
		}
		return null;
	}

}
