package com.omarcomputer.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.omarcomputer.calculatrice.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    double nb1, nb2;
    String op = "";
    String currentNumber = "";
    String result = "";
    Boolean calculated = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        for (int i = 0; i < binding.getRoot().getChildCount(); i++) {
            View view = binding.getRoot().getChildAt(i);
            if (view instanceof Button) {
                view.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View view) {
        List<String> numbers = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        List<String> operator = Arrays.asList("+", "-", "*", "/", "=");
        Button button = (Button) view;
        String text = button.getText().toString();
        if(numbers.contains(text)){
            addNumber(text);
        }
        else{
            calculateResult(text);
        }
    }

    private void calculateResult(String text) {
        if(!currentNumber.isEmpty() && !op.isEmpty()){
            nb2 = Double.parseDouble(currentNumber);
            switch (op) {
                case "+":
                    result = String.valueOf(nb1 + nb2);
                    break;
                case "-":
                    result = String.valueOf(nb1 - nb2);
                    break;
                case "*":
                    result = String.valueOf(nb1 * nb2);
                    break;
                case "/":
                    result = String.valueOf(nb1 / nb2);
                    break;
            }
            binding.textResult.setText(result);
            nb1 =Double.parseDouble(currentNumber);
            op ="";
        }
        if(text!="=") op = text;
        currentNumber= "";

    }

    private void addNumber(String text) {
        currentNumber += text;
        binding.textResult.setText(currentNumber);
    }
}