package br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaZahlwerk;

import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.EnigmaOneRotors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.PrepareRotors;

public class EnigmaZahlwerkOperation {
    
    private final EnigmaOneRotors ROTORS = new EnigmaOneRotors();
    private char[][] reflector;
    private String message;
    private String Alphabet = ROTORS.DefineUsedRotor(0);
    private String UsedRotorOne;
    private String UsedRotorTwo;
    private String UsedRotorThree;
    private int UsedRotorTwoIndex;
    private int UsedRotorThreeIndex;

    public char[][] getReflector() {
        return reflector;
    }

    public void setReflector(char[][] reflector) {
        this.reflector = reflector;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAlphabet() {
        return Alphabet;
    }

    public void setAlphabet(String Alphabet) {
        this.Alphabet = Alphabet;
    }

    public String getUsedRotorOne() {
        return UsedRotorOne;
    }

    public void setUsedRotorOne(String UsedRotorOne) {
        this.UsedRotorOne = UsedRotorOne;
    }

    public String getUsedRotorTwo() {
        return UsedRotorTwo;
    }

    public void setUsedRotorTwo(String UsedRotorTwo) {
        this.UsedRotorTwo = UsedRotorTwo;
    }

    public String getUsedRotorThree() {
        return UsedRotorThree;
    }

    public void setUsedRotorThree(String UsedRotorThree) {
        this.UsedRotorThree = UsedRotorThree;
    }

    public int getUsedRotorTwoIndex() {
        return UsedRotorTwoIndex;
    }

    public void setUsedRotorTwoIndex(int UsedRotorTwoIndex) {
        this.UsedRotorTwoIndex = UsedRotorTwoIndex;
    }

    public int getUsedRotorThreeIndex() {
        return UsedRotorThreeIndex;
    }

    public void setUsedRotorThreeIndex(int UsedRotorThreeIndex) {
        this.UsedRotorThreeIndex = UsedRotorThreeIndex;
    }

    public EnigmaZahlwerkOperation(char[][] reflector, String message, String UsedRotorOne, String UsedRotorTwo, String UsedRotorThree, int UsedRotorTwoIndex, int UsedRotorThreeIndex) {
        this.reflector = reflector;
        this.message = message;
        this.UsedRotorOne = UsedRotorOne;
        this.UsedRotorTwo = UsedRotorTwo;
        this.UsedRotorThree = UsedRotorThree;
        this.UsedRotorTwoIndex = UsedRotorTwoIndex;
        this.UsedRotorThreeIndex = UsedRotorThreeIndex;
    }

    private char Substitution(char c, String origin, String target) {
        char[] auxOrigin = origin.toCharArray();
        char[] auxTarget = target.toCharArray();
        for (int i = 0; i < 26; i++) {
            if (c == auxOrigin[i]) {
                c = auxTarget[i];
                break;
            }
        }
        return c;
    }

    private char ReflectorSubstitution(char c, char[][] reflector) {
        char aux = ' ';
        for (int i = 0; i < 13; i++) {
            if (reflector[i][0] == c) {
                aux = reflector[i][1];
                break;
            }
            if (reflector[i][1] == c) {
                aux = reflector[i][0];
                break;
            }
        }
        return aux;
    }

    private boolean isTurnoverMoment(String t, char c){
        char[] tCharArray = t.toCharArray();
        for(char ct : tCharArray){
            if(ct == c) return true;
        }
        return false;
    }
    
    private void RotateRotors() {
        PrepareRotors prepare = new PrepareRotors();
        char[] auxUsedRotorOne;
        char[] auxUsedRotorTwo;
        setUsedRotorOne(prepare.PrepareRotorsToEncryptor(UsedRotorOne, 1));
        auxUsedRotorOne = UsedRotorOne.toCharArray();
        boolean hasRotate = false;
        switch (UsedRotorTwoIndex) {
            case 1:
                if (isTurnoverMoment("ACDEHIJKMNOQSTWXY", auxUsedRotorOne[0])) {
                    setUsedRotorTwo(prepare.PrepareRotorsToEncryptor(UsedRotorTwo, 1));
                    hasRotate = true;
                }
                break;
            case 2:
                if (isTurnoverMoment("ABDGHIKLNOPSUVY", auxUsedRotorOne[0])) {
                    setUsedRotorTwo(prepare.PrepareRotorsToEncryptor(UsedRotorTwo, 1));
                    hasRotate = true;
                }
                break;
            case 3:
                if (isTurnoverMoment("CEFIMNPSUVZ", auxUsedRotorOne[0])) {
                    setUsedRotorTwo(prepare.PrepareRotorsToEncryptor(UsedRotorTwo, 1));
                    hasRotate = true;
                }
                break;
        }
        if (hasRotate) {
            auxUsedRotorTwo = UsedRotorTwo.toCharArray();
            switch (UsedRotorThreeIndex) {
                case 1:
                    if (isTurnoverMoment("ACDEHIJKMNOQSTWXY", auxUsedRotorOne[0])) {
                        setUsedRotorThree(prepare.PrepareRotorsToEncryptor(UsedRotorThree, 1));
                    }
                    break;
                case 2:
                    if (isTurnoverMoment("ABDGHIKLNOPSUVY", auxUsedRotorOne[0])) {
                        setUsedRotorThree(prepare.PrepareRotorsToEncryptor(UsedRotorThree, 1));
                    }
                    break;
                case 3:
                    if (isTurnoverMoment("CEFIMNPSUVZ", auxUsedRotorOne[0])) {
                        setUsedRotorThree(prepare.PrepareRotorsToEncryptor(UsedRotorThree, 1));
                    }
                    break;
            }
        }
    }

    public String Operation() {
        char Letter;
        String resultMessage = "";
        char[] messageCharArray = message.toCharArray();
        for (int i = 0; i < message.length(); i++) {
            if (messageCharArray[i] == '0') {
                resultMessage += " ";
            } else {
                Letter = Substitution(messageCharArray[i], Alphabet, UsedRotorOne);
                Letter = Substitution(Letter, Alphabet, UsedRotorTwo);
                Letter = Substitution(Letter, Alphabet, UsedRotorThree);
                Letter = ReflectorSubstitution(Letter, reflector);
                Letter = Substitution(Letter, UsedRotorThree, Alphabet);
                Letter = Substitution(Letter, UsedRotorTwo, Alphabet);
                Letter = Substitution(Letter, UsedRotorOne, Alphabet);
                resultMessage += Letter;
                RotateRotors();
            }
        }
        return resultMessage;
    }
}
