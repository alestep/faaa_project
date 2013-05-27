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
		activity.showToast("Invitation sent");
	}

}
