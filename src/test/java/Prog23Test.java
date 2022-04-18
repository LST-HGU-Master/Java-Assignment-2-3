import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.io.*;

public class Prog23Test {

    @Test
    public void testAdultWithCert()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        in.inputln("1");
        in.inputln("1");
        Prog23.main(null);

        // assertion
        String[] prints = bos.toString().split(System.lineSeparator());
        assertTrue(prints[prints.length - 1].contains("700円です"));

        // undo the binding in System
        System.setOut(originalOut);
    }

    @Test
    public void testAdultWithoutCert()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        in.inputln("1");
        in.inputln("2");
        Prog23.main(null);

        // assertion
        String[] prints = bos.toString().split(System.lineSeparator());
        assertTrue(prints[prints.length - 1].contains("1,000円です"));

        // undo the binding in System
        System.setOut(originalOut);
    }

    @Test
    public void testChild()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        in.inputln("2");
        Prog23.main(null);

        // assertion
        String[] prints = bos.toString().split(System.lineSeparator());
        assertTrue(prints[prints.length - 1].contains("無料です"));

        // undo the binding in System
        System.setOut(originalOut);
    }

    @Test
    public void testPassport()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        in.inputln("3");
        Prog23.main(null);

        // assertion
        String[] prints = bos.toString().split(System.lineSeparator());
        assertTrue(prints[prints.length - 1].contains("1,400円です"));

        // undo the binding in System
        System.setOut(originalOut);
    }

    @Test
    public void testInvalidInput()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        in.inputln("0");
        Prog23.main(null);

        // assertion
        String[] prints = bos.toString().split(System.lineSeparator());
        assertTrue(prints[prints.length - 1].contains("区分の入力が正しくありません"));

        // undo the binding in System
        System.setOut(originalOut);
    }
}
