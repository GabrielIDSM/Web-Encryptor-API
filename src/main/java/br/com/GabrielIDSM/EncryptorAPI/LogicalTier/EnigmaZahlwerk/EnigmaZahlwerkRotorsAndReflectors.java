package br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaZahlwerk;

import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.PrepareRotors;

public class EnigmaZahlwerkRotorsAndReflectors {
    
    private final String R1_DEFAULT = "LPGSZMHAEOQKVXRFYBUTNICJDW";
    private final String R2_DEFAULT = "SLVGBTFXJQOHEWIRZYAMKPCNDU";
    private final String R3_DEFAULT = "CJGDPSHKTURAWZXFMYNQOBVLIE";
    private final String REFLECTOR_DEFAULT = "IMETCGFRAYSQBZXWLHKDVUPOJN";
    
    private final String R1_G312 = "DMTWSILRUYQNKFEJCAZBPGXOHV";
    private final String R2_G312 = "HQZGPJTMOBLNCIFDYAWVEUSRKX";
    private final String R3_G312 = "UQNTLSZFMREHDPXKIBVYGJCWOA";
    private final String REFLECTOR_G312 = "RULQMZJSYGOCETKWDAHNBXPVIF";
    
    private final String R1_G260 = "RCSPBLKQAUMHWYTIFZVGOJNEXD";
    private final String R2_G260 = "WCMIBVPJXAROSGNDLZKEYHUFQT";
    private final String R3_G260 = "FVDHZELSQMAXOKYIWPGCBUJTNR";
    private final String REFLECTOR_G260 = "IMETCGFRAYSQBZXWLHKDVUPOJN";

    public String getR1_DEFAULT() {
        return R1_DEFAULT;
    }

    public String getR2_DEFAULT() {
        return R2_DEFAULT;
    }

    public String getR3_DEFAULT() {
        return R3_DEFAULT;
    }

    public String getREFLECTOR_DEFAULT() {
        return REFLECTOR_DEFAULT;
    }

    public String getR1_G312() {
        return R1_G312;
    }

    public String getR2_G312() {
        return R2_G312;
    }

    public String getR3_G312() {
        return R3_G312;
    }

    public String getREFLECTOR_G312() {
        return REFLECTOR_G312;
    }

    public String getR1_G260() {
        return R1_G260;
    }

    public String getR2_G260() {
        return R2_G260;
    }

    public String getR3_G260() {
        return R3_G260;
    }

    public String getREFLECTOR_G260() {
        return REFLECTOR_G260;
    }
    
    private char[][] CreateReflector (int n, String reflectorString){
        char[][] reflector = new char[13][2];
        PrepareRotors prepareRotors = new PrepareRotors();
        char[] reflectorCharArray = prepareRotors.PrepareRotorsToEncryptor(reflectorString, n).toCharArray();
        for(int i = 0; i < 13; i++){
            reflector[i][0] = reflectorCharArray[2 * i];
            reflector[i][1] = reflectorCharArray[2 * i + 1];
        }
        return reflector;
    }
    
    public String DefineDefaultRotors(int n){
        switch(n){
            case 1:
                return getR1_DEFAULT();
            case 2:
                return getR2_DEFAULT();
            case 3:
                return getR3_DEFAULT();
            default:
                return null;
        }
    }
    
    public String DefineG312Rotors(int n){
        switch(n){
            case 1:
                return getR1_G312();
            case 2:
                return getR2_G312();
            case 3:
                return getR3_G312();
            default:
                return null;
        }
    }
    
    public String DefineG260Rotors(int n){
        switch(n){
            case 1:
                return getR1_G260();
            case 2:
                return getR2_G260();
            case 3:
                return getR3_G260();
            default:
                return null;
        }
    }
    
    public char[][] DefineDefaultReflector(int n){
        return CreateReflector(n, getREFLECTOR_DEFAULT());
    }
    
    public char[][] DefineG312Reflector(int n){
        return CreateReflector(n, getREFLECTOR_G312());
    }
    
    public char[][] DefineG260Reflector(int n){
        return CreateReflector(n, getREFLECTOR_G260());
    }
    
}
