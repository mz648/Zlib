package components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.Button;

import com.zivari.mylibs.R;

public class myButton extends android.support.v7.widget.AppCompatButton {
    String [] font_arr=new String[]{"iranyekan_regular","IranSans","BYekan","CasablancaHeavy"};
    public myButton(Context context) {
        super(context);
        init(null);
    }

    public myButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public myButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

//    public myTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    void init(AttributeSet attrs){

        if(attrs!=null){

           TypedArray typedArray=getContext().obtainStyledAttributes(attrs, R.styleable.myButton);

           attr_font(typedArray);

           typedArray.recycle();
        }
    }

    void attr_font(TypedArray typedArray){

        int index=typedArray.getInt(R.styleable.myButton_button_font_name,0);
        String fontName=font_arr[index];

        Typeface typeface=Typeface.createFromAsset(getContext().getAssets(),"fonts/"+fontName+".ttf");
        setTypeface(typeface);

    }



}
