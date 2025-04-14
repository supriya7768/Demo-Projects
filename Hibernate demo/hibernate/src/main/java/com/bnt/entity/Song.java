package com.bnt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity                               //inside a database u have table song
//@Table(name = "Songs")              //if your class name does not match the database table
public class Song {
	
	@Id
	@Column(name = "songid")           //if your column name does not match databse column
	@GeneratedValue(strategy = GenerationType.IDENTITY)     //database will be giving the id here,, this annotation does not generate id
	private int id;
	private String songName;
	private String singer;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	@Override
	public String toString() {
		return "Song [id=" + id + ", songName=" + songName + ", singer=" + singer + "]";
	}
		

}
