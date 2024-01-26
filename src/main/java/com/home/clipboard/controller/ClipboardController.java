package com.home.clipboard.controller;

import com.home.clipboard.exceptions.ClipboardNotFoundException;
import com.home.clipboard.model.entities.Clipboard;
import com.home.clipboard.service.ClipboardService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RestController
@RequestMapping(path="/clipboard")
public class ClipboardController {
    private ClipboardService clipboardService;

    @Autowired
    public ClipboardController(ClipboardService clipboardService){
        this.clipboardService = clipboardService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> create(@RequestBody Clipboard clipboard){
        try{
            Clipboard createdClipboard = this.clipboardService.save(clipboard);
            return new ResponseEntity<>(createdClipboard.getId().toString(), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("An error has occurred creating the clipboard: " + e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<String> getClipboard(@RequestParam(name="id") long id) throws ClipboardNotFoundException {
        Clipboard clipboard = this.clipboardService.getClipboardById(id);
        return new ResponseEntity<>(clipboard.getContent(), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClipboardNotFoundException.class)
    public String return404(ClipboardNotFoundException e){return e.getMessage();}
}
