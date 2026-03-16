//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    private static ArrayList<Aluno> listaAlunos = new ArrayList();
    private static ArrayList<Turma> listaTurmas = new ArrayList();

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        System.out.println("\n==== Secretaria ====");
        System.out.println("1 - Alunos");
        System.out.println("2 - Turmas");
        System.out.println("3 - Sair");
        switch (Leitura.dados("Digite a opção desejada: ")) {
            case "1":
                menuAlunos();
                break;
            case "2":
                menuTurmas();
                break;
            case "3":
                System.out.println("Até breve...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente");
                menuPrincipal();
        }

    }

    private static void menuTurmas() {
        System.out.println("\n==== Turmas ====");
        System.out.println("1 - Listar Turmas");
        System.out.println("2 - Cadastrar Turma");
        System.out.println("3 - Atualizar Turma");
        System.out.println("4 - Excluir Turma");
        System.out.println("5 - Voltar ao menu principal");
        switch (Leitura.dados("Digite a opção desejada: ")) {
            case "1":
                listarTurmas();
                menuTurmas();
                break;
            case "2":
                cadastrarTurma();
                menuTurmas();
                break;
            case "3":
                atualizarTurma();
                menuTurmas();
                break;
            case "4":
                excluirTurma();
                menuTurmas();
                break;
            case "5":
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente");
                menuTurmas();
        }

    }

    private static void menuAlunos() {
        System.out.println("\n==== Alunos ====");
        System.out.println("1 - Listar Alunos");
        System.out.println("2 - Cadastrar Aluno");
        System.out.println("3 - Atualizar Aluno");
        System.out.println("4 - Excluir Aluno");
        System.out.println("5 - Voltar ao menu principal");
        switch (Leitura.dados("Digite a opção desejada: ")) {
            case "1":
                listarAlunos();
                menuAlunos();
                break;
            case "2":
                cadastrarAluno();
                break;
            case "3":
                atualizarAluno();
                break;
            case "4":
                excluirAluno();
                break;
            case "5":
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente");
                menuAlunos();
        }

    }

    private static String validarCurso() {
        String curso;
        for(curso = Leitura.dados("Digite o curso: "); !isCharacter(curso); curso = Leitura.dados("Digite o curso: ")) {
            System.out.println("Nome de curso inválido! Não use números ou caracteres especiais, por favor");
        }

        return curso;
    }

    private static void listarAlunos() {
        if (isVazioAlunos(listaAlunos)){
            System.out.println("Não há alunos cadastrados!");
        }else {
            for (Aluno a : listaAlunos) {
                if (a.isAtivo()){
                    System.out.println(a);
                }
            }
        }
    }
    private static void cadastrarAluno() {
        String nome = validarNome();
        LocalDate dataNascimento = validarDataNascimento();
        Turma turma = validarTurma();

        Aluno aluno = new Aluno(nome, dataNascimento, turma);
        listaAlunos.add(aluno);
    }

    private static Turma validarTurma() {
        System.out.println("\nLista das Turmas:");

        for(int i = 0; i < listaTurmas.size(); ++i) {
            if (((Turma)listaTurmas.get(i)).isAtivo()) {
                System.out.printf("\n%d - %s", i + 1, ((Turma)listaTurmas.get(i)).getSigla());
            }
        }

        int index = validaIdTurma();
        return listaTurmas.get(index);
    }

    private static LocalDate validarDataNascimento() {
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt","BR"));
        LocalDate dataNascimentoAluno;

        while (true) {
            try {
                String input = Leitura.dados("Digite a data de nascimento do aluno (dd/MM/yyyy): ");
                dataNascimentoAluno = LocalDate.parse(input, dataFormatada);

                LocalDate dataHoje = LocalDate.now();
                int idade = Period.between(dataNascimentoAluno, dataHoje).getYears();

                if (idade < 14) {
                    System.out.println("Aluno precisa ter pelo menos 14 anos");
                    menuAlunos();
                }
                if (idade > 130) {
                    System.out.println("Idade invalida! O aluno não pode ter mais que 130 anos");
                    menuAlunos();
                }
                return dataNascimentoAluno;
            }catch (DateTimeParseException e){
                System.out.println("Digite uma data de nascimento valida!");
            }
        }
        //String opcao = Leitura.dados("\nDigite o número da turma desejada: ");
        //int opcaoValida = -1;
        //int opcaoUsuario = -1;

        //while(opcaoValida == -1) {
        //    opcaoUsuario = validarItemLista(opcao);
        //    if (opcaoUsuario == -1) {
        //        System.out.println("Opção inválida! Digite novamente: ");
        //        opcao = Leitura.dados("Digite o número da turma desejada: ");
        //    } else {
                opcaoValida = opcaoUsuario;
        //    }
        //}

        //return opcaoValida;



    }


    private static String validarNome() {
        String nome;
        for (nome = Leitura.dados("Digite o nome do Aluno: "); !isCharacter(nome); nome = Leitura.dados("Digite o nome do Aluno: ")){
            System.out.println("Nome inválido! Não use números ou caracteres especiais, por favor!");
        }
        return nome;
    }

    private static void atualizarAluno() {
    }

    private static void excluirAluno() {
    }

    private static void listarTurmas() {
        if (isVazioTurmas(listaTurmas)) {
            System.out.println("Não há turmas cadastradas");
        } else {
            for(Turma t : listaTurmas) {
                if (t.isAtivo()) {
                    System.out.println(t);
                }
            }

        }
    }
    private static void cadastrarTurma() {
        Periodo periodo = validarPeriodo();
        String curso = validarCurso();
        String sigla = validarSigla();
        Turma turma = new Turma(curso, sigla, periodo);
        listaTurmas.add(turma);
    }

    private static void atualizarTurma() {
        if (isVazioTurmas(listaTurmas)) {
            System.out.println("Não há turmas cadastradas");
        } else {
            listarTurmasIndiceSigla();
            int idAtualizar = validaIdTurma();
            System.out.printf("O período atual é: %s", ((Turma)listaTurmas.get(idAtualizar)).getPeriodo());
            atualizarParcial("período", idAtualizar);
            System.out.printf("O curso atual é: %s", ((Turma)listaTurmas.get(idAtualizar)).getCurso());
            atualizarParcial("curso", idAtualizar);
            System.out.printf("A sigla atual é: %s", ((Turma)listaTurmas.get(idAtualizar)).getSigla());
            atualizarParcial("sigla", idAtualizar);
        }
    }

    private static void excluirTurma() {
        if (isVazioTurmas(listaTurmas)) {
            System.out.println("Não há turmas cadastradas");
        } else {
            listarTurmasIndiceSigla();
            int idExcluir = validaIdTurma();
            if (confirmaExclusao()) {
                ((Turma)listaTurmas.get(idExcluir)).setAtivo(false);
                System.out.println("Turma excluída com sucesso!");
            }

        }
    }

    private static boolean isVazioAlunos(ArrayList<Aluno> listaAlunos){
        if (listaAlunos.isEmpty()){
            return true;
        }else {
            for (Aluno aluno : listaAlunos){
                if (aluno.isAtivo()){
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean isVazioTurmas(ArrayList<Turma> listaTurmas) {
        if (listaTurmas.isEmpty()) {
            return true;
        } else {
            for(Turma turma : listaTurmas) {
                if (turma.isAtivo()) {
                    return false;
                }
            }

            return true;
        }
    }

    private static boolean confirmaExclusao() {
        while(true) {
            switch (Leitura.dados("Você tem certeza? (S/N): ").toUpperCase()) {
                case "S":
                    return true;
                case "N":
                    return false;
                default:
                    System.out.println("Opção inválida, digite S para sim ou N para não!");
            }
        }
    }

    private static int validarItemLista(String opcao) {
        if (opcao.isBlank()) {
            return -1;
        } else {
            int opcaoNumero = -1;

            try {
                opcaoNumero = Integer.parseInt(opcao);
            } catch (NumberFormatException var3) {
                return -1;
            }

            int indiceLista = opcaoNumero - 1;
            return indiceLista >= 0 && listaTurmas.size() > indiceLista ? indiceLista : -1;
        }
    }

    private static void listarTurmasIndiceSigla() {
        System.out.println("\nLista das Turmas:");

        for(int i = 0; i < listaTurmas.size(); ++i) {
            if (((Turma)listaTurmas.get(i)).isAtivo()) {
                System.out.printf("\n%d - %s", i + 1, ((Turma)listaTurmas.get(i)).getSigla());
            }
        }
    }

    private static void atualizarParcial(String atributo, int idAtualizar) {
        boolean rodarNovamente = true;

        while(rodarNovamente) {
            switch (Leitura.dados("\nDeseja modificar " + atributo + " ? (S/N): ").toUpperCase()) {
                case "S":
                    switch (atributo) {
                        case "período":
                            Periodo periodo = validarPeriodo();
                            ((Turma)listaTurmas.get(idAtualizar)).setPeriodo(periodo);
                            break;
                        case "curso":
                            String curso = validarCurso();
                            ((Turma)listaTurmas.get(idAtualizar)).setCurso(curso);
                            break;
                        case "sigla":
                            String sigla = validarSigla();
                            ((Turma)listaTurmas.get(idAtualizar)).setSigla(sigla);
                    }

                    System.out.println(atributo + " atualizado com sucesso!");
                    rodarNovamente = false;
                    break;
                case "N":
                    rodarNovamente = false;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha S para SIM ou N para NÃO");
            }
        }

    }

    private static String validarSigla() {
        String sigla;
        for(sigla = Leitura.dados("Digite a sigla: "); !validarSigla(sigla); sigla = Leitura.dados("Digite a sigla: ")) {
            System.out.println("Sigla inválida! Precisa conter texto e não pode ser repetida");
        }

        return sigla;
    }



    private static void atualizarPeriodo(int idAtualizar) {
        boolean rodarNovamente = true;

        while(rodarNovamente) {
            switch (Leitura.dados("\nDeseja modificar o período? (S/N): ").toUpperCase()) {
                case "S":
                    Periodo periodo = validarPeriodo();
                    ((Turma)listaTurmas.get(idAtualizar)).setPeriodo(periodo);
                    System.out.println("Período atualizado com sucesso para " + String.valueOf(periodo));
                    rodarNovamente = false;
                    break;
                case "N":
                    rodarNovamente = false;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha S para SIM ou N para NÃO");
            }
        }

    }

    private static int validaIdTurma() {
        String opcao = Leitura.dados("\nDigite o número da turma desejada: ");
        int opcaoValida = -1;
        int opcaoUsuario = -1;

        while(opcaoValida == -1) {
            opcaoUsuario = validarItemLista(opcao);
            if (opcaoUsuario == -1) {
                System.out.println("Opção inválida! Digite novamente: ");
                opcao = Leitura.dados("Digite o número da turma desejada: ");
            } else {
                opcaoValida = opcaoUsuario;
            }
        }

        return opcaoValida;
    }

    private static boolean validarSigla(String sigla) {
        if (sigla.isBlank()) {
            return false;
        } else {
            for(Turma turma : listaTurmas) {
                if (turma.getSigla().equals(sigla)) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean isCharacter(String texto) {
        return !texto.isBlank() && texto.matches("^[a-zA-ZÀ-ÿ ]+$");
    }

    private static Periodo validarPeriodo() {
        switch (Leitura.dados("Digite o número do período escolhido:\n1 - Matutino\n2 - Vespertino\n3 - Noturno\n4 - Integral")) {
            case "1":
                return Periodo.MATUTINO;
            case "2":
                return Periodo.VESPERTINO;
            case "3":
                return Periodo.NOTURNO;
            case "4":
                return Periodo.INTEGRAL;
            default:
                System.out.println("Opção inválida, digite novamente");
                return validarPeriodo();
        }
    }
}
