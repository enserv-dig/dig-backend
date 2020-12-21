package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.entity.Photo;
import com.enservsolutions.dig.repository.PhotoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Slf4j
@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("photo")
public class PhotoController {
    private final PhotoRepository photoRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        Photo img = new Photo(file.getOriginalFilename(), compressBytes(file.getBytes()));
        log.info(String.valueOf(img.getPicByte().length));
        photoRepository.save(img);
        return ResponseEntity.status(HttpStatus.CREATED).body("done");
    }

 @GetMapping(path = { "/get/{imageName}" })
    public Photo getImage(@PathVariable("imageName") String imageName) throws IOException {
        final Optional<Photo> retrievedImage = photoRepository.findByName(imageName);
        Photo img = new Photo(retrievedImage.get().getName(), decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        return outputStream.toByteArray();
    }


    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {

        } catch (DataFormatException e) {

        }
        return outputStream.toByteArray();
    }
}
