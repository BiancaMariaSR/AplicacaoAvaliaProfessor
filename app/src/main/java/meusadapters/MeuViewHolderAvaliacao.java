package meusadapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.edu.ifma.dai.maurolcsilva.aplicacaoavaliaprofessor.R;

/**
 * Created by maurolcsilva on 07/12/2017.
 */

public class MeuViewHolderAvaliacao extends RecyclerView.ViewHolder {
    final TextView lblDisciplina;
    final TextView lblProfessor;

    public MeuViewHolderAvaliacao(View itemView) {
        super(itemView);
        lblDisciplina = (TextView) itemView.findViewById(R.id.lblListaDisciplina);
        lblProfessor = (TextView) itemView.findViewById(R.id.lblListaProfessor);
    }
}
