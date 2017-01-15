package helpers;

import java.io.*;

import javazoom.jl.player.*;

public class Music {
	
	private static Player player;
	private static Player defeat;
	private static Player victory;
	private static Player mouse;

	// constructor that takes the name of an MP3 file

	public static void close ()
	{
		if (player != null) {
			player.close();
		}
	}

	// play the MP3 file to the sound card
	public static void play ()
	{
		try
		{
			FileInputStream fis = new FileInputStream(new File("D:/我的文件夾/桌面/JAVA/JAVA專題/workspace/CSEDenfender/src/res/BGM.mp3"));
			player = new Player(fis);
		} catch (Exception e)
		{
			System.out.println("Problem playing file BGM");
			System.out.println(e);
		}

		// run in new thread to play in background
		new Thread() {
			public void run ()
			{
				try
				{
					player.play();
				} catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}.start();
	}
	
	public static void defeat () {
		try
		{
			FileInputStream fis = new FileInputStream(new File("D:/我的文件夾/桌面/JAVA/JAVA專題/workspace/CSEDenfender/src/res/Defeat.mp3"));
			defeat = new Player(fis);
		} catch (Exception e)
		{
			System.out.println("Problem playing file DefeatBGM");
			System.out.println(e);
		}

		// run in new thread to play in background
		new Thread() {
			public void run ()
			{
				try
				{
					defeat.play();
				} catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}.start();
	}
	
	public static void mouseClick () {
		try
		{
			FileInputStream fis = new FileInputStream(new File("D:/我的文件夾/桌面/JAVA/JAVA專題/workspace/CSEDenfender/src/res/click_one.mp3"));
			mouse = new Player(fis);
		} catch (Exception e)
		{
			System.out.println("Problem playing file Click");
			System.out.println(e);
		}

		// run in new thread to play in background
		new Thread() {
			public void run ()
			{
				try
				{
					mouse.play();
				} catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}.start();
	}
	
	public static void victory () {
		try
		{
			FileInputStream fis = new FileInputStream(new File("D:/我的文件夾/桌面/JAVA/JAVA專題/workspace/CSEDenfender/src/res/Victory.mp3"));
			victory = new Player(fis);
		} catch (Exception e)
		{
			System.out.println("Problem playing file victoryBGM");
			System.out.println(e);
		}

		// run in new thread to play in background
		new Thread() {
			public void run ()
			{
				try
				{
					victory.play();
				} catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}.start();
	}
}
