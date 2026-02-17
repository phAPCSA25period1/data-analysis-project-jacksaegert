/**
 * Represents one row from the State Violence Rates dataset.
 */
public class StateViolenceData {

    private String state;
    private int population;
    private int drugDeaths;
    private int gunDeaths;

    /**
     * Constructor that initializes all attributes.
     * @param state the state name
     * @param population the population of the state
     * @param drugDeaths the number of drug-related deaths
     * @param gunDeaths the number of gun-related deaths
     */
    public StateViolenceData(String state, int population, int drugDeaths, int gunDeaths) {
        this.state = state;
        this.population = population;
        this.drugDeaths = drugDeaths;
        this.gunDeaths = gunDeaths;
    }

    /**
     * Gets the state name.
     * @return the state name
     */
    public String getState() {
        return state;
    }

    /**
     * Gets the population.
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Gets the number of drug deaths.
     * @return the drug deaths
     */
    public int getDrugDeaths() {
        return drugDeaths;
    }

    /**
     * Gets the number of gun deaths.
     * @return the gun deaths
     */
    public int getGunDeaths() {
        return gunDeaths;
    }

    /**
     * Calculates the total deaths (drug + gun).
     * @return the total deaths
     */
    public int getTotalDeaths() {
        return drugDeaths + gunDeaths;
    }

    /**
     * Returns a string representation of the object.
     * @return a formatted string of the object's data
     */
    @Override
    public String toString() {
        return "State: " + state + ", Population: " + population + ", Drug Deaths: " + drugDeaths + ", Gun Deaths: " + gunDeaths;
    }

    /**
     * Finds the maximum total deaths across all states.
     * @param data the array of StateViolenceData
     * @return the maximum total deaths
     */
    public static int MaxTotalDeaths(StateViolenceData[] data) {
        int max = Integer.MIN_VALUE;
        for (StateViolenceData State : data) {
            if (State.getTotalDeaths() > max) {
                max = State.getTotalDeaths();
            }
        }
        return max;
    }

    /**
     * Finds the minimum total deaths across all states.
     * @param data the array of StateViolenceData
     * @return the minimum total deaths
     */
    public static int MinTotalDeaths(StateViolenceData[] data) {
        int min = Integer.MAX_VALUE;
        for (StateViolenceData State : data) {
            if (State.getTotalDeaths() < min) {
                min = State.getTotalDeaths();
            }
        }
        return min;
    }

    /**
     * Computes the average total deaths across all states.
     * @param data the array of StateViolenceData
     * @return the average total deaths
     */
    public static double AverageTotalDeaths(StateViolenceData[] data) {
        int sum = 0;
        for (StateViolenceData State : data) {
            sum += State.getTotalDeaths();
        }
        return (double) sum / data.length;
    }

    /**
     * Finds the state with the maximum total deaths.
     * @param data the array of StateViolenceData
     * @return the StateViolenceData with max total deaths
     */
    public static StateViolenceData StateMaxTotalDeaths(StateViolenceData[] data) {
        StateViolenceData maxState = null;
        for (StateViolenceData s : data) {
            if (s.getTotalDeaths() > maxState.getTotalDeaths()) {
                maxState = s;
            }
        }
        return maxState;
    }

    /**
     * Finds the state with the minimum total deaths.
     * @param data the array of StateViolenceData
     * @return the StateViolenceData with min total deaths
     */
    public static StateViolenceData StateMinTotalDeaths(StateViolenceData[] data) {
        StateViolenceData minState = null;
        for (StateViolenceData s : data) {
            if (s.getTotalDeaths() < minState.getTotalDeaths()) {
                minState = s;
            }
        }
        return minState;
    }
}
