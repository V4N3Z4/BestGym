import java.time.LocalDate;

public class Member {
    private String name;
    private String personalNumber;
    private LocalDate lastPaymentDate;
    private String membershipLevel;

    public Member(String name, String address, String email, String personalNumber,
                  LocalDate membershipStartDate, LocalDate lastPaymentDate, String membershipLevel) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.lastPaymentDate = lastPaymentDate;
        this.membershipLevel = membershipLevel;
    }

    public boolean isCurrent() {
        System.out.println("Last payment: " + lastPaymentDate);
        return lastPaymentDate.isAfter(LocalDate.now().minusYears(1));
    }

    public String getName() { return name; }
    public String getPersonalNumber() { return personalNumber; }
    public String getMembershipLevel() { return membershipLevel; }
}