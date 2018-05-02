#include <ArduinoJson.h>
#include <Firebase.h>
#include <FirebaseArduino.h>
#include <FirebaseCloudMessaging.h>
#include <FirebaseError.h>
#include <FirebaseHttpClient.h>
#include <FirebaseObject.h>

#include <ESP8266WiFi.h>

#define FIREBASE_HOST "*****YOUR FIREBASE HOST URL********"
#define FIREBASE_AUTH "*****YOUR FIREBASE AUTH CODE********"
#define WIFI_SSID "*****YOUR WIFI NAME********"
#define WIFI_PASSWORD "*****YOUR WIFI PASSWORD********"

const String VALVE = "lawn";
const String SECONDS = "lastOn_seconds";
const int valvePin = D7;
int seconds = 0;

void setup() {
  Serial.begin(9600);

  pinMode(valvePin, OUTPUT);
  digitalWrite(valvePin, LOW);

  // connect to wifi.
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("connecting");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(500);
  }
  
  Serial.println();
  Serial.print("connected: ");
  Serial.println(WiFi.localIP());

  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  Firebase.set(VALVE, false);
  Firebase.set(SECONDS, 0);
}

void loop() {
  digitalWrite(valvePin, Firebase.getBool(VALVE) && Firebase.success());
  
  seconds = (seconds + 1);
  Firebase.set(SECONDS, seconds);  

  delay(1000);
}


