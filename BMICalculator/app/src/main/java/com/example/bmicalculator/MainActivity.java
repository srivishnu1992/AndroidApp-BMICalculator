package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Button btn =  (Button) findViewById(R.id.button);
            btn.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("WrongViewCast")
                @Override
                public void onClick(View view) {
                    EditText age = (EditText) findViewById(R.id.editText);
                    EditText weight = (EditText) findViewById(R.id.editText2);
                    EditText foot = (EditText) findViewById(R.id.editText5);
                    EditText inches = (EditText) findViewById(R.id.editText6);
                    double age1 = Double.parseDouble(age.getText().toString());
                    double weight1 = Double.parseDouble(weight.getText().toString());
                    double foot1 = Double.parseDouble(foot.getText().toString());
                    double inches1 = Double.parseDouble(inches.getText().toString());
                    TextView textView;
                    textView = (TextView) findViewById(R.id.textView4);
                    TextView comment;
                    comment = (TextView) findViewById(R.id.textView8);
                    TextView result;
                    result = (TextView) findViewById(R.id.textview5);
                    TextView normal;
                    normal = (TextView) findViewById(R.id.textView7);
                    TextView color;
                    color = (TextView) findViewById(R.id.textView6);

                    if(age1<18) {
                        Toast.makeText(MainActivity.this, "Age should be 18 and above", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        double height = (12*foot1)+inches1;
                        double bmi = 703*weight1/(height*height);
                        double underMass = 18.5*(height*height)/703;
                        double overMass = 25*(height*height)/703;
                        result.setText("Result");
                        normal.setText("Normal BMI Range: 18.5 - 25");
                        textView.setText("BMI = "+String.valueOf(bmi));
                        if(bmi<18.5) {
                            comment.setText("You will need to gain "+(underMass-weight1)+"lbs to reach a BMI of 18.5");
                            color.setText("Underweight");
                            color.setTextColor(Color.parseColor("#0000ff"));
                        }
                        else if(bmi>25) {
                            comment.setText("You will need to gain "+(weight1-overMass)+"lbs to reach a BMI of 18.5");
                            color.setText("Overweight");
                            color.setTextColor(Color.parseColor("#ff0000"));

                        }
                        else {
                            comment.setText("Keep up good work!!");
                            color.setText("Normal");
                            color.setTextColor(Color.parseColor("#00ff00"));
                        }

                    }
                }
            });
        }
        catch(Exception e) {
            TextView textView;
            textView = (TextView) findViewById(R.id.textView4);
            textView.setText("Exception Occured");
        }

    }


}
