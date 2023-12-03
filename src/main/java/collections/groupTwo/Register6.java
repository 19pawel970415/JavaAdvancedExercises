package collections.groupTwo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register6 {

    private List<Student6> students = new ArrayList<>();

    public void addStudent(Student6 student) {
        students.add(student);
    }

    public void removeStudent(Student6 student) {
        students.remove(student);
    }

    public void removeStudentUsingStudentsCardNumber(String studentCardNumber) {
        Optional<Student6> any = students.stream()
                .filter(s -> s.getStudentsCardNumber().equals(studentCardNumber))
                .findAny();
        if (any.isPresent()) {
            students.remove(any.get());
        } else {
            System.out.println("No student with such number");
        }
    }

    public Student6 getStudentUsingStudentsCardNumber(String studentCardNumber) {
        Optional<Student6> any = students.stream()
                .filter(s -> s.getStudentsCardNumber().equals(studentCardNumber))
                .findAny();
        if (any.isPresent()) {
            Student6 student = any.get();
            return student;
        } else {
            System.out.println("No student with such number");
            Student6 student = any.get();
            return student;
        }
    }

    public Double getStudentsAverage(String studentCardNumber) {
        OptionalDouble average = students.stream()
                .filter(s -> s.getStudentsCardNumber().equals(studentCardNumber))
                .map(s -> s.getMarks())
                .flatMap(List::stream)
                .mapToDouble(m -> (double) m)
                .average();

        if (average.isPresent()) {
            Double averageDouble = average.getAsDouble();
            return averageDouble;
        } else {
            System.out.println("No student with such number");
            return 0d;
        }
    }

    public List<Student6> getFailingStudents() {
        return students.stream()
                .filter(s -> s.getMarks().contains(2d))
                .collect(Collectors.toList());
    }

    public List<Student6> sortStudents(List<Student6> students) {
        List<Student6> sortedStudents = students.stream()
                .sorted(Comparator.comparing(s -> s.getStudentsCardNumber()))
                .collect(Collectors.toList());

        return sortedStudents;
    }

    public void addMark(String studentCardNumber, Double mark) {
        students.stream()
                .filter(s -> s.getStudentsCardNumber().equals(studentCardNumber))
                .findAny()
                .ifPresentOrElse(
                        student -> {
                            List<Double> marks = new ArrayList<>(student.getMarks());
                            marks.add(mark);
                            student.setMarks(marks);
                        },
                        () -> System.out.println("No student with such number on the list")
                );
    }

    public void addStudents(Student6... students6) {
        students.addAll(Arrays.asList(students6));
    }


    public void removeStudents(Student6... students6) {
        students.removeAll(Arrays.asList(students6));
    }

    public void removeStudentsUsingStudentsCardNumbers(String... studentCardNumbers) {
        List<Student6> studentsToKeep = students.stream()
                .filter(s -> !Arrays.asList(studentCardNumbers).contains(s.getStudentsCardNumber()))
                .collect(Collectors.toList());

        if (studentsToKeep.size() < students.size()) {
            students.clear();
            students.addAll(studentsToKeep);
        } else {
            System.out.println("No student with such number");
        }
    }

    public List<Student6> getStudentsUsingStudentsCardNumbers(String... studentCardNumbers) {
        return students.stream()
                .filter(s -> Arrays.asList(studentCardNumbers).contains(s.getStudentsCardNumber()))
                .collect(Collectors.toList());
    }

    public List<Double> getStudentsAverages(String... studentCardNumbers) {
        List<Double> averages = new ArrayList<Double>();
        for (String studentCardNumber : studentCardNumbers) {
            OptionalDouble average = students.stream()
                    .filter(s -> s.getStudentsCardNumber().equals(studentCardNumber))
                    .map(s -> s.getMarks())
                    .flatMap(List::stream)
                    .mapToDouble(m -> (double) m)
                    .average();
            if (average.isPresent()) {
                Double averageDouble = average.getAsDouble();
                averages.add(averageDouble);
            } else {
                System.out.println("No student with such number");
            }
        }
        return averages;
    }

    public void addMarkForStudents(Double mark, String... studentCardNumbers) {
        Arrays.asList(studentCardNumbers).forEach(studentCardNumber -> students.stream()
                .filter(s -> s.getStudentsCardNumber().equals(studentCardNumber))
                .findAny()
                .ifPresentOrElse(
                        student -> {
                            List<Double> marks = new ArrayList<>(student.getMarks());
                            marks.add(mark);
                            student.setMarks(marks);
                        },
                        () -> System.out.println("No student with such number on the list")
                )
        );
    }

    public void addMarksForStudent(String studentCardNumber, Double... marks) {
        students.stream()
                .filter(s -> s.getStudentsCardNumber().equals(studentCardNumber))
                .findAny()
                .ifPresentOrElse(
                        student -> {
                            List<Double> studentMarks = new ArrayList<>(student.getMarks());
                            studentMarks.addAll(Arrays.asList(marks));
                            student.setMarks(studentMarks);
                        },
                        () -> System.out.println("No student with such number on the list")
                );
    }

}
