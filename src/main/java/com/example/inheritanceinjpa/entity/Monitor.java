package com.example.inheritanceinjpa.entity;

import com.example.inheritanceinjpa.customenum.ECategory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "monitors")
@PrimaryKeyJoinColumn(name = "id")
public class Monitor extends Product{
    public enum EPanel {
        IPS,
        TN,
        OLED
    }

    public enum EConnection {
        HDMI,
        DisplayPort,
        USB_C,
        VGA,
        Thunderbolt
    }

    @Column(name = "screen_size")
    private double screenSize;
    @Column(name = "resolution")
    private String resolution;
    @Column(name = "touch_screen")
    private boolean touchScreen;
    @Column(name = "panel_type")
    @Enumerated(EnumType.STRING)
    private EPanel panelType;
    @Column(name = "refresh_rate")
    private int refreshRate;
    @Column(name = "eye_care_technology")
    private boolean eyeCareTechnology;
    private int brightness;
    @Column(name = "hdr_supported")
    private boolean hdrSupported;
    @Column(name = "built_in_speakers")
    private boolean builtInSpeakers;
    @Column(name = "power_consumption")
    private double powerConsumption;
    private double weight;

    @ElementCollection(targetClass = EConnection.class)
    @CollectionTable(name = "monitor_connections", joinColumns = @JoinColumn(name = "monitor_id"))
    @Enumerated(EnumType.STRING)
    private Set<EConnection> connections;

    public Monitor() {
        super();
    }

    public Monitor(String brand, String model, String desc, BigDecimal price, Integer stockQty,
                   double discountPercent, String version, String color, ECategory category, int releaseYear,
                   double screenSize, String resolution, boolean touchScreen, EPanel panelType, int refreshRate,
                   boolean eyeCareTechnology, int brightness, boolean hdrSupported, boolean builtInSpeakers,
                   double powerConsumption, double weight, Set<EConnection> connections) {
        super(brand, model, desc, price, stockQty, discountPercent, version, color, category, releaseYear);
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.touchScreen = touchScreen;
        this.panelType = panelType;
        this.refreshRate = refreshRate;
        this.eyeCareTechnology = eyeCareTechnology;
        this.brightness = brightness;
        this.hdrSupported = hdrSupported;
        this.builtInSpeakers = builtInSpeakers;
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.connections = connections;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "screenSize=" + screenSize +
                ", resolution='" + resolution + '\'' +
                ", touchScreen=" + touchScreen +
                ", panelType=" + panelType +
                ", refreshRate=" + refreshRate +
                ", eyeCareTechnology=" + eyeCareTechnology +
                ", brightness=" + brightness +
                ", hdrSupported=" + hdrSupported +
                ", builtInSpeakers=" + builtInSpeakers +
                ", powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", connections=" + connections +
                ", id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", stockQty=" + stockQty +
                ", discountPercent=" + discountPercent +
                ", version='" + version + '\'' +
                ", color='" + color + '\'' +
                ", releaseYear=" + releaseYear +
                ", category=" + category +
                '}';
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public boolean isTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(boolean touchScreen) {
        this.touchScreen = touchScreen;
    }

    public EPanel getPanelType() {
        return panelType;
    }

    public void setPanelType(EPanel panelType) {
        this.panelType = panelType;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public boolean isEyeCareTechnology() {
        return eyeCareTechnology;
    }

    public void setEyeCareTechnology(boolean eyeCareTechnology) {
        this.eyeCareTechnology = eyeCareTechnology;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public boolean isHdrSupported() {
        return hdrSupported;
    }

    public void setHdrSupported(boolean hdrSupported) {
        this.hdrSupported = hdrSupported;
    }

    public boolean isBuiltInSpeakers() {
        return builtInSpeakers;
    }

    public void setBuiltInSpeakers(boolean builtInSpeakers) {
        this.builtInSpeakers = builtInSpeakers;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Set<EConnection> getConnections() {
        return connections;
    }

    public void setConnections(Set<EConnection> connections) {
        this.connections = connections;
    }
}
