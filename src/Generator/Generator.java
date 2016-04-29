package Generator;
import RandomObjects.RandomObjects;

//This is the interface for generators
public interface Generator<T> {
    
    RandomObjects generate();
    
}
