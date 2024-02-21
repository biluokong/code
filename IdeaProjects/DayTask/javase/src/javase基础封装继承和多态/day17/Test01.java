package javase基础封装继承和多态.day17;
/*编写程序实现乐手弹奏乐器。乐手可以弹奏不同的乐器从而发出不同的声音。
可以弹奏的乐器包括二胡、钢琴和琵琶。
	实现思路及关键代码：
		1)定义乐器类Instrument，包括方法makeSound()
		2)定义乐器类的子类：二胡Erhu、钢琴Piano和小提琴Violin
		3)定义乐手类Musician，可以弹奏各种乐器play(Instrument i)
		4)定义测试类，给乐手不同的乐器让他弹奏*/
public class Test01 {
    public static void main(String[] args) {
        Musician musician = new Musician();
        musician.play(new Erhu());
        musician.play(new Piano());
        musician.play(new Violin());
    }
}

abstract class Instrument {
    abstract void makeSound();
}

class Erhu extends Instrument {
    @Override
    void makeSound() {
        System.out.println("听到了二胡的音乐");
    }
}

class Piano extends Instrument {
    @Override
    void makeSound() {
        System.out.println("听到了钢琴的音乐");
    }
}

class Violin extends Instrument {
    @Override
    void makeSound() {
        System.out.println("听到了小提琴的音乐");
    }
}

class Musician {
    public void play(Instrument instrument) {
        instrument.makeSound();
    }
}