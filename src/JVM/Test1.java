package JVM;

public class Test1 {
    public void hello(){
        System.out.println("恩，是的，我是由 " + getClass().getClassLoader().getClass()
                + " 加载进来的");
    }
}