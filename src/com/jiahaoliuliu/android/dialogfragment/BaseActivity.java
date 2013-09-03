package com.jiahaoliuliu.android.dialogfragment;

import com.jiahaoliuliu.androidframeprogressdialog.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

public class BaseActivity extends FragmentActivity {

	private Button showDialogButton;

	private FragmentManager fm = getSupportFragmentManager();
	private LoadingDialog loadingDialog = new LoadingDialog();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		showDialogButton = (Button)findViewById(R.id.showDialog);
		showDialogButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				loadingDialog.show(fm, "loadingFragmentDialog");
				loadingDialog.show(fm, "loadingFragmentDialog");
				loadingDialog.show(fm, "loadingFragmentDialog");
				loadingDialog.show(fm, "loadingFragmentDialog");
				loadingDialog.show(fm, "loadingFragmentDialog");
				loadingDialog.show(fm, "loadingFragmentDialog");
			}
		});
		
	}

	@Override
	protected void onResume() {
		super.onResume();
		// Dismiss once. It is not enough
		loadingDialog.dismiss();

		// Force dismiss the loading dialog
		loadingDialog.dismissForce();
	}

}
