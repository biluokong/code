package test;

public class SayImpl implements Say{
    @Override
    public void sayHello() {
        System.out.println("SayImpl --> hello" );
    }

    @Override
    public void sayBuy() {
        System.out.println("SayImpl --> buy" );
    }

    @Override
    public void sayGood() {
        System.out.println("SayImpl --> good" );
    }
}
