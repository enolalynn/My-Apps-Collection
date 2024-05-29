package com.enola.myapps;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.enola.myapps.databinding.ActivityDiceRollerBinding;

import java.util.Random;

public class DiceRollerActivity extends AppCompatActivity {
    private ActivityDiceRollerBinding binding;
    int[] imgResources = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDiceRollerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUi();
        initListener();
    }

    private void initUi() {
        binding.imageView.setImageResource(imgResources[0]);
    }

    private void initListener() {
        binding.btRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        int randomIndex = random.nextInt(imgResources.length);
        binding.imageView.setImageResource(imgResources[randomIndex]);
        int diceNum = randomIndex + 1;
        binding.tvDiceNumber.setText(String.valueOf(diceNum));
    }
}