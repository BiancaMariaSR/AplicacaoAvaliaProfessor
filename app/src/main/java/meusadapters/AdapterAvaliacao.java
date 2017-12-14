package meusadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.edu.ifma.dai.maurolcsilva.aplicacaoavaliaprofessor.R;
import modelo.AvaliaProfessor;

/**
 * Created by maurolcsilva on 07/12/2017.
 */

public class AdapterAvaliacao extends RecyclerView.Adapter {
    //Contexto da Aplicação
    private Context ctx;
    //Lista com os dados da entidade que será apresentada na RecyclerView
    private ArrayList<AvaliaProfessor> listadeavaliacoes;

    public AdapterAvaliacao(Context ctx, ArrayList<AvaliaProfessor> listadeavaliacoes) {
        this.ctx = ctx;
        this.listadeavaliacoes = listadeavaliacoes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Este método é responsável por criar um objeto view que represente o layout dos
        //itens do RecyclerView
        //Para fazer esta ação devemos usar o LayoutInflater
        //Ele irá inflar um arquivo de layout em objeto Java. Ele tranforma o layout xml em
        //um componente java
        //Ele será usado para recuperar os componentes Java do xml do layout para componentes Java reais
        //Esta ação ocorrerá no ViewHolder
        View layoutitemrecycler = LayoutInflater.from(ctx).inflate(R.layout.layout_item_recyclerview,null);
        //O construtor do nosso ViewHolder recebe o layout transformado em componente java
        MeuViewHolderAvaliacao mvh = new MeuViewHolderAvaliacao(layoutitemrecycler);

        return mvh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        //Este método conecta os dados de uma entidade e os coloca em um componente visual
        //Este método será chamado várias vezes, enquanto tiver dados na lista de dados da entidade
        //Pegamos uma entidade AvaliaProfessor da lista de avaliações
        //Usamos o parametro position
        AvaliaProfessor avp = listadeavaliacoes.get(position);
        //Tranformamos o holder recebido como parametro em nosso ViewHolder
        MeuViewHolderAvaliacao mvh = (MeuViewHolderAvaliacao) holder;
        //A partir do nosso ViewHolder podemos recuperar os componentes do layout
        //e setar a eles os valores que serão apresentados na lista do recyclerview
        mvh.lblDisciplina.setText(avp.getDisciplina());
        mvh.lblProfessor.setText(avp.getProfessor());

    }

    @Override
    public int getItemCount() {
        return listadeavaliacoes.size();
    }
}
