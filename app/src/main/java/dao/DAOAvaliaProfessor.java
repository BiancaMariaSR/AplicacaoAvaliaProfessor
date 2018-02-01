package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import modelo.AvaliaProfessor;
import util.DBGateway;

/**
 * Created by maurolcsilva on 30/11/2017.
 */

public class DAOAvaliaProfessor {

    private DBGateway gw;
    private ArrayList<AvaliaProfessor> listadeavaliacoes;
    private Cursor cursor;

    //Verifique que o construtor do DAO precisa receber o Contexto
    //Pois DBGateway precisa do contexto para criar uma referência
    //ao banco de dados, através da Classe CriaDB
    public DAOAvaliaProfessor(Context ctx){
        this.gw = DBGateway.getInstance(ctx);
    }

    public boolean salvar(AvaliaProfessor avaliaprof){
        long resultado;
        boolean retorno = false;

        ContentValues valores = new ContentValues();
        valores.put("disciplina",avaliaprof.getDisciplina());
        valores.put("nome",avaliaprof.getProfessor());
        valores.put("aula",avaliaprof.getAula());
        valores.put("nota",avaliaprof.getNota());
        valores.put("observacao",avaliaprof.getObservacoes());
        resultado = gw.getDatabase().insert("avaliaprofessor",null,valores);
        //Se resultado retornar um long maior que 0, significa que deu certo a SALVA
        if (resultado > 0)
            retorno = true;
        return retorno;
    }

    public ArrayList<AvaliaProfessor> listar(){
        listadeavaliacoes = new ArrayList<AvaliaProfessor>();
        //Array contendo as colunas que serão usadas no SELECT
        String colunas[] = {"idavaliaprof","disciplina","nome","aula","nota","observacao"};
        //Utilização de um objeto cursor para iterar pelos valores
        //retornados na execução do SELECT
        cursor = gw.getDatabase().query("avaliaprofessor",colunas,null,null,null,null,null);
        //Verificamos se a quantidade de registros retornados é maior que 0
        if (cursor.getCount()>0){
            //Iteramos entre os dados obtidos
            while(cursor.moveToNext()){
                AvaliaProfessor avaliaprof = new AvaliaProfessor();
                avaliaprof.setIdavaliaprof(cursor.getInt(0));
                avaliaprof.setDisciplina(cursor.getString(1));
                avaliaprof.setProfessor(cursor.getString(2));
                avaliaprof.setAula(cursor.getString(3));
                avaliaprof.setNota(cursor.getInt(4));
                avaliaprof.setObservacoes(cursor.getString(5));
                listadeavaliacoes.add(avaliaprof);

            }
        }

        return (listadeavaliacoes);

    }

    public boolean deletar(AvaliaProfessor avaliaprof){
        long resultado;
        boolean retorno = false;
        int idavaliaprof = avaliaprof.getIdavaliaprof();

        resultado = gw.getDatabase().delete("avaliaprofessor","idavaliaprof = ?",new String[] {String.valueOf(idavaliaprof)});

        if (resultado > 0)
            retorno = true;


        return (retorno);
    }



}
