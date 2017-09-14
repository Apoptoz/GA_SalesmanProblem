
import java.util.ArrayList;
import java.util.Collections;

public class Tour {
  private ArrayList tour = new ArrayList<City>();

  private double fitness = 0;
  private int distance = 0;

  //blank tour
  public Tour() {
    for (int i=0;i<TourManager.numberOfCities();i++) {
      tour.add(null);
    }
  }
  public Tour(ArrayList tour) {
    this.tour = tour;
  }

  public void generateIndividual() {
    for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
      this.setCity(cityIndex, TourManager.getCity(cityIndex));
    }
    //Reorder the tour randomly
    Collections.shuffle(tour);
  }

  public City getCity(int tourPosition) {
    return (City)tour.get(tourPosition);
  }
  public void setCity(int tourPosition, City city) {
    tour.set(tourPosition,city);
  }

  public double getFitness() {
    if (fitness == 0) {
      fitness = 1/(double)this.getDistance();
    }
    return fitness;
  }

  public int getDistance() {
    if (this.distance == 0) {
      int tourDistance = 0;

      for (int cityIndex = 0; cityIndex<this.tourSize(); cityIndex++) {

        City fromCity = this.getCity(cityIndex);
        City destCity;
        if (cityIndex+1 < this.tourSize()) {
          destCity = this.getCity(cityIndex+1);
        } else {
          destCity = this.getCity(0);
        }
        tourDistance += fromCity.distanceTo(destCity);
      }
      this.distance = tourDistance;
    }
    return this.distance;
  }

  public int tourSize() { return this.tour.size(); }

  public boolean containsCity(City city) {
    return tour.contains(city);
  }

  @Override
  public String toString() {
    String geneString = "|";
    for (int i=0;i<tourSize();i++) {
      geneString += getCity(i)+"|";
    }
    return geneString;
  }

}
