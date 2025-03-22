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
        return ("El reloj marca " + hora + ":" + minuto + ":" + segundo + ".\nLa manecilla corta marca la hora " + hora +", la manecilla larga marca el minuto " + minuto + " y a manecilla delgada marca el segundo "+ segundo + ".");
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
