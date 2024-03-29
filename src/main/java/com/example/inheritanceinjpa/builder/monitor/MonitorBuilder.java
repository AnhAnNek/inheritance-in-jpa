package com.example.inheritanceinjpa.builder.monitor;

import com.example.inheritanceinjpa.builder.prod.ProductBuilderImpl;
import com.example.inheritanceinjpa.entity.Monitor;

import java.util.Set;

public abstract class MonitorBuilder extends ProductBuilderImpl<Monitor> {
    public abstract MonitorBuilder screenSize(double screenSize);
    public abstract MonitorBuilder resolution(String resolution);
    public abstract MonitorBuilder touchScreen(boolean touchScreen);
    public abstract MonitorBuilder panelType(Monitor.EPanel panelType);
    public abstract MonitorBuilder refreshRate(int refreshRate);
    public abstract MonitorBuilder eyeCareTechnology(boolean eyeCareTechnology);
    public abstract MonitorBuilder brightness(int brightness);
    public abstract MonitorBuilder hdrSupported(boolean hdrSupported);
    public abstract MonitorBuilder builtInSpeakers(boolean builtInSpeakers);
    public abstract MonitorBuilder powerConsumption(double powerConsumption);
    public abstract MonitorBuilder weight(double weight);
    public abstract MonitorBuilder connections(Set<Monitor.EConnection> connections);
}
