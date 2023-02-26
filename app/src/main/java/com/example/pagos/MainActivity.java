package com.example.pagos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner ListaCarrera;
    Spinner ListaTipo;
    EditText CuotaEstandar, IngreCum;
    Button Ver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                ListaCarrera = findViewById(R.id.ListaCarreras);
                ListaTipo = findViewById(R.id.ListaTipo);
                CuotaEstandar = findViewById(R.id.CuotaEstandar);
                IngreCum = findViewById(R.id.IngreCum);
                Ver = findViewById(R.id.Ver);
                String[] Carrera = {"Ingeniería En Manejo y Gestión de Base De Datos", "Ingeniería En Sistemas","Técnico en Sistemas"};
                ArrayAdapter<String> VerCarrera = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Carrera);
                ListaCarrera.setAdapter(VerCarrera);
                String[] Tipo = {"Pública", "Privada"};
                ArrayAdapter<String> VerTipo = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Tipo);
                ListaTipo.setAdapter(VerTipo);

                Ver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Makes();
                    }
                });
            }
            public void Makes() {
                String op1, op2;
                double cuotaS=0, Cum, aumento = 0, descuento = 0, Institucion_Descuento = 0, Apagar=0;
                cuotaS = Double.parseDouble(CuotaEstandar.getText().toString());
                Cum = Double.parseDouble(IngreCum.getText().toString());
                op1 = ListaCarrera.getSelectedItem().toString();
                op2 = ListaTipo.getSelectedItem().toString();
                if (op1.equals("Ingeniería En Manejo y Gestión de Base De Datos")) {
                    aumento = cuotaS * 0.30 + 20;
                } else if (op1.equals("Ingeniería En Sistemas")) {
                    aumento = cuotaS * 0.40 + 25;
                } else if (op1.equals("Técnico en Sistemas")) {
                    aumento = cuotaS * 0.45 + 30;
                }
                if (Cum >= 9) {
                    descuento = cuotaS * 0.25;
                } else if (Cum >= 8) {
                    descuento = cuotaS * 0.20;
                } else if (Cum >= 7) {
                    descuento = cuotaS * 0.15;
                }
                if (op2.equals("Pública")) {
                    Institucion_Descuento = cuotaS * 0.05;
                } else if (op2.equals("Privada")) {
                    Institucion_Descuento = cuotaS * 0.10;
                }
                Apagar = cuotaS + aumento - descuento - Institucion_Descuento;
                Intent Registrar = new Intent(MainActivity.this, ObtenerDatos.class);
                Registrar.putExtra("Carrera", op1);
                Registrar.putExtra("Tipo", op2);
                Registrar.putExtra("Cuota", cuotaS);
                Registrar.putExtra("Cum", Cum);
                Registrar.putExtra("Total", Apagar);
                startActivity(Registrar);
                CuotaEstandar.setText("");
                IngreCum.setText("");
            }

        }