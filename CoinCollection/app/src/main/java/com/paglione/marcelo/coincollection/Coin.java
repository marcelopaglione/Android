package com.paglione.marcelo.coincollection;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.View.TEXT_ALIGNMENT_CENTER;

/**
 * Created by marcelopaglione on 3/26/15.
 */
public class Coin {
    private Button button;
    private TextView textView;
    private boolean selected = false;
    private int id;

    private float xFrom, xTo, yFrom, yTo;

    public void setFrom(float xFrom, float yFrom){
        this.xFrom = xFrom;
        this.yFrom = yFrom;
    }

    public void setTo(float xTo, float yTo){
        this.xTo = xTo;
        this.yTo = yTo;
    }

    public float getxFrom(){
        return xFrom;
    }

    public float getyFrom(){
        return yFrom;
    }

    public float getxTo(){
        return xTo;
    }

    public float getyTo(){
        return yTo;
    }

    public TextView getTextView(){ return textView; }
    public Button getButton() {
        return button;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Coin(String name, TextView textView, Button button, int id, Drawable d, int width) {


        this.id = id;
        this.textView = textView;
        char c = 11014; //arrow unicode
        textView.setText(name);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setTextSize(13);
        textView.setTextColor(Color.WHITE);
        textView.setLayoutParams(new LinearLayout.LayoutParams(width / 4, width / 10));



        //button.setText(name);
        button.setId(this.id);
        button.setLayoutParams(new LinearLayout.LayoutParams(width / 4, width / 4));
        button.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        button.setBackground(d);
        this.button = button;

    }



}
