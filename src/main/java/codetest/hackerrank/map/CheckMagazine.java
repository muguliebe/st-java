package codetest.hackerrank.map;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class CheckMagazine {
    public static void main(String[] args) {

        String input1 = "ive got a lovely bunch of some coconuts coconuts\n";
        String input2 = "ive got some coconuts coconuts\n";


        String[] magazine = input1.trim().replaceAll("\n", "").split(" ");
        String[] note = input2.trim().replaceAll("\n", "").split(" ");

        checkMagazine(magazine, note);

    }

    private static void checkMagazine(String[] magazine, String[] note) {
        List<String> setMagazine = Arrays.stream(magazine).collect(toList());

        Optional<Boolean> first = Arrays.stream(note)
                .map(setMagazine::remove)
                .filter(answer -> answer.equals(false))
                .findFirst();
        if(first.isPresent()){
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
