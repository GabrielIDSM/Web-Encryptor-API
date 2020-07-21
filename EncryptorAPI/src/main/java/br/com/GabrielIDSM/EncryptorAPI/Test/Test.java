package br.com.GabrielIDSM.EncryptorAPI.Test;

import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EncryptorMain;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModel;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageResponseModel;

public class Test {
    public static void main(String[] args) {
        MessageRequestModel messageRequest = new MessageRequestModel();
        messageRequest.setMessage("Testando o algoritmo");
        messageRequest.setChave1(1);
        messageRequest.setChave2(10);
        messageRequest.setChave3(20);
        messageRequest.setRotor1(1);
        messageRequest.setRotor2(3);
        messageRequest.setRotor3(5);
        messageRequest.setPr11(0);
        messageRequest.setPr12(25);
        messageRequest.setPr21(1);
        messageRequest.setPr22(24);
        messageRequest.setPr31(2);
        messageRequest.setPr32(23);
        messageRequest.setPr41(3);
        messageRequest.setPr42(22);
        messageRequest.setPr51(4);
        messageRequest.setPr52(21);
        messageRequest.setPr61(5);
        messageRequest.setPr62(20);
        MessageResponseModel messageResponse = EncryptorMain.Encryptor(messageRequest);
        System.out.println("Mensagem inicial: " +  messageRequest.getMessage());
        System.out.println("Mensagem pós Encryptor: " +  messageResponse.getMessage());
        messageRequest.setMessage(messageResponse.getMessage());
        messageResponse = EncryptorMain.Encryptor(messageRequest);
        System.out.println("Mensagem inicial pós Encryptor: " +  messageResponse.getMessage());
    }
}
