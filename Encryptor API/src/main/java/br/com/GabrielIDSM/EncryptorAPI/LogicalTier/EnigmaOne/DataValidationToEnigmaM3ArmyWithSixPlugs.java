package br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne;

import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3ArmyWithSixPlugs;

public class DataValidationToEnigmaM3ArmyWithSixPlugs {
    public static boolean isMessageRequestModelValid (MessageRequestModelToEnigmaM3ArmyWithSixPlugs requestModel){
        try{
            if(requestModel.getRotorOne() < 1 || requestModel.getRotorOne() > 5) return false;
            if(requestModel.getRotorTwo() < 1 || requestModel.getRotorTwo() > 5) return false;
            if(requestModel.getRotorThree() < 1 || requestModel.getRotorThree() > 5) return false;
            if(requestModel.getRotorOneWheelSet() < 1 || requestModel.getRotorOneWheelSet() > 26) return false;
            if(requestModel.getRotorTwoWheelSet() < 1 || requestModel.getRotorTwoWheelSet() > 26) return false;
            if(requestModel.getRotorThreeWheelSet() < 1 || requestModel.getRotorThreeWheelSet() > 26) return false;
            if(requestModel.getRotorOne() == requestModel.getRotorTwo()
                    || requestModel.getRotorOne() == requestModel.getRotorThree()
                    || requestModel.getRotorTwo() == requestModel.getRotorThree()) return false;
            int[] plugLettersArray = createArrayWithPlugLetters(requestModel);
            for(int pr : plugLettersArray){
                if(pr < 0 || pr > 25) return false;
            }
            for(int i = 0; i < plugLettersArray.length; i++){
                for(int j = 0; j < plugLettersArray.length; j++){
                    if(i == j) continue;
                    if(plugLettersArray[i] == plugLettersArray[j]) return false;
                }
            }
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    private static int[] createArrayWithPlugLetters(MessageRequestModelToEnigmaM3ArmyWithSixPlugs messageRequest){
        int[] array = new int[12];
        array[0] = messageRequest.getPlugOneA();
        array[1] = messageRequest.getPlugOneB();
        array[2] = messageRequest.getPlugTwoA();
        array[3] = messageRequest.getPlugTwoB();
        array[4] = messageRequest.getPlugThreeA();
        array[5] = messageRequest.getPlugThreeB();
        array[6] = messageRequest.getPlugFourA();
        array[7] = messageRequest.getPlugFourB();
        array[8] = messageRequest.getPlugFiveA();
        array[9] = messageRequest.getPlugFiveB();
        array[10] = messageRequest.getPlugSixA();
        array[11] = messageRequest.getPlugSixB();
        return array;
    }
}
