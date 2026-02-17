import java.io.File;
import java.util.Scanner;

/**
 * Main application for the Data Analysis Mini‑Project.
 *
 * TODO:
 *  - Update the path to your dataset file
 *  - Read the CSV file using Scanner
 *  - Parse each row and extract the correct columns
 *  - Construct StateViolenceData objects from each row
 *  - Store them in an array
 *  - Write methods to analyze the dataset (min, max, average, filters, etc.)
 *  - Print insights and answer your guiding question
 *  - Add Javadoc comments for any methods you create
 */
public class App {
    public static void main(String[] args) {

        // TODO: Update this with your CSV file path
        File file = new File("ViolenceData.csv");

        // TODO: Create an array of StateViolenceData objects to store data
        StateViolenceData[] data = null;

        // TODO: Read file using Scanner
        // - Skip header if needed
        // - Loop through rows
        // - Split each line by commas
        // - Convert text to numbers when needed
        // - Create new StateViolenceData objects
        // - Add to your array
        try {
            // First pass: count valid rows
            Scanner scanner = new Scanner(file);
            boolean firstLine = true;
            int count = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length < 7) continue;
                try {
                    int population = Integer.parseInt(parts[1]);
                    int gunDeaths = Integer.parseInt(parts[4]);
                    int drugDeaths = Integer.parseInt(parts[6]);
                    if (population < 0 || gunDeaths < 0 || drugDeaths < 0) continue;
                    count++;
                } catch (NumberFormatException e) {
                    // Ignore errors / Skip empty rows
                }
            }
            scanner.close();

            // Create array
            data = new StateViolenceData[count];

            // Second pass: fill array
            scanner = new Scanner(file);
            firstLine = true;
            int index = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length < 7) continue;
                try {
                    String state = parts[0];
                    int population = Integer.parseInt(parts[1]);
                    int gunDeaths = Integer.parseInt(parts[4]);
                    int drugDeaths = Integer.parseInt(parts[6]);
                    if (population < 0 || gunDeaths < 0 || drugDeaths < 0) continue;
                    data[index] = new StateViolenceData(state, population, drugDeaths, gunDeaths);
                    index++;
                } catch (NumberFormatException e) {
                    // Skip invalid rows
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // TODO: Call your analysis methods
        // Example:
        // double maxValue = findMaxValue(dataList);
        // double average = computeAverageValue(dataList);
        int maxTotal = StateViolenceData.MaxTotalDeaths(data);
        int minTotal = StateViolenceData.MinTotalDeaths(data);
        double avgTotal = StateViolenceData.AverageTotalDeaths(data);

        // Find state with max and min total deaths
        StateViolenceData maxState = StateViolenceData.StateMaxTotalDeaths(data);
        StateViolenceData minState = StateViolenceData.StateMinTotalDeaths(data);

        // TODO: Print insights
        // - Number of rows loaded
        // - Min, max, average, or any other findings
        // - Final answer to your guiding question
        System.out.println("Number of states loaded: " + data.length);
        System.out.println("Max total deaths: " + maxTotal);
        System.out.println("Min total deaths: " + minTotal);
        System.out.println("Average state deaths: " + avgTotal);
        System.out.println("State with highest total deaths: " + maxState.getState() + " (" + maxState.getTotalDeaths() + ")");
        System.out.println("State with lowest total deaths: " + minState.getState() + " (" + minState.getTotalDeaths() + ")");

        // OPTIONAL TODO:
        // Add user interaction:
        // Ask the user what kind of analysis they want to see
    }


}
