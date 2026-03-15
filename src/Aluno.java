import java.time.LocalDate;

public class Aluno {
    private String nome;
    private LocalDate dataNascimento;
    private Turma turma;
    private boolean ativo;

    public Aluno(String nome, LocalDate dataNascimento, Turma turma){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.turma = turma;
        this.ativo = true;
    }

    public Aluno(){
        this.nome = "";
        this.dataNascimento = LocalDate.now();
        this.turma = new Turma();
        this.ativo = true;
    }
    public String getNome(){return this.nome;}
    public void setNome (String nome){this.nome = nome;}

    public LocalDate getDataNascimento(){return this.dataNascimento;}
    public void setDataNascimento (LocalDate dataNascimento){this.dataNascimento = dataNascimento;}

    public Turma getTurma(){return this.turma;}
    public void setTurma (Turma turma){this.turma = turma;}

    public boolean isAtivo(){return this.ativo;}
    public void setAtivo(boolean ativo){this.ativo = ativo;}


}
