package com.dummyapp;


import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;



/**
 * Created by cl_macmini_86 on 4/8/16.
 */
public class ThreeButtonAlert {

    public static void showAlert(Context sourceContext, String head, String left, String right,
                                 OnAlertOkCancelClickListener onAlertOkClickListener1) {

        try {
            final Dialog dialog;
            final OnAlertOkCancelClickListener mOnAlertOkClickListener;

            mOnAlertOkClickListener=onAlertOkClickListener1;

            dialog = new Dialog(sourceContext, android.R.style.Theme_Translucent_NoTitleBar);
            dialog.setContentView(R.layout.three_button_custom_alert);
            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
            lp.dimAmount = 0.5f;// Dim level. 0.0 - no dim, 1.0 - completely opaque
            dialog.getWindow().setAttributes(lp);

            TextView tvHead = (TextView) dialog.findViewById(R.id.tvInfo);
            TextView leftButton = (TextView) dialog.findViewById(R.id.tvLeftSide);
            TextView rightButton = (TextView) dialog.findViewById(R.id.tvRightSide);
            TextView tvCenterSide = (TextView) dialog.findViewById(R.id.tvCenterSide);


            dialog.getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_DIM_BEHIND);

            //   used to dismiss teh dialog on onbackpressed of that activity
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);



            tvHead.setText(head);
            leftButton.setText(left);
            rightButton.setText(right);

            rightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mOnAlertOkClickListener.onOkButtonClicked();
                    dialog.dismiss();
                }
            });

            leftButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mOnAlertOkClickListener.onCancelButtonClicked();

                    dialog.dismiss();
                }
            });

            tvCenterSide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mOnAlertOkClickListener.onViewClicked();

                    dialog.dismiss();
                }
            });
            dialog.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface OnAlertOkClickListener {
        void onOkButtonClicked();

    }

    public interface OnAlertOkCancelClickListener {
        void onOkButtonClicked();
        void onCancelButtonClicked();
        void onViewClicked();

    }
}

