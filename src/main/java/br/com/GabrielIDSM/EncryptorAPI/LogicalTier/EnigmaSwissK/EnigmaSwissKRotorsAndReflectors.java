package br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaSwissK;

import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.PrepareRotors;

public class EnigmaSwissKRotorsAndReflectors {
    
    private final String R1_COMMERCIAL = "LPGSZMHAEOQKVXRFYBUTNICJDW";
    private final String R2_COMMERCIAL = "SLVGBTFXJQOHEWIRZYAMKPCNDU";
    private final String R3_COMMERCIAL = "CJGDPSHKTURAWZXFMYNQOBVLIE";
    private final String REFLECTOR_COMMERCIAL = "IMETCGFRAYSQBZXWLHKDVUPOJN";
    private final String R1_AIRFORCE = "PEZUOHXSCVFMTBGLRINQJWAYDK";
    private final String R2_AIRFORCE = "ZOUESYDKFWPCIQXHMVBLGNJRAT";
    private final String R3_AIRFORCE = "EHRVXGAOBQUSIMZFLYNWKTPDJC";
    private final String REFLECTOR_AIRFORCE = "IMETCGFRAYSQBZXWLHKDVUPOJN";

    public String getR1_COMMERCIAL() {
        return R1_COMMERCIAL;
    }

    public String getR2_COMMERCIAL() {
        return R2_COMMERCIAL;
    }

    public String getR3_COMMERCIAL() {
        return R3_COMMERCIAL;
    }

    public String getREFLECTOR_COMMERCIAL() {
        return REFLECTOR_COMMERCIAL;
    }

    public String getR1_AIRFORCE() {
        return R1_AIRFORCE;
    }

    public String getR2_AIRFORCE() {
        return R2_AIRFORCE;
    }

    public String getR3_AIRFORCE() {
        return R3_AIRFORCE;
    }

    public String getREFLECTOR_AIRFORCE() {
        return REFLECTOR_AIRFORCE;
    }
    
    public String DefineCommercialRotors(int n){
        switch(n){
            case 1:
                return getR1_COMMERCIAL();
            case 2:
                return getR2_COMMERCIAL();
            case 3:
                return getR3_COMMERCIAL();
            default:
                return null;
        }
    }
    
    public String DefineAirForceRotors(int n){
        switch(n){
            case 1:
                return getR1_AIRFORCE();
            case 2:
                return getR2_AIRFORCE();
            case 3:
                return getR3_AIRFORCE();
            default:
                return null;
        }
    }
    
    public char[][] DefineCommercialReflector(int n){
        return CreateReflector(n, getREFLECTOR_COMMERCIAL());
    }
    
    public char[][] DefineAirForceReflector(int n){
        return CreateReflector(n, getREFLECTOR_AIRFORCE());
    }
    
    private char[][] CreateReflector (int n, String reflectorString){
        char[][] reflector = new char[13][2];
        PrepareRotors prepareRotors = new PrepareRotors();
        char[] reflectorCharArray = prepareRotors.PrepareRotorsToEncryptor(reflectorString, n).toCharArray();
        for(int i = 0; i < 13; i++){
            reflector[i][0] = reflectorCharArray[i];
        }
        for(int i = 12; i >= 0; i--){
            reflector[i][1] = reflectorCharArray[25-i];
        }
        return reflector;
    }
}
