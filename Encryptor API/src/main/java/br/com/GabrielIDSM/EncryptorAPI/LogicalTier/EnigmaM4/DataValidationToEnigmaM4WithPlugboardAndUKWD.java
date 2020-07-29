package br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4;

import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM4WithPlugboardAndUKWD;

public class DataValidationToEnigmaM4WithPlugboardAndUKWD {

    public static boolean isMessageRequestModelValid(MessageRequestModelToEnigmaM4WithPlugboardAndUKWD requestModel) {
        try {
            if (requestModel.getRotorOne() < 1 || requestModel.getRotorOne() > 8) {
                return false;
            }
            if (requestModel.getRotorTwo() < 1 || requestModel.getRotorTwo() > 8) {
                return false;
            }
            if (requestModel.getRotorThree() < 1 || requestModel.getRotorThree() > 8) {
                return false;
            }
            if (requestModel.getRotorOneWheelSet() < 1 || requestModel.getRotorOneWheelSet() > 26) {
                return false;
            }
            if (requestModel.getRotorTwoWheelSet() < 1 || requestModel.getRotorTwoWheelSet() > 26) {
                return false;
            }
            if (requestModel.getRotorThreeWheelSet() < 1 || requestModel.getRotorThreeWheelSet() > 26) {
                return false;
            }
            if (requestModel.getRotorOne() == requestModel.getRotorTwo()
                    || requestModel.getRotorOne() == requestModel.getRotorThree()
                    || requestModel.getRotorTwo() == requestModel.getRotorThree()) {
                return false;
            }
            int[] plugLettersArray = createArrayWithPlugLetters(requestModel);
            for (int pr : plugLettersArray) {
                if (pr < 0 || pr > 25) {
                    return false;
                }
            }
            for (int i = 0; i < plugLettersArray.length; i++) {
                for (int j = 0; j < plugLettersArray.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (plugLettersArray[i] == plugLettersArray[j]) {
                        return false;
                    }
                }
            }
            int[] reflectorArray = createArrayWithReflector(requestModel);
            for (int i = 0; i < reflectorArray.length; i++) {
                for (int j = 0; j < reflectorArray.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (reflectorArray[i] == reflectorArray[j]) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static int[] createArrayWithPlugLetters(MessageRequestModelToEnigmaM4WithPlugboardAndUKWD messageRequest) {
        int[] array = new int[20];
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
        array[12] = messageRequest.getPlugSevenA();
        array[13] = messageRequest.getPlugSevenB();
        array[14] = messageRequest.getPlugEightA();
        array[15] = messageRequest.getPlugEightB();
        array[16] = messageRequest.getPlugNineA();
        array[17] = messageRequest.getPlugNineB();
        array[18] = messageRequest.getPlugTenA();
        array[19] = messageRequest.getPlugTenB();
        return array;
    }

    private static int[] createArrayWithReflector(MessageRequestModelToEnigmaM4WithPlugboardAndUKWD messageRequest) {
        int[] array = new int[24];
        array[0] = messageRequest.getReflectorOneA();
        array[1] = messageRequest.getReflectorOneB();
        array[2] = messageRequest.getReflectorTwoA();
        array[3] = messageRequest.getReflectorTwoB();
        array[4] = messageRequest.getReflectorThreeA();
        array[5] = messageRequest.getReflectorThreeB();
        array[6] = messageRequest.getReflectorFourA();
        array[7] = messageRequest.getReflectorFourB();
        array[8] = messageRequest.getReflectorFiveA();
        array[9] = messageRequest.getReflectorFiveB();
        array[10] = messageRequest.getReflectorSixA();
        array[11] = messageRequest.getReflectorSixB();
        array[12] = messageRequest.getReflectorSevenA();
        array[13] = messageRequest.getReflectorSevenB();
        array[14] = messageRequest.getReflectorEightA();
        array[15] = messageRequest.getReflectorEightB();
        array[16] = messageRequest.getReflectorNineA();
        array[17] = messageRequest.getReflectorNineB();
        array[18] = messageRequest.getReflectorTenA();
        array[19] = messageRequest.getReflectorTenB();
        array[20] = messageRequest.getReflectorElevenA();
        array[21] = messageRequest.getReflectorElevenB();
        array[22] = messageRequest.getReflectorTwelveA();
        array[23] = messageRequest.getReflectorTwelveB();
        return array;
    }
}
