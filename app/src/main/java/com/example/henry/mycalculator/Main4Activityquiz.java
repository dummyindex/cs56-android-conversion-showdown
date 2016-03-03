package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import java.util.Random;

public class Main4Activityquiz extends Activity implements OnClickListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4_activityquiz);
        Intent intentextra = getIntent();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void onClick(View view) {
        Intent intent = new Intent(this, Main4Activityquiz.class);

        // Calling another activity Main4Activitytest start the quiz

        startActivity(intent);
    }

public static int numerator = 0;
public static int denominator = 0;
public static int result = 0;

    public void TestResult(View view) {
        // Take number from text field and convert it to an integer
        TextView myText = (TextView) findViewById(R.id.decimal);
        String TxtString = myText.getText().toString();
        int binary = Integer.parseInt(TxtString);

        //Respond prompts
        TextView test = (TextView) findViewById(R.id.test);
        TextView respond = (TextView) findViewById(R.id.RightOrWrong);


        // Take user answer from text field and convert it to binary number then an int
        EditText answer = (EditText) findViewById(R.id.AnswerField);
        String sAnswer = answer.getText().toString();

        if(TextUtils.isEmpty(sAnswer)) {
            answer.setError("Put a value please");
            return;
        }

        int checkBinary = Integer.parseInt(answer.getText().toString());

        if (checkBinary % 10 > 1 ) {
            answer.setError("You don't know what a binary is do you");
            return;

        } else {

            int binaryanswer = Integer.parseInt(answer.getText().toString(), 2);
            String binarytext = answer.getText().toString();

            //denominator always increases
            TextView denominator = (TextView) findViewById(R.id.NumAttempt);
            int den = Integer.parseInt(denominator.getText().toString());
            den = den + 1;
            denominator.setText(String.valueOf(den));

            TextView numerator = (TextView) findViewById(R.id.NumCorrect);
            int num = Integer.parseInt(numerator.getText().toString());

            // compare the answer to the actual value
            if (binary == binaryanswer) {
                num = num + 1;
                numerator.setText(String.valueOf(num));

                respond.setText(R.string.correct);
                test.setText(TxtString + " is the same as " + binarytext);
            } else {

                respond.setText(R.string.incorrect);
                test.setText("Keep Trying");
            }
            TextView de = (TextView) findViewById(R.id.NumAttempt);
            int d = Integer.parseInt(de.getText().toString());
            float deno = (float) d;

            TextView nu = (TextView) findViewById(R.id.NumCorrect);
            int n = Integer.parseInt(nu.getText().toString());
            float numer = (float) n;

            float result = (numer/deno)*100;
            TextView percent = (TextView) findViewById(R.id.PercentCorrect);
            percent.setText(String.valueOf(result + " %"));
        }
    }


    public void changeDecimal(View view) {
        // create a Random number for the next problem
        TextView myText = (TextView) findViewById(R.id.decimal);
        Random rand = new Random();
        int number = rand.nextInt(4097);
        myText.setText(String.valueOf(number));
    }



}
