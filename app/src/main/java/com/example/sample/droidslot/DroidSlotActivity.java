package com.example.sample.droidslot;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class DroidSlotActivity extends AppCompatActivity {
    int droidSide1 = -1;
    int droidSide2 = -1;
    int droidSide3 = -1;
    Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_droid_slot);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //ImageViewerに画像リソース設定　2-3
        final ImageView droidImage1 = (ImageView) this.findViewById(R.id.droidimageid1);
        final ImageView droidImage2 = (ImageView) this.findViewById(R.id.droidimageid2);
        final ImageView droidImage3 = (ImageView) this.findViewById(R.id.droidimageid3);
        //R.drawable.droid_2 リソースIDに画像名を注入
        // droidImage1.setImageResource(R.drawable.droid_2);


        //2-4 2つの画像をランダムに表示 乱数によるif文で設定
//        int droidSide1;
//        final Random r = new Random();
//        droidSide1 = r.nextInt(4);


        final Random r = new Random();
        //3-1 ボタン押下による挙動
        //idによりウィジェット検索
        final Button b1 = (Button) this.findViewById(R.id.slotbutton1);
        final Button b2 = (Button) this.findViewById(R.id.slotbutton2);
        final Button b3 = (Button) this.findViewById(R.id.slotbutton3);
        retryButton = (Button) this.findViewById(R.id.retrybutton);
        retryButton.setVisibility(View.INVISIBLE);


        //ボタンクリックにより作動するオブジェクトに設定する
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                droidSide1 = r.nextInt(4);
                b1.setEnabled(false);
                droidImage1.setImageResource(getDrawableId(droidSide1));

                //ボタンを一度利用したら利用不可にする
                b1.setEnabled(false);
                checkSlot();
            }
        });

        //ボタンクリックにより作動するオブジェクトに設定する
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                droidSide2 = r.nextInt(4);
                b2.setEnabled(false);

                droidImage2.setImageResource(getDrawableId(droidSide2));
                //ボタンを一度利用したら利用不可にする
                b2.setEnabled(false);
                checkSlot();
            }
        });

        //ボタンクリックにより作動するオブジェクトに設定する
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                droidSide3 = r.nextInt(4);
                b3.setEnabled(false);
                droidImage3.setImageResource(getDrawableId(droidSide3));

                //ボタンを一度利用したら利用不可にする
                b3.setEnabled(false);
                //トースト表示
                checkSlot();
            }
        });


        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                droidImage1.setImageResource(R.drawable.droid_star);
                droidImage2.setImageResource(R.drawable.droid_star);
                droidImage3.setImageResource(R.drawable.droid_star);
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                retryButton.setVisibility(View.INVISIBLE);
                droidSide1 = droidSide2 = droidSide3 = -1;
            }
        });
    }


    /**
     * @param side
     * @return //4つの画像をランダムに表示
     */
    private int getDrawableId(int side) {
        int drawableid;

        switch (side) {
            case 0:
                drawableid = R.drawable.picture_droid;
                break;
            case 1:
                drawableid = R.drawable.droid_2;
                break;
            case 2:
                drawableid = R.drawable.droid_m;
                break;
            default:
                drawableid = R.drawable.droid_3;
        }
        return drawableid;
    }

    /**
     * 画像が3つそろったときにトースト表示
     */
    private void checkSlot() {
        if (droidSide1 == droidSide2 && droidSide1 == droidSide3) {
            Toast.makeText(getApplicationContext(), "おめでとう！BIG BONUS！", Toast.LENGTH_LONG).show();
            //3-4
            retryButton.setVisibility(View.VISIBLE);
        } else if (droidSide1 != -1 && droidSide2 != -1 && droidSide3 != -1) {
            retryButton.setVisibility(View.VISIBLE);
        }
    }

//
//        F loatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_droid_slot, menu);
        return true;
    }

    /**
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
