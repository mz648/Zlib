package com.zivari.mylibs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class clsImage {

    public static Bitmap bitmap_resized(Bitmap image, int maxWidth, int maxHeight) {
        int width = image.getWidth();
        int height = image.getHeight();

        if(width>maxWidth && height>maxHeight){
            double ratio;
            if (width > height) {
                // landscape
                ratio = (width+.0) / maxWidth;
                width = maxWidth;
                height = (int) (height / ratio);
            } else if (height > width) {
                // portrait
                ratio = (height+.0) / maxHeight;
                height = maxHeight;
                width = (int) (width / ratio);
            } else {
                // square
                height = maxHeight;
                width = maxWidth;
            }
        }


        return Bitmap.createScaledBitmap(image, width, height, true);
    }
    public static String imge_to_base64(Bitmap bmp,int maxWidth,int maxHeight) {
        try {
            bmp=bitmap_resized(bmp,maxWidth,maxHeight);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] imageBytes = baos.toByteArray();
            String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
            return encodedImage;
        }
        catch (Exception ex){
            ex.printStackTrace();
            Log.i("imgg",ex.getMessage().toString());
            return "";
        }

    }
    public static String base64_resized(String base64image,int maxWidth,int maxHeight){
        byte [] encodeByte=Base64.decode(base64image.getBytes(),Base64.DEFAULT);
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inPurgeable = true;
        Bitmap image = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length,options);


        if(image.getHeight() <= 600 && image.getWidth() <= 600){
            return base64image;
        }
        int width = image.getWidth();
        int height = image.getHeight();

        Log.v("Pictures", "Width and height are " + width + "--" + height);

        if (width > height) {
            // landscape
            int ratio = width / maxWidth;
            width = maxWidth;
            height = height / ratio;
        } else if (height > width) {
            // portrait
            int ratio = height / maxHeight;
            height = maxHeight;
            width = width / ratio;
        } else {
            // square
            height = maxHeight;
            width = maxWidth;
        }


        //image = Bitmap.createScaledBitmap(image, 400, 250, false);
        image = Bitmap.createScaledBitmap(image, width, height, false);

        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG,100, baos);

        byte [] b=baos.toByteArray();
        System.gc();
        return Base64.encodeToString(b, Base64.NO_WRAP);

    }
    public boolean bitmap_compare(Bitmap bitmap1, Bitmap bitmap2) {
        ByteBuffer buffer1 = ByteBuffer.allocate(bitmap1.getHeight() * bitmap1.getRowBytes());
        bitmap1.copyPixelsToBuffer(buffer1);

        ByteBuffer buffer2 = ByteBuffer.allocate(bitmap2.getHeight() * bitmap2.getRowBytes());
        bitmap2.copyPixelsToBuffer(buffer2);

        return Arrays.equals(buffer1.array(), buffer2.array());
    }
    public static void picasso_set(String url, Context context, ImageView row_img){
        if(url==null)
            return;
        if(url!= null && !url.equals("")){
            Picasso.with(context).load(url).placeholder(R.drawable.no_image).into(row_img);
        }
        else
            row_img.setImageResource(R.drawable.no_image);
    }
    public static void picasso_set2(String url, Context context, ImageView row_img,int no_image_id){
        if(url!= null && !url.equals("")){
            Picasso.with(context).load(url).placeholder(no_image_id).into(row_img);
        }
        else
            row_img.setImageResource(R.drawable.no_image);
    }
}
