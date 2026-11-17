package by.gstu.project.cli;

import by.gstu.project.core.Calculator;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

/**
 * Console calculator entry point using JANSI for colored output.
 */
public class App {

    public static String greeting() {
        return "Hello from GSTU Calculator!";
    }

    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        try {
            Calculator calc = new Calculator();
            System.out.println(Ansi.ansi().fgCyan().bold().a(greeting()).reset());

            if (args.length == 3) {
                double a = Double.parseDouble(args[0]);
                String op = args[1];
                double b = Double.parseDouble(args[2]);
                System.out.println(Ansi.ansi().fgGreen().a(calc.formatExpression(op, a, b)).reset());
            } else {
                System.out.println(Ansi.ansi().fgYellow().a("Demo calculations:").reset());
                System.out.println(Ansi.ansi().fgGreen().a("  " + calc.formatExpression("+", 12, 8)).reset());
                System.out.println(Ansi.ansi().fgGreen().a("  " + calc.formatExpression("-", 15, 4)).reset());
                System.out.println(Ansi.ansi().fgGreen().a("  " + calc.formatExpression("*", 6, 7)).reset());
                System.out.println(Ansi.ansi().fgGreen().a("  " + calc.formatExpression("/", 20, 4)).reset());
            }
        } catch (Exception e) {
            System.err.println(Ansi.ansi().fgRed().a("Error: " + e.getMessage()).reset());
        } finally {
            AnsiConsole.systemUninstall();
        }
    }
}
