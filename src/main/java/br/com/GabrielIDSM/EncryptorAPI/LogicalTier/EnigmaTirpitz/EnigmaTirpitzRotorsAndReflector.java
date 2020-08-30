package br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaTirpitz;

import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.PrepareRotors;

public class EnigmaTirpitzRotorsAndReflector {
    
    private final String R1 = "KPTYUELOCVGRFQDANJMBSWHZXI";
    private final String R2 = "UPHZLWEQMTDJXCAKSOIGVBYFNR";
    private final String R3 = "QUDLYRFEKONVZAXWHMGPJBSICT";
    private final String R4 = "CIWTBKXNRESPFLYDAGVHQUOJZM";
    private final String R5 = "UAXGISNJBVERDYLFZWTPCKOHMQ";
    private final String R6 = "XFUZGALVHCNYSEWQTDMRBKPIOJ";
    private final String R7 = "BJVFTXPLNAYOZIKWGDQERUCHSM";
    private final String R8 = "YMTPNZHWKODAJXELUQVGCBISFR";
    private final String REFLECTOR = "GEKPBTAUMOCNILJDXZYFHWVQSR";

    public String getR1() {
        return R1;
    }

    public String getR2() {
        return R2;
    }

    public String getR3() {
        return R3;
    }

    public String getR4() {
        return R4;
    }

    public String getR5() {
        return R5;
    }

    public String getR6() {
        return R6;
    }

    public String getR7() {
        return R7;
    }

    public String getR8() {
        return R8;
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
            case 4:
                return getR4();
            case 5:
                return getR5();
            case 6:
                return getR6();
            case 7:
                return getR7();
            case 8:
                return getR8();
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
        for(int i = 0; i < 13; i++){
            reflector[i][0] = reflectorCharArray[i];
        }
        for(int i = 12; i >= 0; i--){
            reflector[i][1] = reflectorCharArray[25-i];
        }
        return reflector;
    }
    
}
