package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
    }

    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập id bài hát: ");
        songId = sc.nextLine();
        while (!songId.matches("^S.{3}$")) {
            System.out.println("Id bài hát 4 ký tự và bắt đầu bằng kí tự S, không trùng lặp.vui lòng nhập lại: ");
            songId = sc.nextLine();
        }
        System.out.println("Mời bạn nhập tên bài hát: ");
        songName = sc.nextLine();
        while (songName.isEmpty()) {
            System.out.println("Tên bài hát không được để trống! Mời bạn nhập lại: ");
            songName = sc.nextLine();
        }
        System.out.println("Mời bạn nhập mô tả bài hát: ");
        descriptions = sc.nextLine();
        while (descriptions.isEmpty()) {
            System.out.println("Mô tả không được để trống! Mời bạn nhập lại: ");
            descriptions = sc.nextLine();
        }
        System.out.println("Mời bạn nhập id ca sĩ: ");
        int id = Integer.parseInt(sc.nextLine());
        singer = new Singer();
        System.out.println("Mời bạn nhập người sáng tác bài hát: ");
        songWriter = sc.nextLine();
        while (songWriter.isEmpty()) {
            System.out.println("Người sáng tác không được để trống! Mời bạn nhập lại: ");
            songWriter = sc.nextLine();
        }
        System.out.println("Mời bạn nhập trạng thái bài hát (true/false): ");
        songStatus = Boolean.parseBoolean(sc.nextLine());
        createdDate = new Date();
    }
    public void displayData(){
        System.out.printf("%-15s %-20s %-50s %-20s %-25s %-10b \n",songId,songName,descriptions,singer.getSingerName(),songWriter,songStatus);
        System.out.print("createDate"+createdDate);
    }
}