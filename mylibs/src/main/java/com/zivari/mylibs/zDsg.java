package com.zivari.mylibs;


import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class zDsg {


    public static void setFace_textview( Activity activity,String font, TextView...pTxt)
    {

        try {

            Typeface face=Typeface.createFromAsset(activity.getAssets(), "fonts/"+font+".ttf");

            for (TextView txt : pTxt)
            {
                txt.setTypeface(face);
                //txt.setText(txt.getText().toString());
            }
        }
        catch (Exception ex){
            zMsg.msg_toast(activity,true,ex.getMessage().toString());
        }

    }

    public static void setFace_switch(Activity activity, String font, Switch...pSw)
    {
        try {
            Typeface face=Typeface.createFromAsset(activity.getAssets(), "fonts/"+font+".ttf");
            for (Switch sw : pSw)
            {
                sw.setTypeface(face);
            }
        }
        catch (Exception ex){
            zMsg.msg_toast(activity,true,ex.getMessage().toString());
        }
    }

    public static void setFace_radio(Activity activity, String font, RadioButton...pRdo)
    {
        try {
            Typeface face=Typeface.createFromAsset(activity.getAssets(), "fonts/"+font+".ttf");
            for (RadioButton rdo : pRdo)
            {
                rdo.setTypeface(face);
            }
        }
        catch (Exception ex){
            zMsg.msg_toast(activity,true,ex.getMessage().toString());
        }
    }


    public static void setFace_mat_edittext( Activity activity,String font, EditText...pTxt)
    {

        try {
            Typeface face=Typeface.createFromAsset(activity.getAssets(), "fonts/"+font+".ttf");

            for (EditText txt : pTxt)
            {
                txt.setTypeface(face);
            }
        }
        catch (Exception ex){
            zMsg.msg_toast(activity,true,ex.getMessage().toString());
        }

    }

    public static void setFace_checkbox( Activity activity,String font, CheckBox...pChk)
    {

        try {

            Typeface face=Typeface.createFromAsset(activity.getAssets(), "fonts/"+font+".ttf");

            for (CheckBox chk : pChk)
            {
                chk.setTypeface(face);
            }
        }
        catch (Exception ex){
            zMsg.msg_toast(activity,true,ex.getMessage().toString());
        }

    }


    public static void setUnderline_textview( TextView...pTxt)
    {

        for (TextView txt : pTxt)
        {
            txt.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        }

    }

    public static void setFace_edittext(Activity activity, String font, EditText...pTxt)
    {

        try {
            Typeface face=Typeface.createFromAsset(activity.getAssets(), "fonts/"+font+".ttf");

            for (EditText txt : pTxt)
            {
                txt.setTypeface(face);
                //txt.setText(txt.getText().toString());
            }
        }
        catch (Exception ex){
            zMsg.msg_toast(activity,true,ex.getMessage().toString());
        }

    }


    public static void setFace_button(Activity activity, String font, Button...pBtn)
    {

        Typeface face=Typeface.createFromAsset(activity.getAssets(), "fonts/"+font+".ttf");

        for (Button btn : pBtn)
        {
            btn.setTypeface(face);
            btn.setText(btn.getText().toString());
        }

    }

    public static void textview_strike(TextView textView,int t){
        if(t==1)
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        else
            textView.setPaintFlags( Paint.LINEAR_TEXT_FLAG);
    }

    public interface fonts{

        String b_yekan="iranyekan_bold";
        String casablance="CasablancaHeavy";
        String iran_sans="IranSans";
        String iran_yekan ="iranyekan_regular";
    }




}
