package basic.section3;

public abstract class JavaAnimal {
    protected final String species;
    int legCount;

    public JavaAnimal(String species, int legCount) {
        this.species = species;
        this.legCount = legCount;
    }

    abstract public void move();

    public String getSpecies() {
        return species;
    }

/*    public int getLegCount() {
        return legCount;
    }*/
}
