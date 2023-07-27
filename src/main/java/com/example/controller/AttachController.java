package com.example.controller;

import com.example.dto.AttachResponseDTO;
import com.example.service.AttachService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: Alisher Odilov
 * Date: 17.03.2023
 */
//@Tag(name = "Attach Controller", description = "This controller for file uploading and file downloading")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/attach")
public class AttachController {

    private final AttachService attachService;


    /**
     * This method is used for file uploading in DataBase
     * If File Name is Empty  ,throw FileNameNotFoundException()
     *
     * @param file MultipartHttpServletRequest
     * @return AttachDTO
     */
    @PostMapping(value = "/public/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@ModelAttribute("file")MultipartFile file){
        log.info("upload file -> multipartFile: {}", file);
        AttachResponseDTO result=attachService.uploadFile(file);
        return ResponseEntity.ok(result);
    }

    /**
     * This method is used for downloading file
     * If file is not exist DB, throw FileNotFoundException
     *
     * @param id       Integer
     * @return Message
     */
    @GetMapping(value = "public/download/{id}", produces = MediaType.ALL_VALUE)
    public ResponseEntity<?> downloadFile(@PathVariable("id") String id){
        log.info("downloadMedia by id: {}", id);
        Resource file =attachService.downloadFile(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
        "attachment; filename=\"" + file.getFilename()+"\"").body(file);
    }
}
