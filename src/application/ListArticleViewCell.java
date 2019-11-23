package application;

import javafx.scene.image.ImageView;

public class ListArticleViewCell {
	final String title;
    final ImageView image;

    public ListArticleViewCell(final String title, final String imageURL) {
        this.title = title;
        this.image = new ImageView(imageURL);
    }

}


