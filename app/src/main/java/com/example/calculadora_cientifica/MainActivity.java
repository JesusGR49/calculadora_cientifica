package com.example.calculadora_cientifica;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

// Corregimos el error de tipeo en objecthunter
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    // 1. Las variables se declaran aquí arriba, a nivel de clase
    private EditText entradaEditText;
    private TextView resultadoTextView;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Corregimos el ID (Number con 'b')
        entradaEditText = findViewById(R.id.editTextNumberDecimal);
        resultadoTextView = findViewById(R.id.textView2);
        calcularButton = findViewById(R.id.button16);

        // 3. El OnClickListener va ADENTRO de onCreate
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado();
            }
        });
    }

    private void calcularResultado() {
        String expresion = entradaEditText.getText().toString();

        try {
            double resultado = evaluarExpresion(expresion);
            resultadoTextView.setText("Resultado: " + resultado);
        } catch (Exception e) { // 4. Se usa una variable 'e' en vez de '0'
            resultadoTextView.setText("Error: Expresion invalida"); // 5. Es con punto, no igual
        }
    }

    private double evaluarExpresion(String expresion) {
        Expression expression = new ExpressionBuilder(expresion).build();
        return expression.evaluate();
    }
}