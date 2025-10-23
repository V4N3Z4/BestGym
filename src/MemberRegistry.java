import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class MemberRegistry {
    private List<Member> members = new ArrayList<>();

    public MemberRegistry(String filePath) {
        loadMembers(filePath);
    }

    private void loadMembers(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            System.out.println("File not found: " + filePath);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();


            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split(";");
                if (parts.length < 7) continue;

                try {
                    LocalDate startDate = LocalDate.parse(parts[4].trim());
                    LocalDate lastPayment = LocalDate.parse(parts[5].trim());

                    Member m = new Member(
                            parts[0].trim(), // name
                            parts[1].trim(), // address
                            parts[2].trim(), // email
                            parts[3].trim(), // personal number
                            startDate,       // membership start date
                            lastPayment,     // last payment date
                            parts[6].trim()  // membership level
                    );
                    members.add(m);
                 } catch (DateTimeParseException e) {
                    System.out.println(" Invalid date in line: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println(" Error reading the file: " + e.getMessage());
        }
    }

    public Member findMember(String input) {
        String trimmedInput = input.trim();
        for (Member m : members) {

            if (m.getName().equalsIgnoreCase(trimmedInput) || m.getPersonalNumber().equals(trimmedInput)) {
                return m;
            }
        }

        return null;
    }
}