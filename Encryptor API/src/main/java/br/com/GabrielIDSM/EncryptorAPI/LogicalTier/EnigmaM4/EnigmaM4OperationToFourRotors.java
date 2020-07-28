package br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4;

import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.PrepareRotors;

public class EnigmaM4OperationToFourRotors {

    private final EnigmaM4Rotors ROTORS = new EnigmaM4Rotors();
    private final EnigmaM4Reflectors REFLECTORS = new EnigmaM4Reflectors();
    private char[][] reflector;
    private String message;
    private final String Alphabet = ROTORS.DefineUsedRotor(0);
    private String UsedRotorOne;
    private String UsedRotorTwo;
    private String UsedRotorThree;
    private String UsedRotorFour;
    private int UsedRotorTwoIndex;
    private int UsedRotorThreeIndex;
    private int UsedRotorFourIndex;
    private int reflectorIndex;

    public EnigmaM4OperationToFourRotors(char[][] reflector, String message, String UsedRotorOne, String UsedRotorTwo, String UsedRotorThree, String UsedRotorFour, int UsedRotorTwoIndex, int UsedRotorThreeIndex, int UsedRotorFourIndex, int reflectorIndex) {
        this.reflector = reflector;
        this.message = message;
        this.UsedRotorOne = UsedRotorOne;
        this.UsedRotorTwo = UsedRotorTwo;
        this.UsedRotorThree = UsedRotorThree;
        this.UsedRotorFour = UsedRotorFour;
        this.UsedRotorTwoIndex = UsedRotorTwoIndex;
        this.UsedRotorThreeIndex = UsedRotorThreeIndex;
        this.UsedRotorFourIndex = UsedRotorFourIndex;
        this.reflectorIndex = reflectorIndex;
    }

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

    public String getUsedRotorFour() {
        return UsedRotorFour;
    }

    public void setUsedRotorFour(String UsedRotorFour) {
        this.UsedRotorFour = UsedRotorFour;
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

    private char ReflectorSubstitution(char c) {
        char[][] usedReflector;
        if (UsedRotorFourIndex == 1 && reflectorIndex == 4) {
            usedReflector = REFLECTORS.DefineReflector(2);
            for (int i = 0; i < 13; i++) {
                if (usedReflector[i][0] == c) {
                    return usedReflector[i][1];
                }
                if (usedReflector[i][1] == c) {
                    return usedReflector[i][0];
                }
            }
        } else if (UsedRotorFourIndex == 2 && reflectorIndex == 5) {
            usedReflector = REFLECTORS.DefineReflector(3);
            for (int i = 0; i < 13; i++) {
                if (usedReflector[i][0] == c) {
                    return usedReflector[i][1];
                }
                if (usedReflector[i][1] == c) {
                    return usedReflector[i][0];
                }
            }
        } else {
            usedReflector = reflector;
            c = Substitution(c, Alphabet, UsedRotorFour);
            for (int i = 0; i < 13; i++) {
                if (usedReflector[i][0] == c) {
                    c = usedReflector[i][1];
                    break;
                }
                if (usedReflector[i][1] == c) {
                    c = usedReflector[i][0];
                    break;
                }
            }
            return Substitution(c, UsedRotorFour, Alphabet);
        }
        return ' ';
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
                if (auxUsedRotorOne[0] == 'R') {
                    setUsedRotorTwo(prepare.PrepareRotorsToEncryptor(UsedRotorTwo, 1));
                    hasRotate = true;
                }
                break;
            case 2:
                if (auxUsedRotorOne[0] == 'F') {
                    setUsedRotorTwo(prepare.PrepareRotorsToEncryptor(UsedRotorTwo, 1));
                    hasRotate = true;
                }
                break;
            case 3:
                if (auxUsedRotorOne[0] == 'W') {
                    setUsedRotorTwo(prepare.PrepareRotorsToEncryptor(UsedRotorTwo, 1));
                    hasRotate = true;
                }
                break;
            case 4:
                if (auxUsedRotorOne[0] == 'K') {
                    setUsedRotorTwo(prepare.PrepareRotorsToEncryptor(UsedRotorTwo, 1));
                    hasRotate = true;
                }
                break;
            case 5:
                if (auxUsedRotorOne[0] == 'A') {
                    setUsedRotorTwo(prepare.PrepareRotorsToEncryptor(UsedRotorTwo, 1));
                    hasRotate = true;
                }
                break;
            case 6:
                if (auxUsedRotorOne[0] == 'A') {
                    setUsedRotorTwo(prepare.PrepareRotorsToEncryptor(UsedRotorTwo, 1));
                    hasRotate = true;
                }
                break;
            case 7:
                if (auxUsedRotorOne[0] == 'A') {
                    setUsedRotorTwo(prepare.PrepareRotorsToEncryptor(UsedRotorTwo, 1));
                    hasRotate = true;
                }
                break;
            case 8:
                if (auxUsedRotorOne[0] == 'A') {
                    setUsedRotorTwo(prepare.PrepareRotorsToEncryptor(UsedRotorTwo, 1));
                    hasRotate = true;
                }
                break;
        }
        if (hasRotate) {
            auxUsedRotorTwo = UsedRotorTwo.toCharArray();
            switch (UsedRotorThreeIndex) {
                case 1:
                    if (auxUsedRotorTwo[0] == 'R') {
                        setUsedRotorThree(prepare.PrepareRotorsToEncryptor(UsedRotorThree, 1));
                    }
                    break;
                case 2:
                    if (auxUsedRotorTwo[0] == 'F') {
                        setUsedRotorThree(prepare.PrepareRotorsToEncryptor(UsedRotorThree, 1));
                    }
                    break;
                case 3:
                    if (auxUsedRotorTwo[0] == 'W') {
                        setUsedRotorThree(prepare.PrepareRotorsToEncryptor(UsedRotorThree, 1));
                    }
                    break;
                case 4:
                    if (auxUsedRotorTwo[0] == 'K') {
                        setUsedRotorThree(prepare.PrepareRotorsToEncryptor(UsedRotorThree, 1));
                    }
                    break;
                case 5:
                    if (auxUsedRotorTwo[0] == 'A') {
                        setUsedRotorThree(prepare.PrepareRotorsToEncryptor(UsedRotorThree, 1));
                    }
                    break;
                case 6:
                    if (auxUsedRotorOne[0] == 'A') {
                        setUsedRotorThree(prepare.PrepareRotorsToEncryptor(UsedRotorThree, 1));
                    }
                    break;
                case 7:
                    if (auxUsedRotorOne[0] == 'A') {
                        setUsedRotorThree(prepare.PrepareRotorsToEncryptor(UsedRotorThree, 1));
                    }
                    break;
                case 8:
                    if (auxUsedRotorOne[0] == 'A') {
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
                Letter = ReflectorSubstitution(Letter);
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
