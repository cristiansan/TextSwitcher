package app.prueba.textswitcher;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity
{
    private TextSwitcher mSwitcher;
    private TextSwitcher mSwitcher2;
    ImageButton btnNext1;
    ImageButton btnNext2;
    ImageButton btnNext3;

    // Array of String to Show In TextSwitcher
    String textToShow[]= {"text1", "text2", "text3"};
    //String textToShow[]= {getString(R.string.pregunta_primera), getString(R.string.pregunta_segunda), getString(R.string.pregunta_tercera)};
    int messageCount=textToShow.length;
    // to keep current Index of text
    int currentIndex=-1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // get The references
        btnNext1=(ImageButton)findViewById(R.id.buttonNext1);
        btnNext2=(ImageButton)findViewById(R.id.buttonNext2);
        btnNext3=(ImageButton)findViewById(R.id.buttonNext3);
        mSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        mSwitcher2 = (TextSwitcher) findViewById(R.id.textSwitcher2);

        // Set the ViewFactory of the TextSwitcher that will create TextView object when asked
        mSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub
                // create new textView and set the properties like color, size etc
                TextView myText = new TextView(MainActivity.this);
                myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(36);
                myText.setTextColor(Color.WHITE);
                return myText;
            }
        });

         mSwitcher2.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub
                // create new textView and set the properties like color, size etc
                TextView myText2 = new TextView(MainActivity.this);
                myText2.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
                myText2.setTextSize(30);
                myText2.setTextColor(Color.WHITE);
                return myText2;
            }
        });

        // Declare the in and out animations and initialize them
        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type of textSwitcher
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);
        mSwitcher2.setInAnimation(in);
        mSwitcher2.setOutAnimation(out);


        // ClickListener for NEXT button
        // When clicked on Button TextSwitcher will switch between texts
        // The current Text will go OUT and next text will come in with specified animation
        btnNext1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex++;
                // If index reaches maximum reset it
                if(currentIndex==messageCount)
                    currentIndex=0;
                mSwitcher.setText(textToShow[currentIndex]);
                mSwitcher2.setText(textToShow[currentIndex]);
            }
        });

        btnNext2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex++;
                // If index reaches maximum reset it
                if(currentIndex==messageCount)
                    currentIndex=0;
                mSwitcher.setText(textToShow[currentIndex]);
                mSwitcher2.setText(textToShow[currentIndex]);
            }
        });

        btnNext3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex++;
                // If index reaches maximum reset it
                if(currentIndex==messageCount)
                    currentIndex=0;
                mSwitcher.setText(textToShow[currentIndex]);
                mSwitcher2.setText(textToShow[currentIndex]);
            }
        });
    }
}
