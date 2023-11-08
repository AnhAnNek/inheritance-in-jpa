package com.example.inheritanceinjpa.entity;

import com.example.inheritanceinjpa.customenum.ECategory;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "mechanical_keyboards")
@PrimaryKeyJoinColumn(name = "id")
public class MechanicalKeyboard extends Product {
    public enum ECompatibility {
        WINDOWS,
        MAC_OS,
        LINUX
    }

    public enum EConnection {
        USB_RECEIVER,
        BLUETOOTH,
        WIRED
    }

    public enum ELayout {
        FULL_SIZE,
        TKL,
        COMPACT,
        ERGONOMIC
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "compatibility")
    private ECompatibility compatibility;
    @Enumerated(EnumType.STRING)
    @Column(name = "connection_type")
    private EConnection connectionType;
    @Column(name = "cable_length")
    private String cableLength;
    @Column(name = "switch_type")
    private String switchType;
    @Enumerated(EnumType.STRING)
    @Column(name = "keyboard_layout")
    private ELayout layout;
    @Column(name = "key_count")
    private int keyCount;
    @Column(name = "keycap_material")
    private String keycapMaterial;
    @Column(name = "battery_type")
    private String batteryType;

    public MechanicalKeyboard() {
        super();
    }

    public MechanicalKeyboard(String brand, String model, String desc, BigDecimal price, Integer stockQty,
                              double discountPercent, String version, String color, ECategory category,
                              int releaseYear, ECompatibility compatibility, EConnection connectionType,
                              String cableLength, String switchType, ELayout layout, int keyCount,
                              String keycapMaterial, String batteryType) {
        super(brand, model, desc, price, stockQty, discountPercent, version, color, category, releaseYear);
        this.compatibility = compatibility;
        this.connectionType = connectionType;
        this.cableLength = cableLength;
        this.switchType = switchType;
        this.layout = layout;
        this.keyCount = keyCount;
        this.keycapMaterial = keycapMaterial;
        this.batteryType = batteryType;
    }

    @Override
    public String toString() {
        return "MechanicalKeyboard{" +
                "compatibility=" + compatibility +
                ", connectionType=" + connectionType +
                ", cableLength='" + cableLength + '\'' +
                ", switchType='" + switchType + '\'' +
                ", layout=" + layout +
                ", keyCount=" + keyCount +
                ", keycapMaterial='" + keycapMaterial + '\'' +
                ", batteryType='" + batteryType + '\'' +
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

    public ECompatibility getCompatibility() {
        return compatibility;
    }

    public void setCompatibility(ECompatibility compatibility) {
        this.compatibility = compatibility;
    }

    public EConnection getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(EConnection connectionType) {
        this.connectionType = connectionType;
    }

    public String getCableLength() {
        return cableLength;
    }

    public void setCableLength(String cableLength) {
        this.cableLength = cableLength;
    }

    public String getSwitchType() {
        return switchType;
    }

    public void setSwitchType(String switchType) {
        this.switchType = switchType;
    }

    public ELayout getLayout() {
        return layout;
    }

    public void setLayout(ELayout layout) {
        this.layout = layout;
    }

    public int getKeyCount() {
        return keyCount;
    }

    public void setKeyCount(int keyCount) {
        this.keyCount = keyCount;
    }

    public String getKeycapMaterial() {
        return keycapMaterial;
    }

    public void setKeycapMaterial(String keycapMaterial) {
        this.keycapMaterial = keycapMaterial;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }
}
