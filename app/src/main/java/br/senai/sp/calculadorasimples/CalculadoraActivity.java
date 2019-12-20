package br.senai.sp.calculadorasimples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {

    EditText etValor1, etValor2;
    TextView tvResultado;
    Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        etValor1 = (EditText) findViewById(R.id.etValor1);
        etValor2 = (EditText) findViewById(R.id.etValor2);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etValor1.setText(null);
                etValor2.setText(null);
                tvResultado.setText("RESULTADO");
                etValor1.requestFocus();
            }
        });
    }

    public void somar(View v){
        if (verificarDados()){
            tvResultado.setText(String.valueOf(Float.parseFloat(etValor1.getText().toString())+Float.parseFloat(etValor2.getText().toString())));
        }
    }

    public void subtrair(View v){
        if (verificarDados()){
            tvResultado.setText(String.valueOf(Float.parseFloat(etValor1.getText().toString())-Float.parseFloat(etValor2.getText().toString())));
        }
    }

    public void multiplicar(View v){
        if (verificarDados()){
            tvResultado.setText(String.valueOf(Float.parseFloat(etValor1.getText().toString())*Float.parseFloat(etValor2.getText().toString())));
        }
    }

    public void dividir(View v){
        if (verificarDados()){
            tvResultado.setText(String.valueOf(Float.parseFloat(etValor1.getText().toString())/Float.parseFloat(etValor2.getText().toString())));
        }
    }

    public boolean verificarDados(){
        if(etValor1.getText().toString().equalsIgnoreCase("") || etValor2.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this,"Necessário preencher todos os campos", Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }
}
