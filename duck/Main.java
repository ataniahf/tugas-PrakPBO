
package duck;

import duck.Attack.ArrowAttack;
import duck.Attack.SwordAttack;
import duck.Defense.ArmorDefense;
import duck.Defense.ShiledDefense;
import duck.Fly.*;
import duck.Sound.*;

public class Main {
    public static void main(String[] args) {
    Duck superduck = new Duck(new RocketFly(), new ToaSound(), new ArrowAttack(), new ShiledDefense());
    System.out.println("Super Duck Behaviour : ");
    superduck.fly();
    superduck.sound();
    superduck.attack();
    superduck.defense();

    System.out.println("");
    System.out.println("Noob Duck Behaviour : ");
    Duck noobDuck = new Duck(new WingsFly(), new NormalSound(), new SwordAttack(), new ArmorDefense());
    noobDuck.fly();
    noobDuck.sound();
    noobDuck.attack();
    noobDuck.defense();

    System.out.println("");
    System.out.println("Super Duck change Fly Behaviour : ");
    superduck.setBehaviourFly(new PlaneFly());
    superduck.fly();
    superduck.sound();
    superduck.attack();
    superduck.defense();
  }
}
