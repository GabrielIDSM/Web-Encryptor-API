package br.com.GabrielIDSM.EncryptorAPI.LogicalTier;

public class PrepareMessage {
    private boolean Verify(String message){
        char[] c = message.toCharArray();
        boolean rt = true;
        for(int i=0; i<c.length; i++){
            if(Character.isDigit(c[i])){
                rt = false;
                break;
            }
        }
        return rt;
    }
    public String PrepareMessageToEncryptor(String message){        
        boolean b = Verify(message);
        if(b){
            message = message.toUpperCase();
            message = message.replace(" ", "0");
        }else{
            message = null;
        }
        return message;
    }
}
