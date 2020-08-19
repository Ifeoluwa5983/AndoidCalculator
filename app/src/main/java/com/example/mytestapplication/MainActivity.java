package com.example.mytestapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private Button num1, num2, AC, line1, text2, line3, num3, multiply, num4, num5, num6, divide, num7, num8, num9, num0, power, cancel, equals, decimal;
    private String input,answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (TextView) findViewById(R.id.resultTextVIew);
        num1 = (Button) findViewById(R.id.num1);
        AC = (Button) findViewById(R.id.AC);
        num2 = (Button) findViewById(R.id.num2);
        line1 = (Button) findViewById(R.id.line1);
        text2 = (Button) findViewById(R.id.text2);
        line3 = (Button) findViewById(R.id.line3);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        multiply = (Button) findViewById(R.id.multiply);
        num6 = (Button) findViewById(R.id.num6);
        divide = (Button) findViewById(R.id.divide);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        num0 = (Button) findViewById(R.id.num0);
        power = (Button) findViewById(R.id.power);
        cancel = (Button) findViewById(R.id.cancel);
        equals = (Button) findViewById(R.id.equals);
        decimal = (Button) findViewById(R.id.decimal);
    }
    public void click(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "AC":
                solve();
                input=" ";
                break;
            case ".":
                solve();
                input += ".";
                break;
            case "^":
                solve();
                input+= "^";
                break;
            case "=":
                solve();
                answer = input;
                break;
            case "[x]":
                String newText = input.substring(0,input.length() - 1);
                input=newText;
                break;
            default:
                if(input == null){
                    input = " ";
                if(data.equals("+")||data.equals("-")||data.equals("*")||data.equals("%")||data.equals("/")){
                    solve();
                }
            }
                input += data;
        }
        screen.setText(input);



    }
    public void solve(){
        if(input.split("\\*").length== 2){
            String number[] = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul+ "";
            }
            catch (Exception e){}
        }
        else if(input.split("/").length== 2){
            String number[] = input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div+ "";
            }
            catch (Exception e){}
        }
        else if(input.split("\\^").length== 2){
            String number[] = input.split("\\^");
            try {
                double pow =Math.pow(Double.parseDouble(number[0]) ,Double.parseDouble(number[1]));
                input = pow+ "";
            }
            catch (Exception e){}
        }
        else if(input.split("\\+").length== 2){
            String number[] = input.split("\\+");
            try {
                double add = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = add+ "";
            }
            catch (Exception e){}
        }
        else if(input.split("-").length>1){
            String number[] = input.split("-");
            if(number[0] == "" && number.length==2){
                number[0]= 0+ "";
            }
            try {
                double sub = 0;
                if(number.length == 2) {
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                if(number.length ==3 ) {
                    sub = Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = sub+ "";
            }
            catch (Exception e){}
        }
        else if(input.split("%").length== 2){
            String number[] = input.split("%");
            try {
                double mod = Double.parseDouble(number[0]) % Double.parseDouble(number[1]);
                input = mod+ "";
            }
            catch (Exception e){}
        }
        String b[] = input.split("\\.");
        if(b.length>1){
            if(b[1].equals("0")){
                input= b[0];
            }
        }
        screen.setText(input);

    }
}