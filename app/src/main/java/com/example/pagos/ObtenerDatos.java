package com.example.pagos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ObtenerDatos extends AppCompatActivity {
    TextView Carrera, Tipo, Cuota, Cum, Pago;
    Button Regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtener_datos);
        Carrera = findViewById(R.id.VerCarrera);
        Tipo = findViewById(R.id.VerTipo);
        Cuota = findViewById(R.id.VerCuota);
        Cum = findViewById(R.id.VerCum);
        Pago = findViewById(R.id.VerPago);
        Regresar = findViewById(R.id.Volver);
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Back();
            }
        });
    }
    public void Back(){
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle Observar = getIntent().getExtras();
        if (Observar!= null){
            String ViewCarrera = Observar.getString("Carrera");
            String ViewTipo = Observar.getString("Tipo");
            double ViewCuota = Observar.getDouble("Cuota");
            double ViewCum = Observar.getDouble("Cum");
            double ViewTotal = Observar.getDouble("Total");
            Carrera.setText(ViewCarrera);
            Tipo.setText(ViewTipo);
            Cuota.setText("$ "+ViewCuota);
            Cum.setText("Nota "+ViewCum);
            Pago.setText("Debe pagar "+ViewTotal);
        }
    }
}