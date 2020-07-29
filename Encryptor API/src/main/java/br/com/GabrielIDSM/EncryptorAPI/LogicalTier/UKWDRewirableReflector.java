package br.com.GabrielIDSM.EncryptorAPI.LogicalTier;

import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM4WithPlugboardAndUKWD;

public class UKWDRewirableReflector {
    
    private final char[] AVAILABLE_LETTERS = "ABCDEFGHIKLMNOPQRSTUVWXZ".toCharArray();
    
    public char[][] DefineReflector (MessageRequestModelToEnigmaM4WithPlugboardAndUKWD messageRequest){
        char[][] reflector = new char[13][2];
        reflector[0][0] = 'J';
        reflector[0][1] = 'Y';
        reflector[1][0] = AVAILABLE_LETTERS[messageRequest.getReflectorOneA()];
        reflector[1][1] = AVAILABLE_LETTERS[messageRequest.getReflectorOneB()];
        reflector[2][0] = AVAILABLE_LETTERS[messageRequest.getReflectorTwoA()];
        reflector[2][1] = AVAILABLE_LETTERS[messageRequest.getReflectorTwoB()];
        reflector[3][0] = AVAILABLE_LETTERS[messageRequest.getReflectorThreeA()];
        reflector[3][1] = AVAILABLE_LETTERS[messageRequest.getReflectorThreeB()];
        reflector[4][0] = AVAILABLE_LETTERS[messageRequest.getReflectorFourA()];
        reflector[4][1] = AVAILABLE_LETTERS[messageRequest.getReflectorFourB()];
        reflector[5][0] = AVAILABLE_LETTERS[messageRequest.getReflectorFiveA()];
        reflector[5][1] = AVAILABLE_LETTERS[messageRequest.getReflectorFiveB()];
        reflector[6][0] = AVAILABLE_LETTERS[messageRequest.getReflectorSixA()];
        reflector[6][1] = AVAILABLE_LETTERS[messageRequest.getReflectorSixB()];
        reflector[7][0] = AVAILABLE_LETTERS[messageRequest.getReflectorSevenA()];
        reflector[7][1] = AVAILABLE_LETTERS[messageRequest.getReflectorSevenB()];
        reflector[8][0] = AVAILABLE_LETTERS[messageRequest.getReflectorEightA()];
        reflector[8][1] = AVAILABLE_LETTERS[messageRequest.getReflectorEightB()];
        reflector[9][0] = AVAILABLE_LETTERS[messageRequest.getReflectorNineA()];
        reflector[9][1] = AVAILABLE_LETTERS[messageRequest.getReflectorNineB()];
        reflector[10][0] = AVAILABLE_LETTERS[messageRequest.getReflectorTenA()];
        reflector[10][1] = AVAILABLE_LETTERS[messageRequest.getReflectorTenB()];
        reflector[11][0] = AVAILABLE_LETTERS[messageRequest.getReflectorElevenA()];
        reflector[11][1] = AVAILABLE_LETTERS[messageRequest.getReflectorElevenB()];
        reflector[12][0] = AVAILABLE_LETTERS[messageRequest.getReflectorTwelveA()];
        reflector[12][1] = AVAILABLE_LETTERS[messageRequest.getReflectorTwelveB()];
        return reflector;
    }
}
