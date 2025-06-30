package com.healthtrack;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class UsuarioSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        // Configuración compatible con GitHub Actions
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // URL pública del formulario
        driver.get("https://luvisoft.cl/demos/modulo4/form.html");
    }

    @Test
    public void testActualizarPesoEnFormulario() {
        WebElement pesoInput = driver.findElement(By.id("peso"));
        pesoInput.clear();
        pesoInput.sendKeys("80");

        WebElement botonActualizar = driver.findElement(By.id("btnActualizar"));
        botonActualizar.click();

        WebElement mensaje = driver.findElement(By.id("mensaje"));
        Assertions.assertEquals("Peso actualizado a 80 kg.", mensaje.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
