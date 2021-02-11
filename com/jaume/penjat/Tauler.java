package com.jaume.penjat;

public class Tauler {
    private String letra;
    private Integer vidas;
    private String paraula;
    private Integer intents;
    private char[] paraulaSecreta;
    private String[] palabraEndevinada;

    public Tauler(){

    }
    public Tauler(String letra, Integer vidas, String paraula, Integer intents, char[] paraulaSecreta, String[] palabraEndevinada) {
        this.letra = letra;
        this.vidas = vidas;
        this.paraula = paraula;
        this.intents = intents;
        this.paraulaSecreta = paraulaSecreta;
        this.palabraEndevinada = palabraEndevinada;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Integer getVidas() {
        return vidas;
    }

    public void setVidas(Integer vidas) {
        this.vidas = vidas;
    }

    public String getParaula() {
        return paraula;
    }

    public void setParaula(String paraula) {
        this.paraula = paraula;
    }

    public Integer getIntents() {
        return intents;
    }

    public void setIntents(Integer intents) {
        this.intents = intents;
    }

    public char[] getParaulaSecreta() {
        return paraulaSecreta;
    }

    public void setParaulaSecreta(char[] paraulaSecreta) {
        this.paraulaSecreta = paraulaSecreta;
    }

    public String[] getPalabraEndevinada() {
        return palabraEndevinada;
    }

    public void setPalabraEndevinada(String[] palabraEndevinada) {
        this.palabraEndevinada = palabraEndevinada;
    }



    public String imprimir() {
        //Definimos salida con " " el cual significa que hay un valor. Que este valor sea la cadena vacia o no, no es relevante.
        String salida = "";
        for (int i = 0; i < palabraEndevinada.length; i++) {
            //si palabraEndevinada es distinto a null imprimirá la posición 1,2 o la longitud de la palabra que hayamos asignado
            if (!(palabraEndevinada[i] == (null))) {
                //salida += palabraEndevinada[i];
                System.out.print(palabraEndevinada[i]);
//en caso contrario, imprimirá _
            } else {
                System.out.print("_");
                //  salida += "_";
            }
        }
        //hay que darle una salida a este metodo
        return salida;
    }

    //lo que hace este metodo es restar los intentos --
    public void restarIntent() {
        Integer restarIntent=intents--;
    }


    public String imprimirVides() {
        String vidilla = String.format("Et queden %s vides de %s", intents,vidas);
        if (1 == intents) vidilla = String.format("Et queda %s vida de %s",intents, vidas);
        return vidilla;
    }

    /*String.join: Concatena los elementos de la matriz especificada o los miembros de una colección,
    usando el separador indicado entre todos los elementos o miembros. Además, lo que hace este metodo es igualar paraulaSecreta con palabraEndevinada */
    public boolean hasGuanyat() {
        if (String.valueOf(paraulaSecreta).equals(String.join("",palabraEndevinada))){
            return true;
        }else
            return false;
    }

}
