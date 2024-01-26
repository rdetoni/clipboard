package com.home.clipboard.exceptions;

public class ClipboardNotFoundException extends Exception{
    public ClipboardNotFoundException(){
        super("Clipboard does not exist");
    }
}
