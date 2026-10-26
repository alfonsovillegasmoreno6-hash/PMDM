package com.example.loginalfonso;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.materialswitch.MaterialSwitch;

public class MainActivity extends AppCompatActivity {

    private static final String CORREO_VALIDO = "alfonso@correo.com";
    private static final String PASS_VALIDA = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vistas
        EditText cajaTextoCorreo = findViewById(R.id.cajaTextoCorreo);
        EditText cajaTextoPass = findViewById(R.id.cajaTextoPass);
        MaterialSwitch swRecordar = findViewById(R.id.swRecordar);
        Button btnContinuar = findViewById(R.id.btnContinuar);
        TextView tvMensaje = findViewById(R.id.tvMensaje);

        btnContinuar.setOnClickListener(v -> {
            String correo = cajaTextoCorreo.getText().toString();
            String pass = cajaTextoPass.getText().toString();

            // Compara con equals, nunca con ==
            if (correo.equals(CORREO_VALIDO) && pass.equals(PASS_VALIDA)) {
                if (swRecordar.isChecked()) {
                    tvMensaje.setText(R.string.mensaje_ok_recordar);
                } else {
                    tvMensaje.setText(R.string.mensaje_ok);
                }
                tvMensaje.setTextColor(ContextCompat.getColor(this, R.color.verde));
            } else {
                tvMensaje.setText(R.string.mensaje_error);
                tvMensaje.setTextColor(ContextCompat.getColor(this, R.color.rojo));
            }
        });
    }
}