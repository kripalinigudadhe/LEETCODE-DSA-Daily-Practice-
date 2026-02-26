import java.util.*;

class StringBinary {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int currentBit = (s.charAt(i) - '0') + carry;

            if (currentBit % 2 == 0) {
                steps += 1;      // Even case → divide by 2
            } else {
                steps += 2;      // Odd case → add 1 and divide
                carry = 1;
            }
        }

        return steps + carry;
    }

    // PSVM
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary string: ");
        String s = sc.nextLine();

        StringBinary sol = new StringBinary();
        int result = sol.numSteps(s);

        System.out.println("Number of steps to reduce to 1: " + result);

        sc.close();
    }
}