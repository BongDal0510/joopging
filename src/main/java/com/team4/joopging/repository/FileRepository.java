package com.team4.joopging.repository;

import com.team4.joopging.entity.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileRepository extends JpaRepository<UploadFile, Integer> {
    public UploadFile findOneByFileName(int fileName);
}