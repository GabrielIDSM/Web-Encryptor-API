package br.com.GabrielIDSM.EncryptorAPI.LogicalTier;

public class PrepareMessage {
    //Não possui atributos
    //Não possui Getters e Setters
    //Métodos IN
    private boolean verifica(String mensagem){
        char[] c = mensagem.toCharArray();
        boolean rt = true;
        for(int i=0; i<c.length; i++){
            if(Character.isDigit(c[i])){
                rt = false;
                break;
            }
        }
        return rt;
    }
    public String Preparamensagem(String mensagem){        
        boolean b = verifica(mensagem);
        if(b){
            mensagem = mensagem.toUpperCase();
            mensagem = mensagem.replace(" ", "0");
        }else{
            mensagem = null;
        }
        return mensagem;
    }
    //Métodos FIM
}
