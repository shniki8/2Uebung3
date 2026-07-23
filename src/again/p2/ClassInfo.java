package again.p2;

public class ClassInfo {
    private Object obj;
    public ClassInfo(Object obj){
        this.obj = obj;
    }
    public String getClassName(){
        return obj.getClass().getSimpleName();
    }
    public String getFullClassName(){
        return obj.getClass().getName();
    }
    public String getPackageName(){
        if (obj.getClass().getPackage() == null) return "none";
        return obj.getClass().getPackage().getName();
    }
    public boolean isInSamePackage(Object other){
        return (getPackageName().equals(new ClassInfo(other).getPackageName()));
    }
}
