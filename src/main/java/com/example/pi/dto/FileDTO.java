package com.example.pi.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FileDTO {

    private String name;

    private String path;

    private MultipartFile blob;

}
