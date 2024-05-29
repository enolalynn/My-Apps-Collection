package com.enola.myapps;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.enola.myapps.databinding.ActivityFontConverterBinding;

public class FontConverterActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private ActivityFontConverterBinding binding;
    private Typeface zawgyi,unicode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFontConverterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intitTypeface();
        initListener();
    }

    private void intitTypeface() {
        zawgyi = ResourcesCompat.getFont(this, R.font.zawgyi);
        unicode = ResourcesCompat.getFont(this, R.font.unicode);

    }

    private void initListener() {
        binding.rgFonts.setOnCheckedChangeListener(this);
        binding.btCovert.setOnClickListener(v -> {
            String inputText = binding.etInput.getText().toString();
            String convertedText;
            if(binding.rbUni2Zg.isChecked()){
                convertedText = RabbitConverter.uni2zg(inputText);
            }else {
                convertedText= RabbitConverter.zg2uni(inputText);
            }
            binding.etOutput.setText(convertedText);
            showSample();
        });
        binding.btClear.setOnClickListener(v->{
            binding.etInput.getText().clear();
            binding.etOutput.getText().clear();
        });
        binding.btCopy.setOnClickListener(v->{
            if(!binding.etOutput.getText().toString().isEmpty()){
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("font_converter",binding.etOutput.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(this, "Output text copied",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "No output text to copy",Toast.LENGTH_SHORT).show();

            }

        });
    }

    private void showSample() {
        String input = "abc";//regular expression = regex
        String output = input.replaceAll("[aA]","\u1000");
        output = output.replaceAll("[bB]","\u1001");
        output = output.replaceAll("[cC]","\u1002");

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.rbUni2Zg){
            binding.etInput.setTypeface(unicode);
            binding.etOutput.setTypeface(zawgyi);
            Log.d("K Khine" ,"Unicode to Zawgyi" );

        }else {

            Log.d("K Khine" ,"Zawgyi to Unicode" );
            binding.etInput.setTypeface(zawgyi);
            binding.etOutput.setTypeface(unicode);
        }
    }
}