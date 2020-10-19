package models;

import com.fazecast.jSerialComm.*;

import java.util.ArrayList;

public class ConnectDeviceModel {
    private final SerialPort[] ports;
    private SerialPort chosenPort;

    public ConnectDeviceModel() {
        this.ports = SerialPort.getCommPorts();
    }

    public ArrayList<String> getAvailablePorts() {
        ArrayList<String> portList = new ArrayList<>();
        for (SerialPort port : this.ports) {
            portList.add(port.getSystemPortName());
        }
        return portList;
    }

    public void selectPort(String portName) {
        this.chosenPort = SerialPort.getCommPort(portName);
    }

    public SerialPort getSelectedPort() {
        return this.chosenPort;
    }

}
