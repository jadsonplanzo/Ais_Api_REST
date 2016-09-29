package org.dalol.aisapirest.model.dado;

public class Alunos {

    public String aluno, turma, disciplina;
    public int serie, unidade;
    public double nota;



    private Alunos(Builder builder){
       aluno = builder.aluno;
        turma = builder.turma;
       serie = builder.serie;
        disciplina = builder.disciplina;
        unidade = builder.unidade;
        nota = builder.nota;

    }

    public static class Builder {

        public String aluno, turma, disciplina;
        public int serie, unidade;
        public double nota;


        public Builder setAluno(String aluno) {
           aluno = aluno;
            return Builder.this;
        }



        public Builder setTurma(String turma) {
         turma = turma;
            return Builder.this;
        }

        public Builder setDisciplina(String disciplina) {
           disciplina = disciplina;
            return Builder.this;
        }

        public Builder setUnidade(int unidade) {
            unidade = unidade;
            return Builder.this;
        }

        public Builder setSerie(int serie) {
           serie = serie;
            return Builder.this;
        }
        public Builder setNota(double nota) {
          nota =nota;
            return Builder.this;
        }

        public Alunos build() {
            return new Alunos(Builder.this);
        }
    }
}
