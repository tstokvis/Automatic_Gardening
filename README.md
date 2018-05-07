# Automatic Gardening

Arduino system controls a solenoid valve via a Android companion application.

### Parts Needed
* 12 Volt Power Source
* [LinkSprite LinkNode D1 Arduino-Compatible WiFi Development Board](https://www.mouser.com/new/linksprite/linksprite-linknode-d1/)
* [IRLB8721 Power MOSFET](https://cdn-shop.adafruit.com/datasheets/irlb8721pbf.pdf)
* [Water Solenoid Valve](https://www.amazon.ca/Adafruit-997-Water-Solenoid-Valve/dp/B00K0TKJCU/ref=sr_1_13?ie=UTF8&qid=1525289998&sr=8-13&keywords=solenoid+valve)
* [Power Jack Adapter](https://www.amazon.ca/OSEPP-Barrel-Adapter-Female-Components-LS-00015/dp/B00EFZV24Y/ref=sr_1_3?ie=UTF8&qid=1525290639&sr=8-3&keywords=power+adapter+jack+arduino)


### Setup

1. [Arduino Code](https://github.com/tstokvis/Automatic_Gardening/blob/master/Arduino%20Code/WaterSys/WaterSys.ino): this can be uploaded via the [Arduino IDE](https://www.arduino.cc/en/Main/Software). For information on how to connect to WiFi using the LinkNode D1 module, visit [linksprite.com](http://www.linksprite.com/wiki/index.php5?title=LinkNode_D1) for help. You'll also need to setup your own Gooogle Firebase and connect it with the [Arduino core for ESP8266 WiFi chip library](https://github.com/esp8266/Arduino) 

2. [Android Companion App](https://github.com/tstokvis/Automatic_Gardening/tree/master/GardenControl): from Android Studio, connect to your Firebase application that you created by going to  
Tools->Firebase.


### Diagram

The hardware is setup according to the diagram below:

![Water System Layout](https://github.com/tstokvis/Automatic_Gardening/blob/master/GardeningSystem.png)
