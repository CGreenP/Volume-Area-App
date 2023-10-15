package com.example.volumeareaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;

public class Cylinder extends AppCompatActivity {
    EditText cylinder_radius, cylinder_height;
    TextView title, result;
    Button btn;
    private double volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);
        cylinder_radius = findViewById(R.id.editText_cylinder_radius);
        cylinder_height = findViewById(R.id.editText_cylinder_height);
        title = findViewById(R.id.title);
        result = findViewById(R.id.result);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String radius = cylinder_radius.getText().toString();
                String height = cylinder_height.getText().toString();
                if (radius.isEmpty() || height.isEmpty()) {
                    Toast.makeText(Cylinder.this, "Please give valid input!", Toast.LENGTH_SHORT).show();
                } else {
                    int r = Integer.parseInt(radius);
                    int h = Integer.parseInt(height);

                    // V = pi * r^2 * h
                    volume = (3.14159 * r * r * h);
                    result.setText("V = " + volume + " m^3");
                }
            }
        });

        if (savedInstanceState != null) {
            volume = savedInstanceState.getDouble("vol");
            result.setText("V = " + volume + " m^3");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("vol",volume);
    }
}