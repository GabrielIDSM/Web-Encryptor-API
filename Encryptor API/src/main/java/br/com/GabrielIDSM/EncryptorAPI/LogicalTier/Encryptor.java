package br.com.GabrielIDSM.EncryptorAPI.LogicalTier;

import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4.EnigmaM4OperationToFourRotors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4.EnigmaM4OperationToThreeRotors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4.EnigmaM4Reflectors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4.EnigmaM4Rotors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.EnigmaOneOperation;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.EnigmaOneRotors;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3ArmyWithSixPlugs;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3ArmyWithTenPlugs;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3Naval;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM4WithPlugboardAndFourRotors;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM4WithPlugboardAndThreeRotors;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaOne;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageResponseModel;

public class Encryptor {

    public static MessageResponseModel EnigmaM3ArmyWithSixPlugsEncryptor(MessageRequestModelToEnigmaM3ArmyWithSixPlugs messageRequest) {
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaOneRotors Rotors = new EnigmaOneRotors();
        int[] plugsIndexArray = new int[12];
        char[][] reflector = Rotors.DefineReflector();
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();
        int rotorOneWheelSet = messageRequest.getRotorOneWheelSet();
        int rotorTwoWheelSet = messageRequest.getRotorTwoWheelSet();
        int rotorThreeWheelSet = messageRequest.getRotorThreeWheelSet();
        String usedRotorOne = Rotors.DefineUsedRotor(messageRequest.getRotorOne());
        String usedRotorTwo = Rotors.DefineUsedRotor(messageRequest.getRotorTwo());
        String usedRotorThree = Rotors.DefineUsedRotor(messageRequest.getRotorThree());
        usedRotorOne = Prepare.PrepareRotorsToEncryptor(usedRotorOne, rotorOneWheelSet);
        usedRotorTwo = Prepare.PrepareRotorsToEncryptor(usedRotorTwo, rotorTwoWheelSet);
        usedRotorThree = Prepare.PrepareRotorsToEncryptor(usedRotorThree, rotorThreeWheelSet);
        plugsIndexArray[0] = messageRequest.getPlugOneA();
        plugsIndexArray[1] = messageRequest.getPlugOneB();
        plugsIndexArray[2] = messageRequest.getPlugTwoA();
        plugsIndexArray[3] = messageRequest.getPlugTwoB();
        plugsIndexArray[4] = messageRequest.getPlugThreeA();
        plugsIndexArray[5] = messageRequest.getPlugThreeB();
        plugsIndexArray[6] = messageRequest.getPlugFourA();
        plugsIndexArray[7] = messageRequest.getPlugFourB();
        plugsIndexArray[8] = messageRequest.getPlugFiveA();
        plugsIndexArray[9] = messageRequest.getPlugFiveB();
        plugsIndexArray[10] = messageRequest.getPlugSixA();
        plugsIndexArray[11] = messageRequest.getPlugSixB();
        
        //Encryption
        String message = messageRequest.getMessage();
        message = message.replace("\n", "");
        message = message.replace("\t", "");
        message = message.replace("\r", "");
        message = PrepareMessage.PrepareMessageToEncryptor(message);
        message = Plugboard.Operation(message, plugsIndexArray);
        EnigmaOneOperation funcionamento = new EnigmaOneOperation(reflector, usedRotorOne, usedRotorTwo, usedRotorThree, message, messageRequest.getRotorTwo(), messageRequest.getRotorThree());
        message = funcionamento.Operation();
        message = Plugboard.Operation(message, plugsIndexArray);
        messageResponse.setMessage(message);
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaM3ArmyWithTenPlugsEncryptor(MessageRequestModelToEnigmaM3ArmyWithTenPlugs messageRequest){
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaOneRotors Rotors = new EnigmaOneRotors();
        int[] plugsIndexArray = new int[20];
        char[][] reflector = Rotors.DefineReflector();
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();
        int rotorOneWheelSet = messageRequest.getRotorOneWheelSet();
        int rotorTwoWheelSet = messageRequest.getRotorTwoWheelSet();
        int rotorThreeWheelSet = messageRequest.getRotorThreeWheelSet();
        String usedRotorOne = Rotors.DefineUsedRotor(messageRequest.getRotorOne());
        String usedRotorTwo = Rotors.DefineUsedRotor(messageRequest.getRotorTwo());
        String usedRotorThree = Rotors.DefineUsedRotor(messageRequest.getRotorThree());
        usedRotorOne = Prepare.PrepareRotorsToEncryptor(usedRotorOne, rotorOneWheelSet);
        usedRotorTwo = Prepare.PrepareRotorsToEncryptor(usedRotorTwo, rotorTwoWheelSet);
        usedRotorThree = Prepare.PrepareRotorsToEncryptor(usedRotorThree, rotorThreeWheelSet);
        plugsIndexArray[0] = messageRequest.getPlugOneA();
        plugsIndexArray[1] = messageRequest.getPlugOneB();
        plugsIndexArray[2] = messageRequest.getPlugTwoA();
        plugsIndexArray[3] = messageRequest.getPlugTwoB();
        plugsIndexArray[4] = messageRequest.getPlugThreeA();
        plugsIndexArray[5] = messageRequest.getPlugThreeB();
        plugsIndexArray[6] = messageRequest.getPlugFourA();
        plugsIndexArray[7] = messageRequest.getPlugFourB();
        plugsIndexArray[8] = messageRequest.getPlugFiveA();
        plugsIndexArray[9] = messageRequest.getPlugFiveB();
        plugsIndexArray[10] = messageRequest.getPlugSixA();
        plugsIndexArray[11] = messageRequest.getPlugSixB();
        plugsIndexArray[12] = messageRequest.getPlugSevenA();
        plugsIndexArray[13] = messageRequest.getPlugSevenB();
        plugsIndexArray[14] = messageRequest.getPlugEightA();
        plugsIndexArray[15] = messageRequest.getPlugEightB();
        plugsIndexArray[16] = messageRequest.getPlugNineA();
        plugsIndexArray[17] = messageRequest.getPlugNineB();
        plugsIndexArray[18] = messageRequest.getPlugTenA();
        plugsIndexArray[19] = messageRequest.getPlugTenB();
        
        //Encryption
        String message = messageRequest.getMessage();
        message = message.replace("\n", "");
        message = message.replace("\t", "");
        message = message.replace("\r", "");
        message = PrepareMessage.PrepareMessageToEncryptor(message);
        message = Plugboard.Operation(message, plugsIndexArray);
        EnigmaOneOperation funcionamento = new EnigmaOneOperation(reflector, usedRotorOne, usedRotorTwo, usedRotorThree, message, messageRequest.getRotorTwo(), messageRequest.getRotorThree());
        message = funcionamento.Operation();
        message = Plugboard.Operation(message, plugsIndexArray);
        messageResponse.setMessage(message);
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaM3NavalEncryptor(MessageRequestModelToEnigmaM3Naval messageRequest){
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaOneRotors Rotors = new EnigmaOneRotors();
        int[] plugsIndexArray = new int[20];
        char[][] reflector = Rotors.DefineReflector();
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();
        int rotorOneWheelSet = messageRequest.getRotorOneWheelSet();
        int rotorTwoWheelSet = messageRequest.getRotorTwoWheelSet();
        int rotorThreeWheelSet = messageRequest.getRotorThreeWheelSet();
        String usedRotorOne = Rotors.DefineUsedRotor(messageRequest.getRotorOne());
        String usedRotorTwo = Rotors.DefineUsedRotor(messageRequest.getRotorTwo());
        String usedRotorThree = Rotors.DefineUsedRotor(messageRequest.getRotorThree());
        usedRotorOne = Prepare.PrepareRotorsToEncryptor(usedRotorOne, rotorOneWheelSet);
        usedRotorTwo = Prepare.PrepareRotorsToEncryptor(usedRotorTwo, rotorTwoWheelSet);
        usedRotorThree = Prepare.PrepareRotorsToEncryptor(usedRotorThree, rotorThreeWheelSet);
        plugsIndexArray[0] = messageRequest.getPlugOneA();
        plugsIndexArray[1] = messageRequest.getPlugOneB();
        plugsIndexArray[2] = messageRequest.getPlugTwoA();
        plugsIndexArray[3] = messageRequest.getPlugTwoB();
        plugsIndexArray[4] = messageRequest.getPlugThreeA();
        plugsIndexArray[5] = messageRequest.getPlugThreeB();
        plugsIndexArray[6] = messageRequest.getPlugFourA();
        plugsIndexArray[7] = messageRequest.getPlugFourB();
        plugsIndexArray[8] = messageRequest.getPlugFiveA();
        plugsIndexArray[9] = messageRequest.getPlugFiveB();
        plugsIndexArray[10] = messageRequest.getPlugSixA();
        plugsIndexArray[11] = messageRequest.getPlugSixB();
        plugsIndexArray[12] = messageRequest.getPlugSevenA();
        plugsIndexArray[13] = messageRequest.getPlugSevenB();
        plugsIndexArray[14] = messageRequest.getPlugEightA();
        plugsIndexArray[15] = messageRequest.getPlugEightB();
        plugsIndexArray[16] = messageRequest.getPlugNineA();
        plugsIndexArray[17] = messageRequest.getPlugNineB();
        plugsIndexArray[18] = messageRequest.getPlugTenA();
        plugsIndexArray[19] = messageRequest.getPlugTenB();
        
        //Encryption
        String message = messageRequest.getMessage();
        message = message.replace("\n", "");
        message = message.replace("\t", "");
        message = message.replace("\r", "");
        message = PrepareMessage.PrepareMessageToEncryptor(message);
        message = Plugboard.Operation(message, plugsIndexArray);
        EnigmaOneOperation funcionamento = new EnigmaOneOperation(reflector, usedRotorOne, usedRotorTwo, usedRotorThree, message, messageRequest.getRotorTwo(), messageRequest.getRotorThree());
        message = funcionamento.Operation();
        message = Plugboard.Operation(message, plugsIndexArray);
        messageResponse.setMessage(message);
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaOneEncryptor(MessageRequestModelToEnigmaOne messageRequest){
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaOneRotors Rotors = new EnigmaOneRotors();
        int[] plugsIndexArray = new int[20];
        char[][] reflector = Rotors.DefineReflector();
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();
        int rotorOneWheelSet = messageRequest.getRotorOneWheelSet();
        int rotorTwoWheelSet = messageRequest.getRotorTwoWheelSet();
        int rotorThreeWheelSet = messageRequest.getRotorThreeWheelSet();
        String usedRotorOne = Rotors.DefineUsedRotor(messageRequest.getRotorOne());
        String usedRotorTwo = Rotors.DefineUsedRotor(messageRequest.getRotorTwo());
        String usedRotorThree = Rotors.DefineUsedRotor(messageRequest.getRotorThree());
        usedRotorOne = Prepare.PrepareRotorsToEncryptor(usedRotorOne, rotorOneWheelSet);
        usedRotorTwo = Prepare.PrepareRotorsToEncryptor(usedRotorTwo, rotorTwoWheelSet);
        usedRotorThree = Prepare.PrepareRotorsToEncryptor(usedRotorThree, rotorThreeWheelSet);
        plugsIndexArray[0] = messageRequest.getPlugOneA();
        plugsIndexArray[1] = messageRequest.getPlugOneB();
        plugsIndexArray[2] = messageRequest.getPlugTwoA();
        plugsIndexArray[3] = messageRequest.getPlugTwoB();
        plugsIndexArray[4] = messageRequest.getPlugThreeA();
        plugsIndexArray[5] = messageRequest.getPlugThreeB();
        plugsIndexArray[6] = messageRequest.getPlugFourA();
        plugsIndexArray[7] = messageRequest.getPlugFourB();
        plugsIndexArray[8] = messageRequest.getPlugFiveA();
        plugsIndexArray[9] = messageRequest.getPlugFiveB();
        plugsIndexArray[10] = messageRequest.getPlugSixA();
        plugsIndexArray[11] = messageRequest.getPlugSixB();
        plugsIndexArray[12] = messageRequest.getPlugSevenA();
        plugsIndexArray[13] = messageRequest.getPlugSevenB();
        plugsIndexArray[14] = messageRequest.getPlugEightA();
        plugsIndexArray[15] = messageRequest.getPlugEightB();
        plugsIndexArray[16] = messageRequest.getPlugNineA();
        plugsIndexArray[17] = messageRequest.getPlugNineB();
        plugsIndexArray[18] = messageRequest.getPlugTenA();
        plugsIndexArray[19] = messageRequest.getPlugTenB();
        
        //Encryption
        String message = messageRequest.getMessage();
        message = message.replace("\n", "");
        message = message.replace("\t", "");
        message = message.replace("\r", "");
        message = PrepareMessage.PrepareMessageToEncryptor(message);
        message = Plugboard.Operation(message, plugsIndexArray);
        EnigmaOneOperation funcionamento = new EnigmaOneOperation(reflector, usedRotorOne, usedRotorTwo, usedRotorThree, message, messageRequest.getRotorTwo(), messageRequest.getRotorThree());
        message = funcionamento.Operation();
        message = Plugboard.Operation(message, plugsIndexArray);
        messageResponse.setMessage(message);
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaM4WithPlugboardAndFourRotorsEncryptor(MessageRequestModelToEnigmaM4WithPlugboardAndFourRotors messageRequest){
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaM4Rotors Rotors = new EnigmaM4Rotors();
        EnigmaM4Reflectors Reflectors = new EnigmaM4Reflectors();
        int[] plugsIndexArray = new int[20];
        char[][] reflector = Reflectors.DefineReflector(messageRequest.getReflector());
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();
        int rotorOneWheelSet = messageRequest.getRotorOneWheelSet();
        int rotorTwoWheelSet = messageRequest.getRotorTwoWheelSet();
        int rotorThreeWheelSet = messageRequest.getRotorThreeWheelSet();
        int rotorFourWheelSet = messageRequest.getRotorFourWheelSet();
        String usedRotorOne = Rotors.DefineUsedRotor(messageRequest.getRotorOne());
        String usedRotorTwo = Rotors.DefineUsedRotor(messageRequest.getRotorTwo());
        String usedRotorThree = Rotors.DefineUsedRotor(messageRequest.getRotorThree());
        String usedRotorFour = Rotors.DefineExtraRotor(messageRequest.getRotorFour());
        usedRotorOne = Prepare.PrepareRotorsToEncryptor(usedRotorOne, rotorOneWheelSet);
        usedRotorTwo = Prepare.PrepareRotorsToEncryptor(usedRotorTwo, rotorTwoWheelSet);
        usedRotorThree = Prepare.PrepareRotorsToEncryptor(usedRotorThree, rotorThreeWheelSet);
        usedRotorFour = Prepare.PrepareRotorsToEncryptor(usedRotorFour, rotorFourWheelSet);
        plugsIndexArray[0] = messageRequest.getPlugOneA();
        plugsIndexArray[1] = messageRequest.getPlugOneB();
        plugsIndexArray[2] = messageRequest.getPlugTwoA();
        plugsIndexArray[3] = messageRequest.getPlugTwoB();
        plugsIndexArray[4] = messageRequest.getPlugThreeA();
        plugsIndexArray[5] = messageRequest.getPlugThreeB();
        plugsIndexArray[6] = messageRequest.getPlugFourA();
        plugsIndexArray[7] = messageRequest.getPlugFourB();
        plugsIndexArray[8] = messageRequest.getPlugFiveA();
        plugsIndexArray[9] = messageRequest.getPlugFiveB();
        plugsIndexArray[10] = messageRequest.getPlugSixA();
        plugsIndexArray[11] = messageRequest.getPlugSixB();
        plugsIndexArray[12] = messageRequest.getPlugSevenA();
        plugsIndexArray[13] = messageRequest.getPlugSevenB();
        plugsIndexArray[14] = messageRequest.getPlugEightA();
        plugsIndexArray[15] = messageRequest.getPlugEightB();
        plugsIndexArray[16] = messageRequest.getPlugNineA();
        plugsIndexArray[17] = messageRequest.getPlugNineB();
        plugsIndexArray[18] = messageRequest.getPlugTenA();
        plugsIndexArray[19] = messageRequest.getPlugTenB();
        
        //Encryption
        String message = messageRequest.getMessage();
        message = message.replace("\n", "");
        message = message.replace("\t", "");
        message = message.replace("\r", "");
        message = PrepareMessage.PrepareMessageToEncryptor(message);
        message = Plugboard.Operation(message, plugsIndexArray);
        EnigmaM4OperationToFourRotors funcionamento = new EnigmaM4OperationToFourRotors(reflector, message, usedRotorOne, usedRotorTwo, usedRotorThree, usedRotorFour, rotorTwoWheelSet, rotorThreeWheelSet);
        message = funcionamento.Operation();
        message = Plugboard.Operation(message, plugsIndexArray);
        messageResponse.setMessage(message);
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaM4WithPlugboardAndThreeRotorsEncryptor(MessageRequestModelToEnigmaM4WithPlugboardAndThreeRotors messageRequest){
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaM4Rotors Rotors = new EnigmaM4Rotors();
        EnigmaM4Reflectors Reflectors = new EnigmaM4Reflectors();
        int[] plugsIndexArray = new int[20];
        char[][] reflector = Reflectors.DefineReflector(messageRequest.getReflector());
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();
        int rotorOneWheelSet = messageRequest.getRotorOneWheelSet();
        int rotorTwoWheelSet = messageRequest.getRotorTwoWheelSet();
        int rotorThreeWheelSet = messageRequest.getRotorThreeWheelSet();
        String usedRotorOne = Rotors.DefineUsedRotor(messageRequest.getRotorOne());
        String usedRotorTwo = Rotors.DefineUsedRotor(messageRequest.getRotorTwo());
        String usedRotorThree = Rotors.DefineUsedRotor(messageRequest.getRotorThree());
        usedRotorOne = Prepare.PrepareRotorsToEncryptor(usedRotorOne, rotorOneWheelSet);
        usedRotorTwo = Prepare.PrepareRotorsToEncryptor(usedRotorTwo, rotorTwoWheelSet);
        usedRotorThree = Prepare.PrepareRotorsToEncryptor(usedRotorThree, rotorThreeWheelSet);
        plugsIndexArray[0] = messageRequest.getPlugOneA();
        plugsIndexArray[1] = messageRequest.getPlugOneB();
        plugsIndexArray[2] = messageRequest.getPlugTwoA();
        plugsIndexArray[3] = messageRequest.getPlugTwoB();
        plugsIndexArray[4] = messageRequest.getPlugThreeA();
        plugsIndexArray[5] = messageRequest.getPlugThreeB();
        plugsIndexArray[6] = messageRequest.getPlugFourA();
        plugsIndexArray[7] = messageRequest.getPlugFourB();
        plugsIndexArray[8] = messageRequest.getPlugFiveA();
        plugsIndexArray[9] = messageRequest.getPlugFiveB();
        plugsIndexArray[10] = messageRequest.getPlugSixA();
        plugsIndexArray[11] = messageRequest.getPlugSixB();
        plugsIndexArray[12] = messageRequest.getPlugSevenA();
        plugsIndexArray[13] = messageRequest.getPlugSevenB();
        plugsIndexArray[14] = messageRequest.getPlugEightA();
        plugsIndexArray[15] = messageRequest.getPlugEightB();
        plugsIndexArray[16] = messageRequest.getPlugNineA();
        plugsIndexArray[17] = messageRequest.getPlugNineB();
        plugsIndexArray[18] = messageRequest.getPlugTenA();
        plugsIndexArray[19] = messageRequest.getPlugTenB();
        
        //Encryption
        String message = messageRequest.getMessage();
        message = message.replace("\n", "");
        message = message.replace("\t", "");
        message = message.replace("\r", "");
        message = PrepareMessage.PrepareMessageToEncryptor(message);
        message = Plugboard.Operation(message, plugsIndexArray);
        EnigmaM4OperationToThreeRotors funcionamento = new EnigmaM4OperationToThreeRotors(reflector, message, usedRotorOne, usedRotorTwo, usedRotorThree, rotorTwoWheelSet, rotorThreeWheelSet);
        message = funcionamento.Operation();
        message = Plugboard.Operation(message, plugsIndexArray);
        messageResponse.setMessage(message);
        return messageResponse;
    }
    
}
