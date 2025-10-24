import java.time.LocalDate;

public class Member {
    private final String name;
    private final String address;
    private final String email;
    private final String personalNumber;
    private final LocalDate membershipStartDate;
    private final LocalDate lastPaymentDate;
    private final String membershipLevel;

    public Member(String name, String address, String email, String personalNumber,
                  LocalDate membershipStartDate, LocalDate lastPaymentDate, String membershipLevel) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.personalNumber = personalNumber;
        this.membershipStartDate = membershipStartDate;
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
