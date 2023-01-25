package com.example.calculator20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.userInput);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText(null);
                }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        //get cursor position
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        //putting input between left and right half of string
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos+1);
        }else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos+1);
        }
    }
    public void zeroBtn(View view){
        updateText("0");
    }
    public void oneBtn(View view){
        updateText("1");
    }
    public void twoBtn(View view){
        updateText("2");
    }
    public void threeBtn(View view){
        updateText("3");
    }
    public void fourBtn(View view){
        updateText("4");
    }
    public void fiveBtn(View view){
        updateText("5");
    }
    public void sixBtn(View view){
        updateText("6");
    }
    public void sevenBtn(View view){
        updateText("7");
    }
    public void eightBtn(View view){
        updateText("8");
    }
    public void nineBtn(View view){
        updateText("9");
    }
    public void plusMinusBtn(View view){

    }
    public void dotBtn(View view){
        updateText(".");
    }
    public void equalsBtn(View view){

    }
    public void addBtn(View view){
        updateText("+");
    }
    public void minusBtn(View view){
        updateText("-");
    }
    public void multiplyBtn(View view){
        updateText("*");
    }
    public void divideBtn(View view){
        updateText("/");
    }
    public void clearBtn(View view){
        display.setText(null);
    }
    public void exponentialBtn(View view){
        updateText("^");
    }
    public void parenthesisBtn(View view){
        int cursorPos = display.getSelectionStart();
        int openBrac = 0;
        int closeBrac = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < cursorPos; i++){
            //checking for open parenthesis
            if (display.getText().toString().substring(i, i+1).equals("(")){
                openBrac += 1;
            }
            //checking for closed parenthesis
            if (display.getText().toString().substring(i, i+1).equals(")")){
                closeBrac += 1;
            }
        }

        if(openBrac == closeBrac || display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText("(");
        }
        else if(closeBrac < openBrac || !display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText(")");
        }

        display.setSelection(cursorPos + 1);
    }
    public void backspaceBtn(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            //replace character eore cursor
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos -1);
        }
    }
}