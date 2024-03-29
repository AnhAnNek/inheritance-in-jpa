package com.example.inheritanceinjpa.entity;

import com.example.inheritanceinjpa.customenum.ECategory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

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

    @ElementCollection(fetch = FetchType.EAGER, targetClass = ECompatibility.class)
    @CollectionTable(name = "keyboard_compatibilities", joinColumns = @JoinColumn(name = "keyboard_comp_id"))
    @Enumerated(EnumType.STRING)
    private Set<ECompatibility> compatibilities;

    @ElementCollection(fetch = FetchType.EAGER, targetClass = EConnection.class)
    @CollectionTable(name = "keyboard_connections", joinColumns = @JoinColumn(name = "keyboard_conn_id"))
    @Enumerated(EnumType.STRING)
    private Set<EConnection> connections;

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
                              int releaseYear, Set<ECompatibility> compatibilities, Set<EConnection> connections,
                              String cableLength, String switchType, ELayout layout, int keyCount,
                              String keycapMaterial, String batteryType) {
        super(brand, model, desc, price, stockQty, discountPercent, version, color, category, releaseYear);
        this.compatibilities = compatibilities;
        this.connections = connections;
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
                "compatibilities=" + compatibilities +
                ", connections=" + connections +
                ", cableLength='" + cableLength + '\'' +
                ", switchType='" + switchType + '\'' +
                ", layout=" + layout +
                ", keyCount=" + keyCount +
                ", keycapMaterial='" + keycapMaterial + '\'' +
                ", batteryType='" + batteryType + '\'' +
                ", superClass=" + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MechanicalKeyboard that = (MechanicalKeyboard) o;

        if (keyCount != that.keyCount) return false;
        if (compatibilities != that.compatibilities) return false;
        if (connections != that.connections) return false;
        if (!Objects.equals(cableLength, that.cableLength)) return false;
        if (!Objects.equals(switchType, that.switchType)) return false;
        if (layout != that.layout) return false;
        if (!Objects.equals(keycapMaterial, that.keycapMaterial))
            return false;
        return Objects.equals(batteryType, that.batteryType);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (compatibilities != null ? compatibilities.hashCode() : 0);
        result = 31 * result + (connections != null ? connections.hashCode() : 0);
        result = 31 * result + (cableLength != null ? cableLength.hashCode() : 0);
        result = 31 * result + (switchType != null ? switchType.hashCode() : 0);
        result = 31 * result + (layout != null ? layout.hashCode() : 0);
        result = 31 * result + keyCount;
        result = 31 * result + (keycapMaterial != null ? keycapMaterial.hashCode() : 0);
        result = 31 * result + (batteryType != null ? batteryType.hashCode() : 0);
        return result;
    }

    public Set<ECompatibility> getCompatibility() {
        return compatibilities;
    }

    public void setCompatibilities(Set<ECompatibility> compatibilities) {
        this.compatibilities = compatibilities;
    }

    public Set<EConnection> getConnectionType() {
        return connections;
    }

    public void setConnections(Set<EConnection> connections) {
        this.connections = connections;
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
