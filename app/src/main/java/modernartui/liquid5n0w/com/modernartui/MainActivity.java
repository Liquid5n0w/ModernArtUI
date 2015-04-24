package modernartui.liquid5n0w.com.modernartui;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {
    
    float[] hsvColor = new float[3];
    TextView[] boxes = new TextView[5];
    private static final String TAG = MainActivity.class.getSimpleName();
    private android.content.Context context = this;


    //SeekBar seekBar;

    //This is a test of Git hub

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate() Created layout");


        

      


        
        boxes[0] = (TextView) findViewById(R.id.box1);
        boxes[1] = (TextView) findViewById(R.id.box2);
        boxes[2] = (TextView) findViewById(R.id.box3);
        boxes[3] = (TextView) findViewById(R.id.box4);
        boxes[4] = (TextView) findViewById(R.id.box5);


        Log.d(TAG, "onCreate() Setup boxes");
        hsvColor[0] = 0;
        hsvColor[1] = (float) 0.8;
        hsvColor[2] = (float) 0.9;
        changeColor(0);

        Log.d(TAG, "onCreate() Setup Color");

        ((SeekBar) findViewById(R.id.seekBar))
                .setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        
                        changeColor((float) i);

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });


    }

    private void changeColor(float i) {
        i = i/1000 * 360;
        float a = 0;
        

        for (int x=0; x < boxes.length ;  x++) {
            a = i + (x * 25);
            if (a > 360)
                a = a - 360;
            setBoxColor(boxes[x], ((int) a));
            //TODO remove later
            //boxes[x].setText("" + a);
        }



    }

    private void setBoxColor(TextView box, int hue) {
        hsvColor[0] = hue;
        box.setBackgroundColor(Color.HSVToColor(hsvColor));
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d(TAG, "Menu: inflated");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.more_info) {
            Log.d(TAG, "Menu: More Info entered");
            
            //TODO Make the fragment pop up

            new AlertDialog.Builder(context)
                    .setTitle(R.string.dialog_title)
                    .setMessage(R.string.dialog_message)
                    .setCancelable(false)
                    .setPositiveButton(R.string.visit, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.d(TAG, "Menu: Clicked Visit");
                            //TODO Implicit intent to open site
                            //http://www.MoMA.org

                        }
                    })
                    .setNegativeButton(R.string.later, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.d(TAG, "Menu: Clicked Later");
                            dialog.cancel();

                        }
                    })
                    .create().show();


            Log.d(TAG, "More Info done");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
