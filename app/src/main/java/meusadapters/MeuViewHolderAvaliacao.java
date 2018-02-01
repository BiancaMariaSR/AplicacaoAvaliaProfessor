package meusadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifma.dai.maurolcsilva.aplicacaoavaliaprofessor.R;

/**
 * Created by maurolcsilva on 07/12/2017.
 */

public class MeuViewHolderAvaliacao extends RecyclerView.ViewHolder {
    //Devemos colocar como atributos do nosso ViewHolder os componentes
    //que fazem parte do layout do nosso RecyclerView
    final TextView lblDisciplina;
    final TextView lblProfessor;
    final Button btnAdicionar;

    public MeuViewHolderAvaliacao(View itemView) {
        super(itemView);
        //Usamos o layout transformado em componente java para recuperar
        //os elementos xml usando findviewbyid
        //A partir deste momento o ViewHolder passa a ter os componentes java
        //dentro dele

        lblDisciplina = (TextView) itemView.findViewById(R.id.lblListaDisciplina);
        lblProfessor = (TextView) itemView.findViewById(R.id.lblListaProfessor);
        btnAdicionar = (Button) itemView.findViewById(R.id.btnAdicionar);

    }
}
