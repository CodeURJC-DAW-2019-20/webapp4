package es.urjc.daw.urjc_share.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadFileService implements WebMvcConfigurer {
    private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "src/main/resources/static");

    private Path createFilePath(long id, Path folder, String extension) {
        return folder.resolve("note-" + id + "." + extension);
    }

    public void saveFile(String folderName, MultipartFile file, long id) throws IOException {
        Path folder = FILES_FOLDER.resolve(folderName);
        if (!Files.exists(folder)) {
            Files.createDirectories(folder);
        }
        String[] s = file.getOriginalFilename().split("\\.");
        Path newFile = createFilePath(id, folder, s[s.length-1]);
        file.transferTo(newFile);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/notes/**").addResourceLocations("file:" + FILES_FOLDER.toAbsolutePath().toString() + "/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    public ResponseEntity<Object> createResponseFromImage(String folderName, long id, String extension) throws MalformedURLException {

        Path folder = FILES_FOLDER.resolve(folderName);

        Resource file = new UrlResource(createFilePath(id, folder, extension).toUri());

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "notes/file").body(file);
    }
}
