import java.util.Scanner;

public class BestGym {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberRegistry registry = new MemberRegistry("data/members.txt");
        VisitLogger logger = new VisitLogger("data/visits.txt");

        System.out.print("Enter name or social security number: ");
        String input = scanner.nextLine().trim();

        Member member = registry.findMember(input);
        if (member == null) {
            System.out.println("Not authorized. This person is not in the registry.");
        } else if (member.isCurrent()) {
            System.out.println("Current member (" + member.getMembershipLevel() + ")");
            logger.logVisit(member);
        } else {
            System.out.println("Former client. Membership has expired.");
        }
        scanner.close();
    }
}