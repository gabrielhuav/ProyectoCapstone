#include <SPI.h>               //Sensor RFID-RC522.
#include <MFRC522.h>

//Definmos el sensor RFID
#define RST_PIN         2        // Pin RST.
#define SS_PIN          4        // Pin SDA.
MFRC522 mfrc522(SS_PIN, RST_PIN);  // Creamos un objeto a  el sensor MFRC522.

// Funcion del sensor RFID, nos devuelve el id en formato decimal.
unsigned long getID(){
  if ( ! mfrc522.PICC_ReadCardSerial()) { 
    return -1;
  }
  unsigned long hex_num;
  hex_num =  mfrc522.uid.uidByte[0] << 24;
  hex_num += mfrc522.uid.uidByte[1] << 16;
  hex_num += mfrc522.uid.uidByte[2] <<  8;
  hex_num += mfrc522.uid.uidByte[3];
  mfrc522.PICC_HaltA(); 
  return hex_num;
}

//Funcion RFID
void Fun_RFID() {
    unsigned long uid = getID();      // Numero de identificacion en formato decimal.

    if(uid != -1){                    // Comprobamos que la lectura de la tarjeta sea correcta 
      Serial.println("El numero de identificacion de tu tarjeta RFID es :");Serial.println(uid);
    }
}

void setup() {
    Serial.begin(9600); //Se inicia el monitor serie a 9600 baudios.

    //Iniciamos sensor RFID
    SPI.begin();        // Iniciamos el bus SPI.
    mfrc522.PCD_Init(); // Iniciamos el objeto MFRC522.
    delay(4);           // Le damos tiempo para que se inicie. 
    mfrc522.PCD_DumpVersionToSerial(); //Opcional, mostramos detalles de las tarjetas MFRC522.
} 

void loop() {
    if(mfrc522.PICC_IsNewCardPresent()) {
       Fun_RFID();
    }  
}
