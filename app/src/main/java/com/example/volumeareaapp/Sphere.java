package com.example.volumeareaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sphere extends AppCompatActivity {
    EditText sphere_radius;
    TextView title, result;
    Button btn;
    private double volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);
        sphere_radius = findViewById(R.id.editText_sphere);
        title = findViewById(R.id.title);
        result = findViewById(R.id.result);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String radius = sphere_radius.getText().toString();
                if (radius.isEmpty()) {
                    Toast.makeText(Sphere.this, "Please give valid input!", Toast.LENGTH_SHORT).show();
                } else {
                    int r = Integer.parseInt(radius);

                    // V = (4/3) * pi * r^3
                    volume = (((3.14159 * r * r * r) * 4) / 3);
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