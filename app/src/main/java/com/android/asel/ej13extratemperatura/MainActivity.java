package com.android.asel.ej13extratemperatura;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTemperatura;
    private RadioButton radioButtonCelsius;
    private RadioButton radioButtonFahrenheit;
    private Button buttonCalculate;

    private double temperatura;

    private void getReferencias() {

        editTextTemperatura = (EditText) findViewById(R.id.editTextTemperatura);
        radioButtonCelsius = (RadioButton) findViewById(R.id.radioButtonCelsius);
        radioButtonFahrenheit = (RadioButton) findViewById(R.id.radioButtonFahrenheit);
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);

    }

    public void convertTemperatura() {

        if (radioButtonCelsius.isChecked()) {

            temperatura = Double.parseDouble(editTextTemperatura.getText().toString());
            temperatura = (temperatura - 32 ) / 1.8;
            editTextTemperatura.setText(String.valueOf(temperatura));
            radioButtonCelsius.setChecked(false);

        } else if (radioButtonFahrenheit.isChecked()) {

            temperatura = Double.parseDouble(editTextTemperatura.getText().toString());
            temperatura = (temperatura * 1.8) + 32;
            editTextTemperatura.setText(String.valueOf(temperatura));
            radioButtonFahrenheit.setChecked(false);

        } else {

            Toast.makeText(this, "Selecciona una opcion", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferencias();

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                convertTemperatura();

            }

        });

    }

}
