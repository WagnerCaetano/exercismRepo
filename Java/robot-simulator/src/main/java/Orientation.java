enum Orientation {
    NORTH, EAST, SOUTH, WEST;

    public Orientation getNext() {
        return this.ordinal() < Orientation.values().length - 1 ?
                Orientation.values()[this.ordinal() + 1] : Orientation.values()[0];
    }

    public Orientation getBefore(){
        return this.ordinal() > 0 ?
                Orientation.values()[this.ordinal() - 1] : Orientation.values()[Orientation.values().length-1];
    }
}
