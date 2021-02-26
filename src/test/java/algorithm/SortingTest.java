package algorithm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTest {
    @TempDir
    File tempDirectory;

    @Test
    public void testSortingStringsAsc() throws IOException {
        List<String> expectedResult = Arrays.asList("a", "b", "c", "d", "h", "j", "k", "m", "n", "o", "z");
        String input1 = "in1.txt";
        List<String> lines1 = Arrays.asList("a", "d", "j", "k", "n");
        File inFile1 = createTempFile(input1, lines1);

        String input2 = "in2.txt";
        List<String> lines2 = Arrays.asList("b", "c", "h", "m", "o", "z");
        File inFile2 = createTempFile(input2, lines2);

        String outputFileName = "out.txt";
        File outfile = new File(tempDirectory, outputFileName);

        List<String> inputFiles = new ArrayList<>();
        inputFiles.add(inFile1.getAbsolutePath());
        inputFiles.add(inFile2.getAbsolutePath());

        Sorting sorting = new Sorting(new SortSettings(true, true, inputFiles, outfile.getAbsolutePath()));
        sorting.sort();

        List<String> result = readFile(outfile.getAbsolutePath());
        assertEquals(expectedResult, result);

    }

    @Test
    public void testSortingStringsDesc() throws IOException {
        List<String> expectedResult = Arrays.asList("z", "y", "x", "l", "k", "j", "i", "h", "g", "f", "e", "d", "c", "b", "a");
        String input1 = "in1.txt";
        List<String> lines1 = Arrays.asList("z", "y", "x", "j", "g", "d", "a");
        File inFile1 = createTempFile(input1, lines1);

        String input2 = "in2.txt";
        List<String> lines2 = Arrays.asList("k", "h", "e", "b");
        File inFile2 = createTempFile(input2, lines2);

        String input3 = "in3.txt";
        List<String> lines3 = Arrays.asList("l", "i", "f", "c");
        File inFile3 = createTempFile(input3, lines3);

        String outputFileName = "out.txt";
        File outfile = new File(tempDirectory, outputFileName);

        List<String> inputFiles = new ArrayList<>();
        inputFiles.add(inFile1.getAbsolutePath());
        inputFiles.add(inFile2.getAbsolutePath());
        inputFiles.add(inFile3.getAbsolutePath());

        Sorting sorting = new Sorting(new SortSettings(false, true, inputFiles, outfile.getAbsolutePath()));
        sorting.sort();

        List<String> result = readFile(outfile.getAbsolutePath());
        assertEquals(expectedResult, result);

    }

    @Test
    public void testSortingStringsDescWithInvalidData() throws IOException {
        List<String> expectedResult = Arrays.asList("t", "s", "r", "i", "h", "g", "f", "e", "d", "c", "b", "a");
        String input1 = "in1.txt";
        List<String> lines1 = Arrays.asList("\n", "t", "z", "g", "d", "a", "\n");
        File inFile1 = createTempFile(input1, lines1);

        String input2 = "in2.txt";
        List<String> lines2 = Arrays.asList("s", "y", "h", "\n", "e", "b", "");
        File inFile2 = createTempFile(input2, lines2);

        String input3 = "in3.txt";
        List<String> lines3 = Arrays.asList("r", "x", " ", "i", "f", "c");
        File inFile3 = createTempFile(input3, lines3);

        String outputFileName = "out.txt";
        File outfile = new File(tempDirectory, outputFileName);

        List<String> inputFiles = new ArrayList<>();
        inputFiles.add(inFile1.getAbsolutePath());
        inputFiles.add(inFile2.getAbsolutePath());
        inputFiles.add(inFile3.getAbsolutePath());

        Sorting sorting = new Sorting(new SortSettings(false, true, inputFiles, outfile.getAbsolutePath()));
        sorting.sort();

        List<String> result = readFile(outfile.getAbsolutePath());
        assertEquals(expectedResult, result);

    }

    @Test
    public void testSortingIntegersAsc() throws IOException {
        List<String> expectedResult = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "15");
        String input1 = "in1.txt";
        List<String> lines1 = Arrays.asList("1", "3", "4", "5", "8");
        File inFile1 = createTempFile(input1, lines1);

        String input2 = "in2.txt";
        List<String> lines2 = Arrays.asList("2", "6", "7", "9", "10", "15");
        File inFile2 = createTempFile(input2, lines2);

        String outputFileName = "out.txt";
        File outfile = new File(tempDirectory, outputFileName);

        List<String> inputFiles = new ArrayList<>();
        inputFiles.add(inFile1.getAbsolutePath());
        inputFiles.add(inFile2.getAbsolutePath());

        Sorting sorting = new Sorting(new SortSettings(true, false, inputFiles, outfile.getAbsolutePath()));
        sorting.sort();

        List<String> result = readFile(outfile.getAbsolutePath());
        assertEquals(expectedResult, result);
    }


    @Test
    public void testSortingIntegersAscInvalidData() throws IOException {
        List<String> expectedResult = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "15");
        String input1 = "in1.txt";
        List<String> lines1 = Arrays.asList("aa", "1", "3", "4", "5", "8");
        File inFile1 = createTempFile(input1, lines1);

        String input2 = "in2.txt";
        List<String> lines2 = Arrays.asList("bb", "2", "6", "7", "9", "10", "15");
        File inFile2 = createTempFile(input2, lines2);

        String outputFileName = "out.txt";
        File outfile = new File(tempDirectory, outputFileName);

        List<String> inputFiles = new ArrayList<>();
        inputFiles.add(inFile1.getAbsolutePath());
        inputFiles.add(inFile2.getAbsolutePath());

        Sorting sorting = new Sorting(new SortSettings(true, false, inputFiles, outfile.getAbsolutePath()));
        sorting.sort();

        List<String> result = readFile(outfile.getAbsolutePath());
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSortingIntegersDesc() throws IOException {
        List<String> expectedResult = Arrays.asList("15", "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1");
        String input1 = "in1.txt";
        List<String> lines1 = Arrays.asList("13", "10", "7", "4", "1");
        File inFile1 = createTempFile(input1, lines1);

        String input2 = "in2.txt";
        List<String> lines2 = Arrays.asList("14", "11", "8", "5", "2");
        File inFile2 = createTempFile(input2, lines2);

        String input3 = "in3.txt";
        List<String> lines3 = Arrays.asList("15", "12", "9", "6", "3");
        File inFile3 = createTempFile(input3, lines3);

        String outputFileName = "out.txt";
        File outfile = new File(tempDirectory, outputFileName);

        List<String> inputFiles = new ArrayList<>();
        inputFiles.add(inFile1.getAbsolutePath());
        inputFiles.add(inFile2.getAbsolutePath());
        inputFiles.add(inFile3.getAbsolutePath());

        Sorting sorting = new Sorting(new SortSettings(false, false, inputFiles, outfile.getAbsolutePath()));
        sorting.sort();

        List<String> result = readFile(outfile.getAbsolutePath());
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSortingIntegersDescInvalidData() throws IOException {
        List<String> expectedResult = Arrays.asList("15", "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1");
        String input1 = "in1.txt";
        List<String> lines1 = Arrays.asList("aa", "13", "10", "7", "\n", "4", "1", "aa");
        File inFile1 = createTempFile(input1, lines1);

        String input2 = "in2.txt";
        List<String> lines2 = Arrays.asList("aa", "14", "11", "8", "5", "2", "cc");
        File inFile2 = createTempFile(input2, lines2);

        String input3 = "in3.txt";
        List<String> lines3 = Arrays.asList("dd", "15", "12", "9", "6", "3", "");
        File inFile3 = createTempFile(input3, lines3);

        String outputFileName = "out.txt";
        File outfile = new File(tempDirectory, outputFileName);

        List<String> inputFiles = new ArrayList<>();
        inputFiles.add(inFile1.getAbsolutePath());
        inputFiles.add(inFile2.getAbsolutePath());
        inputFiles.add(inFile3.getAbsolutePath());

        Sorting sorting = new Sorting(new SortSettings(false, false, inputFiles, outfile.getAbsolutePath()));
        sorting.sort();

        List<String> result = readFile(outfile.getAbsolutePath());
        assertEquals(expectedResult, result);
    }



    private File createTempFile(String fileName, List<String> lines) throws IOException {
        File file = new File(tempDirectory, fileName);
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (String line : lines) {
            writer.write(line);
            writer.write("\n");
        }
        writer.close();
        return file;
    }

    private List<String> readFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }
}
