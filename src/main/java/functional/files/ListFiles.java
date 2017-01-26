package functional.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListFiles {

	public static void main(String[] args) throws IOException, InterruptedException {
		Files.list(Paths.get("."))
			.filter(Files::isDirectory)
			.forEach(System.out::println)
			;
		
		System.out.println("====================");
		
		Files.newDirectoryStream(
				Paths.get("src/main/java/functional/files"), path -> path.toString().endsWith(".java")
				)
			.forEach(System.out::println);
		
		System.out.println("====================");
		
		{
			final File[] files = new File(".").listFiles(file -> file.isHidden());
			new File(".").listFiles(File::isHidden);
		}
		
		System.out.println("====================");
		{
			List<File> files =
					Stream.of(new File(".").listFiles())
					.flatMap(file -> file.listFiles() == null ?
							Stream.of(file) : Stream.of(file.listFiles()))
					.collect(Collectors.toList());
			System.out.println("Count: " + files.size());
					
		}
		
		{
			final Path path = Paths.get(".");
			final WatchService watchService = path.getFileSystem().newWatchService();
			path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
			System.out.println("Report any file changed within next 1 minutes...");
			
			final WatchKey watchKey = watchService.poll(10000, TimeUnit.MINUTES);
			if(watchKey != null) {
				watchKey.pollEvents().stream().forEach(event ->
				System.out.println(event.context()));
			}
		}
		
		
	}
}
