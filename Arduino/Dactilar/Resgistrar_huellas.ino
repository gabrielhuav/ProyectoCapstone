/***************************************************
  Progrma para el registro de huellas en el sensor.
 ****************************************************/

#include <Adafruit_Fingerprint.h>   // Libreria para el sensor de huellas dactilares.
#define mySerial Serial2            // Definimos los pines de conexion (GPIO16 ,GPIO17).
Adafruit_Fingerprint finger = Adafruit_Fingerprint(&mySerial); // Objeto  para el sensor de huellas dactilares.

uint8_t id; // Variable para asignar el id.

void setup(){
  Serial.begin(9600);
  while (!Serial);  
  delay(100);
  Serial.println("\n\nRegistro de huellas dactilares");

  // Establecemos la velocidad de datos para el puerto serie del sensor
  finger.begin(57600);

  if (finger.verifyPassword()) {
    Serial.println("¡Sensor de huellas dactilares encontrado!");
  } else {
    Serial.println("Sensor de huellas dactilares no encontrado :(");
    while (1) { delay(1); }
  }
}

uint8_t readnumber(void) {
  uint8_t num = 0;

  while (num == 0) {
    while (! Serial.available());
    num = Serial.parseInt();
  }
  return num;
}

void loop() {
  Serial.println("Listo para registrar una huella dactilar");
  Serial.println("Escriba el número de identificación (del 1 al 127) en el que desea guardar este dedo como...");
  id = readnumber();
  if (id == 0) { // ID # 0 no permitida, intente de nuevo!
     return;
  }
  Serial.print("Número de Identificación : ");
  Serial.println(id);

  while (!  getFingerprintEnroll() );
}

uint8_t getFingerprintEnroll() {

  int p = -1;
  Serial.print("Esperando un dedo válido para inscribir como #"); Serial.println(id);
  while (p != FINGERPRINT_OK) {
    p = finger.getImage();
    switch (p) {
    case FINGERPRINT_OK:
      Serial.println("Imagen tomada");
      break;
    case FINGERPRINT_NOFINGER:
      Serial.println(".");
      break;
    case FINGERPRINT_PACKETRECIEVEERR:
      Serial.println("Error de comunicació");
      break;
    case FINGERPRINT_IMAGEFAIL:
      Serial.println("Error de imagen");
      break;
    default:
      Serial.println("Error desconocido");
      break;
    }
  }

  // ok exito!

  p = finger.image2Tz(1);
  switch (p) {
    case FINGERPRINT_OK:
      Serial.println("Imagen convertida");
      break;
    case FINGERPRINT_IMAGEMESS:
      Serial.println("Imagen demasiado desordenada");
      return p;
    case FINGERPRINT_PACKETRECIEVEERR:
      Serial.println("Error de comunicación");
      return p;
    case FINGERPRINT_FEATUREFAIL:
      Serial.println("No se pudieron encontrar las características de la huella digital");
      return p;
    case FINGERPRINT_INVALIDIMAGE:
      Serial.println("No se pudieron encontrar las características de la huella digital");
      return p;
    default:
      Serial.println("Error desconocido");
      return p;
  }

  Serial.println("Quita el dedo");
  delay(2000);
  p = 0;
  while (p != FINGERPRINT_NOFINGER) {
    p = finger.getImage();
  }
  Serial.print("ID "); Serial.println(id);
  p = -1;
  Serial.println("Coloque el mismo dedo otra vez");
  while (p != FINGERPRINT_OK) {
    p = finger.getImage();
    switch (p) {
    case FINGERPRINT_OK:
      Serial.println("Imagen tomada");
      break;
    case FINGERPRINT_NOFINGER:
      Serial.print(".");
      break;
    case FINGERPRINT_PACKETRECIEVEERR:
      Serial.println("Error de comunicación");
      break;
    case FINGERPRINT_IMAGEFAIL:
      Serial.println("Error de imagen");
      break;
    default:
      Serial.println("Error desconocido");
      break;
    }
  }

  p = finger.image2Tz(2);
  switch (p) {
    case FINGERPRINT_OK:
      Serial.println("Imagen convertida");
      break;
    case FINGERPRINT_IMAGEMESS:
      Serial.println("Imagen demasiado desordenada");
      return p;
    case FINGERPRINT_PACKETRECIEVEERR:
      Serial.println("Error de comunicación");
      return p;
    case FINGERPRINT_FEATUREFAIL:
      Serial.println("No se pudieron encontrar las características de la huella digital");
      return p;
    case FINGERPRINT_INVALIDIMAGE:
      Serial.println("No se pudieron encontrar las características de la huella digital");
      return p;
    default:
      Serial.println("Error desconocido");
      return p;
  }

  // OK convertido!
  Serial.print("Creando modelo para #");  Serial.println(id);

  p = finger.createModel();
  if (p == FINGERPRINT_OK) {
    Serial.println("¡Estampados combinados!");
  } else if (p == FINGERPRINT_PACKETRECIEVEERR) {
    Serial.println("Error de comunacacion");
    return p;
  } else if (p == FINGERPRINT_ENROLLMISMATCH) {
    Serial.println("Las huellas dactilares no coinciden");
    return p;
  } else {
    Serial.println("Error desconocido");
    return p;
  }

  Serial.print("ID "); Serial.println(id);
  p = finger.storeModel(id);
  if (p == FINGERPRINT_OK) {
    Serial.println("¡Almacenada!");
  } else if (p == FINGERPRINT_PACKETRECIEVEERR) {
    Serial.println("Error de comunicación");
    return p;
  } else if (p == FINGERPRINT_BADLOCATION) {
    Serial.println("No se pudo almacenar en esa ubicación");
    return p;
  } else if (p == FINGERPRINT_FLASHERR) {
    Serial.println("Error al escribir en flash");
    return p;
  } else {
    Serial.println("Error desconocido");
    return p;
  }

  return true;
}
