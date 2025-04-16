package org.hajam.common.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileUtil {

    private final String uploadPath = "C:\\upload";

    public List<String> saveFiles(List<MultipartFile> multipartFiles) throws IOException {
        if (multipartFiles == null || multipartFiles.isEmpty()) {
            return List.of();
        }

        List<String> savedNames = new ArrayList<>();
        String folderPath = makeFolders();

        for (MultipartFile file : multipartFiles) {
            String originalName = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            String savedName = uuid + "_" + originalName;

            File saveFile = new File(uploadPath + File.separator + folderPath, savedName);
            file.transferTo(saveFile);

            savedNames.add(folderPath + File.separator + savedName);

            // 썸네일 생성 (이미지일 경우)
            if (file.getContentType() != null && file.getContentType().startsWith("image")) {
                File thumbnailFile = new File(uploadPath + File.separator + folderPath, "s_" + savedName);
                Thumbnails.of(saveFile)
                          .size(400, 400)
                          .toFile(thumbnailFile);
            }
        }

        return savedNames;
    }

    public void deleteFiles(List<String> fileNames) {
        if (fileNames == null || fileNames.isEmpty()) return;

        for (String fileName : fileNames) {
            File origin = new File(uploadPath, fileName);
            File thumbnail = new File(uploadPath, getThumbnailName(fileName));

            if (origin.exists()) origin.delete();
            if (thumbnail.exists()) thumbnail.delete();
        }
    }

    private String getThumbnailName(String fileName) {
        int idx = fileName.lastIndexOf(File.separator);
        String path = fileName.substring(0, idx + 1);
        String name = fileName.substring(idx + 1);
        return path + "s_" + name;
    }

    private String makeFolders() {
        String dateStr = LocalDate.now().toString().replace("-", File.separator);
        File folder = new File(uploadPath, dateStr);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        return dateStr;
    }
}
