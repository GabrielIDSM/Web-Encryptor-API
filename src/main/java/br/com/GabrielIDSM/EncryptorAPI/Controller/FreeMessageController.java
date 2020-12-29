package br.com.GabrielIDSM.EncryptorAPI.Controller;

import br.com.GabrielIDSM.EncryptorAPI.Error.ResourceNotFoundException;
import br.com.GabrielIDSM.EncryptorAPI.LogicalTier.Encrypter;
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
import br.com.GabrielIDSM.EncryptorAPI.Model.MessageResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("free")
public class FreeMessageController {
    @PostMapping(path = "enigmamthreearmywithsixplugs")
    public ResponseEntity<?> EnigmaM3ArmyWithSixPlugs (@RequestBody MessageRequestModelToEnigmaM3ArmyWithSixPlugs messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaM3ArmyWithSixPlugsEncrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamthreearmywithtenplugs")
    public ResponseEntity<?> EnigmaM3ArmyWithTenPlugs (@RequestBody MessageRequestModelToEnigmaM3ArmyWithTenPlugs messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaM3ArmyWithTenPlugsEncrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamthreenavalsevenrotorsmodel")
    public ResponseEntity<?> EnigmaM3NavalSevenRotorsModel (@RequestBody MessageRequestModelToEnigmaM3Naval messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaM3NavalEncrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamthreenavaleightrotorsmodel")
    public ResponseEntity<?> EnigmaM3NavalEightRotorsModel (@RequestBody MessageRequestModelToEnigmaM3Naval messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaM3NavalEncrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmaone")
    public ResponseEntity<?> EnigmaOne (@RequestBody MessageRequestModelToEnigmaOne messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaOneEncrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamfourwithplugboardandfourrotors")
    public ResponseEntity<?> EnigmaM4WithPlugboardAndFourRotors (@RequestBody MessageRequestModelToEnigmaM4WithPlugboardAndFourRotors messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaM4WithFourRotorsEncrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamfourwithplugboardandthreerotors")
    public ResponseEntity<?> EnigmaM4WithPlugboardAndThreeRotors (@RequestBody MessageRequestModelToEnigmaM4WithPlugboardAndThreeRotors messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaM4WithThreeRotorsEncrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmaswisskcommercial")
    public ResponseEntity<?> EnigmaSwissKCommercial (@RequestBody MessageRequestModelToEnigmaSwissK messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaSwissKCommercialEncrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmaswisskairforce")
    public ResponseEntity<?> EnigmaSwissKAirForce (@RequestBody MessageRequestModelToEnigmaSwissK messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaSwissKAirForceEncrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmamfourwithplugboardandukwd")
    public ResponseEntity<?> EnigmaM4WithPlugboardAndUKWD (@RequestBody MessageRequestModelToEnigmaM4WithPlugboardAndUKWD messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaM4WithPlugboardAndUKWDEncrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmarailway")
    public ResponseEntity<?> EnigmaRailway (@RequestBody MessageRequestModelToEnigmaRailway messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaRailwayEncrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmatirpitz")
    public ResponseEntity<?> EnigmaTirpitz (@RequestBody MessageRequestModelToEnigmaTirpitz messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaTirpitzEncrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmazahlwerkdefault")
    public ResponseEntity<?> EnigmaZahlwerk (@RequestBody MessageRequestModelToEnigmaZahlwerk messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaZahlwerkDefaultEncrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmazahlwerkg312")
    public ResponseEntity<?> EnigmaG312 (@RequestBody MessageRequestModelToEnigmaZahlwerk messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaZahlwerkG312Encrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
    @PostMapping(path = "enigmazahlwerkg260")
    public ResponseEntity<?> EnigmaG260 (@RequestBody MessageRequestModelToEnigmaZahlwerk messageRequest){
        MessageResponseModel Response;
        try {
            Response = Encrypter.EnigmaZahlwerkG260Encrypter(messageRequest);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }
    
}