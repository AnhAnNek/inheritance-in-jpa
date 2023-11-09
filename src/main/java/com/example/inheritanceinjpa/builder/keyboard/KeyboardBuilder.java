package com.example.inheritanceinjpa.builder.keyboard;

import com.example.inheritanceinjpa.builder.prod.ProductBuilder;
import com.example.inheritanceinjpa.entity.Laptop;
import com.example.inheritanceinjpa.entity.MechanicalKeyboard;

import java.util.Set;

public interface KeyboardBuilder extends ProductBuilder<MechanicalKeyboard> {
    KeyboardBuilder compatibilities(Set<MechanicalKeyboard.ECompatibility> compatibilities);
    KeyboardBuilder connections(Set<MechanicalKeyboard.EConnection> connections);
    KeyboardBuilder cableLength(String cableLength);
    KeyboardBuilder switchType(String switchType);
    KeyboardBuilder layout(MechanicalKeyboard.ELayout layout);
    KeyboardBuilder keyCount(int keyCount);
    KeyboardBuilder keycapMaterial(String keycapMaterial);
    KeyboardBuilder batteryType(String batteryType);
}
