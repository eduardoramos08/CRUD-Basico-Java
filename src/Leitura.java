import java.util.Scanner;

public class Leitura {
    public static String dados(String mensagem){
        Scanner scanner = new Scanner(System.in);// System.in espera alguma leitura.
        System.out.println(mensagem);
        return scanner.nextLine();
    }
}
