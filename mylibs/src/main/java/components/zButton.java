package components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.zivari.mylibs.R;

public class zButton extends android.support.v7.widget.AppCompatButton {
    String [] font_arr=new String[]{"iranyekan_regular","IranSans","BYekan","CasablancaHeavy"};
    public zButton(Context context) {
        super(context);
        init(null);
    }

    public zButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public zButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

//    public myTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    void init(AttributeSet attrs){

        if(attrs!=null){

           TypedArray typedArray=getContext().obtainStyledAttributes(attrs, R.styleable.zButton);

           attr_font(typedArray);

           typedArray.recycle();
        }
    }

    void attr_font(TypedArray typedArray){

        int index=typedArray.getInt(R.styleable.zButton_button_font_name,0);
        String fontName=font_arr[index];

        Typeface typeface=Typeface.createFromAsset(getContext().getAssets(),"fonts/"+fontName+".ttf");
        setTypeface(typeface);

    }



}
