package br.com.GabrielIDSM.EncryptorAPI.Controller;

import br.com.GabrielIDSM.EncryptorAPI.Error.ResourceNotFoundException;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.DataValidationToEnigmaM3ArmyWithSixPlugs;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.Encryptor;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4.DataValidationToEnigmaM4WithPlugboardAndFourRotors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4.DataValidationToEnigmaM4WithPlugboardAndThreeRotors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.DataValidationToEnigmaM3ArmyWithTenPlugs;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.DataValidationToEnigmaM3NavalEightRotorsModel;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.DataValidationToEnigmaM3NavalSevenRotorsModel;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.DataValidationToEnigmaOne;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3ArmyWithSixPlugs;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3ArmyWithTenPlugs;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3Naval;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM4WithPlugboardAndFourRotors;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM4WithPlugboardAndThreeRotors;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaOne;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {
    @PostMapping(path = "enigmamthreearmywithsixplugs")
    public ResponseEntity<?> EnigmaM3ArmyWithSixPlugs (@RequestBody MessageRequestModelToEnigmaM3ArmyWithSixPlugs messageRequest){
        if(!DataValidationToEnigmaM3ArmyWithSixPlugs.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encryptor.EnigmaM3ArmyWithSixPlugsEncryptor(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamthreearmywithtenplugs")
    public ResponseEntity<?> EnigmaM3ArmyWithTenPlugs (@RequestBody MessageRequestModelToEnigmaM3ArmyWithTenPlugs messageRequest){
        if(!DataValidationToEnigmaM3ArmyWithTenPlugs.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encryptor.EnigmaM3ArmyWithTenPlugsEncryptor(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamthreenavalsevenrotorsmodel")
    public ResponseEntity<?> EnigmaM3NavalSevenRotorsModel (@RequestBody MessageRequestModelToEnigmaM3Naval messageRequest){
        if(!DataValidationToEnigmaM3NavalSevenRotorsModel.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encryptor.EnigmaM3NavalEncryptor(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamthreenavaleightrotorsmodel")
    public ResponseEntity<?> EnigmaM3NavalEightRotorsModel (@RequestBody MessageRequestModelToEnigmaM3Naval messageRequest){
        if(!DataValidationToEnigmaM3NavalEightRotorsModel.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encryptor.EnigmaM3NavalEncryptor(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmaone")
    public ResponseEntity<?> EnigmaOne (@RequestBody MessageRequestModelToEnigmaOne messageRequest){
        if(!DataValidationToEnigmaOne.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encryptor.EnigmaOneEncryptor(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamfourwithplugboardandfourrotors")
    public ResponseEntity<?> EnigmaM4WithPlugboardAndFourRotors (@RequestBody MessageRequestModelToEnigmaM4WithPlugboardAndFourRotors messageRequest){
        if(!DataValidationToEnigmaM4WithPlugboardAndFourRotors.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encryptor.EnigmaM4WithPlugboardAndFourRotorsEncryptor(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamfourwithplugboardandthreerotors")
    public ResponseEntity<?> EnigmaM4WithPlugboardAndThreeRotors (@RequestBody MessageRequestModelToEnigmaM4WithPlugboardAndThreeRotors messageRequest){
        if(!DataValidationToEnigmaM4WithPlugboardAndThreeRotors.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encryptor.EnigmaM4WithPlugboardAndThreeRotorsEncryptor(messageRequest), HttpStatus.OK);
    }
}
