package com.example.debertwo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Obtener referencias a los TextView
        TextView tvCedula = findViewById(R.id.Cedula);
        TextView tvNombres = findViewById(R.id.Nombre);
        TextView tvFechaNacimiento = findViewById(R.id.FechaNacimiento);
        TextView tvCiudad = findViewById(R.id.Ciudad);
        TextView tvGenero = findViewById(R.id.Genero);
        TextView tvCorreo = findViewById(R.id.Correo);
        TextView tvTelefono = findViewById(R.id.Telefono);

        // Obtener datos del Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tvCedula.setText("Cédula: " + extras.getString("idcedula"));
            tvNombres.setText("Nombres: " + extras.getString("Name"));
            tvFechaNacimiento.setText("Fecha de Nacimiento: " + extras.getString("fecha"));
            tvCiudad.setText("Ciudad: " + extras.getString("ciudad"));
            tvGenero.setText("Género: " + extras.getString("genero"));
            tvCorreo.setText("Correo: " + extras.getString("correo"));
            tvTelefono.setText("Teléfono: " + extras.getString("telefono"));
    }
}
}