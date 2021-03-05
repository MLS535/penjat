package test;

import com.jaume.penjat.Puntuacio;
import com.jaume.penjat.Tauler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.*;

public class PuntuacioTest {
private Puntuacio puntuacio;
private Tauler tauler;


@BeforeEach
void reiniciar() {
    puntuacio = new Puntuacio();
    tauler= new Tauler();
}

@ParameterizedTest
@ValueSource(ints = {1, 2, 3})
void comprobarDificultad(int number) {
    puntuacio.getParaulaSecretaDificultat(number);
    int resultat = 0;
    switch (number) {
        case 1:
            number = 1;
            resultat = 5;
            break;
        case 2:
            number = 2;
            resultat = 4;
            break;
        case 3:
            number = 3;
            resultat = 3;
            break;
        case 4:
            number=4;
            resultat=0;
            default:
            break;
    }
    Assertions.assertEquals(resultat, puntuacio.getIntents());
}


/*
//comprobar dificultad de otra manera
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
}*/

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

//En este test comprobamos que la palabraEndivinada es igual a getParaula. Para ello aplicamos en el set una palabra en concreto
@Test
void comprobarLetraParaula(){
    String[] palabraEdivinada={"p","o","r","c"};
for (int i=0; i < palabraEdivinada.length; i++) {
    if(palabraEdivinada[i] == null) palabraEdivinada[i] = "";
}
String str = String.join("", palabraEdivinada);
    puntuacio.setParaula("porc");
    assertEquals(puntuacio.getParaula(), str);
}

@ParameterizedTest
@ValueSource(ints = {1, 2, 3})
void comprobarPuntuacion(int difNumber) {
    puntuacio.getParaulaSecretaDificultat(difNumber);
    float puntsInicials = puntuacio.calcularPuntuacio(tauler.getPalabraEndevinada(), puntuacio.getIntents());
    float puntsFinals = 1000f;
    float puntsPercentatge = 0f;
    float puntsTemps = 100f;
    switch (difNumber) {
        case 1:
            difNumber=1;
            puntsPercentatge = 0.2f;
            puntsTemps *= puntuacio.getDificultat();
            if (Arrays.stream(puntuacio.getLetresBonus()).anyMatch(puntuacio.getParaula()::contains)) {
                puntsPercentatge += 0.01f;
            } else if (puntsPercentatge > 0) {
                puntsFinals *= puntsPercentatge;

            } else if (puntsFinals > 0 || puntsTemps > 0) {
                puntsFinals += puntsTemps;
                assertEquals(puntsFinals, puntsInicials);
            }
            break;
            case 2:
                difNumber=2;
                puntsPercentatge = 0.2f;
                puntsTemps *= puntuacio.getDificultat();
                if (Arrays.stream(puntuacio.getLetresBonus()).anyMatch(puntuacio.getParaula()::contains)) {
                    puntsPercentatge += 0.01f;
                } else if (puntsPercentatge > 0) {
                    puntsFinals *= puntsPercentatge;

                } else if (puntsFinals > 0 || puntsTemps > 0) {
                    puntsFinals += puntsTemps;
                    assertEquals(puntsFinals, puntsInicials);
                }

                break;
        case 3:
            difNumber=3;
                        puntsPercentatge = 0.3f;
                        puntsTemps *= puntuacio.getDificultat();
                        if (Arrays.stream(puntuacio.getLetresBonus()).anyMatch(puntuacio.getParaula()::contains)) {
                            puntsPercentatge += 0.01f;
                        } else if (puntsPercentatge > 0) {
                            puntsFinals *= puntsPercentatge;

                        } else if (puntsFinals > 0 || puntsTemps > 0) {
                            puntsFinals += puntsTemps;
                            assertEquals(puntsFinals, puntsInicials);
                        }
                        break;
        default:
            break;
                    }

                }
            }
