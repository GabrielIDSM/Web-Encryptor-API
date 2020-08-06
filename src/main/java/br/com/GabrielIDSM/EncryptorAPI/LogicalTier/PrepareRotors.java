package br.com.GabrielIDSM.EncryptorAPI.LogicalTier;

public class PrepareRotors {

    private boolean Verify(int n) {
        boolean rt = true;
        if (n < 0 || n > 26) {
            rt = false;
        }
        return rt;
    }

    public String PrepareRotorsToEncryptor(String S, int n) {
        boolean rt = Verify(n);
        if (!rt) {
            return null;
        }
        String aux = "";
        int i = 0;
        char c;
        if (n == 0 || n == 26) {
            aux = S;
            return aux;
        }
        for (i = 0; i < 26; i++) {
            if ((n + i) < 26) {
                c = S.charAt((n + i));
                aux += c;
            } else {
                c = S.charAt((n + i - 26));
                aux += c;
            }
        }
        return aux;
    }

}
