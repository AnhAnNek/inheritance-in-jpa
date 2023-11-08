package com.example.inheritanceinjpa.builder.laptop;

import com.example.inheritanceinjpa.builder.prod.ProductBuilder;
import com.example.inheritanceinjpa.builder.prod.ProductBuilderImpl;
import com.example.inheritanceinjpa.entity.Laptop;

public interface LaptopBuilder extends ProductBuilder<Laptop> {
    LaptopBuilder cpuName(String cpuName);
    LaptopBuilder cpuCores(int cpuCores);
    LaptopBuilder cpuThreads(int cpuThreads);
    LaptopBuilder cpuSpeed(double cpuSpeed);
    LaptopBuilder cpuMaxSpeed(double cpuMaxSpeed);
    LaptopBuilder cpuCache(int cpuCache);
    LaptopBuilder ramSize(int ramSize);
    LaptopBuilder ramType(Laptop.ERam ramType);
    LaptopBuilder ramBusSpeed(int ramBusSpeed);
    LaptopBuilder ramMaxSupport(int ramMaxSupport);
    LaptopBuilder romType(Laptop.ERom romType);
    LaptopBuilder romSize(int romSize);
    LaptopBuilder screenSize(double screenSize);
    LaptopBuilder screenResolution(String screenResolution);
    LaptopBuilder screenRefreshRate(int screenRefreshRate);
    LaptopBuilder screenTechnology(String screenTechnology);
    LaptopBuilder brightness(int brightness);
    LaptopBuilder antiGlare(boolean antiGlare);
    LaptopBuilder graphicsCard(String graphicsCard);
    LaptopBuilder weight(double weight);
    LaptopBuilder material(String material);
    LaptopBuilder operatingSystem(String operatingSystem);
    Laptop build();
}
