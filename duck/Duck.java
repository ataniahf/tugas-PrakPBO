package duck;

import duck.Attack.*;
import duck.Defense.*;
import duck.Fly.*;
import duck.Sound.*;
public class Duck {
    
  private BehaviorFly behaviourFly;
  private BehaviorSound behaviourSound;
  private BehaviorAttack behaviourAttack;
  private BehaviorDefense behaviourDefense;

  public Duck(BehaviorFly behaviourFly, BehaviorSound behaviourSound, BehaviorAttack behaviourAttack,
    BehaviorDefense behaviourDefense) {
    this.behaviourFly = behaviourFly;
    this.behaviourSound = behaviourSound;
    this.behaviourAttack = behaviourAttack;
    this.behaviourDefense = behaviourDefense;
  }

  public void setBehaviourFly(BehaviorFly behaviourFly) {
    this.behaviourFly = behaviourFly;
  }

  public void setBehaviourSound(BehaviorSound behaviourSound) {
    this.behaviourSound = behaviourSound;
  }

  public void setBehaviourAttack(BehaviorAttack behaviourAttack) {
    this.behaviourAttack = behaviourAttack;
  }

  public void setBehaviourDefense(BehaviorDefense behaviourDefense) {
    this.behaviourDefense = behaviourDefense;
  }

  public void fly() {
    behaviourFly.fly();
  }

  public void sound() {
    behaviourSound.sound();
  }

  public void attack() {
    behaviourAttack.attack();
  }

  public void defense() {
    behaviourDefense.defense();
  }
}
