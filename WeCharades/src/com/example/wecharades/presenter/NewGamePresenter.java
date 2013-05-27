package com.example.wecharades.presenter;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.views.NewGameActivity;
import com.example.wecharades.views.StartActivity;

public class NewGamePresenter extends Presenter {
	
	public NewGamePresenter(NewGameActivity activity) {
		super(activity);
	}

	public void randomInvitation() {
		dc.putInRandomQueue();
		
		final Dialog dialog = new Dialog(activity);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setCanceledOnTouchOutside(false);
		dialog.setContentView(R.layout.dialog_success);
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));               

		TextView successText = (TextView) dialog.findViewById(R.id.successText);
		successText.setText("Invitation has been sent");

		Button ok = (Button) dialog.findViewById(R.id.ok);
		ok.setOnClickListener(new OnClickListener() {          
			public void onClick(View v) {
				dialog.dismiss();
				activity.startActivity(new Intent(activity, StartActivity.class));
			}
		});

		dialog.show();
	}

}
