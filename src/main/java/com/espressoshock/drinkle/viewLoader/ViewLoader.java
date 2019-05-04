package com.espressoshock.drinkle.viewLoader;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;

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

    public static void setLoadingWrapperNode(Node loadingWrapperNode) {
        ViewLoader.loadingWrapperNode = loadingWrapperNode;
    }
}
