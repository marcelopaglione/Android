package com.paglione.marcelo.coincollection;

import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    public ArrayList<Coin> coinList = new ArrayList<Coin>();
    public LinearLayout linearMain,linearMain2,linearMain3,linearMain4;
    public ScrollView scroll;
    public float clickedX,clickedY;
    final static public String NAMEFILE = "MySavedCoins";

    final String states[] = {
            "Alabama",
            "Alaska",
            "American Samoa",
            "Arizona",
            "Arkansas",
            "California",
            "Colorado",
            "Connecticut",
            "Delaware",
            "District of Columbia",
            "Florida",
            "Georgia",
            "Guam",
            "Hawaii",
            "Idaho",
            "Illinois",
            "Indiana",
            "Iowa",
            "Kansas",
            "Kentucky",
            "Louisiana",
            "Maine",
            "Maryland",
            "Massachusetts",
            "Michigan",
            "Minnesota",
            "Mississippi",
            "Missouri",
            "Montana",
            "Nebraska",
            "Nevada",
            "New Hampshire",
            "New Jersey",
            "New Mexico",
            "New York",
            "North Carolina",
            "North Dakota",
            "Northern Mariana Islands",
            "Ohio",
            "Oklahoma",
            "Oregon",
            "Pennsylvania",
            "Puerto Rico",
            "Rhode Island",
            "South Carolina",
            "South Dakota",
            "Tennessee",
            "Texas",
            "United States Virgin Islands",
            "Utah",
            "Vermont",
            "Virginia",
            "Washington",
            "West Virginia",
            "Wisconsin",
            "Wyoming"
    };

    final int images[] = {
            R.mipmap.al,
            R.mipmap.ak,
            R.mipmap.as,
            R.mipmap.az,
            R.mipmap.ar,
            R.mipmap.ca,
            R.mipmap.co,
            R.mipmap.ct,
            R.mipmap.de,
            R.mipmap.dc,
            R.mipmap.fl,
            R.mipmap.ga,
            R.mipmap.gu,
            R.mipmap.hi,
            R.mipmap.id,
            R.mipmap.il,
            R.mipmap.in,
            R.mipmap.ia,
            R.mipmap.ks,
            R.mipmap.ky,
            R.mipmap.la,
            R.mipmap.me,
            R.mipmap.md,
            R.mipmap.ma,
            R.mipmap.mi,
            R.mipmap.mn,
            R.mipmap.ms,
            R.mipmap.mo,
            R.mipmap.mt,
            R.mipmap.ne,
            R.mipmap.nv,
            R.mipmap.nh,
            R.mipmap.nj,
            R.mipmap.nm,
            R.mipmap.ny,
            R.mipmap.nc,
            R.mipmap.nd,
            R.mipmap.nmi,
            R.mipmap.oh,
            R.mipmap.ok,
            R.mipmap.or,
            R.mipmap.pa,
            R.mipmap.pr,
            R.mipmap.ri,
            R.mipmap.sc,
            R.mipmap.sd,
            R.mipmap.tn,
            R.mipmap.tx,
            R.mipmap.usvi,
            R.mipmap.ut,
            R.mipmap.vt,
            R.mipmap.va,
            R.mipmap.wa,
            R.mipmap.wv,
            R.mipmap.wi,
            R.mipmap.wy
    };

    public void addAllCoins() {
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        for (int i = 0; i < states.length; i++) {
            TextView t = new TextView(this);
            Button b = new Button(this);
            Drawable d = getResources().getDrawable(images[i]);
            coinList.add(new Coin(states[i], t, b, i, d, width));
            coinList.get(i).getButton().setOnClickListener(getOnClickDoSomething(coinList.get(i).getButton()));
        }
    }

    public void updateView(){

        for (int i = 0; i < states.length; i++) {
            coinList.get(i).setFrom(coinList.get(i).getButton().getX(),coinList.get(i).getButton().getY());
        }

        linearMain.removeAllViews();
        linearMain2.removeAllViews();
        linearMain3.removeAllViews();
        linearMain4.removeAllViews();
        int owned = 0, missing =0;
        int j=0,k=0;
        for (int i = 0; i < states.length; i++) {
            if (coinList.get(i).isSelected()) {
                if(j%2==0) {
                    coinList.get(i).getButton().getBackground().clearColorFilter();
                    linearMain3.addView(coinList.get(i).getButton());
                    linearMain3.addView(coinList.get(i).getTextView());
                    coinList.get(i).setTo(coinList.get(i).getButton().getX(),coinList.get(i).getButton().getY());
                }
                else{
                    coinList.get(i).getButton().getBackground().clearColorFilter();
                    linearMain4.addView(coinList.get(i).getButton());
                    linearMain4.addView(coinList.get(i).getTextView());
                    coinList.get(i).setTo(coinList.get(i).getButton().getX(),coinList.get(i).getButton().getY());
                }
                j++;
                missing++;
            }
            else {
                if(k%2==0) {
                    coinList.get(i).getButton().getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    linearMain.addView(coinList.get(i).getButton());
                    linearMain.addView(coinList.get(i).getTextView());
                    coinList.get(i).setTo(coinList.get(i).getButton().getX(),coinList.get(i).getButton().getY());
                }
                else{
                    coinList.get(i).getButton().getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    linearMain2.addView(coinList.get(i).getButton());
                    linearMain2.addView(coinList.get(i).getTextView());
                    coinList.get(i).setTo(coinList.get(i).getButton().getX(),coinList.get(i).getButton().getY());
                }
                k++;
                owned++;
            }
        }

        TextView tv = (TextView) findViewById(R.id.textView1);
        String missingCoinsString = "Missing Coins: "+ owned;
        tv.setText(missingCoinsString);
        String ownedCoinsString = "Owned Coins: "+ missing;
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        tv2.setText(ownedCoinsString);
    }

    public View.OnClickListener getOnClickDoSomething(final Button button){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedX = v.getX();
                clickedY = v.getY();
                if(coinList.get(button.getId()).isSelected()) {
                    coinList.get(button.getId()).setSelected(false);
                }
                else{
                    coinList.get(button.getId()).setSelected(true);
                }
                saveCoins();
                updateView();
                animate(coinList.get(button.getId()));
            }
        };

    }

    public void loadCoins(){
        SharedPreferences loadGame = getSharedPreferences(NAMEFILE, MODE_PRIVATE);
        for(int i=0;i<states.length;i++) {
            coinList.get(i).setSelected(loadGame.getBoolean(states[i], false));
        }
    }

    public void saveCoins(){

        SharedPreferences saveGame = getSharedPreferences(NAMEFILE, MODE_APPEND);
        saveGame.edit().clear();
        SharedPreferences.Editor editor = saveGame.edit();
        for (int i=0;i<states.length;i++) {
            editor.putBoolean(states[i], coinList.get(i).isSelected());
        }
        editor.commit();
    }

    private void animate(final Coin button) {
        /*
        final float amountToMoveRight = button.getxTo() - button.getxFrom();
        final float amountToMoveDown = button.getyTo() - button.getyFrom();

        TranslateAnimation anim = new TranslateAnimation(0, amountToMoveDown, 0, amountToMoveRight);
        anim.setDuration(1000);
        anim.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                GridLayout.LayoutParams p = (GridLayout.LayoutParams) button.getButton().getLayoutParams();
                System.out.println("modeDown: "+amountToMoveDown);
                System.out.println("modeRight: "+amountToMoveRight);
                p.topMargin += amountToMoveDown;
                p.leftMargin += amountToMoveRight;
                button.getButton().setLayoutParams(p);

            }
        });
        button.getButton().startAnimation(anim);
        */
        RotateAnimation rotate = new RotateAnimation(
                0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);

        rotate.setDuration(500);
        rotate.setRepeatCount(2);
        button.getButton().setAnimation(rotate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearMain = (LinearLayout) findViewById(R.id.linear_view);
        linearMain2 = (LinearLayout) findViewById(R.id.linear_view2);
        linearMain3 = (LinearLayout) findViewById(R.id.linear_view3);
        linearMain4 = (LinearLayout) findViewById(R.id.linear_view4);

        addAllCoins();
        loadCoins();
        saveCoins();
        updateView();
    }
}
