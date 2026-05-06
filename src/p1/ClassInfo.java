package p1;

public class ClassInfo {
    private Object obj;
    public ClassInfo(Object obj){
        this.obj = obj;
    }
    public String getCanonClassName(){
        return obj.getClass().getCanonicalName(); // kanonischer Name yippie
    }

    public String getClassName(){
        return obj.getClass().getSimpleName(); //Nur name der Klasse
    }
    public String getFullClassName(){
        return obj.getClass().getName(); //package1.package2. ... . packageN.classname -> packagepfad.name
    }
    public String getPackageName(){
        if (obj.getClass().getPackage() != null) {
            return obj.getClass().getPackageName(); //alt.: return obj.getClass().getPackage().getName()
                                                    //nur packagepfad
        }
        System.out.println("Class not in a package.");
        return "";
    }
    public boolean isInSamePackage(Object other){
        String s = other.getClass().getPackageName();
        if (s == null && getPackageName() == ""){
            return true;
        }
        return (getPackageName().equals(s));
    }
}
