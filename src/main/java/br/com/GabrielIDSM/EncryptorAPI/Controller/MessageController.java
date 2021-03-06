package br.com.GabrielIDSM.EncryptorAPI.Controller;

import br.com.GabrielIDSM.EncryptorAPI.Error.ResourceNotFoundException;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.DataValidationToEnigmaM3ArmyWithSixPlugs;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.Encrypter;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4.DataValidationToEnigmaM4WithPlugboardAndFourRotors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4.DataValidationToEnigmaM4WithPlugboardAndThreeRotors;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaM4.DataValidationToEnigmaM4WithPlugboardAndUKWD;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.DataValidationToEnigmaM3ArmyWithTenPlugs;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.DataValidationToEnigmaM3NavalEightRotorsModel;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.DataValidationToEnigmaM3NavalSevenRotorsModel;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaOne.DataValidationToEnigmaOne;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaRailway.DataValidationToEnigmaRailway;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaSwissK.DataValidationToEnigmaSwissK;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaTirpitz.DataValidationToEnigmaTirpitz;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.EnigmaZahlwerk.DataValidationToEnigmaZahlwerk;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3ArmyWithSixPlugs;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3ArmyWithTenPlugs;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM3Naval;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM4WithPlugboardAndFourRotors;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM4WithPlugboardAndThreeRotors;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaM4WithPlugboardAndUKWD;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaOne;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaRailway;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaSwissK;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaTirpitz;
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageRequestModelToEnigmaZahlwerk;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("message")
public class MessageController {
    @PostMapping(path = "enigmamthreearmywithsixplugs")
    public ResponseEntity<?> EnigmaM3ArmyWithSixPlugs (@RequestBody MessageRequestModelToEnigmaM3ArmyWithSixPlugs messageRequest){
        if(!DataValidationToEnigmaM3ArmyWithSixPlugs.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaM3ArmyWithSixPlugsEncrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamthreearmywithtenplugs")
    public ResponseEntity<?> EnigmaM3ArmyWithTenPlugs (@RequestBody MessageRequestModelToEnigmaM3ArmyWithTenPlugs messageRequest){
        if(!DataValidationToEnigmaM3ArmyWithTenPlugs.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaM3ArmyWithTenPlugsEncrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamthreenavalsevenrotorsmodel")
    public ResponseEntity<?> EnigmaM3NavalSevenRotorsModel (@RequestBody MessageRequestModelToEnigmaM3Naval messageRequest){
        if(!DataValidationToEnigmaM3NavalSevenRotorsModel.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaM3NavalEncrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamthreenavaleightrotorsmodel")
    public ResponseEntity<?> EnigmaM3NavalEightRotorsModel (@RequestBody MessageRequestModelToEnigmaM3Naval messageRequest){
        if(!DataValidationToEnigmaM3NavalEightRotorsModel.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaM3NavalEncrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmaone")
    public ResponseEntity<?> EnigmaOne (@RequestBody MessageRequestModelToEnigmaOne messageRequest){
        if(!DataValidationToEnigmaOne.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaOneEncrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamfourwithplugboardandfourrotors")
    public ResponseEntity<?> EnigmaM4WithPlugboardAndFourRotors (@RequestBody MessageRequestModelToEnigmaM4WithPlugboardAndFourRotors messageRequest){
        if(!DataValidationToEnigmaM4WithPlugboardAndFourRotors.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaM4WithFourRotorsEncrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamfourwithplugboardandthreerotors")
    public ResponseEntity<?> EnigmaM4WithPlugboardAndThreeRotors (@RequestBody MessageRequestModelToEnigmaM4WithPlugboardAndThreeRotors messageRequest){
        if(!DataValidationToEnigmaM4WithPlugboardAndThreeRotors.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaM4WithThreeRotorsEncrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmaswisskcommercial")
    public ResponseEntity<?> EnigmaSwissKCommercial (@RequestBody MessageRequestModelToEnigmaSwissK messageRequest){
        if(!DataValidationToEnigmaSwissK.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaSwissKCommercialEncrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmaswisskairforce")
    public ResponseEntity<?> EnigmaSwissKAirForce (@RequestBody MessageRequestModelToEnigmaSwissK messageRequest){
        if(!DataValidationToEnigmaSwissK.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaSwissKAirForceEncrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamfourwithplugboardandukwd")
    public ResponseEntity<?> EnigmaM4WithPlugboardAndUKWD (@RequestBody MessageRequestModelToEnigmaM4WithPlugboardAndUKWD messageRequest){
        if(!DataValidationToEnigmaM4WithPlugboardAndUKWD.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaM4WithPlugboardAndUKWDEncrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmarailway")
    public ResponseEntity<?> EnigmaRailway (@RequestBody MessageRequestModelToEnigmaRailway messageRequest){
        if(!DataValidationToEnigmaRailway.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaRailwayEncrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmatirpitz")
    public ResponseEntity<?> EnigmaTirpitz (@RequestBody MessageRequestModelToEnigmaTirpitz messageRequest){
        if(!DataValidationToEnigmaTirpitz.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaTirpitzEncrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmazahlwerkdefault")
    public ResponseEntity<?> EnigmaZahlwerk (@RequestBody MessageRequestModelToEnigmaZahlwerk messageRequest){
        if(!DataValidationToEnigmaZahlwerk.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaZahlwerkDefaultEncrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmazahlwerkg312")
    public ResponseEntity<?> EnigmaG312 (@RequestBody MessageRequestModelToEnigmaZahlwerk messageRequest){
        if(!DataValidationToEnigmaZahlwerk.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaZahlwerkG312Encrypter(messageRequest), HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmazahlwerkg260")
    public ResponseEntity<?> EnigmaG260 (@RequestBody MessageRequestModelToEnigmaZahlwerk messageRequest){
        if(!DataValidationToEnigmaZahlwerk.isMessageRequestModelValid(messageRequest)) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(Encrypter.EnigmaZahlwerkG260Encrypter(messageRequest), HttpStatus.OK);
    }
    
}
