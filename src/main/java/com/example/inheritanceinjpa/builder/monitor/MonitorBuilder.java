package com.example.inheritanceinjpa.builder.monitor;

import com.example.inheritanceinjpa.builder.prod.ProductBuilder;
import com.example.inheritanceinjpa.entity.Monitor;

import java.util.Set;

public interface MonitorBuilder extends ProductBuilder<Monitor> {
    MonitorBuilder screenSize(double screenSize);
    MonitorBuilder resolution(String resolution);
    MonitorBuilder touchScreen(boolean touchScreen);
    MonitorBuilder panelType(Monitor.EPanel panelType);
    MonitorBuilder refreshRate(int refreshRate);
    MonitorBuilder eyeCareTechnology(boolean eyeCareTechnology);
    MonitorBuilder brightness(int brightness);
    MonitorBuilder hdrSupported(boolean hdrSupported);
    MonitorBuilder builtInSpeakers(boolean builtInSpeakers);
    MonitorBuilder powerConsumption(double powerConsumption);
    MonitorBuilder weight(double weight);
    MonitorBuilder connections(Set<Monitor.EConnection> connections);
}
