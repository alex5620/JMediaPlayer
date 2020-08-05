package App.ButtonsPanel;

import App.FileTypeFilter;
import App.JMediaPlayer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;


public class LoadButton extends AbstractButton {
    public LoadButton(JMediaPlayer mediaPlayer)
    {
        super(mediaPlayer);
        setBounds(320, 15, 62, 60);
        setIcon(new ImageIcon("images/open.png"));
        addListeners();
    }

    @Override
    protected void addListeners()
    {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setIcon(new ImageIcon("images/open_pressed.png"));
                JFileChooser openFileChooser = new JFileChooser(mediaPlayer.getCurrentDirectory());
                openFileChooser.setFileFilter(new FileTypeFilter(".mp3", "Open MP3 Files Only!"));
                int result = openFileChooser.showOpenDialog(null);
                if(result == JFileChooser.APPROVE_OPTION)
                {
                    mediaPlayer.getPlayer().stop();
                    File songFile = openFileChooser.getSelectedFile();
                    mediaPlayer.setSongFile(songFile);
                    mediaPlayer.updateCurrentDirectory(songFile.getAbsolutePath());
                    mediaPlayer.updateSongName();
                    mediaPlayer.createPlayer();
                    mediaPlayer.getPlayer().play();
                }
                setIcon(new ImageIcon("images/open.png"));
            }
        });
    }

}
