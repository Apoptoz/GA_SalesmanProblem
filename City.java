
public class City {
  int x;
  int y;
  int number;

  //Constructeur : défini des positions aléatoires
  public City() {
    this.x = (int)(Math.random()*200);
    this.y = (int)(Math.random()*200);
  }
  public City(int number, int x, int y) {
    this.number = number;
    this.x = x;
    this.y = y;
  }

  public int getX() { return this.x; }
  public int getY() { return this.y; }
  public int getNumber() { return this.number; }

  public double distanceTo(City city) {
    int xDistance = Math.abs(this.getX() - city.getX());
    int yDistance = Math.abs(getY() - city.getY());
    double distance = Math.sqrt((xDistance*xDistance)+(yDistance*yDistance));
    return distance;
  }

  @Override
  public String toString() {
    return String.valueOf(this.getNumber());
  }

}
