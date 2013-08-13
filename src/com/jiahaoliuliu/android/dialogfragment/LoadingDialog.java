package com.jiahaoliuliu.android.dialogfragment;

// Source code: http://grepcode.com/file/repository.grepcode.com/java/ext/com.google.android/android/4.0.1_r1/android/app/DialogFragment.java

import com.jiahaoliuliu.androidframeprogressdialog.R;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class LoadingDialog extends DialogFragment {

	private boolean isDialogShownBool;

	public LoadingDialog() {
		// Empty constructor required for DialogFragment
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInsntaceState) {
		View view = inflater.inflate(R.layout.fragment_loading, container);
		
		// Remove the title
		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		return view;
	}

	@Override
	public int show(FragmentTransaction transaction, String tag) {
		int result = -1;
		if (!isDialogShownBool) {
			result = super.show(transaction, tag);
			isDialogShownBool = true;
		}
		return result;
	}
	
	@Override
	public void show(FragmentManager manager, String tag) {
		if (!isDialogShownBool) {
			super.show(manager, tag);
			isDialogShownBool = true;
		}
	}
	
	@Override
	public void dismiss() {
		if (isDialogShownBool) {
			super.dismiss();
		}
	}
	
	/**
	 * Check if the dialog is being shown
	 * @return true  if the dialog is shown
	 *         false otherwise
	 */
	public boolean isDialogShown() {
		return isDialogShownBool;
	}
	
	@Override
	public void onCancel(DialogInterface dialog) {
		super.onCancel(dialog);
		isDialogShownBool = false;
	}
}
