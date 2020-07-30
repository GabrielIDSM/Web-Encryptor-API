package br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4;

public class EnigmaM4Rotors {

    private final String R0 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String R1 = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
    private final String R2 = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
    private final String R3 = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
    private final String R4 = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
    private final String R5 = "VZBRGITYUPSDNHLXAWMJQOFECK";
    private final String R6 = "JPGVOUMFYQBENHZRDKASXLICTW";
    private final String R7 = "NZJHGRCXMYSWBOUFAIVLPEKQDT";
    private final String R8 = "FKQHTLXOCBJSPDZRAMEWNIUYGV";
    private final String BETA = "LEYJVCNIXWPBQMDRTAKZGFUHOS";
    private final String GAMA = "FSOKANUERHMBTIYCWLQPZXVGJD";

    private String getR0() {
        return R0;
    }

    private String getR1() {
        return R1;
    }

    private String getR2() {
        return R2;
    }

    private String getR3() {
        return R3;
    }

    private String getR4() {
        return R4;
    }

    private String getR5() {
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

    public String getBETA() {
        return BETA;
    }

    public String getGAMA() {
        return GAMA;
    }

    public String DefineUsedRotor(int n) {
        String aux;
        switch (n) {
            case 0:
                aux = getR0();
                break;
            case 1:
                aux = getR1();
                break;
            case 2:
                aux = getR2();
                break;
            case 3:
                aux = getR3();
                break;
            case 4:
                aux = getR4();
                break;
            case 5:
                aux = getR5();
                break;
            case 6:
                aux = getR6();
                break;
            case 7:
                aux = getR7();
                break;
            case 8:
                aux = getR8();
                break;
            default:
                aux = null;
                break;
        }
        return aux;
    }

    public String DefineExtraRotor(int n) {
        String aux;
        switch (n) {
            case 1:
                aux = getBETA();
                break;
            case 2:
                aux = getGAMA();
                break;
            default:
                aux = null;
                break;
        }
        return aux;
    }
}
