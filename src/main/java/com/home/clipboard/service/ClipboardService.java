package com.home.clipboard.service;

import com.home.clipboard.exceptions.ClipboardNotFoundException;
import com.home.clipboard.model.entities.Clipboard;
import com.home.clipboard.model.repo.ClipboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClipboardService {
    private ClipboardRepository clipboardRepository;

    @Autowired
    public ClipboardService (ClipboardRepository clipboardRepository){
        this.clipboardRepository = clipboardRepository;
    }

    public Clipboard save (Clipboard clipboard){
        return this.clipboardRepository.save(clipboard);
    }

    public Clipboard getClipboardById(Long id) throws ClipboardNotFoundException{
        return this.clipboardRepository.findById(id).orElseThrow(ClipboardNotFoundException::new);
    }
}
