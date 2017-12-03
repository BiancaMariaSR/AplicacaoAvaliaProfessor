package modelo;

/**
 * Created by maurolcsilva on 30/11/2017.
 */

public class AvaliaProfessor {
    private int idavaliaprof;
    private String disciplina;
    private String professor;
    private String aula;
    private int nota;
    private String observacoes;

    public int getIdavaliaprof() {
        return idavaliaprof;
    }

    public void setIdavaliaprof(int idavaliaprof) {
        this.idavaliaprof = idavaliaprof;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
