package com.espressoshock.drinkle.viewLoader;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewLoader {
    private static Node loadingWrapperNode;

    public ViewLoader() {
    }

    public static <T>T load(ViewMetadata view) throws IOException {
        FXMLLoader loader = new FXMLLoader(ViewMetadata.class.getResource(view.getResourcePath()));
        Node rootNode = (Parent) loader.load();
        ((Pane) loadingWrapperNode).getChildren().add(rootNode);

        return loader.getController();
    }

    public static <T>T load(ViewMetadata view, double offsetX, double offsetY) throws IOException {
        FXMLLoader loader = new FXMLLoader(ViewMetadata.class.getResource(view.getResourcePath()));
        Node rootNode = (Parent) loader.load();
        rootNode.setLayoutX(offsetX);
        rootNode.setLayoutY(offsetY);
        ((Pane) loadingWrapperNode).getChildren().add(rootNode);

        return loader.getController();
    }

    public static <T>List<T> loadLayout(ViewMetadata view) throws IOException{
        if(view == ViewMetadata.AUTH_LOGIN || view == ViewMetadata.AUTH_REGISTRATION)
            return load(view);
         else if(view != ViewMetadata.APP_SIDEBAR){
            List<T>controllers = new ArrayList<>();
            controllers.add(load(ViewMetadata.APP_SIDEBAR, 0d, 35d));
            controllers.add(load(view, 65d, 35d));

            return controllers;
        }
        return load(view);
    }

    public static void setLoadingWrapperNode(Node loadingWrapperNode) {
        ViewLoader.loadingWrapperNode = loadingWrapperNode;
    }
}
