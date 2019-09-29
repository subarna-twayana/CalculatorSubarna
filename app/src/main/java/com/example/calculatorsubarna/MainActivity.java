package com.example.calculatorsubarna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.calculatorsubarna.action.Numbers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView result;
    Button butc, but1, but2, but3, buta, but4, but5, but6, buts, but7, but8, but9, butd, butr, but0, butm, bute;
    int count = 0;
    String doa;
    Numbers numbers = new Numbers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butc= findViewById(R.id.clear);
        butc.setOnClickListener(this);

        but1= findViewById(R.id.butone);
        but1.setOnClickListener(this);
        but2= findViewById(R.id.buttwo);
        but2.setOnClickListener(this);
        but3= findViewById(R.id.butthree);
        but3.setOnClickListener(this);
        buta=findViewById(R.id.butadd);
        buta.setOnClickListener(this);

        but4= findViewById(R.id.butfour);
        but4.setOnClickListener(this);
        but5= findViewById(R.id.butfive);
        but5.setOnClickListener(this);
        but6= findViewById(R.id.butsix);
        but6.setOnClickListener(this);
        buts= findViewById(R.id.butsub);
        buts.setOnClickListener(this);

        but7= findViewById(R.id.butseven);
        but7.setOnClickListener(this);
        but8= findViewById(R.id.buteight);
        but8.setOnClickListener(this);
        but9= findViewById(R.id.butnine);
        but9.setOnClickListener(this);
        butd= findViewById(R.id.butdivide);
        butd.setOnClickListener(this);

        butr= findViewById(R.id.butrem);
        butr.setOnClickListener(this);
        but0=findViewById(R.id.butzero);
        but0.setOnClickListener(this);
        butm= findViewById(R.id.butmul);
        butm.setOnClickListener(this);
        bute= findViewById(R.id.butequalto);
        bute.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.butzero:
                result.append("0");
                break;
            case R.id.butone:
                result.append("1");
                break;
            case R.id.buttwo:
                result.append("2");
                break;
            case R.id.butthree:
                result.append("3");
                break;
            case R.id.butfour:
                result.append("4");
                break;
            case R.id.butfive:
                result.append("5");
                break;
            case R.id.butsix:
                result.append("6");
                break;
            case R.id.butseven:
                result.append("7");
                break;
            case R.id.buteight:
                result.append("8");
                break;
            case R.id.butnine:
                result.append("9");
                break;
            case R.id.clear:
                try {
                    String NumberEntered = result.getText().toString();
                    NumberEntered = NumberEntered.substring(0, NumberEntered.length()-1);
                    String word =(NumberEntered);
                    result.setText(word);
                    return;
                }catch (Exception e){
                    result.setError("enter value");
                }
                break;
            case R.id.butadd:
                count++;
                if (count<2){
                    SetData(count);
                    doa ="add";
                }else{
                    result.setError("only two time");
                }
                break;
                
            case R.id.butsub:
                count++;
                if (count<2){
                    SetData(count);
                    doa = "sub";
                }else{
                    result.setError("only two times");
                }
                break;
            case R.id.butdivide:
                count++;
                if(count<2){
                    SetData(count);
                    doa = "divide";
                }else{
                    result.setError("only two times");
                }
                break;
            case R.id.butmul:
                count++;
                if(count<2){
                    SetData(count);
                    doa ="mul";
                }else{
                    result.setError("only two time");
                }
                break;
            case R.id.butequalto:
                MathCal mathCal = new MathCal();
                count++;
                SetData(count);
                if(doa.equalsIgnoreCase("add")){
                    result.setText(mathCal.add(numbers));
                }else if(doa.equalsIgnoreCase("sub")){
                    result.setText(mathCal.sub(numbers));
                }else if(doa.equalsIgnoreCase("divide")){
                    result.setText(mathCal.divide(numbers));
                }else if(doa.equalsIgnoreCase("mul")){
                    result.setText(mathCal.mul(numbers));
                }
                break;
        }

    }

    private void SetData(int count) {
        if (!result.getText().toString().isEmpty()){
            if(count == 1){
                numbers.setFirstNumber(Double.parseDouble(result.getText().toString()));
                result.setText("");
                return;
            }else if (count == 2){
                numbers.setSecondNumber(Double.parseDouble(result.getText().toString()));
                result.setText("");
                return;
            }else{
                result.setError("only two times");
                return;
            }}
            else{
                result.setError("enter first number");
                count--;
                return;
            }
        }
    }
}
