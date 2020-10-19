package controllers;

import com.fazecast.jSerialComm.SerialPort;
import models.ConnectDeviceModel;

import java.util.ArrayList;

public class ConnectDeviceController {

    private final ConnectDeviceModel deviceModel;

    public ConnectDeviceController(ConnectDeviceModel deviceModel) {
        this.deviceModel = deviceModel;
    }

    public void selectPort(String port) {
        this.deviceModel.selectPort(port);
    }

    public ArrayList<String> getAvailablePorts() {
        return this.deviceModel.getAvailablePorts();
    }

    public SerialPort getSelectedPort() {
        return this.deviceModel.getSelectedPort();
    }

}
