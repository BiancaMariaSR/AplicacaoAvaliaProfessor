package br.edu.ifma.dai.maurolcsilva.aplicacaoavaliaprofessor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class FormularioAvaliacao extends AppCompatActivity {

    private Spinner spnDisciplinas;
    private Spinner spnProfessores;
    private EditText txtAulas;
    private RadioGroup rdgNotas;
    private CheckBox chkObs01;
    private CheckBox chkObs02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_avaliacao);
        //Aqui iniciaremos nossa implementação
        spnDisciplinas = (Spinner) findViewById(R.id.spnFormularioDisciplina);
    }
}
