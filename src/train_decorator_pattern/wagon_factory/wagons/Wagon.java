package train_decorator_pattern.wagon_factory.wagons;

public interface Wagon {
    String print();
    Wagon detatchEnd();
    Wagon getDecoratedWagon();
    Wagon detatchHead();

    boolean fill();
}
