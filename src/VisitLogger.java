import java.io.*;
import java.time.LocalDate;

public class VisitLogger {
    private String logFilePath;

    public VisitLogger(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void logVisit(Member member) {
        if (alreadyLoggedToday(member)) {
            System.out.println("A visit has already been logged today for this member.");
            return;
        }

        try (FileWriter writer = new FileWriter(logFilePath, true)) {
            writer.write(member.getName() + ";" + member.getPersonalNumber() + ";" + LocalDate.now() + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error while logging the visit: " + e.getMessage());
        }
    }

    private boolean alreadyLoggedToday(Member member) {
        File file = new File(logFilePath);
        if (!file.exists()) return false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String today = LocalDate.now().toString();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    String personalNumber = parts[1].trim();
                    String date = parts[2].trim();
                    if (personalNumber.equals(member.getPersonalNumber()) && date.equals(today)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error while checking for duplicates: " + e.getMessage());
        }
        return false;
    }
}