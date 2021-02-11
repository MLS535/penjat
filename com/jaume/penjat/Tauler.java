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

    public String setLetra(String letra) {
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
            //si no existe la letra, restará en el método intents
            if (!exist) {
                restarIntent();
            }

        }
        return "";
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
