
public class Algorithm {

  private static final double mutationRate = 0.015;
  private static final int tournamentSize = 5;
  private static final boolean elitism = true;


  public static Population evolvePopulation(Population pop) {
    Population newPopulation = new Population(pop.size(), false);

    if (elitism) {
      newPopulation.saveTour(0,pop.getFittest());
    }

    //Définir l'offset : si on a l'élitisme, commmencer à 1, sinon à 0
    int offset;
    if (elitism) {
      offset = 1;
    } else { offset = 0; }

    for (int i=offset; i < pop.size(); i++) {
      Tour parent1 = tournamentSelection(pop);
      Tour parent2 = tournamentSelection(pop);
      Tour child = crossover(parent1,parent2);
      newPopulation.saveTour(i,child);
    }
    for (int i=0; i < newPopulation.size(); i++) {
      mutation(newPopulation.getTour(i));
    }
    return newPopulation;
  }

  public static Tour tournamentSelection(Population pop) {
    //Initialise une population de tournamentSize, ici 5 donc
    Population tournamentPopulation = new Population(tournamentSize,false);
    Tour tournamentWinner = new Tour();
    for(int i=0; i < tournamentSize; i++) {
      int chosenNumber = (int)(Math.random()*pop.size());
      Tour chosenTour = pop.getTour(chosenNumber);
      tournamentPopulation.saveTour(i,chosenTour);
    }
    tournamentWinner = tournamentPopulation.getFittest();
    return tournamentWinner;
  }


  public static Tour crossover(Tour parent1, Tour parent2) {
    Tour child = new Tour();

    int startPos = (int) (Math.random()*parent1.tourSize());
    int endPos = (int) (Math.random()*parent1.tourSize());

    //Ajout du parent1 dans l'enfant
    for (int i=0; i < child.tourSize(); i++) {
      if (startPos < endPos && i > startPos && i < endPos) {
        child.setCity(i,parent1.getCity(i));
      }
      else if (startPos > endPos) {
        if (!(i > endPos && i < startPos)) {
          child.setCity(i,parent1.getCity(i));
        }
      }
    }
    //Ajout du parent2
    for (int i=0; i < parent2.tourSize(); i++) {
      //Si la i-ème position du parent est une cité que l'enfant n'a pas,
      //on l'ajoute dans le prochain emplacement vide
      if (!(child.containsCity(parent2.getCity(i)))) {
        for (int j=0; j < child.tourSize(); j++) {
          if (child.getCity(j) == null) {
            child.setCity(j,parent2.getCity(i));
            break;
          }
        }
      }
    }
    return child;
  }

  public static Tour mutation(Tour tour) {
    for (int tourPos1=0; tourPos1<tour.tourSize(); tourPos1++) {
      if (Math.random() < mutationRate) {
        int tourPos2 = (int) (Math.random()*tour.tourSize());

        City citySwap = tour.getCity(tourPos1);
        tour.setCity(tourPos1,tour.getCity(tourPos2));
        tour.setCity(tourPos2,citySwap);
      }
    }
    return tour;
  }

  //Le mec tente la mutation sur chaque ville avec une boucle sur tour
  //On va tenter comme ça
  public static Tour myMutation(Tour tour) {
    if (Math.random() < mutationRate) {
      int swap1 = (int) (Math.random()*tour.tourSize());
      int swap2 = (int) (Math.random()*tour.tourSize());

      City city_swap = tour.getCity(swap1);
      tour.setCity(swap1,tour.getCity(swap2));
      tour.setCity(swap2,city_swap);
    }
    return tour;
  }
}
