package org.drools.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RuleGen {

    public static String generateRule(int numOfRules) {
        StringBuilder sb = new StringBuilder();
        sb.append("package org.drools.example;\n" +
                "\n" +
                "import org.drools.example.*;\n" +
                "\n");

        for (int i = 0; i < numOfRules; i++) {
            sb.append("rule R" + i + "\n" +
                    "    when\n" +
                    "        $r : Result()\n" +
                    "        $p : Person(value1 > " + i + ", value2 > " + i + ", value3 > " + i + ", value4 > " + i + ", value5 > " + i + ")\n" +
                    "        $o : Order (value1 > $p.value1, value2 > $p.value2, value3 > $p.value3, value4 > $p.value4, value5 > $p.value5)\n" +
                    "    then\n" +
                    "        $r.addValue(" + i + ");\n" +
                    "end\n\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Path path = Paths.get("./src/main/resources/org/drools/example/personOrder.drl");
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.append(RuleGen.generateRule(1000));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}