package com.xzh.englishspeak.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.xzh.englishspeak.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class LoadingDialog extends Dialog {

    @Bind(R.id.loading_progressBar)
    ProgressBar loadingProgressBar;
    @Bind(R.id.loading_msg)
    TextView loadingMsg;

    private Context mContext = null;
    private View dialogView = null;

    public LoadingDialog(Context context) {
        this(context, R.style.progress_dialog);
        this.mContext = context;
    }

    public LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;
        init();
    }

    private void init() {
        dialogView = LayoutInflater.from(mContext).inflate(R.layout.loading_dialog, null);
        this.setContentView(dialogView);
        this.setCancelable(true);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        ButterKnife.bind(this, dialogView);
    }


    public void setText(String text) {
        if (loadingMsg != null)
            loadingMsg.setText(text);
    }

    public void setParam(int width, int height) {
        if (dialogView == null)
            return;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        dialogView.setLayoutParams(params);
    }

}
