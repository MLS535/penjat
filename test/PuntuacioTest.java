package test;

import com.jaume.penjat.Puntuacio;
import com.jaume.penjat.Tauler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.*;

public class PuntuacioTest {
    private Puntuacio puntuacio;

    @BeforeEach
    void reiniciar(){
        this.puntuacio = new Puntuacio();
    }

    //comprobar dificultad
    @Test
    void comprobarDificultatNivellBaix(){
        this.puntuacio.getParaulaSecretaDificultat(1);
        assertEquals(5, this.puntuacio.getIntents());
    }

    @Test
    void comprobarDificultatNivellMitjana(){
        this.puntuacio.getParaulaSecretaDificultat(2);
        assertEquals(4, this.puntuacio.getIntents());
    }

    @Test
    void comprobarDificultatNivellAlt(){
        this.puntuacio.getParaulaSecretaDificultat(3);
        assertEquals(3, this.puntuacio.getIntents());
    }

    //Comprobamos que el tiempo no es igual y que se inicia correctamente.
    @Test
    void comprobarInicioTiempo() throws InterruptedException {
        this.puntuacio.getParaulaSecretaDificultat(1);
        TimeUnit.SECONDS.sleep(1);
        this.puntuacio.calcularPuntuacio(new String[1],0);
        assertNotEquals(0, this.puntuacio.getTemps());
    }


    @Test
    void comprobarPuntuacion(){
        String paraulaSecreta = this.puntuacio.getParaulaSecretaDificultat(1);
        assertNotEquals( 0, this.puntuacio.calcularPuntuacio(new String[]{paraulaSecreta},0));
    }

    @Test
    void comprobarPuntuacionMasAlta(){
        String paraulaSecreta = this.puntuacio.getParaulaSecretaDificultat(1);
        assertNotEquals( 0, this.puntuacio.calcularPuntuacio(new String[]{paraulaSecreta},5));
    }



}