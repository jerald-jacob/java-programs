
public class Main {

    public static void main(String[] args) {
SecondClass aa=new SecondClass();
        aa.f1();
    }

}

interface firstInterface {

    void f1();

    void f2();

}

interface secondInterface {

    void f1();

    void f2();

}

class FirstClass implements firstInterface, secondInterface {

  
    @Override
    public void f2() {

    }

    @Override
    public void f1() {
       System.out.println("interface method");
    }

}
abstract class firstAbstract{
    abstract void f1();
    void fun2(){
        System.out.println("its a methord");
}
    
}
class SecondClass extends firstAbstract implements firstInterface{

    @Override
    public void f1() {
        System.out.println("abstract class method");// this is abstract of interface
    }

   
    @Override
    public void f2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
