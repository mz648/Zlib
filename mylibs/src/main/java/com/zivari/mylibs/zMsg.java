package com.zivari.mylibs;


import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

public class zMsg {

    public static void msg_toast(Activity activity,boolean is_short,String msg){

        LayoutInflater inflater =activity.getLayoutInflater();

        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) activity.findViewById(R.id.custom_toast_layout_id));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(msg);
        zDsg.setFace_textview(activity, zDsg.fonts.iran_yekan,text);

        Toast toast = new Toast(activity);
        toast.setGravity(Gravity.BOTTOM, 0, 20);
        if(is_short)
            toast.setDuration(Toast.LENGTH_SHORT);
        else
            toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    public static void msg_toast(Activity activity,String msg){

        LayoutInflater inflater =activity.getLayoutInflater();

        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) activity.findViewById(R.id.custom_toast_layout_id));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(msg);
        zDsg.setFace_textview(activity, zDsg.fonts.iran_yekan,text);

        Toast toast = new Toast(activity);
        toast.setGravity(Gravity.BOTTOM, 0, 20);

        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }


    public static void msg_dialog(Activity activity, String msg){

        AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "تایید",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();


    }
    public static void msg_dialog(Activity activity,String title, String msg){

        AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
        alertDialog.setMessage(msg);
        alertDialog.setTitle(title);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "تایید",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();


    }
    public static void msg_dialog_custome(Activity activity,String title,String dess){

        try{
            final MaterialDialog dialog= new MaterialDialog.Builder(activity)
                    .customView(R.layout.dialog_msg,false)
                    .cancelable(true)
                    .show();

            Button btn_ok;
            TextView txt_dess,txt_title;

            btn_ok=(Button)dialog.findViewById(R.id.btn_ok) ;
            txt_dess=(TextView) dialog.findViewById(R.id.txt_dess) ;
            txt_title=(TextView) dialog.findViewById(R.id.txt_title) ;


            btn_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            zDsg.setFace_textview(activity, zDsg.fonts.iran_yekan,txt_dess,txt_title);
            zDsg.setFace_button(activity, zDsg.fonts.b_yekan,btn_ok);
            txt_dess.setText(dess);
            txt_title.setText(title);

            dialog.show();
        }
        catch(Exception e){
            msg_toast(activity,true,e.getMessage());
        }
    }

    public static void wait_dialog (Activity activity,MaterialDialog dialog,String msg){

        if(msg.equals(""))
            msg="لطفا کمی صبر کنید ...";


        dialog=new MaterialDialog.Builder(activity)
                .cancelable(false).content(msg)
                .progress(true,0)
                .build();

    }
    public static MaterialDialog wait_dialog(Activity activity){
        return new MaterialDialog.Builder(activity).content("لطفا صبر کنید...").cancelable(false).progress(true,0).build();
    }

    public static void alter_try(final Runnable runnable, Activity activity,String msg){

        if(msg==null)
            msg="";
        final AlertDialog.Builder alert=new AlertDialog.Builder(activity);
        alert.setMessage("خطا در اتصال به سرور.لطفا اینترنت خود را چک نمایید"+"\n"+msg);
        alert.setPositiveButton("سعی مجدد", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                new Handler().post(runnable);

            }
        });
        alert.setNegativeButton("انصراف", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.create().show();
    }


}
