import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Excecao {
    public static void main(String[] args){
        Excecao e1 = new Excecao();
        e1.lerArquivo();

    }

    public void lerArquivo(){
        try {
            BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
            System.out.println("Informe o nome do Arquivo de entrada:");
            String nomeArquivo = reader.readLine();
            nomeArquivo = nomeArquivo+ ".csv"; 
            BufferedReader arqLeitura = new BufferedReader (new FileReader(nomeArquivo));
            String linha;
            Boolean primeiraLinha = true;
            while((linha = arqLeitura.readLine()) != null){
                if (primeiraLinha == true){
                    System.out.println(linha);
                    primeiraLinha = false;
                } else {
                    String[] arrayLinha = linha.split(";");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate data = LocalDate.parse(arrayLinha[1], formatter).plusDays(7);
                    System.out.println(arrayLinha[0] + ";" + data);
                }
            }
            arqLeitura.close();         
        } catch (FileNotFoundException e1) {
            System.out.println("Arquivo não encontrado. Error: " + e1.getMessage());
        } catch (DateTimeParseException e2) {
            System.out.println("Formato da data inválido. Error: " + e2.getMessage());
        //} catch  (ErroLeituraException e3){
        //    System.out.println("Erro: " + e3.getMessage());
        } catch (Exception e4) {
            System.out.println("Erro: " + e4.getMessage());
        }
    }

}

