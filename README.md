# Self Balancing Robot based on Arduino

### This project includes:
- Graphical User Interface to display data from Arduino through serial port
- Arduino code running on Arduino board to control data sending and self balancing
- Arduino wiring schematics for sensors and motors

### Task list:

Graphical User Interface in Java using JavaFX:
- [x] create MVC project structure
- [ ] allow user to set basic configuration like baud rate, **port**, theme, language etc.
- [ ] write code to obtain data from serial port from Arduino
- [ ] write code to visualize data in the form of line charts, pie charts etc.

Arduino code running on the Arduino Nano:
- [ ] using NRF24 module for wireless communication with Arduino Uno also using NRF24
- [ ] sending data to serial port
- [ ] sending data to Arduino Uno
- [ ] controlling Arduino Uno with joystick sensor

Arduino code running on the Arduino Uno:
- [ ] implement self balancing mechanism for two stepper motors
- [ ] obtain data from MPU-6050 sensors
- [ ] send gyroscope and accelerometer data to Arduino Nano
- [ ] receive data from Arduino Nano 