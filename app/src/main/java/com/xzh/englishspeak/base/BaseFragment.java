package com.xzh.englishspeak.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;

import com.xzh.englishspeak.view.LoadingDialog;


public class BaseFragment extends Fragment {

	public LoadingDialog mLoadingDialog = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mLoadingDialog = new LoadingDialog(getActivity());
		mLoadingDialog.setCanceledOnTouchOutside(false);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return false;
	}

	protected void cancelLoadingDialog() {
		if (!getActivity().isFinishing()) {
			mLoadingDialog.cancel();
		}
	}
}