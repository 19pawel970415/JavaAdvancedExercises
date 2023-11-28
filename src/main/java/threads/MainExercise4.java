package threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.Optional;
import java.util.Scanner;

public class MainExercise4 implements Runnable {

    private static File file;
    private static Optional<String> pathString = Optional.empty();
    private static boolean watching = false;
    private static boolean modifying = false;

    public static void main(String[] args) {
        MainExercise4 mainExercise4 = new MainExercise4();
        Thread thread = new Thread(mainExercise4);
        thread.start();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String line = scanner.nextLine();
                pathString = Optional.ofNullable(line);
                watching = false;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            if (pathString.isPresent()) {
                File file1 = new File(pathString.get());
                if (file1.exists() && file1.isFile()) {
                    try {
                        if (file == null || !file1.getCanonicalPath().equals(file.getCanonicalPath())) {
                            printFileContent(file1);
                            file = file1;
                            if (!watching) {
                                watchFileChanges(file1.toPath());
                                watching = true;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printFileContent(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void watchFileChanges(Path path) {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            path.getParent().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

            new Thread(() -> {
                try {
                    WatchKey key;
                    while ((key = watchService.take()) != null) {
                        for (WatchEvent<?> event : key.pollEvents()) {
                            if (event.context().equals(path.getFileName())) {
                                if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY && !modifying) {
                                    modifying = true;
                                } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY && modifying) {
                                    System.out.println("File has been modified. Printing new content:");
                                    printFileContent(path.toFile());
                                    modifying = false;
                                }
                            }
                        }
                        key.reset();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
