package hust.soict.hedspi.screen;

import AimsProject.src.hust.soict.hedspi.main.Cart.Cart;
import AimsProject.src.hust.soict.hedspi.main.aims.media.Media;
import AimsProject.src.hust.soict.hedspi.main.aims.media.Playable;
import AimsProject.src.hust.soict.hedspi.main.exception.PlayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton cart_button=new JButton("Add to cart");
        container.add(cart_button);
        cart_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cart.addMedia(media);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        if (media instanceof Playable) {
            JButton play_button = new JButton("Play");
            container.add(play_button);
            play_button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ((Playable) media).play();
                    } catch (PlayerException exception) {
                        throw new RuntimeException(exception);
                    }
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
