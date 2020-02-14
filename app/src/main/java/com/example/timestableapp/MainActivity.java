package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int maxNumber = 20;
        int startPosition = 1;
        listView = findViewById(R.id.listView);
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(maxNumber);
        seekBar.setProgress(startPosition);

        displayList(startPosition); //calling this function inside OnCreate so that when we open the app, there is some default content displayed

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minNumber = 1;
                int number;
                if (progress < minNumber) {
                    number = minNumber;
                } else {
                    number = progress;
                }
                Log.i("INFO: ", Integer.toString(number));
                Toast.makeText(getApplicationContext(), Integer.toString(number) + " Times Table", Toast.LENGTH_SHORT).show();
                displayList(number);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void displayList(int number){
        final ArrayList<Integer> numbers = new ArrayList<Integer>();

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, numbers);
        arrayAdapter.clear();

        for(int i=1; i<=10; i++) {
            numbers.add(i * number);
        }
        listView.setAdapter(arrayAdapter);
    }
}
