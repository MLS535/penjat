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
        return letra;
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
        this.vidas = intents;
    }

    public char[] getParaulaSecreta() {
        return paraulaSecreta;
    }

    public void setParaulaSecreta(char[] paraulaSecreta) {
        this.paraulaSecreta = paraulaSecreta;
        this.palabraEndevinada = new String[paraulaSecreta.length]; //aquí dará null
    }

    public String[] getPalabraEndevinada() {
        return palabraEndevinada;
    }

    public void setPalabraEndevinada(String[] palabraEndevinada) {
        this.palabraEndevinada = palabraEndevinada;
    }
    public void inicialitzarPartida(String paraula, Integer vidas) {
        char[] parole = paraula.toCharArray();
        setParaulaSecreta(parole);
        setIntents(vidas);
    }

    public String verificar (String letra) {
        //aquí creamos un string que contiene el set de letra. Este string verifica la longitud. Si es mayor a 1 dará error
        String letraEnviada = setLetra(letra);
        if (letraEnviada.length() > 1) {
            return ("Lletra incorrecte");
        } else {
            //exist es un metodo booleano
            boolean exist = false;
            for (int j = 0; j < paraulaSecreta.length; j++) {
/*charAt() es un método de la clase String que retorna el caracter (tipo char) que se encuentra
 en la posición indicada. El metodo length() de la clase String también, retorna la cantidad total de caracteres contenidos en la cadena. */
                if (paraulaSecreta[j] == letra.charAt(0)) {
                    exist = true;
                    palabraEndevinada[j] = String.valueOf(letra.charAt(0));
                }
            }
//si no existe la letra, restará en el metodo intents
            if (!exist) {
                restarIntent();
            }

        }
        return "";
    }
}
