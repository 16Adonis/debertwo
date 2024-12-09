package com.example.debertwo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText Cedula, Nombres, FechaNacimiento, Ciudad, Correo, Telefono;
    private RadioGroup rGenero;
    private Button btnGuardar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los controles
        Cedula = findViewById(R.id.txtCedula);
        Nombres = findViewById(R.id.txtnombre);
        FechaNacimiento = findViewById(R.id.txtFecha);
        Ciudad = findViewById(R.id.txtCiudad);
        Correo = findViewById(R.id.txtCorreo);
        Telefono = findViewById(R.id.txttelefono);
        rGenero = findViewById(R.id.rgenero);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        // Acción del botón Enviar
        btnGuardar.setOnClickListener(v -> {
            if (validarFormulario()) {
                // Obtener datos
                String idcedula = Cedula.getText().toString();
                String Name = Nombres.getText().toString().toUpperCase();
                String fecha = FechaNacimiento.getText().toString();
                String ciudad = Ciudad.getText().toString().toUpperCase();
                String genero = ((RadioButton) findViewById(rGenero.getCheckedRadioButtonId())).getText().toString();
                String correo = Correo.getText().toString();
                String telefono = Telefono.getText().toString();

                // Pasar datos
                Intent intent = new Intent(MainActivity.this, Resultado.class);
                intent.putExtra("cedula", idcedula);
                intent.putExtra("nombres", Name);
                intent.putExtra("fechaNacimiento", fecha);
                intent.putExtra("ciudad", ciudad);
                intent.putExtra("genero", genero);
                intent.putExtra("correo", correo);
                intent.putExtra("telefono", telefono);
                startActivity(intent);
            }
        });

        // Acción del botón Limpiar
        btnLimpiar.setOnClickListener(v -> limpiarFormulario());
    }

    private boolean validarFormulario() {
        // Validar campos
        if (Cedula.getText().toString().length() != 10 || !TextUtils.isDigitsOnly(Cedula.getText())) {
            Cedula.setError("Ingrese un número de cédula válido de 10 dígitos");
            return false;
        }
        if (TextUtils.isEmpty(Nombres.getText()) || Nombres.getText().toString().length() > 500) {
            Nombres.setError("Ingrese un nombre válido (máx. 500 caracteres)");
            return false;
        }
        if (TextUtils.isEmpty(FechaNacimiento.getText())) {
            FechaNacimiento.setError("Ingrese una fecha válida");
            return false;
        }
        if (TextUtils.isEmpty(Ciudad.getText()) || Ciudad.getText().toString().length() > 200) {
            Ciudad.setError("Ingrese una ciudad válida (máx. 200 caracteres)");
            return false;
        }
        if (rGenero.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Seleccione un género", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Correo.getText()).matches()) {
            Correo.setError("Ingrese un correo electrónico válido");
            return false;
        }
        if (Telefono.getText().toString().length() != 10 || !TextUtils.isDigitsOnly(Telefono.getText())) {
            Telefono.setError("Ingrese un número de teléfono válido de 10 dígitos");
            return false;
        }
        return true;
    }

    private void limpiarFormulario() {
        Cedula.setText("");
        Nombres.setText("");
        FechaNacimiento.setText("");
        Ciudad.setText("");
        rGenero.clearCheck();
        Correo.setText("");
        Telefono.setText("");
    }
}