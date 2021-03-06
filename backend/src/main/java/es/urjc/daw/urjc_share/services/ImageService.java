package es.urjc.daw.urjc_share.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Configuration
public class ImageService implements WebMvcConfigurer {
    private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "images");

    private Path createFilePath(long id, Path folder) {
        return folder.resolve("image-" + id + ".jpg");
    }

    public void saveImage(String folderName, long id, MultipartFile image) throws IOException {
        Path folder = FILES_FOLDER.resolve(folderName);
        if (!Files.exists(folder)) {
            Files.createDirectories(folder);
        }
        Path newFile = createFilePath(id, folder);
        image.transferTo(newFile);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/images/**").addResourceLocations("file:" + FILES_FOLDER.toAbsolutePath().toString() + "/");
    	registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
    public ResponseEntity<Object> createResponseFromImage(String folderName, long id) throws MalformedURLException {

        Path folder = FILES_FOLDER.resolve(folderName);

        Resource file = new UrlResource(createFilePath(id, folder).toUri());
        
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/jpeg").body(file);
    }
}
