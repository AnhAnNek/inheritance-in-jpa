package com.example.inheritanceinjpa;

import com.example.inheritanceinjpa.builder.laptop.LaptopBuilderImpl;
import com.example.inheritanceinjpa.customenum.ECategory;
import com.example.inheritanceinjpa.entity.Laptop;
import com.example.inheritanceinjpa.entity.MechanicalKeyboard;
import com.example.inheritanceinjpa.entity.Monitor;
import com.example.inheritanceinjpa.entity.Product;
import com.example.inheritanceinjpa.repository.prod.ProdRepos;
import com.example.inheritanceinjpa.repository.prod.ProdReposImpl;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

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

        getProductById(out);
    }

    private void saveLaptop(PrintWriter out) {
        Laptop laptop = laptopBuilder();
        out.println(laptop.toString() + "</br>");

        Product saved = prodRepos.save(laptop);
        String str = saved.toString();
        if (str != null || !str.isEmpty()) {
            existProdId = saved.getId();
            out.println(str);
        } else {
            out.println("Save unsuccessfully");
        }
    }

    private Laptop laptopBuilder() {
        return new LaptopBuilderImpl()
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
        out.println(monitor.toString() + "</br>");

        Product saved = prodRepos.save(monitor);
        String str = saved.toString();
        if (str != null || !str.isEmpty()) {
            out.println(str);
        } else {
            out.println("Save unsuccessfully");
        }
    }

    Monitor monitorBuilder() {
        Set<Monitor.EConnection> connections = new HashSet<>();
        connections.add(Monitor.EConnection.HDMI);
        connections.add(Monitor.EConnection.USB_C);


        return new Monitor("BrandName", "Model123", "Description of the monitor",
                new BigDecimal("299.99"), 50, 0.1, "Version2", "Black", ECategory.MONITOR, 2023,
                27.0, "1920x1080", true, Monitor.EPanel.IPS, 144, true, 250, true, true,
                50.5, 7.2, connections);
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

    public void destroy() {
    }
}