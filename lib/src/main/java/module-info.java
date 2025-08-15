 module jenvy {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.swing;
    requires atlantafx.base;
    requires org.jetbrains.annotations;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.boxicons;
    requires javafx.base;

     exports org.jenvy.view;
    exports org.jenvy.controller;
    exports org.jenvy.interactor;
    exports org.jenvy.model;
    exports org.jenvy.dto;
    exports org.jenvy.components;
    exports org.jenvy.utils;
    exports org.jenvy.view.router;
    exports org.jenvy;
    
}
