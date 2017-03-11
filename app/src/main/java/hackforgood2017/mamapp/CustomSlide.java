package hackforgood2017.mamapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import agency.tango.materialintroscreen.SlideFragment;

/**
 * Created by jorgeanta on 11/3/17.
 */

public class CustomSlide extends SlideFragment {
    ImageView imageView;
    TextView tvContent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.content_explore, container, false);
        imageView=(ImageView)view.findViewById(R.id.imageView);
        tvContent=(TextView)view.findViewById(R.id.tv_content);
        return view;
    }

    @Override
    public int backgroundColor() {
        return R.color.colorPrimary;
    }

    @Override
    public int buttonsColor() {
        return R.color.colorAccent;
    }

    @Override
    public boolean canMoveFurther() {
        return true;
    }

    @Override
    public String cantMoveFurtherErrorMessage() {
        return "Error";
    }
    public void setImage(Drawable drawable){
        imageView.setImageDrawable(drawable);
    }
    public void setContent(String content){
        tvContent.setText(content);
    }

}