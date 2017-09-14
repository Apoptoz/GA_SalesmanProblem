
public class Population {

  Tour[] tours;

  public Population(int populationSize, boolean initialise) {
    this.tours = new Tour[populationSize];

    if(initialise) {
      for(int i=0; i < size(); i++) {
        Tour newTour = new Tour();
        newTour.generateIndividual();
        this.saveTour(i,newTour);
      }
    }
  }

  public Tour getTour(int index) {
    return this.tours[index];
  }

  public Tour getFittest() {
    Tour fittest = this.getTour(0);
    double fitness = 0;
    for(int i=1; i < this.size(); i++) {
      Tour currentTour = this.getTour(i);
      if (currentTour.getFitness() > fitness) {
        fitness = currentTour.getFitness();
        fittest = currentTour;
      }
    }
    return fittest;
  }

  public void saveTour(int index, Tour tour) {
    this.tours[index] = tour;
  }

  public int size() {
    return this.tours.length;
  }
}
