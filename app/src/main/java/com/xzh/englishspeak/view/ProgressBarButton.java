package com.xzh.englishspeak.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ProgressBarButton extends RelativeLayout {

	private int textViewId = 1234;
	private ProgressBar mProgressBar;
	private TextView mText;
	private LayoutParams mLayoutParams, mLayoutParams2;

	public ProgressBarButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		initAttrs();
		initTextView(context, attrs);
		initProgressBar(context, attrs);
	}

	private void initAttrs() {

	}

	private void initProgressBar(Context context, AttributeSet attrs) {
		mProgressBar = new ProgressBar(context, attrs,
				android.R.attr.progressBarStyleSmallInverse);
		mProgressBar.setVisibility(View.GONE);
		mProgressBar.setId(textViewId++);
		mProgressBar.setBackgroundDrawable(null);
		mLayoutParams2 = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		mLayoutParams2.addRule(CENTER_VERTICAL);
		mLayoutParams2.addRule(RelativeLayout.LEFT_OF, mText.getId());
		mLayoutParams2.setMargins(10, 0, 10, 0);
		mProgressBar.setLayoutParams(mLayoutParams2);
		addView(mProgressBar);
	}

	private void initTextView(Context context, AttributeSet attrs) {
		mText = new TextView(context, attrs);
		mText.setId(textViewId++);
		mText.setTextColor(getResources().getColor(android.R.color.white));
		mText.setText("登录");
		mText.setGravity(Gravity.CENTER);
		mText.setBackgroundDrawable(null);
		mLayoutParams = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		mLayoutParams.addRule(CENTER_IN_PARENT);

		mText.setLayoutParams(mLayoutParams);
		addView(mText);
	}

	public ProgressBarButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void setVisibility(int visibility) {
		mText.setVisibility(visibility);
		mProgressBar.setVisibility(visibility);
		super.setVisibility(visibility);
	}

	public void setProgressBarVisibility(int v) {
		mProgressBar.setVisibility(v);
	}

	public void setText(String text) {
		mText.setText(text);
	}

	public void setTextColor(int id){
		mText.setTextColor(getResources().getColor(id));
	}
}
