package br.com.GabrielIDSM.EncryptorAPI.LogicalTier;

import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4.EnigmaM4OperationToFourRotors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4.EnigmaM4OperationToThreeRotors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4.EnigmaM4Reflectors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4.EnigmaM4Rotors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.EnigmaOneOperation;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.EnigmaOneRotors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaRailway.EnigmaRailwayOperation;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaRailway.EnigmaRailwayRotorsAndReflector;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaSwissK.EnigmaSwissKOperation;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaSwissK.EnigmaSwissKRotorsAndReflectors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaTirpitz.EnigmaTirpitzOperation;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaTirpitz.EnigmaTirpitzRotorsAndReflector;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaZahlwerk.EnigmaZahlwerkOperation;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaZahlwerk.EnigmaZahlwerkRotorsAndReflectors;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3ArmyWithSixPlugs;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3ArmyWithTenPlugs;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3Naval;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM4WithPlugboardAndFourRotors;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM4WithPlugboardAndThreeRotors;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM4WithPlugboardAndUKWD;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaOne;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaRailway;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaSwissK;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaTirpitz;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaZahlwerk;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageResponseModel;

public class Encrypter {

    public static MessageResponseModel EnigmaM3ArmyWithSixPlugsEncrypter(MessageRequestModelToEnigmaM3ArmyWithSixPlugs messageRequest) {
        
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
        EnigmaOneOperation M3Army = new EnigmaOneOperation(reflector, usedRotorOne, usedRotorTwo, usedRotorThree, message, messageRequest.getRotorTwoWheelSet(), messageRequest.getRotorThreeWheelSet());
        message = M3Army.Operation();
        message = Plugboard.Operation(message, plugsIndexArray);
        messageResponse.setMessage(message);
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaM3ArmyWithTenPlugsEncrypter(MessageRequestModelToEnigmaM3ArmyWithTenPlugs messageRequest){
        
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
        EnigmaOneOperation M3Army = new EnigmaOneOperation(reflector, usedRotorOne, usedRotorTwo, usedRotorThree, message, messageRequest.getRotorTwoWheelSet(), messageRequest.getRotorThreeWheelSet());
        message = M3Army.Operation();
        message = Plugboard.Operation(message, plugsIndexArray);
        messageResponse.setMessage(message);
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaM3NavalEncrypter(MessageRequestModelToEnigmaM3Naval messageRequest){
        
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
        EnigmaOneOperation M3Naval = new EnigmaOneOperation(reflector, usedRotorOne, usedRotorTwo, usedRotorThree, message, messageRequest.getRotorTwoWheelSet(), messageRequest.getRotorThreeWheelSet());
        message = M3Naval.Operation();
        message = Plugboard.Operation(message, plugsIndexArray);
        messageResponse.setMessage(message);
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaOneEncrypter(MessageRequestModelToEnigmaOne messageRequest){
        
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
        EnigmaOneOperation One = new EnigmaOneOperation(reflector, usedRotorOne, usedRotorTwo, usedRotorThree, message, messageRequest.getRotorTwoWheelSet(), messageRequest.getRotorThreeWheelSet());
        message = One.Operation();
        message = Plugboard.Operation(message, plugsIndexArray);
        messageResponse.setMessage(message);
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaM4WithFourRotorsEncrypter(MessageRequestModelToEnigmaM4WithPlugboardAndFourRotors messageRequest){
        
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
        EnigmaM4OperationToFourRotors M4 = new EnigmaM4OperationToFourRotors(reflector, message, usedRotorOne, usedRotorTwo, usedRotorThree, usedRotorFour, rotorTwoWheelSet, rotorThreeWheelSet, rotorFourWheelSet, messageRequest.getRotorFourWheelSet(), messageRequest.getReflector());
        message = M4.Operation();
        message = Plugboard.Operation(message, plugsIndexArray);
        messageResponse.setMessage(message);
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaM4WithThreeRotorsEncrypter(MessageRequestModelToEnigmaM4WithPlugboardAndThreeRotors messageRequest){
        
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
        EnigmaM4OperationToThreeRotors M4 = new EnigmaM4OperationToThreeRotors(reflector, message, usedRotorOne, usedRotorTwo, usedRotorThree, rotorTwoWheelSet, rotorThreeWheelSet);
        message = M4.Operation();
        message = Plugboard.Operation(message, plugsIndexArray);
        messageResponse.setMessage(message);
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaSwissKCommercialEncrypter(MessageRequestModelToEnigmaSwissK messageRequest){
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaSwissKRotorsAndReflectors RotorsAndReflectors = new EnigmaSwissKRotorsAndReflectors();
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();
        char[][] reflector = RotorsAndReflectors.DefineCommercialReflector(messageRequest.getReflectorWheelSet());
        String usedRotorOne = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineCommercialRotors(messageRequest.getRotorOne()), messageRequest.getRotorOneWheelSet());
        String usedRotorTwo = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineCommercialRotors(messageRequest.getRotorTwo()), messageRequest.getRotorTwoWheelSet());
        String usedRotorThree = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineCommercialRotors(messageRequest.getRotorThree()), messageRequest.getRotorThreeWheelSet());
        
        //Encryption
        String message = messageRequest.getMessage();
        message = message.replace("\n", "");
        message = message.replace("\t", "");
        message = message.replace("\r", "");
        message = PrepareMessage.PrepareMessageToEncryptor(message);
        EnigmaSwissKOperation EnigmaSwissK = new EnigmaSwissKOperation(reflector, message, usedRotorOne, usedRotorTwo, usedRotorThree, messageRequest.getRotorTwoWheelSet(), messageRequest.getRotorThreeWheelSet());
        messageResponse.setMessage(EnigmaSwissK.Operation());
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaSwissKAirForceEncrypter(MessageRequestModelToEnigmaSwissK messageRequest){
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaSwissKRotorsAndReflectors RotorsAndReflectors = new EnigmaSwissKRotorsAndReflectors();
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();
        char[][] reflector = RotorsAndReflectors.DefineAirForceReflector(messageRequest.getReflectorWheelSet());
        String usedRotorOne = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineAirForceRotors(messageRequest.getRotorOne()), messageRequest.getRotorOneWheelSet());
        String usedRotorTwo = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineAirForceRotors(messageRequest.getRotorTwo()), messageRequest.getRotorTwoWheelSet());
        String usedRotorThree = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineAirForceRotors(messageRequest.getRotorThree()), messageRequest.getRotorThreeWheelSet());
        
        //Encryption
        String message = messageRequest.getMessage();
        message = message.replace("\n", "");
        message = message.replace("\t", "");
        message = message.replace("\r", "");
        message = PrepareMessage.PrepareMessageToEncryptor(message);
        EnigmaSwissKOperation EnigmaSwissK = new EnigmaSwissKOperation(reflector, message, usedRotorOne, usedRotorTwo, usedRotorThree, messageRequest.getRotorTwoWheelSet(), messageRequest.getRotorThreeWheelSet());
        messageResponse.setMessage(EnigmaSwissK.Operation());
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaM4WithPlugboardAndUKWDEncrypter(MessageRequestModelToEnigmaM4WithPlugboardAndUKWD messageRequest){
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaM4Rotors Rotors = new EnigmaM4Rotors();
        UKWDRewirableReflector Reflector = new UKWDRewirableReflector();
        int[] plugsIndexArray = new int[20];
        char[][] reflector = Reflector.DefineReflector(messageRequest);
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
        EnigmaM4OperationToThreeRotors M4 = new EnigmaM4OperationToThreeRotors(reflector, message, usedRotorOne, usedRotorTwo, usedRotorThree, rotorTwoWheelSet, rotorThreeWheelSet);
        message = M4.Operation();
        message = Plugboard.Operation(message, plugsIndexArray);
        messageResponse.setMessage(message);
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaRailwayEncrypter(MessageRequestModelToEnigmaRailway messageRequest){
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaRailwayRotorsAndReflector RotorsAndReflectors = new EnigmaRailwayRotorsAndReflector();
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();
        char[][] reflector = RotorsAndReflectors.DefineReflector(messageRequest.getReflectorWheelSet());
        String usedRotorOne = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineRotors(messageRequest.getRotorOne()), messageRequest.getRotorOneWheelSet());
        String usedRotorTwo = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineRotors(messageRequest.getRotorTwo()), messageRequest.getRotorTwoWheelSet());
        String usedRotorThree = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineRotors(messageRequest.getRotorThree()), messageRequest.getRotorThreeWheelSet());
        
        //Encryption
        String message = messageRequest.getMessage();
        message = message.replace("\n", "");
        message = message.replace("\t", "");
        message = message.replace("\r", "");
        message = PrepareMessage.PrepareMessageToEncryptor(message);
        EnigmaRailwayOperation EnigmaRailway = new EnigmaRailwayOperation(reflector, message, usedRotorOne, usedRotorTwo, usedRotorThree, messageRequest.getRotorTwoWheelSet(), messageRequest.getRotorThreeWheelSet());
        messageResponse.setMessage(EnigmaRailway.Operation());
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaTirpitzEncrypter(MessageRequestModelToEnigmaTirpitz messageRequest){
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaTirpitzRotorsAndReflector RotorsAndReflectors = new EnigmaTirpitzRotorsAndReflector();
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();
        char[][] reflector = RotorsAndReflectors.DefineReflector(messageRequest.getReflectorWheelSet());
        String usedRotorOne = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineRotors(messageRequest.getRotorOne()), messageRequest.getRotorOneWheelSet());
        String usedRotorTwo = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineRotors(messageRequest.getRotorTwo()), messageRequest.getRotorTwoWheelSet());
        String usedRotorThree = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineRotors(messageRequest.getRotorThree()), messageRequest.getRotorThreeWheelSet());
        
        //Encryption
        String message = messageRequest.getMessage();
        message = message.replace("\n", "");
        message = message.replace("\t", "");
        message = message.replace("\r", "");
        message = PrepareMessage.PrepareMessageToEncryptor(message);
        EnigmaTirpitzOperation EnigmaTirpitz = new EnigmaTirpitzOperation(reflector, message, usedRotorOne, usedRotorTwo, usedRotorThree, messageRequest.getRotorTwoWheelSet(), messageRequest.getRotorThreeWheelSet());
        messageResponse.setMessage(EnigmaTirpitz.Operation());
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaZahlwerkDefaultEncrypter(MessageRequestModelToEnigmaZahlwerk messageRequest){
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaZahlwerkRotorsAndReflectors RotorsAndReflectors = new EnigmaZahlwerkRotorsAndReflectors();
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();
        char[][] reflector = RotorsAndReflectors.DefineDefaultReflector(messageRequest.getReflectorWheelSet());
        String usedRotorOne = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineDefaultRotors(messageRequest.getRotorOne()), messageRequest.getRotorOneWheelSet());
        String usedRotorTwo = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineDefaultRotors(messageRequest.getRotorTwo()), messageRequest.getRotorTwoWheelSet());
        String usedRotorThree = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineDefaultRotors(messageRequest.getRotorThree()), messageRequest.getRotorThreeWheelSet());
        
        //Encryption
        String message = messageRequest.getMessage();
        message = message.replace("\n", "");
        message = message.replace("\t", "");
        message = message.replace("\r", "");
        message = PrepareMessage.PrepareMessageToEncryptor(message);
        EnigmaZahlwerkOperation EnigmaZahlwerk = new EnigmaZahlwerkOperation(reflector, message, usedRotorOne, usedRotorTwo, usedRotorThree, messageRequest.getRotorTwoWheelSet(), messageRequest.getRotorThreeWheelSet());
        messageResponse.setMessage(EnigmaZahlwerk.Operation());
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaZahlwerkG312Encrypter(MessageRequestModelToEnigmaZahlwerk messageRequest){
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaZahlwerkRotorsAndReflectors RotorsAndReflectors = new EnigmaZahlwerkRotorsAndReflectors();
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();
        char[][] reflector = RotorsAndReflectors.DefineG312Reflector(messageRequest.getReflectorWheelSet());
        String usedRotorOne = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineG312Rotors(messageRequest.getRotorOne()), messageRequest.getRotorOneWheelSet());
        String usedRotorTwo = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineG312Rotors(messageRequest.getRotorTwo()), messageRequest.getRotorTwoWheelSet());
        String usedRotorThree = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineG312Rotors(messageRequest.getRotorThree()), messageRequest.getRotorThreeWheelSet());
        
        //Encryption
        String message = messageRequest.getMessage();
        message = message.replace("\n", "");
        message = message.replace("\t", "");
        message = message.replace("\r", "");
        message = PrepareMessage.PrepareMessageToEncryptor(message);
        EnigmaZahlwerkOperation EnigmaZahlwerk = new EnigmaZahlwerkOperation(reflector, message, usedRotorOne, usedRotorTwo, usedRotorThree, messageRequest.getRotorTwoWheelSet(), messageRequest.getRotorThreeWheelSet());
        messageResponse.setMessage(EnigmaZahlwerk.Operation());
        return messageResponse;
    }
    
    public static MessageResponseModel EnigmaZahlwerkG260Encrypter(MessageRequestModelToEnigmaZahlwerk messageRequest){
        
        //Preparation to Encryption
        MessageResponseModel messageResponse = new MessageResponseModel();
        EnigmaZahlwerkRotorsAndReflectors RotorsAndReflectors = new EnigmaZahlwerkRotorsAndReflectors();
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();
        char[][] reflector = RotorsAndReflectors.DefineG260Reflector(messageRequest.getReflectorWheelSet());
        String usedRotorOne = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineG260Rotors(messageRequest.getRotorOne()), messageRequest.getRotorOneWheelSet());
        String usedRotorTwo = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineG260Rotors(messageRequest.getRotorTwo()), messageRequest.getRotorTwoWheelSet());
        String usedRotorThree = Prepare.PrepareRotorsToEncryptor(RotorsAndReflectors.DefineG260Rotors(messageRequest.getRotorThree()), messageRequest.getRotorThreeWheelSet());
        
        //Encryption
        String message = messageRequest.getMessage();
        message = message.replace("\n", "");
        message = message.replace("\t", "");
        message = message.replace("\r", "");
        message = PrepareMessage.PrepareMessageToEncryptor(message);
        EnigmaZahlwerkOperation EnigmaZahlwerk = new EnigmaZahlwerkOperation(reflector, message, usedRotorOne, usedRotorTwo, usedRotorThree, messageRequest.getRotorTwoWheelSet(), messageRequest.getRotorThreeWheelSet());
        messageResponse.setMessage(EnigmaZahlwerk.Operation());
        return messageResponse;
    }
    
}
