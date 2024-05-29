package com.enola.myapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.enola.myapps.databinding.ActivityGuessWordBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GuessWordActivity extends AppCompatActivity {
    private ActivityGuessWordBinding binding;
    private TextView tvScore, tvGuessWord, tvMatchPlayed;
    private EditText etYourGuess;
    private Button btGuess;
    private int score, matchPlayed;
    private String guessWord;
    private String[] words = {"apple", "banana", "game", "computer",
            "orange", "flower", "cat", "ball", "bell", "iron"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuessWordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUi();
        initListeners();
    }

    private void initListeners() {
        binding.btGuess.setOnClickListener(v -> {
            if (matchPlayed == 5) {
                if (score > 3) {
                    tvGuessWord.setText("WINNER");
                } else {
                    tvGuessWord.setText("TRY AGAIN!");
                }
                etYourGuess.setText("");
                return;
            }

            matchPlayed++;
            binding.tvMatchPlayed.setText("Match Played : " + matchPlayed);
            String myGuess = etYourGuess.getText().toString();
            if (guessWord.equals(myGuess)) {
                score++;
                tvScore.setText(score + "/5");
            }
            nextRound();
        });
    }

    private void nextRound() {
        String guessWord = getRandomWordFromWords();
        binding.tvGuessWord.setText(guessWord);
        binding.etYourGuess.setText("");
    }

    private void initUi() {
        tvScore = findViewById(R.id.tvScore);
        tvGuessWord = findViewById(R.id.tvGuessWord);
        tvMatchPlayed = findViewById(R.id.tvMatchPlayed);
        etYourGuess = findViewById(R.id.etYourGuess);
        btGuess = findViewById(R.id.btGuess);
        tvGuessWord.setText(getRandomWordFromWords());
    }

    private String getRandomWordFromWords() {

        List<String> wordList = Arrays.asList(words);
        Collections.shuffle(wordList);
        words = wordList.toArray(new String[wordList.size()]);

        // Get the next word
        int rd = new Random().nextInt(words.length);
        guessWord = words[rd];
        char [] letters = guessWord.toCharArray();
        List<Character> letterList = new ArrayList<>();
        for(char letter : letters){
            letterList.add(letter);
        }
        Collections.shuffle(letterList);
        StringBuilder shuffleWord = new StringBuilder();
        for(char letter : letterList){
            shuffleWord.append(letter);
        }
        return shuffleWord.toString();

    }

}