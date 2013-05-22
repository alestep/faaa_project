package com.example.wecharades.presenter;

import com.example.wecharades.views.AccountActivity;

public class AccountPresenter extends Presenter {

	private AccountActivity activity;
	public AccountPresenter(AccountActivity activity) {
		super(activity);
		this.activity = activity;
	}

}
