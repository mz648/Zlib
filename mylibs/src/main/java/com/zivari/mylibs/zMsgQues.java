package com.zivari.mylibs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class zMsgQues {

    Activity activity;
    String msg;
    private OnSelectedListener listener;
    int text_color=R.color.color_blue2;

    public interface OnSelectedListener{
        void onYes();
        void onNo();
    }

    public zMsgQues(Activity _activity,String _msg){

        activity=_activity;
        msg=_msg;
    }
    public void set_text_color(int color){
        text_color=color;
    }
    public void setOnSelectedListener(OnSelectedListener onSelectedListener){
        listener=onSelectedListener;

//        AlertDialog.Builder alert=new AlertDialog.Builder(activity);
//        alert.setMessage(msg);
//        alert.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                listener.onNo();
//            }
//        });
//        alert.setPositiveButton("بله", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                listener.onYes();
//            }
//        });
//        alert.create().show();

        TextView txt_msg;
        Button btn_ok,btn_cancel;

        final Dialog dialog=new Dialog(activity);
        dialog.setContentView(R.layout.dialog_msg_ques);
        dialog.setCancelable(true);

        txt_msg=(TextView)dialog.findViewById(R.id.txt_msg);

        btn_ok=(Button) dialog.findViewById(R.id.btn_ok);
        btn_cancel=(Button) dialog.findViewById(R.id.btn_cancel);

        txt_msg.setTextColor(activity.getResources().getColor(text_color));

        txt_msg.setText(msg);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNo();
                dialog.dismiss();
            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onYes();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
