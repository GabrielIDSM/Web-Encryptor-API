package br.com.GabrielIDSM.EncryptorAPI.Test;

import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.Encryptor;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaRailway;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageResponseModel;

public class EnigmaRailwayTest {

    public static void main(String[] args) {
        MessageRequestModelToEnigmaRailway messageRequest = new MessageRequestModelToEnigmaRailway();
        messageRequest.setMessage("Eu amo a Milena mais que prog");
        messageRequest.setRotorOneWheelSet(1);
        messageRequest.setRotorTwoWheelSet(10);
        messageRequest.setRotorThreeWheelSet(20);
        messageRequest.setRotorOne(1);
        messageRequest.setRotorTwo(2);
        messageRequest.setRotorThree(3);

        for (int i = 0; i < 3; i++) {
            messageRequest.setReflectorWheelSet(i);
            MessageResponseModel messageResponse = Encryptor.EnigmaRailwayEncryptor(messageRequest);
            System.out.println("Mensagem inicial: " + messageRequest.getMessage());
            System.out.println("Mensagem pós Encryptor: " + messageResponse.getMessage());
            messageRequest.setMessage(messageResponse.getMessage());
            messageResponse = Encryptor.EnigmaRailwayEncryptor(messageRequest);
            System.out.println("Mensagem inicial pós Encryptor: " + messageResponse.getMessage());
            messageRequest.setMessage("Eu amo a Milena mais que prog");
        }
        
        for (int i = 13; i < 16; i++) {
            messageRequest.setReflectorWheelSet(i);
            MessageResponseModel messageResponse = Encryptor.EnigmaRailwayEncryptor(messageRequest);
            System.out.println("Mensagem inicial: " + messageRequest.getMessage());
            System.out.println("Mensagem pós Encryptor: " + messageResponse.getMessage());
            messageRequest.setMessage(messageResponse.getMessage());
            messageResponse = Encryptor.EnigmaRailwayEncryptor(messageRequest);
            System.out.println("Mensagem inicial pós Encryptor: " + messageResponse.getMessage());
            messageRequest.setMessage("Eu amo a Milena mais que prog");
        }
        
    }
}
