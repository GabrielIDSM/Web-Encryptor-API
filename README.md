# Web Encryptor API (Spring Boot Application)

## Deploy (Heroku)

https://encryptorapi-gabrielidsm.herokuapp.com/

## Requests Model (JSON)

### Enigma 1 with plugboard ( .../enigmaone )
```
{
  "message":[String] message here,
  "rotorOne":[Integer] choice from 1 to 3,
  "rotorTwo":[Integer] choice from 1 to 3,
  "rotorThree":[Integer] choice from 1 to 3,
  "rotorOneWheelSet":[Integer] choice from 1 to 26,
  "rotorTwoWheelSet":[Integer] choice from 1 to 26,
  "rotorThreeWheelSet":[Integer] choice from 1 to 26,
  "plugOneA" : [Integer] choice from 0 to 25,
  "plugOneB" : [Integer] choice from 0 to 25,
  "plugTwoA" : [Integer] choice from 0 to 25,
  "plugTwoB" : [Integer] choice from 0 to 25,
  "plugThreeA" : [Integer] choice from 0 to 25,
  "plugThreeB" : [Integer] choice from 0 to 25,
  "plugFourA" : [Integer] choice from 0 to 25,
  "plugFourB" : [Integer] choice from 0 to 25,
  "plugFiveA" : [Integer] choice from 0 to 25,
  "plugFiveB" : [Integer] choice from 0 to 25,
  "plugSixA" : [Integer] choice from 0 to 25,
  "plugSixB" : [Integer] choice from 0 to 25,
  "plugSevenA" : [Integer] choice from 0 to 25,
  "plugSevenB" : [Integer] choice from 0 to 25,
  "plugEightA" : [Integer] choice from 0 to 25,
  "plugEightB" : [Integer] choice from 0 to 25,
  "plugNineA" : [Integer] choice from 0 to 25,
  "plugNineB" : [Integer] choice from 0 to 25,
  "plugTenA" : [Integer] choice from 0 to 25,
  "plugTenB" : [Integer] choice from 0 to 25
}
```
### Enigma M3 with plugboard/6 plugs ( .../enigmamthreearmywithsixplugs )
```
{
  "message":[String] message here,
  "rotorOne":[Integer] choice from 1 to 5,
  "rotorTwo":[Integer] choice from 1 to 5,
  "rotorThree":[Integer] choice from 1 to 5,
  "rotorOneWheelSet":[Integer] choice from 1 to 26,
  "rotorTwoWheelSet":[Integer] choice from 1 to 26,
  "rotorThreeWheelSet":[Integer] choice from 1 to 26,
  "plugOneA" : [Integer] choice from 0 to 25,
  "plugOneB" : [Integer] choice from 0 to 25,
  "plugTwoA" : [Integer] choice from 0 to 25,
  "plugTwoB" : [Integer] choice from 0 to 25,
  "plugThreeA" : [Integer] choice from 0 to 25,
  "plugThreeB" : [Integer] choice from 0 to 25,
  "plugFourA" : [Integer] choice from 0 to 25,
  "plugFourB" : [Integer] choice from 0 to 25,
  "plugFiveA" : [Integer] choice from 0 to 25,
  "plugFiveB" : [Integer] choice from 0 to 25,
  "plugSixA" : [Integer] choice from 0 to 25,
  "plugSixB" : [Integer] choice from 0 to 25
}
```
### Enigma M3 with plugboard ( .../enigmamthreearmywithtenplugs )
```
{
  "message":[String] message here,
  "rotorOne":[Integer] choice from 1 to 5,
  "rotorTwo":[Integer] choice from 1 to 5,
  "rotorThree":[Integer] choice from 1 to 5,
  "rotorOneWheelSet":[Integer] choice from 1 to 26,
  "rotorTwoWheelSet":[Integer] choice from 1 to 26,
  "rotorThreeWheelSet":[Integer] choice from 1 to 26,
  "plugOneA" : [Integer] choice from 0 to 25,
  "plugOneB" : [Integer] choice from 0 to 25,
  "plugTwoA" : [Integer] choice from 0 to 25,
  "plugTwoB" : [Integer] choice from 0 to 25,
  "plugThreeA" : [Integer] choice from 0 to 25,
  "plugThreeB" : [Integer] choice from 0 to 25,
  "plugFourA" : [Integer] choice from 0 to 25,
  "plugFourB" : [Integer] choice from 0 to 25,
  "plugFiveA" : [Integer] choice from 0 to 25,
  "plugFiveB" : [Integer] choice from 0 to 25,
  "plugSixA" : [Integer] choice from 0 to 25,
  "plugSixB" : [Integer] choice from 0 to 25,
  "plugSevenA" : [Integer] choice from 0 to 25,
  "plugSevenB" : [Integer] choice from 0 to 25,
  "plugEightA" : [Integer] choice from 0 to 25,
  "plugEightB" : [Integer] choice from 0 to 25,
  "plugNineA" : [Integer] choice from 0 to 25,
  "plugNineB" : [Integer] choice from 0 to 25,
  "plugTenA" : [Integer] choice from 0 to 25,
  "plugTenB" : [Integer] choice from 0 to 25
}
```
### Enigma M3 Naval with plugboard and 7 rotors available ( .../enigmamthreenavalsevenrotorsmodel )
```
{
  "message":[String] message here,
  "rotorOne":[Integer] choice from 1 to 7,
  "rotorTwo":[Integer] choice from 1 to 7,
  "rotorThree":[Integer] choice from 1 to 7,
  "rotorOneWheelSet":[Integer] choice from 1 to 26,
  "rotorTwoWheelSet":[Integer] choice from 1 to 26,
  "rotorThreeWheelSet":[Integer] choice from 1 to 26,
  "plugOneA" : [Integer] choice from 0 to 25,
  "plugOneB" : [Integer] choice from 0 to 25,
  "plugTwoA" : [Integer] choice from 0 to 25,
  "plugTwoB" : [Integer] choice from 0 to 25,
  "plugThreeA" : [Integer] choice from 0 to 25,
  "plugThreeB" : [Integer] choice from 0 to 25,
  "plugFourA" : [Integer] choice from 0 to 25,
  "plugFourB" : [Integer] choice from 0 to 25,
  "plugFiveA" : [Integer] choice from 0 to 25,
  "plugFiveB" : [Integer] choice from 0 to 25,
  "plugSixA" : [Integer] choice from 0 to 25,
  "plugSixB" : [Integer] choice from 0 to 25,
  "plugSevenA" : [Integer] choice from 0 to 25,
  "plugSevenB" : [Integer] choice from 0 to 25,
  "plugEightA" : [Integer] choice from 0 to 25,
  "plugEightB" : [Integer] choice from 0 to 25,
  "plugNineA" : [Integer] choice from 0 to 25,
  "plugNineB" : [Integer] choice from 0 to 25,
  "plugTenA" : [Integer] choice from 0 to 25,
  "plugTenB" : [Integer] choice from 0 to 25
}
```
### Enigma M3 Naval with plugboard and 8 rotors available ( .../enigmamthreenavaleightrotorsmodel )
```
{
  "message":[String] message here,
  "rotorOne":[Integer] choice from 1 to 8,
  "rotorTwo":[Integer] choice from 1 to 8,
  "rotorThree":[Integer] choice from 1 to 8,
  "rotorOneWheelSet":[Integer] choice from 1 to 26,
  "rotorTwoWheelSet":[Integer] choice from 1 to 26,
  "rotorThreeWheelSet":[Integer] choice from 1 to 26,
  "plugOneA" : [Integer] choice from 0 to 25,
  "plugOneB" : [Integer] choice from 0 to 25,
  "plugTwoA" : [Integer] choice from 0 to 25,
  "plugTwoB" : [Integer] choice from 0 to 25,
  "plugThreeA" : [Integer] choice from 0 to 25,
  "plugThreeB" : [Integer] choice from 0 to 25,
  "plugFourA" : [Integer] choice from 0 to 25,
  "plugFourB" : [Integer] choice from 0 to 25,
  "plugFiveA" : [Integer] choice from 0 to 25,
  "plugFiveB" : [Integer] choice from 0 to 25,
  "plugSixA" : [Integer] choice from 0 to 25,
  "plugSixB" : [Integer] choice from 0 to 25,
  "plugSevenA" : [Integer] choice from 0 to 25,
  "plugSevenB" : [Integer] choice from 0 to 25,
  "plugEightA" : [Integer] choice from 0 to 25,
  "plugEightB" : [Integer] choice from 0 to 25,
  "plugNineA" : [Integer] choice from 0 to 25,
  "plugNineB" : [Integer] choice from 0 to 25,
  "plugTenA" : [Integer] choice from 0 to 25,
  "plugTenB" : [Integer] choice from 0 to 25
}
```
### Enigma M4 with plugboard and 4 rotors ( .../enigmamfourwithplugboardandfourrotors )
```
{
  "message":[String] message here,
  "rotorOne":[Integer] choice from 1 to 8,
  "rotorTwo":[Integer] choice from 1 to 8,
  "rotorThree":[Integer] choice from 1 to 8,
  "rotorFour":[Integer] choice 1 or 2,
  "rotorOneWheelSet":[Integer] choice from 1 to 26,
  "rotorTwoWheelSet":[Integer] choice from 1 to 26,
  "rotorThreeWheelSet":[Integer] choice from 1 to 26,
  "rotorFourWheelSet":[Integer] choice from 1 to 26,
  "plugOneA" : [Integer] choice from 0 to 25,
  "plugOneB" : [Integer] choice from 0 to 25,
  "plugTwoA" : [Integer] choice from 0 to 25,
  "plugTwoB" : [Integer] choice from 0 to 25,
  "plugThreeA" : [Integer] choice from 0 to 25,
  "plugThreeB" : [Integer] choice from 0 to 25,
  "plugFourA" : [Integer] choice from 0 to 25,
  "plugFourB" : [Integer] choice from 0 to 25,
  "plugFiveA" : [Integer] choice from 0 to 25,
  "plugFiveB" : [Integer] choice from 0 to 25,
  "plugSixA" : [Integer] choice from 0 to 25,
  "plugSixB" : [Integer] choice from 0 to 25,
  "plugSevenA" : [Integer] choice from 0 to 25,
  "plugSevenB" : [Integer] choice from 0 to 25,
  "plugEightA" : [Integer] choice from 0 to 25,
  "plugEightB" : [Integer] choice from 0 to 25,
  "plugNineA" : [Integer] choice from 0 to 25,
  "plugNineB" : [Integer] choice from 0 to 25,
  "plugTenA" : [Integer] choice from 0 to 25,
  "plugTenB" : [Integer] choice from 0 to 25
}
```
### Enigma M4 with plugboard and 3 rotors ( .../enigmamfourwithplugboardandthreerotors )
```
{
  "message":[String] message here,
  "reflector":[Integer] choice from 1 to 3,
  "rotorOne":[Integer] choice from 1 to 8,
  "rotorTwo":[Integer] choice from 1 to 8,
  "rotorThree":[Integer] choice from 1 to 8,
  "rotorFour":[Integer] choice 1 or 2,
  "rotorOneWheelSet":[Integer] choice from 1 to 26,
  "rotorTwoWheelSet":[Integer] choice from 1 to 26,
  "rotorThreeWheelSet":[Integer] choice from 1 to 26,
  "rotorFourWheelSet":[Integer] choice from 1 to 26,
  "plugOneA" : [Integer] choice from 0 to 25,
  "plugOneB" : [Integer] choice from 0 to 25,
  "plugTwoA" : [Integer] choice from 0 to 25,
  "plugTwoB" : [Integer] choice from 0 to 25,
  "plugThreeA" : [Integer] choice from 0 to 25,
  "plugThreeB" : [Integer] choice from 0 to 25,
  "plugFourA" : [Integer] choice from 0 to 25,
  "plugFourB" : [Integer] choice from 0 to 25,
  "plugFiveA" : [Integer] choice from 0 to 25,
  "plugFiveB" : [Integer] choice from 0 to 25,
  "plugSixA" : [Integer] choice from 0 to 25,
  "plugSixB" : [Integer] choice from 0 to 25,
  "plugSevenA" : [Integer] choice from 0 to 25,
  "plugSevenB" : [Integer] choice from 0 to 25,
  "plugEightA" : [Integer] choice from 0 to 25,
  "plugEightB" : [Integer] choice from 0 to 25,
  "plugNineA" : [Integer] choice from 0 to 25,
  "plugNineB" : [Integer] choice from 0 to 25,
  "plugTenA" : [Integer] choice from 0 to 25,
  "plugTenB" : [Integer] choice from 0 to 25
}
```
### Enigma M4 with plugboard and UKWD ( .../enigmamfourwithplugboardandukwd )
```
{
  "message":[String] message here,
  "rotorOne":[Integer] choice from 1 to 8,
  "rotorTwo":[Integer] choice from 1 to 8,
  "rotorThree":[Integer] choice from 1 to 8,
  "rotorOneWheelSet":[Integer] choice from 1 to 26,
  "rotorTwoWheelSet":[Integer] choice from 1 to 26,
  "rotorThreeWheelSet":[Integer] choice from 1 to 26,
  "plugOneA" : [Integer] choice from 0 to 25,
  "plugOneB" : [Integer] choice from 0 to 25,
  "plugTwoA" : [Integer] choice from 0 to 25,
  "plugTwoB" : [Integer] choice from 0 to 25,
  "plugThreeA" : [Integer] choice from 0 to 25,
  "plugThreeB" : [Integer] choice from 0 to 25,
  "plugFourA" : [Integer] choice from 0 to 25,
  "plugFourB" : [Integer] choice from 0 to 25,
  "plugFiveA" : [Integer] choice from 0 to 25,
  "plugFiveB" : [Integer] choice from 0 to 25,
  "plugSixA" : [Integer] choice from 0 to 25,
  "plugSixB" : [Integer] choice from 0 to 25,
  "plugSevenA" : [Integer] choice from 0 to 25,
  "plugSevenB" : [Integer] choice from 0 to 25,
  "plugEightA" : [Integer] choice from 0 to 25,
  "plugEightB" : [Integer] choice from 0 to 25,
  "plugNineA" : [Integer] choice from 0 to 25,
  "plugNineB" : [Integer] choice from 0 to 25,
  "plugTenA" : [Integer] choice from 0 to 25,
  "plugTenB" : [Integer] choice from 0 to 25,
  "reflectorOneA" : [Integer] choice from 0 to 23,
  "reflectorOneB" : [Integer] choice from 0 to 23,
  "reflectorTwoA" : [Integer] choice from 0 to 23,
  "reflectorTwoB" : [Integer] choice from 0 to 23,
  "reflectorThreeA" : [Integer] choice from 0 to 23,
  "reflectorThreeB" : [Integer] choice from 0 to 23,
  "reflectorFourA" : [Integer] choice from 0 to 23,
  "reflectorFourB" : [Integer] choice from 0 to 23,
  "reflectorFiveA" : [Integer] choice from 0 to 23,
  "reflectorFiveB" : [Integer] choice from 0 to 23,
  "reflectorSixA" : [Integer] choice from 0 to 23,
  "reflectorSixB" : [Integer] choice from 0 to 23,
  "reflectorSevenA" : [Integer] choice from 0 to 23,
  "reflectorSevenB" : [Integer] choice from 0 to 23,
  "reflectorEightA" : [Integer] choice from 0 to 23,
  "reflectorEightB" : [Integer] choice from 0 to 23,
  "reflectorNineA" : [Integer] choice from 0 to 23,
  "reflectorNineB" : [Integer] choice from 0 to 23,
  "reflectorTenA" : [Integer] choice from 0 to 23,
  "reflectorTenB" : [Integer] choice from 0 to 23,
  "reflectorElevenA" : [Integer] choice from 0 to 23,
  "reflectorElevenB" : [Integer] choice from 0 to 23,
  "reflectorTwelveA" : [Integer] choice from 0 to 23,
  "reflectorTwelveB" : [Integer] choice from 0 to 23
}
```
### Enigma Swiss-K Commercial ( .../enigmaswisskcommercial ) / Enigma Swiss-K Air Force ( .../enigmaswisskairforce ) / Enigma Railway ( .../enigmarailway ) / Enigma Zahlwerk ( .../enigmazahlwerk )
```
{
  "message":[String] message here,
  "rotorOne":[Integer] choice from 1 to 3,
  "rotorTwo":[Integer] choice from 1 to 3,
  "rotorThree":[Integer] choice from 1 to 3,
  "rotorOneWheelSet":[Integer] choice from 1 to 26,
  "rotorTwoWheelSet":[Integer] choice from 1 to 26,
  "rotorThreeWheelSet":[Integer] choice from 1 to 26,
  "reflectorWheelSet":[Integer] choice from 1 to 26
}
```
### Enigma Tirpitz ( .../enigmastirpitz )
```
{
  "message":[String] message here,
  "rotorOne":[Integer] choice from 1 to 8,
  "rotorTwo":[Integer] choice from 1 to 8,
  "rotorThree":[Integer] choice from 1 to 8,
  "rotorOneWheelSet":[Integer] choice from 1 to 26,
  "rotorTwoWheelSet":[Integer] choice from 1 to 26,
  "rotorThreeWheelSet":[Integer] choice from 1 to 26,
  "reflectorWheelSet":[Integer] choice from 1 to 26
}
```

## Response Model

```
{
  "message":[String] message
}
```

## Team

Web Encryptor is a project created by Gabriel Inácio ([Github](https://github.com/GabrielIDSM)/[LinkedIn](https://www.linkedin.com/in/gabriel-inacio-uff/))

## Contact

E-mail: gabrielinacio@id.uff.br
