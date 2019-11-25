package beginner;

import com.sandwich.koan.Koan;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

public class AboutInheritance {

    abstract class Animal {
        abstract public String makeSomeNoise();
    }

    class Cow extends Animal {
        @Override
        public String makeSomeNoise() {
            return "Moo!";
        }
    }

    class Dog extends Animal {
        @Override
        public String makeSomeNoise() {
            return "Woof!";
        }

        public boolean canFetch() {
            return true;
        }
    }

    class Puppy extends Dog {
        @Override
        public String makeSomeNoise() {
            return "Squeak!";
        }
        public boolean canFetch() {
            return false;
        }
    }

    @Koan
    public void methodOverloading() {
        Cow cow = new Cow();
        Dog dog = new Dog();
        Puppy puppy = new Puppy();
        assertEquals(cow.makeSomeNoise(), "Moo!");
        assertEquals(dog.makeSomeNoise(), "Woof!");
        assertEquals(puppy.makeSomeNoise(), "Squeak!");

        assertEquals(dog.canFetch(), true);
        assertEquals(puppy.canFetch(), false);
        // but can Bob the Cow fetch?
    }

    @Koan
    public void methodOverloadingUsingPolymorphism() {
        Animal cow = new Cow();
        Animal dog = new Dog();
        Animal puppy = new Puppy();
        assertEquals(cow.makeSomeNoise(), "Moo!");
        assertEquals(dog.makeSomeNoise(), "Woof!");
        assertEquals(puppy.makeSomeNoise(), "Squeak!");
        // but can max or barney (here as an Animal) fetch?
        // try to write it down here
    }

    @Koan
    public void inheritanceHierarchy() {
        Animal someAnimal = new Cow();
        Animal bob = new Cow();
        assertEquals(someAnimal.makeSomeNoise().equals(bob.makeSomeNoise()), true);
        // cow is a Cow, but it can also be an animal
        assertEquals(bob instanceof Animal, true);
        assertEquals(bob instanceof Cow, true);
        // but is it a Puppy?
        assertEquals(bob instanceof Puppy, false);
    }

    @Koan
    public void deeperInheritanceHierarchy() {
        Dog max = new Dog();
        Puppy barney = new Puppy();
        assertEquals(max instanceof Puppy, false);
        assertEquals(max instanceof Dog, true);
        assertEquals(barney instanceof Puppy, true);
        assertEquals(barney instanceof Dog, true);
    }

    // TODO overriding
//
//    abstract class ParentTwo {
//        abstract public Collection<?> doStuff();
//    }
//
//    class ChildTwo extends ParentTwo {
//        public Collection<?> doStuff() {
//            return Collections.emptyList();
//        }
//
//        ;
//    }
//
//    @Koan
//    public void overriddenMethodsMayReturnSubtype() {
//        // What do you need to change in order to get rid of the type cast?
//        // Why does this work?
//        List<?> list = (List<?>) new ChildTwo().doStuff();
//        assertEquals(list instanceof List, __);
//    }
}
