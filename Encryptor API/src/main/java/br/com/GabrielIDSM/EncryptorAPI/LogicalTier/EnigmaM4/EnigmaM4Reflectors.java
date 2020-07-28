package br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4;

public class EnigmaM4Reflectors {
    
    private final char[][] REFLECTOR_UKWA = {{'E', 'J'}, {'M', 'Z'}, {'A', 'L'}, {'Y', 'X'}, {'V', 'B'}, {'W', 'F'}, {'C', 'R'}, {'Q', 'U'}, 
        {'O', 'N'}, {'T', 'S'}, {'P', 'I'}, {'K', 'H'}, {'G', 'D'}};
    private final char[][] REFLECTOR_UKWB = {{'Y', 'R'}, {'U', 'H'}, {'Q', 'S'}, {'L', 'D'}, {'P', 'X'}, {'N', 'G'}, {'O', 'K'}, {'M', 'I'}, 
        {'E', 'B'}, {'F', 'Z'}, {'C', 'W'}, {'V', 'J'}, {'A', 'T'}};
    private final char[][] REFLECTOR_UKWC = {{'F', 'V'}, {'P', 'J'}, {'I', 'A'}, {'O', 'Y'}, {'E', 'D'}, {'R', 'Z'}, {'X', 'W'}, {'G', 'C'}, 
        {'T', 'K'}, {'U', 'Q'}, {'S', 'B'}, {'N', 'M'}, {'H', 'L'}};
    private final char[][] REFLECTOR_UKWB_THIN = {{'E', 'N'}, {'K', 'Q'}, {'A', 'U'}, {'Y', 'W'}, {'J', 'I'}, {'C', 'O'}, {'P', 'B'}, {'L', 'M'}, 
        {'D', 'X'}, {'Z', 'V'}, {'F', 'T'}, {'H', 'R'}, {'G', 'S'}};
    private final char[][] REFLECTOR_UKWC_THIN = {{'R', 'D'}, {'O', 'B'}, {'J', 'N'}, {'T', 'K'}, {'V', 'E'}, {'H', 'M'}, {'L', 'F'}, {'C', 'W'}, 
        {'Z', 'A'}, {'X', 'G'}, {'Y', 'I'}, {'P', 'S'}, {'U', 'Q'}};

    public char[][] getREFLECTOR_UKWA() {
        return REFLECTOR_UKWA;
    }

    public char[][] getREFLECTOR_UKWB() {
        return REFLECTOR_UKWB;
    }

    public char[][] getREFLECTOR_UKWC() {
        return REFLECTOR_UKWC;
    }

    public char[][] getREFLECTOR_UKWB_THIN() {
        return REFLECTOR_UKWB_THIN;
    }

    public char[][] getREFLECTOR_UKWC_THIN() {
        return REFLECTOR_UKWC_THIN;
    }
    
    
    public char[][] DefineReflector(int n) {
        char[][] aux;
        switch (n) {
            case 1:
                aux = getREFLECTOR_UKWA();
                break;
            case 2:
                aux = getREFLECTOR_UKWB();
                break;
            case 3:
                aux = getREFLECTOR_UKWC();
                break;
            case 4:
                aux = getREFLECTOR_UKWB_THIN();
                break;
            case 5:
                aux = getREFLECTOR_UKWC_THIN();
                break;
            default:
                aux = null;
                break;
        }
        return aux;
    }
}
