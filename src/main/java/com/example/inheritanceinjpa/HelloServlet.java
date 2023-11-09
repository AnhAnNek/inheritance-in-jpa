package com.example.inheritanceinjpa;

import com.example.inheritanceinjpa.builder.keyboard.KeyboardBuilder;
import com.example.inheritanceinjpa.builder.keyboard.KeyboardBuilderImpl;
import com.example.inheritanceinjpa.builder.laptop.LaptopBuilder;
import com.example.inheritanceinjpa.builder.laptop.LaptopBuilderImpl;
import com.example.inheritanceinjpa.builder.monitor.MonitorBuilder;
import com.example.inheritanceinjpa.builder.monitor.MonitorBuilderImpl;
import com.example.inheritanceinjpa.customenum.ECategory;
import com.example.inheritanceinjpa.entity.Laptop;
import com.example.inheritanceinjpa.entity.MechanicalKeyboard;
import com.example.inheritanceinjpa.entity.Monitor;
import com.example.inheritanceinjpa.entity.Product;
import com.example.inheritanceinjpa.repository.prod.ProdRepos;
import com.example.inheritanceinjpa.repository.prod.ProdReposImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private ProdRepos prodRepos;

    private static Long existProdId = 0L;

    @Override
    public void init() throws ServletException {
        super.init();
        prodRepos = new ProdReposImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        saveLaptop(out);

        saveMonitor(out);

        saveKeyboard(out);

//        getProductById(out);

        getByPriceRange(out);
    }

    private void saveLaptop(PrintWriter out) {
        Laptop laptop = laptopBuilder();
        saveProd(out, laptop);
    }

    private Laptop laptopBuilder() {
        LaptopBuilder builder = new LaptopBuilderImpl();
        return builder
                .cpuName("Intel Core i5")
                .cpuCores(4)
                .cpuThreads(8)
                .cpuSpeed(2.5)
                .cpuMaxSpeed(4.0)
                .cpuCache(8)
                .ramSize(16)
                .ramType(Laptop.ERam.DDR4)
                .ramBusSpeed(3200)
                .ramMaxSupport(32)
                .romType(Laptop.ERom.SSD)
                .romSize(512)
                .screenSize(15.6)
                .screenResolution("1920 x 1080")
                .screenRefreshRate(60)
                .screenTechnology("LED")
                .brightness(250)
                .antiGlare(true)
                .graphicsCard("Nvidia GeForce GTX 1650")
                .weight(2.3)
                .material("Aluminum")
                .operatingSystem("Windows 10")
                .brand("HP")
                .model("Pavilion")
                .desc("Powerful and stylish laptop for everyday use")
                .price(new BigDecimal("799.99"))
                .stockQty(50)
                .discountPercent(10.0)
                .version("1.0")
                .color("Silver")
                .category(ECategory.LAPTOP)
                .releaseYear(2022)
                .build();
    }

    private void saveMonitor(PrintWriter out) {
        Monitor monitor = monitorBuilder();
        saveProd(out, monitor);
    }

    Monitor monitorBuilder() {
        Set<Monitor.EConnection> connections = new HashSet<>();
        connections.add(Monitor.EConnection.HDMI);
        connections.add(Monitor.EConnection.USB_C);

        MonitorBuilder builder = new MonitorBuilderImpl();
        return builder
                .screenSize(27.0)
                .resolution("1920x1080")
                .touchScreen(true)
                .panelType(Monitor.EPanel.IPS)
                .refreshRate(144)
                .eyeCareTechnology(true)
                .brightness(250)
                .hdrSupported(true)
                .builtInSpeakers(true)
                .powerConsumption(50.5)
                .weight(7.2)
                .connections(connections)
                .brand("BrandName")
                .model("Model123")
                .desc("Description of the monitor")
                .price(new BigDecimal("299.99"))
                .stockQty(50)
                .discountPercent(0.1)
                .version("Version2")
                .color("Black")
                .category(ECategory.MONITOR)
                .releaseYear(2023)
                .build();
    }

    private void saveKeyboard(PrintWriter out) {
        MechanicalKeyboard keyboard = keyboardBuilder();
        saveProd(out, keyboard);
    }

    private MechanicalKeyboard keyboardBuilder() {
        Set<MechanicalKeyboard.ECompatibility> compatibilities = new HashSet<>();
        compatibilities.add(MechanicalKeyboard.ECompatibility.WINDOWS);
        compatibilities.add(MechanicalKeyboard.ECompatibility.MAC_OS);
        compatibilities.add(MechanicalKeyboard.ECompatibility.LINUX);

        Set<MechanicalKeyboard.EConnection> connections = new HashSet<>();
        connections.add(MechanicalKeyboard.EConnection.USB_RECEIVER);
        connections.add(MechanicalKeyboard.EConnection.BLUETOOTH);
        connections.add(MechanicalKeyboard.EConnection.WIRED);


        KeyboardBuilder builder = new KeyboardBuilderImpl();
        return builder
                .compatibilities(compatibilities)
                .connections(connections)
                .cableLength("1.8m")
                .switchType("Cherry MX Red")
                .layout(MechanicalKeyboard.ELayout.FULL_SIZE)
                .keyCount(104)
                .keycapMaterial("ABS")
                .batteryType("AA")
                .brand("BrandName")
                .model("Model123")
                .desc("Description of the keyboard")
                .price(new BigDecimal("99.99"))
                .stockQty(50)
                .discountPercent(0.05)
                .version("Version2")
                .color("Black")
                .category(ECategory.MECHANICAL_KEYBOARD)
                .releaseYear(2023)
                .build();
    }

    private void saveProd(PrintWriter out, Product prod) {
        out.println(prod.toString() + "</br>");

        Product saved = prodRepos.save(prod);
        String str = saved.toString();
        if (str != null) {
            out.println(str);
        } else {
            out.println("Save unsuccessfully");
        }
    }

    void getProductById(PrintWriter out) {
        Product prod = prodRepos.getById(existProdId).orElse(null);
        if (prod == null) {
            out.println("Save unsuccessfully");
            return;
        }

        String str = prod.toString();
        out.println("Get By id=" + existProdId + "\n" + str);


        if (prod instanceof Laptop) {
            out.println("Laptop");
        } else if (prod instanceof MechanicalKeyboard) {
            out.println("MechanicalKeyboard");
        } else {
            out.println("Monitor");
        }
    }

    void getByPriceRange(PrintWriter out) {
        List<Product> prods = prodRepos.getByPriceRange(new BigDecimal(0), new BigDecimal(1_000_000));
        if (prods.isEmpty()) {
            out.println("Empty");
            return;
        }

        for (Product prod : prods) {
            if (prod instanceof Laptop) {
                out.println("Laptop");
            } else if (prod instanceof MechanicalKeyboard) {
                out.println("MechanicalKeyboard");
            } else {
                out.println("Monitor");
            }
            out.println(prod.toString());
        }
    }


    public void destroy() {
    }
}