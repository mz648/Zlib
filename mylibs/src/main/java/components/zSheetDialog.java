package components;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zivari.mylibs.R;

import java.util.ArrayList;
import java.util.List;


public class zSheetDialog {

    List<String> list_items=new ArrayList<>();
    List<Drawable> list_icons=new ArrayList<>();

    Activity activity;
    BottomSheetDialog dialog;

    boolean change_color=true;
    int image_color=R.color.color_blue;
    int text_color=R.color.color_blue2;

    private onSelectedListener listener;

    public zSheetDialog(Activity _activity, List<String> _list_items,List<Drawable> _list_icons){

        activity=_activity;
        list_items=_list_items;
        list_icons=_list_icons;
    }

    public void change_image_color(boolean _change_color){
        change_color=_change_color;
    }
    public void set_image_color(int _image_color){
        image_color=_image_color;
    }
    public void set_text_color(int _text_color){
        text_color=_text_color;
    }

    public void setOnSelectedListener(onSelectedListener onSelectedListener){
        listener=onSelectedListener;
        show_dialog();
    }

    void show_dialog(){
        Button btn_cancel;
        RecyclerView rec;

        dialog=new BottomSheetDialog(activity);
        dialog.setContentView(R.layout.dialog_sheet);
        dialog.setCancelable(true);

        btn_cancel=(Button) dialog.findViewById(R.id.btn_cancel);
        rec=(RecyclerView) dialog.findViewById(R.id.rec);


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(activity);
        adapter adapter=new adapter();
        rec.setLayoutManager(linearLayoutManager);
        rec.setAdapter(adapter);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    public interface onSelectedListener{
        void onSelected(int index);
    }

    class adapter extends RecyclerView.Adapter<holder>{

        @NonNull
        @Override
        public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(activity);
            View view=inflater.inflate(R.layout.row_sheet,parent,false);
            holder holder=new holder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull holder holder, final int position) {

            holder.row_title.setText(list_items.get(position));
            holder.row_img.setImageDrawable(list_icons.get(position));

            holder.row_title.setTextColor(activity.getResources().getColor(text_color));

            if(change_color){
                holder.row_img.setColorFilter(ContextCompat.getColor(activity, image_color), android.graphics.PorterDuff.Mode.MULTIPLY);
            }

//                holder.row_title.setTextColor(activity.getResources().getColor(R.color.color_ar));

            holder.row_lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onSelected(position);
                    dialog.dismiss();
                }
            });
        }

        @Override
        public int getItemCount() {
            return list_items.size();
        }
    }
    class holder extends RecyclerView.ViewHolder{

        public LinearLayout row_lay;
        public ImageView row_img;
        public TextView row_title;

        public holder(View itemView) {
            super(itemView);

            row_lay=(LinearLayout)itemView.findViewById(R.id.row_lay);
            row_img=(ImageView)itemView.findViewById(R.id.row_img);
            row_title=(TextView)itemView.findViewById(R.id.row_title);

        }
    }
}
