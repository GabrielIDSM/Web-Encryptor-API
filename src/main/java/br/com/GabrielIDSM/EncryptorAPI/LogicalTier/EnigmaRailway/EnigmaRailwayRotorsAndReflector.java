package br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaRailway;

import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.PrepareRotors;

public class EnigmaRailwayRotorsAndReflector {
    
    private final String R1 = "JGDQOXUSCAMIFRVTPNEWKBLZYH";
    private final String R2 = "NTZPSFBOKMWRCJDIVLAEYUXHGQ";
    private final String R3 = "JVIUBHTCDYAKEQZPOSGXNRMWFL";
    private final String REFLECTOR = "QYHOGNECVPUZTFDJAXWMKISRBL";

    public String getR1() {
        return R1;
    }

    public String getR2() {
        return R2;
    }

    public String getR3() {
        return R3;
    }

    public String getREFLECTOR() {
        return REFLECTOR;
    }
    
    public String DefineRotors(int n){
        switch(n){
            case 1:
                return getR1();
            case 2:
                return getR2();
            case 3:
                return getR3();
            default:
                return null;
        }
    }    
    
    public char[][] DefineReflector(int n){
        return CreateReflector(n, getREFLECTOR());
    }
    
    private char[][] CreateReflector (int n, String reflectorString){
        char[][] reflector = new char[13][2];
        PrepareRotors prepareRotors = new PrepareRotors();
        char[] reflectorCharArray = prepareRotors.PrepareRotorsToEncryptor(reflectorString, n).toCharArray();
        System.out.println(prepareRotors.PrepareRotorsToEncryptor(reflectorString, n));
        for(int i = 0; i < 13; i++){
            reflector[i][0] = reflectorCharArray[i];
        }
        for(int i = 12; i >= 0; i--){
            reflector[i][1] = reflectorCharArray[25-i];
        }
        return reflector;
    }
    
}
