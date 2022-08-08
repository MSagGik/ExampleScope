package ru.msaggik.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        // сравнение бинов по указателям на память
        boolean comparison = firstMusicPlayer == secondMusicPlayer;
        System.out.println(comparison);
        // изменение парамметра у первого плейера
        firstMusicPlayer.setVolume(10);

        firstMusicPlayer.playMusic();
        secondMusicPlayer.playMusic();

        System.out.println(firstMusicPlayer.getName());
        System.out.println(firstMusicPlayer.getVolume());
      
        System.out.println(secondMusicPlayer.getName());
        System.out.println(secondMusicPlayer.getVolume());

        context.close();
    }
}
