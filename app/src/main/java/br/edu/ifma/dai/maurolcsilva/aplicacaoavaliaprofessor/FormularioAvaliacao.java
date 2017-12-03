package br.edu.ifma.dai.maurolcsilva.aplicacaoavaliaprofessor;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import dao.DAOAvaliaProfessor;
import modelo.AvaliaProfessor;
import util.CriaBD;

public class FormularioAvaliacao extends AppCompatActivity {

    //Definição dos Componentes Java
    private Spinner spnDisciplinas;
    private Spinner spnProfessores;
    private EditText txtAula;
    private RadioGroup rdgNotas;
    private CheckBox chkObs01;
    private CheckBox chkObs02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_avaliacao);
        //Criação dos componentes Java baseados no arquivo XML de layout
        spnDisciplinas = (Spinner) findViewById(R.id.spnFormularioDisciplina);
        spnProfessores = (Spinner) findViewById(R.id.spnFormularioProfessor);
        txtAula = (EditText) findViewById(R.id.txtFormularioAula);
        rdgNotas = (RadioGroup) findViewById(R.id.rdgFormularioNotas);
        chkObs01 = (CheckBox) findViewById(R.id.chkFormularioAtrasado);
        chkObs02 = (CheckBox) findViewById(R.id.chkFormularioDuvidas);
        //Criação dos ArrayAdapters para serem usados em conjunto com os Spinners
        ArrayAdapter<String> adapterdisciplina = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.disciplinas));
        ArrayAdapter<String> adapterprofessor = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.professores));
        //Vinculação dos Adapters aos Spinners
        spnDisciplinas.setAdapter(adapterdisciplina);
        spnProfessores.setAdapter(adapterprofessor);

    }

    public void salvarAvaliaProfessor(View v){
        String aula="",observacoes = "",disciplina="",professor="";
        int nota = 0,opcaoradio=0;

        //Recuperação do RadioButton marcado
        opcaoradio = rdgNotas.getCheckedRadioButtonId();
        switch (opcaoradio){
            case R.id.rdFormularioNota10:
                nota = 10;
                break;
            case R.id.rdFormularioNota9:
                nota = 9;
                break;
            case R.id.rdFormularioNota8:
                nota = 8;
                break;
            case R.id.rdFormularioNota7:
                nota = 7;
                break;
            case R.id.rdFormularioNota6:
                nota = 6;
                break;
        }
        //Recuperação dos CheckBoxs marcados
        if (chkObs01.isChecked()){
            observacoes = observacoes + " Chegou Atrasado ";
        }
        if (chkObs02.isChecked()){
            observacoes = observacoes + " Tirou dúvidas dos alunos ";
        }
        //Recuperação da aula dada no dia ministrada pelo professor
        aula = txtAula.getText().toString();

        //Recuperação dos itens selecionados nos Spinners
        disciplina = spnDisciplinas.getSelectedItem().toString();
        professor = spnProfessores.getSelectedItem().toString();

        //Criacao do objeto baseado na classe de modelo
        AvaliaProfessor avaliaprof = new AvaliaProfessor();
        avaliaprof.setDisciplina(disciplina);
        avaliaprof.setProfessor(professor);
        avaliaprof.setAula(aula);
        avaliaprof.setNota(nota);
        avaliaprof.setObservacoes(observacoes);
        //Criacao do objeto DAO
        DAOAvaliaProfessor daoavalia = new DAOAvaliaProfessor(this);
        if (daoavalia.salvar(avaliaprof)){
            Toast.makeText(this,"Dados salvos com sucesso!!!",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Falha na Salva dos Dados!!!",Toast.LENGTH_SHORT).show();
        }
    }

    public void listarAvaliaProfessor(View v){

        ArrayList<AvaliaProfessor> listaavaliaprofessores;
        DAOAvaliaProfessor daoavalia = new DAOAvaliaProfessor(this);
        listaavaliaprofessores = daoavalia.listar();
        for (AvaliaProfessor avp:listaavaliaprofessores) {
            Toast.makeText(this,avp.getProfessor(),Toast.LENGTH_SHORT).show();
        }
        //Array contendo as colunas que serão usadas no SELECT
        String colunas[] = {"disciplina","nome","aula","nota","observacao"};
        CriaBD criabd = new CriaBD(this);
        //Recuperamos uma referência do banco de dados para apenas leitura
        SQLiteDatabase db = criabd.getReadableDatabase();
        //Utilização de um objeto cursor para iterar pelos valores
        //retornados na execução do SELECT
        Cursor cursor = db.query(false,"avaliaprofessor",colunas,null,null,null,null,null,null);
        //Verificamos se a quantidade de registros retornados é maior que 0
        if(cursor.getCount() > 0){
            //Iteramos entre os dados obtidos
            while(cursor.moveToNext()){
                //Recuperamos a coluna "nome", se quiséssemos a nota por exemplo
                //usaríamos cursor.getInt(3), atribuindo este a uma variável inteira
                String nomeprofessor = cursor.getString(1);
                //Toast.makeText(this,nomeprofessor,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
