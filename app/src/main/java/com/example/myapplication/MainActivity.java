package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    public static final String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.button.setOnClickListener(this::sendMessage);
    }

    /** Called when the user taps the Send button */
    private void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = binding.editText.getText().toString();;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
