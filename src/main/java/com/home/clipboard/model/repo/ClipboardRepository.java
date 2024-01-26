package com.home.clipboard.model.repo;

import com.home.clipboard.model.entities.Clipboard;
import org.springframework.data.repository.CrudRepository;

public interface ClipboardRepository extends CrudRepository<Clipboard, Long> {
}