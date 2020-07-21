package br.com.GabrielIDSM.EncryptorAPI.LogicalTier;

import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModel;

public class DataValidation {
    public static boolean isMessageRequestModelValid (MessageRequestModel requestModel){
        try{
            if(requestModel.getRotor1() < 1 || requestModel.getRotor1() > 5) return false;
            if(requestModel.getRotor2() < 1 || requestModel.getRotor2() > 5) return false;
            if(requestModel.getRotor3() < 1 || requestModel.getRotor3() > 5) return false;
            if(requestModel.getChave1() < 1 || requestModel.getChave1() > 26) return false;
            if(requestModel.getChave2() < 1 || requestModel.getChave2() > 26) return false;
            if(requestModel.getChave3() < 1 || requestModel.getChave3() > 26) return false;
            if(requestModel.getRotor1() == requestModel.getRotor2()
                    || requestModel.getRotor1() == requestModel.getRotor3()
                    || requestModel.getRotor2() == requestModel.getRotor3()) return false;
            int[] prArray = createArrayWithPrLetters(requestModel);
            for(int pr : prArray){
                if(pr < 0 || pr > 25) return false;
            }
            for(int i = 0; i < prArray.length; i++){
                for(int j = 0; j < prArray.length; j++){
                    if(i == j) continue;
                    if(prArray[i] == prArray[j]) return false;
                }
            }
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    private static int[] createArrayWithPrLetters(MessageRequestModel messageRequest){
        int[] array = new int[12];
        array[0] = messageRequest.getPr11();
        array[1] = messageRequest.getPr12();
        array[2] = messageRequest.getPr21();
        array[3] = messageRequest.getPr22();
        array[4] = messageRequest.getPr31();
        array[5] = messageRequest.getPr32();
        array[6] = messageRequest.getPr41();
        array[7] = messageRequest.getPr42();
        array[8] = messageRequest.getPr51();
        array[9] = messageRequest.getPr52();
        array[10] = messageRequest.getPr61();
        array[11] = messageRequest.getPr62();
        return array;
    }
}
