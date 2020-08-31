package br.com.GabrielIDSM.EncryptorAPI.Test;

import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.Encrypter;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3ArmyWithSixPlugs;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageResponseModel;

public class EnigmaM3ArmyWithSixPlugsTest {
    public static void main(String[] args) {
        MessageRequestModelToEnigmaM3ArmyWithSixPlugs messageRequest = new MessageRequestModelToEnigmaM3ArmyWithSixPlugs();
        messageRequest.setMessage("Eu amo a Milena mais que prog");
        messageRequest.setRotorOneWheelSet(1);
        messageRequest.setRotorTwoWheelSet(10);
        messageRequest.setRotorThreeWheelSet(20);
        messageRequest.setRotorOne(1);
        messageRequest.setRotorTwo(3);
        messageRequest.setRotorThree(5);
        messageRequest.setPlugOneA(0);
        messageRequest.setPlugOneB(25);
        messageRequest.setPlugTwoA(1);
        messageRequest.setPlugTwoB(24);
        messageRequest.setPlugThreeA(2);
        messageRequest.setPlugThreeB(23);
        messageRequest.setPlugFourA(3);
        messageRequest.setPlugFourB(22);
        messageRequest.setPlugFiveA(4);
        messageRequest.setPlugFiveB(21);
        messageRequest.setPlugSixA(5);
        messageRequest.setPlugSixB(20);
        MessageResponseModel messageResponse = Encrypter.EnigmaM3ArmyWithSixPlugsEncrypter(messageRequest);
        System.out.println("Mensagem inicial: " +  messageRequest.getMessage());
        System.out.println("Mensagem pós Encryptor: " +  messageResponse.getMessage());
        messageRequest.setMessage(messageResponse.getMessage());
        messageResponse = Encrypter.EnigmaM3ArmyWithSixPlugsEncrypter(messageRequest);
        System.out.println("Mensagem inicial pós Encryptor: " +  messageResponse.getMessage());
    }
}
