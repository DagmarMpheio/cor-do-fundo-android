package com.dagmarmpheio.cordofundo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonSelecionado;
    private Button botaoGuardar;
    private ConstraintLayout constraintLayout;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        botaoGuardar = (Button) findViewById(R.id.botaoGuardar);
        constraintLayout = (ConstraintLayout) findViewById(R.id.layoutId);

        botaoGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();

                if (idRadioButtonEscolhido > 0) {
                    radioButtonSelecionado = (RadioButton) findViewById(idRadioButtonEscolhido);

                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    String corEscolhida = radioButtonSelecionado.getText().toString();
                    editor.putString("corEscolhida", corEscolhida);
                    editor.commit();

                    setBackground(corEscolhida);
                }
            }
        });

        //recuperar a cor salva
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (sharedPreferences.contains("corEscolhida")) {
            String corRecuperada = sharedPreferences.getString("corEscolhida", "Rosa");
            setBackground(corRecuperada);
        }

    }

    private void setBackground(String cor) {
        if (cor.equals("Vermelho")) {
            constraintLayout.setBackgroundColor(Color.parseColor("#FF0000"));
        } else if (cor.equals("Amarelo")) {
            constraintLayout.setBackgroundColor(Color.parseColor("#FFDD00"));
        } else if (cor.equals("Azul")) {
            constraintLayout.setBackgroundColor(Color.parseColor("#0000FF"));
        } else if (cor.equals("Laranja")) {
            constraintLayout.setBackgroundColor(Color.parseColor("#F57C00"));
        } else if (cor.equals("Roxo")) {
            constraintLayout.setBackgroundColor(Color.parseColor("#7B1FA2"));
        } else if (cor.equals("Verde")) {
            constraintLayout.setBackgroundColor(Color.parseColor("#00FF00"));
        } else if (cor.equals("Rosa")) {
            constraintLayout.setBackgroundColor(Color.parseColor("#FB50B7"));
        }
    }
}