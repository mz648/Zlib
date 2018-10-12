package com.zivari.mylibs;


import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.afollestad.materialdialogs.MaterialDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import saman.zamani.persiandate.PersianDate;

public class clsDate {

    public static String getDate_now(){

        PersianDate persian_date = new PersianDate();
        int year=persian_date.getShYear();
        int month=persian_date.getShMonth();
        int day=persian_date.getShDay();
        String date_now=String.valueOf(year)+"/"+ String.format("%02d",month)+"/"+String.format("%02d",day);
        return date_now;
    }

    public static void date_picker(final TextView txtDate, final Activity activity){

        try {
            final String date_now=getDate_now();
            String date_str=txtDate.getText().toString();
            if(date_str.equals("")){
                date_str=date_now;
            }
            String []date_arr=date_str.split("/");
            Button btnOK,btnCancel;
            final MaterialDialog dialog_date=new MaterialDialog.Builder(activity)
                    .customView(R.layout.dialog_date,false)
                    .cancelable(true)
                    .build();

            final NumberPicker numberPicker_year = (NumberPicker) dialog_date.findViewById(R.id.number_picker_year);
            final NumberPicker numberPicker_month = (NumberPicker) dialog_date.findViewById(R.id.number_picker_month);
            final NumberPicker numberPicker_day = (NumberPicker) dialog_date.findViewById(R.id.number_picker_day);

            numberPicker_year.setMaxValue(1400);
            numberPicker_year.setMinValue(1396);
            numberPicker_year.setValue( Integer.parseInt(date_arr[0]));
            numberPicker_year.setWrapSelectorWheel(true);

            String[] month_name= new String[]{"فرودین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"};
            numberPicker_month.setMinValue(0);
            numberPicker_month.setMaxValue(11);
            numberPicker_month.setValue(Integer.parseInt(date_arr[1])-1);
            numberPicker_month.setDisplayedValues(month_name);
            numberPicker_month.setWrapSelectorWheel(true);

            numberPicker_day.setMaxValue(31);
            numberPicker_day.setMinValue(1);
            numberPicker_day.setValue(Integer.parseInt(date_arr[2]));
            numberPicker_day.setWrapSelectorWheel(true);


            numberPicker_month.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    if(newVal+1>=7)
                        numberPicker_day.setMaxValue(30);
                    else numberPicker_day.setMaxValue(31);
                }
            });

            numberPicker_day.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                }
            });

            numberPicker_day.setFormatter(new NumberPicker.Formatter() {
                @Override
                public String format(int value) {
                    return String.format("%02d",value);
                }
            });

            btnOK=(Button)dialog_date.findViewById(R.id.dialog_date_btnOk) ;
            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int y,m,d;
                    String date;
                    y=numberPicker_year.getValue();
                    m=numberPicker_month.getValue()+1;
                    d=numberPicker_day.getValue();

                    date=String.valueOf(y)+"/"+String.format("%02d",m)+"/"+String.format("%02d",d);
//                    if(date_diff(date_now,date)<0){
//                        clsMsg.msg_toast(activity,"تاریخ اعتبار باید بزرگتر از تاریخ جاری باشد");
//                        return;
//                    }
                    txtDate.setText(date);
                    txtDate.requestFocus();
                    dialog_date.dismiss();

                }
            });
            btnCancel=(Button)dialog_date.findViewById(R.id.dialog_date_btnCancel) ;
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog_date.dismiss();
                }
            });

            clsDsg.setFace_button(activity, clsDsg.fonts.iran_sans,btnCancel,btnOK);
            dialog_date.show();

        }
        catch (Exception ex){
            clsMsg.msg_toast(activity,ex.getMessage().toString());
        }
    }

    static  int date_count(int y, int m, int d)
    {
        int days;
        int[] HejriMontsDays = { 31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29 };
        int kabise;
        kabise = y / 4;
        days = y * 365 + kabise;
        if (y % 4 == 0 && y > 0)
            HejriMontsDays[11] = 30;
        for (int i = 0; i < 12 && i < m - 1; i++)
        {
            days += HejriMontsDays[i];
        }
        days += d;
        return days;
    }

    public static int date_diff(String date1, String date2)
    {
        String[] temp1 = new String[3];
        String[] temp2 = new String[3];

        int y1, m1, d1;
        int y2, m2, d2;
        int day1, day2;
        int diff = 0;
        temp1 = date1.split("/");
        temp2 = date2.split("/");

        y1 = Integer.parseInt(temp1[0]); m1 =  Integer.parseInt(temp1[1]); d1 =  Integer.parseInt(temp1[2]);
        y2 =  Integer.parseInt(temp2[0]); m2 =  Integer.parseInt(temp2[1]); d2= Integer.parseInt(temp2[2]);


        day1 = date_count(y1, m1, d1);
        day2 = date_count(y2, m2, d2);

        diff = day2 - day1;

        return diff;
    }

    public static String time_diff(String firstTime,String secondTime) throws ParseException {
//        String firstTime = "24:00:00";
//        String secondTime = "10:40:20";

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        Date date1 = null;
        Date date2 = null;
        try {
            date1 = format.parse(firstTime);
            date2 = format.parse(secondTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//get difference between the two times and then convert it in seconds, minutes or hours (what you need)
        long diff = date1.getTime() - date2.getTime();
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);

        long h,m,s;
        h=diffHours;
        m=diffMinutes-(h*60)+1;
        s=diffSeconds-( (h*60*60)+ ((m-1)*60));

        String diff_str = h + ":" + m+":"+s; // updated value every1 second

        return diff_str;
    }

    public static String get_time(){

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String strTime = simpleDateFormat.format(calendar.getTime());

        return strTime;
    }
    public static void timePicker(Activity activity, final EditText edt_time){

        int hour,minute;
//        String []time=new String[2];
//        time=edt_time.getText().toString().split(":");
//        hour=clsMethodes.integer_tryparse(time[0]);
//        minute=new Integer(time[1]);
        hour=0;
        minute=0;

        TimePickerDialog timePickerDialog = new TimePickerDialog(activity,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute)
                    {

                        edt_time.setText(String.format("%02d",hourOfDay) + ":" + String.format("%02d",minute));
                    }
                }, hour, minute, true);

        timePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "تایید", timePickerDialog);
        timePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "انصراف", timePickerDialog);

        timePickerDialog.show();
    }

    public static String get_day_name(String date){

        int y,m,d;

        String temp[]=date.split("/");

        if(temp.length!=3)
            return "";
        y= clsMath.integer_tryparse(temp[0]);
        m= clsMath.integer_tryparse(temp[1]);
        d= clsMath.integer_tryparse(temp[2]);

        PersianDate persian_date = new PersianDate();

        return persian_date.dayName(y,m,d);


    }



}
