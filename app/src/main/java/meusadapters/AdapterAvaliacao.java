package meusadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import modelo.AvaliaProfessor;

/**
 * Created by maurolcsilva on 07/12/2017.
 */

public class AdapterAvaliacao extends RecyclerView.Adapter {
    private Context ctx;
    private ArrayList<AvaliaProfessor> listadeavaliacoes;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listadeavaliacoes.size();
    }
}
