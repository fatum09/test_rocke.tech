package taskone;

import java.io.*;
import java.util.*;

public class TaskOneDistinct {

    private static final String FILE_PROPERTY = "src/main/resources/config.properties";
    private Properties property = new Properties();

    private String propFileName; //file for load
    private String propRegexForSymbols; //regex for replace to "" in file
    private String propFileRegexForSpaces; //regex for replace to " " or "    " to " " in file

    private StringBuilder resultStringBuilder = new StringBuilder();
    private Set<String> resultSet = new HashSet<>();

    public TaskOneDistinct() {

        try (FileInputStream fis = new FileInputStream(FILE_PROPERTY)) {

            property.load(fis);

            propFileName = property.getProperty("file.name");
            propRegexForSymbols = property.getProperty("file.regexForSymbols");
            propFileRegexForSpaces = property.getProperty("file.regexForSpaces");

            loadFile();
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

    }

    private void loadFile() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(propFileName))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultStringBuilder.append(line);
                resultStringBuilder.append(System.lineSeparator());
            }

        } catch (FileNotFoundException e) {
            System.err.println("ОШИБКА: Файл для чтения не доступен");
        }
    }

    public Set<String> getDistinct(String str) {
        if (str == null) {
            throw new NullPointerException("Parameter String cannot be null");
        }
        resultStringBuilder = new StringBuilder(str);
        return getDistinct();
    }

    public Set<String> getDistinct() {
        //        Arrays.stream(resultString.split(" ")).distinct().forEach(s -> resultSet.add(s));
        Arrays.stream(resultStringBuilder.toString().split(" ")).forEach(s -> resultSet.add(s));

        return resultSet; //TODO Immutable Set - ?
    }


    public String cleanStrings(String str) {
        if (str == null) {
            throw new NullPointerException("Parameter String cannot be null");
        }

        resultStringBuilder = new StringBuilder(str);

        return cleanStrings();

    }

    public String cleanStrings() {

        String resultString = resultStringBuilder.toString();

        resultString = resultStringBuilder.toString().replaceAll(propRegexForSymbols, "");
        resultString = resultString.replaceAll(propFileRegexForSpaces, " ");
        resultString = resultString.replaceAll("\\s", " ");
        resultString = resultString.toLowerCase();

        return resultString;
    }

    public void printResult() {
        System.out.println("Result");
        System.out.println("Size " + resultSet.size());
        resultSet.forEach(s -> System.out.print(s + " "));
    }

}
