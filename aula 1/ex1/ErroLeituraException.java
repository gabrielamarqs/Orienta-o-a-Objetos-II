import java.io.IOException;

public class ErroLeituraException extends IOException{
    public ErroLeituraException() {
        super("Erro de leitura.");
    }
}
