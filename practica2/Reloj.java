public class Reloj {
    public int hora, minuto, segundo;
    public Reloj(int hora, int minuto, int segundo){
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    public int ajustarMinuto(){
        while(segundo >= 60){
            minuto +=1;
            segundo -=60;
        }
        return segundo;
    }
    public int ajustaHora(){
        while(minuto >= 60){
            hora +=1;
            minuto -=60;
        }
        return minuto;
    }
    public int horaMaxima(){
        while(hora >= 12){
            hora -=12;
        }
        return hora;
    }
    public String mostrarHora(){
        String horaStr, minutoStr, segundoStr; 
        if (hora < 10) {
            horaStr = "0" + Integer.toString(hora);
        } else {
            horaStr = Integer.toString(hora);
        }
        if (minuto < 10) {
            minutoStr = "0" + Integer.toString(minuto);
        } else {
            minutoStr = Integer.toString(minuto);
        }
        if (segundo < 10) {
            segundoStr = "0" + Integer.toString(segundo);
        } else {
            segundoStr = Integer.toString(segundo);
        }
        return ("El reloj marca " + horaStr + ":" + minutoStr + ":" + segundoStr + ".");
    }
    public void incrementarSegundos(){
        segundo++;
        if (segundo == 60){
            segundo = 0;
            incrementarMinutos();
        }
    }
    public void incrementarMinutos(){
        minuto++;
        if (minuto == 60){
            minuto = 0;
            incrementarHoras();
        }
    }
    public void incrementarHoras(){
        hora++;
        if (hora == 12){
            hora = 0;
        }
    }
}
