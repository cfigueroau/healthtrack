package com.healthtrack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UsuarioSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {        
        driver = new ChromeDriver();
    }

    @Test
    void testActualizarPesoEnFormulario() {        
        //String rutaArchivo = "file:///" + System.getProperty("user.dir") + "/src/test/resources/form.html";  // Carga el archivo local
        String rutaArchivo = "https://luvisoft.cl/demos/modulo4/form.html";         // Carga el archivo desde mi server
        driver.get(rutaArchivo);

        WebElement campoNombre = driver.findElement(By.id("nombre"));
        WebElement campoPeso = driver.findElement(By.id("peso"));
        WebElement botonActualizar = driver.findElement(By.tagName("button"));

        campoNombre.sendKeys("Claudio");
        campoPeso.sendKeys("78.3");
        botonActualizar.click();

        // Verificar el resultado
        WebElement resultado = driver.findElement(By.id("resultado"));
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
