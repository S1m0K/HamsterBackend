package at.ac.htlinn.model.entities;

import at.ac.htlinn.model.QuickSort;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "PROGRAM")
public class Program implements Comparable {
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "program_seq", sequenceName = "PROGRAM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "program_seq")
    private Integer programId;

    @Column(name = "USER_ID")
    private long userID;

    @JsonIgnore
    @Column(name = "HASH_VALUE", unique = true)
    private int hashValue;

    @Column(name = "PROGRAM_NAME")
    private String programName;

    @Column(name = "SOURCE_CODE")
    private String sourceCode;

    @JsonIgnore
    @Column(name = "COMPILATION_ORDER")
    private int compilationOrder;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program that = (Program) o;
        return Objects.equals(programName, that.programName) && Objects.equals(sourceCode, that.sourceCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programName, sourceCode);
    }

    @Override
    public int compareTo(Object o) throws ClassCastException {
        if (!(o instanceof Program)) throw new ClassCastException("A program object expected");
        Program cProgram = (Program) o;
        if (this.hashCode() == cProgram.hashCode()) return 0;


        boolean containsAny = false;
        for (String s : extractClassNames(cProgram.getSourceCode())) {
            if (extractImportedClasses(this.getSourceCode()).contains(s)) {
                containsAny = true;
                break;
            }
        }

        if (containsAny) {
            return 1;
        }
        return -1;
    }


    private static ArrayList<String> extractClassNames(String input) {
        String pattern = "\\s+(class|interface)\\s+([A-Z][a-zA-Z0-9_]*)\\s*";
        ArrayList<String> classNames = new ArrayList<>();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        while (m.find()) {
            String s = m.group();
            s = s.replace("interface", "");
            s = s.replace("class", "");
            s = s.replace(" ", "");
            classNames.add(s);
        }

        return classNames;
    }

    private static ArrayList<String> extractImportedClasses(String input) {
        String pattern = "\\s*import\\s+([a-zA-Z0-9_.]*)\\s*;";
        ArrayList<String> importedClasses = new ArrayList<>();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        while (m.find()) {
            String s = m.group();
            s = s.replace("import", "");
            s = s.replace(";", "");
            s = s.replace(" ", "");
            String[] strings = s.split("\\.");
            s = strings[strings.length - 1];
            importedClasses.add(s);
        }
        return importedClasses;
    }

    private static Program getMainFile(ArrayList<Program> programs) {
        Optional<Program> programWithMain = programs.stream()
                .filter(p -> {
                    Pattern mainPattern = Pattern.compile("public\\s+static\\s+void\\s+main");
                    Matcher mainMatcher = mainPattern.matcher(p.getSourceCode());
                    return mainMatcher.find();
                })
                .findFirst();
        return programWithMain.orElse(null);
    }

    public static ArrayList<Program> resolveCompileOrder(ArrayList<Program> programs) {
        ArrayList<Comparable> sortedPrograms = (ArrayList<Comparable>) programs.clone();
        sortedPrograms = QuickSort.sort(sortedPrograms);
        programs = (ArrayList<Program>) sortedPrograms.clone();

        //move program to last position
        Program main = Program.getMainFile(programs);
        programs.remove(main);
        programs.add(main);
        return programs;
    }
}
