package com.example.appejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    CheckBox checkBox;
    DatePicker datePicker;
    Button button, buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);
        datePicker = findViewById(R.id.datePicker);
        button = findViewById(R.id.button);
        buttonNext = findViewById(R.id.buttonNext);
        Calendar calendar = Calendar.getInstance();

        button.setOnClickListener(v -> {
            if (checkBox.isChecked()) {
                String texto = editText.getText().toString();

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String horaActual = sdf.format(new Date());

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                String mensaje = "Hola, " + texto + ", Fecha: " + day + "/" + month + "/" + year+" - Hora: " + horaActual;
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
            }
        });

        buttonNext.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}
