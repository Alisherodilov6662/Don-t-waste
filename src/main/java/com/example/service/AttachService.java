package com.example.service;

import com.example.dto.AttachResponseDTO;
import com.example.repository.AttachmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: Alisher Odilov
 * Date: 16.07.2023
 */
@Service
@AllArgsConstructor
public class AttachService {

    private final AttachmentRepository attachmentRepository;

    private final ResourceBundleService resourceBundleService;


    public AttachResponseDTO uploadFile(MultipartFile file) {
        return null;
    }

    public Resource downloadFile(String id) {
        return null;
    }
}
