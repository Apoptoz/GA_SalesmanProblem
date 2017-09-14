/* Program mostly based of Lee Jacobson article on 
a solution for the Traveling Salesman's Problem
using Genetic Algortithm */

public class GA {
  public static void main(String[] args) {
    // Create and add our cities
    City city = new City(1,60, 200);
    TourManager.addCity(city);
    City city2 = new City(2,180, 200);
    TourManager.addCity(city2);
    City city3 = new City(3,80, 180);
    TourManager.addCity(city3);
    City city4 = new City(4,140, 180);
    TourManager.addCity(city4);
    City city5 = new City(5,20, 160);
    TourManager.addCity(city5);
    City city6 = new City(6,100, 160);
    TourManager.addCity(city6);
    City city7 = new City(7,200, 160);
    TourManager.addCity(city7);
    City city8 = new City(8,140, 140);
    TourManager.addCity(city8);
    City city9 = new City(9,40, 120);
    TourManager.addCity(city9);
    City city10 = new City(10,100, 120);
    TourManager.addCity(city10);
    City city11 = new City(11,180, 100);
    TourManager.addCity(city11);
    City city12 = new City(12,60, 80);
    TourManager.addCity(city12);
    City city13 = new City(13,120, 80);
    TourManager.addCity(city13);
    City city14 = new City(14,180, 60);
    TourManager.addCity(city14);
    City city15 = new City(15,20, 40);
    TourManager.addCity(city15);
    City city16 = new City(16,100, 40);
    TourManager.addCity(city16);
    City city17 = new City(17,200, 40);
    TourManager.addCity(city17);
    City city18 = new City(18,20, 20);
    TourManager.addCity(city18);
    City city19 = new City(19,60, 20);
    TourManager.addCity(city19);
    City city20 = new City(20,160, 20);
    TourManager.addCity(city20);

    int taillePopulation = Integer.parseInt(args[0]);
    int maxRepetition = Integer.parseInt(args[1]);

    Population pop = new Population(taillePopulation,true);
    //Population newPop = newPopulation(10,false);
    double newFitness;
    int generationCounter = 0;
    int counter = 0;
    double bestFitness = 0;
    while (counter < maxRepetition) {
        generationCounter++;
        System.out.println("Génération numéro : "+generationCounter);
        afficherFittest(pop);
        pop = Algorithm.evolvePopulation(pop);
        newFitness = pop.getFittest().getFitness();
        if (bestFitness < newFitness) {
          bestFitness = newFitness;
        }
        else if (bestFitness == newFitness ) {
          counter++;
        }
    }

    System.out.println("Fin de l'algorithm");
    System.out.println("Population et solution finale :");
    afficherFittest(pop);

    System.out.println("Arguments : "+args);


  }
  public static void afficherFittest(Population pop) {
    Tour fittest = pop.getFittest();
    System.out.println("Distance : "+fittest.getDistance());
  }
  public static void afficherPop(Population pop) {
    for(int i = 0; i < pop.size(); i++) {
      System.out.println("Tour numéro :"+i);
      System.out.println(pop.getTour(i));
      System.out.println("Fitness : "+pop.getTour(i).getFitness());
      System.out.println("Distance : "+pop.getTour(i).getDistance()+"\n");
    }
    System.out.println("Fittest : "+pop.getFittest());
  }
}
