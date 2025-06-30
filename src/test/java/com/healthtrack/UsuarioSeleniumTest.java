package com.healthtrack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UsuarioSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Ejecuta sin abrir ventana
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        //driver = new ChromeDriver(options);

    }

    @Test
    void testActualizarPesoEnFormulario() {
        String rutaArchivo = "https://luvisoft.cl/demos/modulo4/form.html";
        driver.get(rutaArchivo);

        WebElement campoNombre = driver.findElement(By.id("nombre"));
        WebElement campoPeso = driver.findElement(By.id("peso"));
        WebElement botonActualizar = driver.findElement(By.tagName("button"));

        campoNombre.sendKeys("Claudio");
        campoPeso.sendKeys("78.3");
        botonActualizar.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement resultado = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("resultado"))
        );

        String texto = resultado.getText();

        assertTrue(texto.contains("Claudio") && texto.contains("78.3"),
            "El texto mostrado no es correcto: " + texto);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
