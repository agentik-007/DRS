package net.jtk.darkroleplay.songs;

import java.util.ArrayList;

public class songBase {
	
	private String songName = "Alle meine entchen";
	private int songLenght = 0;
	private ArrayList<Integer> Notes = new ArrayList<Integer>();
	
	public songBase(){
		songLenght = Notes.size();
	}
	
	public int getNote(int currentNote){
		if(Notes.size() >= currentNote){
			return Notes.get(currentNote-1);
		}
		return 0;
	}	
	
	public void registerSong(){
		Notes.add(10);
		Notes.add(11);
		Notes.add(12);
		Notes.add(13);
		Notes.add(14);
		Notes.add(14);
		Notes.add(15);
		Notes.add(15);
		Notes.add(15);
		Notes.add(15);
		Notes.add(14);
		Notes.add(15);
		Notes.add(15);
		Notes.add(15);
		Notes.add(15);
		Notes.add(14);
		Notes.add(13);
		Notes.add(13);
		Notes.add(13);
		Notes.add(13);
		Notes.add(12);
		Notes.add(12);
		Notes.add(11);
		Notes.add(11);
		Notes.add(11);
		Notes.add(11);
		Notes.add(10);
	}
}
