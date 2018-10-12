package com.zivari.mylibs;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.opengl.ETC1Util;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class clsMethodes {


    public static ArrayList<HashMap<String, String>> my_json(String result)  {

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(result);

        String currentKey = "";

        for (int i = 0; i < jsonArray.length(); i++) {

            HashMap<String, String> hashMap = new HashMap<String, String>();

            JSONObject jsonObject = jsonArray.getJSONObject(i);
            HashMap<String, Object> has_add = new HashMap<String, Object>();


            Iterator<String> iterator = jsonObject.keys();


            while (iterator.hasNext()) {

                currentKey = iterator.next();
                hashMap.put(currentKey, jsonObject.getString(currentKey));

            }
            list.add(hashMap);

        }

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void my_json2(String result, ArrayList<HashMap<String, String>> list) throws JSONException {

        if (result == null || result.equals(""))
            return;
        JSONArray jsonArray = new JSONArray(result);
        String currentKey = "";

        for (int i = 0; i < jsonArray.length(); i++) {

            HashMap<String, String> hashMap = new HashMap<String, String>();

            JSONObject jsonObject = jsonArray.getJSONObject(i);
            HashMap<String, Object> has_add = new HashMap<String, Object>();


            Iterator<String> iterator = jsonObject.keys();


            while (iterator.hasNext()) {

                currentKey = iterator.next();
                hashMap.put(currentKey, jsonObject.getString(currentKey));

            }
            list.add(hashMap);

        }


    }

    public static String get_rdo_group(RadioGroup group) {
        int radioButtonID = group.getCheckedRadioButtonId();
        View radioButton = group.findViewById(radioButtonID);
        int idx = group.indexOfChild(radioButton);

        RadioButton r = (RadioButton) group.getChildAt(idx);
        String selectedtext = r.getText().toString();

        return selectedtext;
    }


    public static void make_call(Activity activity,String number) {

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + number));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        if (ActivityCompat.checkSelfPermission(clsVars_foods.activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//           clsMsg.msg_toast("لطفا دسترسی به تماس را فعال نمایید");
//            return;
//        }
        activity.startActivity(callIntent);
    }
    public static void send_sms(Activity activity,String number){

        activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + number)));

    }
    public static void open_url_browser(Activity activity,String s){

        String url="";
        if(!s.contains("http://"))
            url="http://";
        url+=s;

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
        activity.startActivity(browserIntent);

    }
    public static void open_email(Activity activity,String email){

       activity.startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"+email)));
    }

    public static boolean checkNet(Activity activity){

        boolean connect=false;

        ConnectivityManager connectivityManager=(ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()== NetworkInfo.State.CONNECTED
                || connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()== NetworkInfo.State.CONNECTED     ){

            connect=true;
        }
        else
        {
//            Toast.makeText(activity,"اینترنت قطع می باشد",Toast.LENGTH_LONG).show();
            clsMsg.msg_toast(activity,"اینترنت قطع می باشد");
        }

        return connect;


    }

    public static boolean checkNet2(Activity activity){

        boolean connect=false;
        HttpsTrustManager.allowAllSSL();
        ConnectivityManager connectivityManager=(ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()== NetworkInfo.State.CONNECTED
                || connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()== NetworkInfo.State.CONNECTED     ){

            connect=true;
        }
        else
        {
            connect=false;
        }

        return connect;


    }


    public static boolean is_exist_char(String s, char c){
        boolean ise=false;

        int plusIndex = s.indexOf(c);

        if(plusIndex>=0)
            ise=true;

        return ise;
    }

    public static void spinners_set(Activity activity, Spinner spinner, String []items){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    public static void spinners_set(Activity activity, Spinner spinner, ArrayList<HashMap<String,String>> hash, String col_name){

        if(hash.size()==0)
            return;
        String []items=new String[hash.size()];
        for (int i=0;i<hash.size();i++){
            items[i]=hash.get(i).get(col_name);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public static void reset_textview(Activity activity ,TextView...pTxt)
    {

        try {
            for (TextView txt : pTxt)
            {
                txt.setText("");
            }
        }
        catch (Exception ex){
            clsMsg.msg_toast(activity,ex.getMessage().toString());
        }

    }

    public static String fa_to_en(String number){

        char chars[] = new char[number.length()];
        for(int i=0;i<number.length();i++) {
            char ch = number.charAt(i);
            if (ch >= 0x0660 && ch <= 0x0669)
                ch -= 0x0660 - '0';
            else if (ch >= 0x06f0 && ch <= 0x06F9)
                ch -= 0x06f0 - '0';
            chars[i] = ch;
        }
        return new String(chars);

    }

    public static int list_search(ArrayList<HashMap<String,String>> hash,String col_name,String val){
        for(int i=0;i<hash.size();i++){
            if(hash.get(i).get(col_name).equals(val))
                return i;
        }
        return 0;
    }

    public static void copy_hash(ArrayList<HashMap<String,String>> hash_src,ArrayList<HashMap<String,String>> hash_dst){

        hash_dst.clear();

        for(HashMap<String,String> hashMap:hash_src){
            hash_dst.add(hashMap);
        }
    }

    public static String url_get_filename(String url){
        String fileName = url.substring(url.lastIndexOf('/') + 1);
        return fileName;
    }
    public static String url_get_ext(String url){
        String extension = url.substring(url.lastIndexOf("."));
        extension=extension.replace(".","").toLowerCase();
        return extension;
    }

    public static String file_to_base64(Activity activity,String file_path){

        File file=new File(file_path);

        int size = (int) file.length();
        byte[] bytes = new byte[size];
        try {

            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
        }
        catch (FileNotFoundException e) {
            clsMsg.msg_toast(activity,e.getMessage());
        }
        catch (IOException e) {
            clsMsg.msg_toast(activity,e.getMessage());
        }

        String base64=Base64.encodeToString(bytes,Base64.DEFAULT);

        return base64;
    }


}
