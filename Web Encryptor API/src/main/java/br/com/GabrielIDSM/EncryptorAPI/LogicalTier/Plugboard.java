package br.com.GabrielIDSM.EncryptorAPI.LogicalTier;

import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.EnigmaOneRotors;

public class Plugboard {
    public static String Operation(String initialMessage,  int[] plugIndexCharArray){
        char[] messageCharArray = initialMessage.toCharArray();
        EnigmaOneRotors Rotors = new EnigmaOneRotors();
        char[] AlphabetCharArray = Rotors.DefineUsedRotor(0).toCharArray();
        String resultMessage = "";
        boolean b = true;
        for (int i = 0; i < messageCharArray.length; i++) {
            for (int j = 0; j < plugIndexCharArray.length; j += 2) {
                if (AlphabetCharArray[plugIndexCharArray[j]] == messageCharArray[i]) {
                    resultMessage += AlphabetCharArray[plugIndexCharArray[(j + 1)]];
                    b = false;
                } else if (AlphabetCharArray[plugIndexCharArray[(j + 1)]] == messageCharArray[i]) {
                    resultMessage += AlphabetCharArray[plugIndexCharArray[j]];
                    b = false;
                }
            }
            if (b) {
                resultMessage += messageCharArray[i];
            }
            b = true;
        }
        return resultMessage;
    }
}
