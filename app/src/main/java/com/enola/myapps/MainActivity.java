package com.enola.myapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.enola.myapps.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    int[] imgResources = {R.drawable.dice,R.drawable.password, R.drawable.question,R.drawable.convert,R.drawable.love,R.drawable.calculator};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUi();
        intiListener();
    }

    private void intiListener() {
        binding.cvDice.setOnClickListener(this::cardItemClicked);
        binding.cvLogIn.setOnClickListener(this::cardItemClicked);
        binding.cvGuessWord.setOnClickListener(this::cardItemClicked);
        binding.cvFontConverter.setOnClickListener(this::cardItemClicked);
        binding.cvDateCounter.setOnClickListener(this::cardItemClicked);
        binding.cvCalculator.setOnClickListener(this::cardItemClicked);

    }

    private void initUi() {

    }


    public void cardItemClicked(View view){
        int id = view.getId();
        Intent intent;
        if(id==R.id.cvDice){
            intent = new Intent(this, DiceRollerActivity.class);
        } else if (id == R.id.cvLogIn) {
            intent = new Intent(this, LogInActivity.class);
        }else if (id == R.id.cvGuessWord) {
            intent = new Intent(this, GuessWordActivity.class);
        }else if (id == R.id.cvFontConverter) {
            intent = new Intent(this, FontConverterActivity.class);
        }else if (id == R.id.cvDateCounter) {
            intent = new Intent(this, DateCounterActivity.class);
        }else {
            intent = new Intent(this, CalculatorActivity.class);
        }
        startActivity(intent);
    }
}