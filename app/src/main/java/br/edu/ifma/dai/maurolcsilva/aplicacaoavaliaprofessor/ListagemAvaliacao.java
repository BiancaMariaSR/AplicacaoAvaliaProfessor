package br.edu.ifma.dai.maurolcsilva.aplicacaoavaliaprofessor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import dao.DAOAvaliaProfessor;
import meusadapters.AdapterAvaliacao;

public class ListagemAvaliacao extends AppCompatActivity {

    private RecyclerView meurecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_avaliacao);
        //Recuperamos o componente RecyclerView do layout para dentro
        //da implementação Java
        meurecyclerview = (RecyclerView) findViewById(R.id.rcvListagemdeAvaliacoes);
        meurecyclerview.hasFixedSize();
        //Usamos um gerenciador de layout para definir como os dados serão apresentados
        //no RecyclerView
        LinearLayoutManager nossolayout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        //Dizemos ao RecyclerView como será a forma de disposição dos seus dados
        meurecyclerview.setLayoutManager(nossolayout);

        //Criamos um objeto DAO para usar o metodo listar
        //Ele retorna uma lista de Avaliações
        DAOAvaliaProfessor daoavaliaprof = new DAOAvaliaProfessor(this);

        //Criamos o nosso e passamos para ele o nosso contexto e os dados que serão
        //apresentados no RecyclerView
        AdapterAvaliacao meuadapter = new AdapterAvaliacao(this,daoavaliaprof.listar());
        //Dizemos ao RecyclerView quem será o seu adapter
        meurecyclerview.setAdapter(meuadapter);

    }
}
