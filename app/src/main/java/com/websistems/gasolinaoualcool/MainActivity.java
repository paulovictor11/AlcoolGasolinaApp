package com.websistems.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtPrecoAlcool, txtPrecoGasolina;
    private Button btnVerificar;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPrecoAlcool = findViewById(R.id.edtAlcool);
        txtPrecoGasolina = findViewById(R.id.edtGasolina);
        btnVerificar = findViewById(R.id.btnVerificar);
        txtResultado = findViewById(R.id.txtResultado);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //recupera valores digitados
                String precoAlcool = txtPrecoAlcool.getText().toString();
                String precoGasolina = txtPrecoGasolina.getText().toString();

                if (precoAlcool.isEmpty()){
                    txtPrecoAlcool.setError("Esse campo precisa ser preenchido");
                    txtPrecoAlcool.requestFocus();
                } else if (precoGasolina.isEmpty()){
                    txtPrecoGasolina.setError("Esse campo precisa ser preenchido");
                    txtPrecoGasolina.requestFocus();
                } else {

                    //converte valores strings para números
                    Double valorAlcool = Double.parseDouble(precoAlcool);
                    Double valorGasolina = Double.parseDouble(precoGasolina);

                    double resultado = valorAlcool / valorGasolina;

                    if (resultado >= 0.7){
                        //gasolina
                        txtResultado.setText("É melhor utilizar Gasolina");
                    } else {
                        //alcool
                        txtResultado.setText("É melhor utilizar Alcool");
                    }
                }
            }
        });
    }
}
