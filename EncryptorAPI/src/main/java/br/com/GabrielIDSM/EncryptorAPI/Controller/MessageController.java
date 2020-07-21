package br.com.GabrielIDSM.EncryptorAPI.Controller;

import br.com.GabrielIDSM.EncryptorAPI.Error.ResourceNotFoundException;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.DataValidation;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EncryptorMain;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {
    @GetMapping()
    public ResponseEntity<?> main (@RequestBody MessageRequestModel messageRequest){
        if(!DataValidation.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(EncryptorMain.Encryptor(messageRequest), HttpStatus.OK);
    }
}
