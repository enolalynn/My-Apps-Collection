package com.enola.myapps;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.enola.myapps.databinding.ActivityCalculatorBinding;

import java.text.DecimalFormat;

public class CalculatorActivity extends AppCompatActivity {

    private ActivityCalculatorBinding binding;
    private String operator, firstNumber , secondNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClearClicked(view);
            }
        });
    }

    private void onClearClicked(View view) {
        binding.tvOperation.setText("");
        binding.etCalculator.setText("");

    }

    public void onNumberClicked(View view) {
        Button btn = (Button) view; // Up casting & Down casting
        Log.d("Enola", btn.getText().toString());
        if (binding.etCalculator.getText().toString().equals("0"))
            binding.etCalculator.setText(btn.getText().toString());
        else
            binding.etCalculator.append(btn.getText().toString());

        if(this.operator == null){
            binding.tvOperation.setText(binding.etCalculator.getText().toString());
        }else {
            binding.tvOperation.setText(firstNumber + " " + this.operator + " " + binding.etCalculator.getText().toString());
        }
        binding.tvOperation.setText(binding.etCalculator.getText().toString());
    }

    public void onOperatorClicked(View view) {
        int operator = view.getId();
        if (operator == R.id.btAdd) {
            this.operator = "+";

        }else if (operator == R.id.btSubtract) {
            this.operator = "-";

        }else if (operator == R.id.btMultiply) {
            this.operator = "x";

        }else if (operator == R.id.btDivide) {
            this.operator = "/";

        }else if (operator == R.id.btEqual) {
            secondNumber = binding.etCalculator.getText().toString();
            calculate(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber));
            binding.tvOperation.setText(firstNumber + " " + this.operator + " " + secondNumber);
            return ;
        }
        firstNumber = binding.etCalculator.getText().toString();
        binding.tvOperation.setText(this.operator);
        binding.etCalculator.setText("0");

    }

    private void calculate(double firstNumber, double secondNumber) {
        double result = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        if (this.operator.equals("+")) {
            result = firstNumber + secondNumber;
        } else if (this.operator.equals("-")) {
            result = firstNumber - secondNumber;
        } else if (this.operator.equals("x")) {
            result = firstNumber * secondNumber;
        } else {
            result = firstNumber / secondNumber;
        }

        binding.etCalculator.setText(String.valueOf(df.format(result)));

    }
}