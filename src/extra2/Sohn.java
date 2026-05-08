package extra2;

public class Sohn extends Vater{
    String name = "Sohn";
    protected int proSoh = 1;
    int x = this.proGro;
    int y = this.proVat;
    int z = this.proSoh;

    void sagNamen(){
        System.out.println(name);
        System.out.println(super.name);
    }
}
