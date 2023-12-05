package classesInterfaces.ex1;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public List<String> validateEmails(String email, String alternativeEmail) {
        class Email {
            private String email;

            public Email(String email) {
                if (email == null || email.isEmpty() || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                    this.email = "Unknown";
                } else {
                    this.email = email;
                }
            }

            public String getFormattedEmail() {
                return email;
            }
        }

        List<String> emails = new ArrayList<>();
        Email mainEmail = new Email(email);
        Email altEmail = new Email(alternativeEmail);

        emails.add(mainEmail.getFormattedEmail());
        emails.add(altEmail.getFormattedEmail());

        return emails;
    }
}
