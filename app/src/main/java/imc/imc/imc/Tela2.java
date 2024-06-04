package imc.imc.imc;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculadora_imc.R;

public class Tela2 extends AppCompatActivity  {


    private TextView textResultado;
    private EditText editePeso;
    private EditText editeAltura;
    private static final String KEY_TEXT_VALUE = "textValue";
    private Button button;
    private Button btnLimpar;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2);



        textResultado = findViewById(R.id.textResultado);
        editePeso = findViewById(R.id.editePeso);
        editeAltura = findViewById(R.id.editeAltura);
        button = findViewById(R.id.button);
        btnLimpar = findViewById(R.id.btnLimpar);



        if (savedInstanceState != null) {
            String savedText = savedInstanceState.getString(KEY_TEXT_VALUE);
            textResultado.setText(savedText);
        }



        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editePeso.getText().toString())){
                    editePeso.setError("Peso Invalido!");
                    return;
                }

                if (TextUtils.isEmpty(editeAltura.getText().toString())){
                    editeAltura.setError("Altura Invalida!");
                    return;

                }

                Toast.makeText(Tela2.this, "", Toast.LENGTH_SHORT);

                double peso = Double.parseDouble(editePeso.getText().toString());
                double altura = Double.parseDouble(editeAltura.getText().toString());
                double resultado = peso / (altura * altura);
                EsconderTeclado(button);
                int lineSpacingExtra = 40;
                int lineIndex = 0;



                if (resultado < 19) {

                    textResultado.setLineSpacing(lineSpacingExtra, 1);
                    textResultado.setText("Abaixo do peso\n" +
                            "Dica 1. Alimente-se com mais frequência.\n" +
                            "Dica 2. Consumir mais calorias do que gastar.\n" +
                            "Dica 3. Escolha alimentos ricos em nutrientes.\n" +
                            "Dica 4. Fique atento ao consumo de líquidos.\n" +
                            "Dica 5. Adicione calorias extras e saudáveis aos seus pratos.\n" +
                            "Dica 6. Faça exercício.\n" +
                            "Dica 7. Priorize proteínas e carboidratos.");


                } else if (resultado <= 19 || resultado < 25) {

                    textResultado.setLineSpacing(lineSpacingExtra, 1);
                    textResultado.setText("Peso Normal\n"+"Dica 1. Exercite-se com frequência.\n" +
                            "Dica 2. Coma bastante proteína.\n" +
                            "Dica 3. Pratique a alimentação Mindful.\n" +
                            "Dica 4. Pratique uma abordagem 80/20.\n" +
                            "Dica 5. Considere participar de treinos de força.\n" +
                            "Dica 6. Mantenha sua dieta interessante.\n" +
                            "Dica 7. Reduza seu consumo de carboidratos refinados.\n" +
                            "Dica 8. Mantenha-se hidratado.");



                } else if (resultado <= 25 || resultado < 30) {


                    textResultado.setLineSpacing(lineSpacingExtra, 1);
                    textResultado.setText("Sobrepeso\n"+"Dica 1. Escolha alimentos naturais.\n" +
                            "Dica 2. Priorize o consumo de proteínas magras.\n" +
                            "Dica 3. Evite distrações ao se alimentar.\n" +
                            "Dica 4. Procure por um nutricionista.\n" +
                            "Dica 5. Nos lanches dê preferência a frutas.\n" +
                            "Dica 6. Pratique atividades físicas. ");


                } else if (resultado <= 30 || resultado < 40) {


                    textResultado.setLineSpacing(lineSpacingExtra, 1);
                    textResultado.setText("Obesidade tipo 1!!!\n"+"Dica 1. Faça uma reeducação alimentar. Maus hábitos alimentares estão entre os principais causadores da obesidade.\n" +
                            "Dica 2. Pratique exercícios físicos.\n" +
                            "Dica 3. Consulte um médico.\n" +
                            "Dica 4. Tenha o suporte de um nutricionista.\n" +
                            "Dica 5. Evite o sedentarismo.\n" +
                            "Dica 6. Aposte na reeducação emocional.\n" +
                            "Dica 7. Beba mais água.");


                } else if (resultado >= 40) {


                    textResultado.setLineSpacing(lineSpacingExtra, 1);
                    textResultado.setText("Obesidade Tipo 2!!!!!!!!!!!!!\n"+"1. Mudanças na dieta.\n"+
                                          "2. Praticar atividades físicas\n"+"3. Remédios para obesidade.\n"+
                                           "4. Cirurgia bariátrica.\n"+"OBS: O TRATAMENTO CIRÚRGICO PARA OBESIDADE TIPO 2, A CIRURGIA BARIÁTRICA, SE MOSTROU EFICAZ POR GERAR PERDA DE PESO NO LONGO PRAZO E BENEFÍCIOS COMO MELHORIA DAS DOENÇAS ASSOCIADAS E AUMENTO DA EXPECTATIVA DE VIDA.") ;

                }

            }

        });

        editeAltura.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editeAltura.removeTextChangedListener(this);
                String text = s.toString().replace(".", "");

                if (text.length() == 3) {
                    // Adicionando pontos a cada três caracteres da direita para a esquerda
                    StringBuilder formattedText = new StringBuilder(text);
                    for (int i = text.length() - 2; i > 0; i -= 2) {
                        formattedText.insert(i, ".");
                    }

                    editeAltura.setText(formattedText.toString());
                    editeAltura.setSelection(formattedText.length());

                }
                editeAltura.addTextChangedListener(this);

            }
        });

    }


    private void limparCampos() {
        EditText campo1 = findViewById(R.id.editePeso);
        EditText campo2 = findViewById(R.id.editeAltura);
        TextView campo3= findViewById(R.id.textResultado);
        campo1.setText("");
        campo2.setText("");
        campo3.setText("");


    }


    public void EsconderTeclado(View v) {
        if (v != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);

        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String textValue = textResultado.getText().toString();
        outState.putString(KEY_TEXT_VALUE, textValue);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String savedText = savedInstanceState.getString(KEY_TEXT_VALUE);
        textResultado.setText(savedText);
    }

}

