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

        // Configuración para evitar errores en GitHub Actions
        options.addArguments("--headless"); // Modo sin interfaz gráfica
        options.addArguments("--no-sandbox"); // Necesario en CI
        options.addArguments("--disable-dev-shm-usage"); // Previene uso excesivo de memoria compartida
        options.addArguments("--disable-gpu"); // En algunos entornos evita errores con GPU
        options.addArguments("--remote-allow-origins=*"); // Requerido por nuevas versiones de ChromeDriver
        options.addArguments("--user-data-dir=/tmp/unique-profile"); // Para evitar conflicto de sesiones

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Asegúrate de que el HTML se sirva correctamente
        driver.get("file://" + System.getProperty("user.dir") + "/src/test/resources/form.html");
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
