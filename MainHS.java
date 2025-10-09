/*********************/
public class Main
{
	public static void main(String[] args) {
	    String frase[];
	    Posicion pos=new Posicion();
	    frase=new String[40];
	    HiloEscribe x=new HiloEscribe(pos); 
	    x.setName("HiloX");
	    x.setIni(3);  x.setInfo(frase); x.start();
	    HiloEscribe y=new HiloEscribe(pos);y.setName("HiloY");
	    y.setIni(0);  y.setInfo(frase); y.start();
	    try{    x.join(); y.join(); } //esperamos a que ambos terminen
	    catch(InterruptedException e)
	    {System.out.println("join - interrupted");}
	    for(int i=0;i<10;i++){
	        System.out.println("frase["+i+"]="+frase[i]);
	    }
		
	}
}
