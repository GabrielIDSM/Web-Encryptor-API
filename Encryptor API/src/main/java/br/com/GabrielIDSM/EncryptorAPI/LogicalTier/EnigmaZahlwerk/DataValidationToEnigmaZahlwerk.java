package br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaZahlwerk;

import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaZahlwerk;

public class DataValidationToEnigmaZahlwerk {
    public static boolean isMessageRequestModelValid (MessageRequestModelToEnigmaZahlwerk requestModel){
        try{
            if(requestModel.getRotorOne() < 1 || requestModel.getRotorOne() > 3) return false;
            if(requestModel.getRotorTwo() < 1 || requestModel.getRotorTwo() > 3) return false;
            if(requestModel.getRotorThree() < 1 || requestModel.getRotorThree() > 3) return false;
            if(requestModel.getRotorOneWheelSet() < 1 || requestModel.getRotorOneWheelSet() > 26) return false;
            if(requestModel.getRotorTwoWheelSet() < 1 || requestModel.getRotorTwoWheelSet() > 26) return false;
            if(requestModel.getRotorThreeWheelSet() < 1 || requestModel.getRotorThreeWheelSet() > 26) return false;
            if(requestModel.getReflectorWheelSet() < 1 || requestModel.getReflectorWheelSet() > 26) return false;
            if(requestModel.getRotorOne() == requestModel.getRotorTwo()
                    || requestModel.getRotorOne() == requestModel.getRotorThree()
                    || requestModel.getRotorTwo() == requestModel.getRotorThree()) return false;
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
