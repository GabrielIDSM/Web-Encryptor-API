package br.com.GabrielIDSM.EncryptorAPI.LogicalTier;

import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModel;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageResponseModel;

public class EncryptorMain {

    public static MessageResponseModel Encryptor(MessageRequestModel messageRequest) {
        MessageResponseModel messageResponse = new MessageResponseModel();
        String U1, U2, U3;
        int auxR1;
        int auxR2;
        int auxR3;
        int auxCh1;
        int auxCh2;
        int auxCh3;
        String mensagemInicial;
        int[] parAParArray = new int[12];
        auxR1 = messageRequest.getRotor1();
        auxR2 = messageRequest.getRotor2();
        auxR3 = messageRequest.getRotor3();
        auxCh1 = messageRequest.getChave1();
        auxCh2 = messageRequest.getChave1();
        auxCh3 = messageRequest.getChave1();
        mensagemInicial = messageRequest.getMessage();
        parAParArray[0] = messageRequest.getPr11();
        parAParArray[1] = messageRequest.getPr12();
        parAParArray[2] = messageRequest.getPr21();
        parAParArray[3] = messageRequest.getPr22();
        parAParArray[4] = messageRequest.getPr31();
        parAParArray[5] = messageRequest.getPr32();
        parAParArray[6] = messageRequest.getPr41();
        parAParArray[7] = messageRequest.getPr42();
        parAParArray[8] = messageRequest.getPr51();
        parAParArray[9] = messageRequest.getPr52();
        parAParArray[10] = messageRequest.getPr61();
        parAParArray[11] = messageRequest.getPr62();
        Rotors Rotores = new Rotors();
        String U0 = Rotores.define_rotor_usado(0);
        char[][] Ref_b = Rotores.define_refletor();
        PrepareRotors Prepare = new PrepareRotors();
        PrepareMessage PrepareMessage = new PrepareMessage();      
        U1 = Rotores.define_rotor_usado(auxR1);
        U2 = Rotores.define_rotor_usado(auxR2);
        U3 = Rotores.define_rotor_usado(auxR3);
        U1 = Prepare.Prepararotor(U1, auxCh1);
        U2 = Prepare.Prepararotor(U2, auxCh2);
        U3 = Prepare.Prepararotor(U3, auxCh3);
        mensagemInicial = mensagemInicial.replace("\n", "");
        mensagemInicial = mensagemInicial.replace("\t", "");
        mensagemInicial = mensagemInicial.replace("\r", "");
        mensagemInicial = PrepareMessage.Preparamensagem(mensagemInicial);
        char[] aux_parapar = Rotores.define_rotor_usado(0).toCharArray();
        char[] aux_mensagem_1 = mensagemInicial.toCharArray();
        String mensagem_1 = "";
        boolean b = true;
        for (int i = 0; i < aux_mensagem_1.length; i++) {
            for (int j = 0; j < 12; j += 2) {
                if (aux_parapar[parAParArray[j]] == aux_mensagem_1[i]) {
                    mensagem_1 += aux_parapar[parAParArray[(j + 1)]];
                    b = false;
                } else if (aux_parapar[parAParArray[(j + 1)]] == aux_mensagem_1[i]) {
                    mensagem_1 += aux_parapar[parAParArray[j]];
                    b = false;
                }
            }
            if (b) {
                mensagem_1 += aux_mensagem_1[i];
            }
            b = true;
        }
        b = true;
        Start funcionamento = new Start(Ref_b, U0, U1, U2, U3, mensagem_1, auxR2, auxR3);
        String mensagemFinal = funcionamento.funcionamento();
        char[] auxMessage = mensagemFinal.toCharArray();
        String message = "";
        for (int i = 0; i < auxMessage.length; i++) {
            for (int j = 0; j < 12; j += 2) {
                if (aux_parapar[parAParArray[j]] == auxMessage[i]) {
                    message += aux_parapar[parAParArray[(j + 1)]];
                    b = false;
                } else if (aux_parapar[parAParArray[(j + 1)]] == auxMessage[i]) {
                    message += aux_parapar[parAParArray[j]];
                    b = false;
                }
            }
            if (b) {
                message += auxMessage[i];
            }
            b = true;
        }
        messageResponse.setMessage(message);
        return messageResponse;
    }
}
