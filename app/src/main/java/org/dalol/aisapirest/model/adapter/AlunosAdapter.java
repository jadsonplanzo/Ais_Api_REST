package org.dalol.aisapirest.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.dalol.aisapirest.R;
import org.dalol.aisapirest.model.dado.Alunos;

import java.util.List;

public class AlunosAdapter extends RecyclerView.Adapter<AlunosAdapter.Holder> {

    public static String TAG = AlunosAdapter.class.getSimpleName();

    private List<Alunos> mAlunoses;

    public AlunosAdapter(List<Alunos> alunoses) {
        mAlunoses = alunoses;
    }

    public void addFlower(Alunos alunos) {
        mAlunoses.add(alunos);
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Alunos currentAlunos = mAlunoses.get(position);
        holder.mAluno.setText(currentAlunos.aluno);
        holder.mTurma.setText(currentAlunos.turma);
        holder.mSerie.setText(currentAlunos.serie);
        holder.mDisciplina.setText(currentAlunos.disciplina);
        holder.mUnidade.setText(currentAlunos.unidade);
        holder.mNota.setText((int) currentAlunos.nota);

    }

    @Override
    public int getItemCount() {
        return mAlunoses.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public TextView mAluno, mTurma, mSerie, mUnidade, mNota, mDisciplina;


        public Holder(View itemView) {
            super(itemView);

            mAluno = (TextView) itemView.findViewById(R.id.txtAluno);
            mTurma = (TextView) itemView.findViewById(R.id.txtTurma);
            mSerie = (TextView) itemView.findViewById(R.id.txtSerie);
            mDisciplina = (TextView) itemView.findViewById(R.id.txtDisciplina);
            mUnidade = (TextView) itemView.findViewById(R.id.txtUnidade);
            mNota = (TextView) itemView.findViewById(R.id.txtnota);

        }
    }
}
