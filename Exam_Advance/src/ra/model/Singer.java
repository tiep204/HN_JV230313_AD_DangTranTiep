package ra.model;

import java.util.Scanner;

public class Singer {
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {
    }

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void inputData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên ca sĩ: ");
        singerName = sc.nextLine();
        while (singerName.isEmpty()){
            System.err.println("Tên ca sĩ không được để trống. vui lòng nhập lại");
            singerName = sc.nextLine();
        }
        System.out.println("Mời bạn nhập tuổi ca sĩ: ");
        age = Integer.parseInt(sc.nextLine());
        while (age<0){
            System.err.println("tuổi ca sĩ phải lớn hơn 0. vui lòng nhập lại: ");
            age = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Mời bạn nhập quốc tịch ca sĩ: ");
        nationality = sc.nextLine();
        while (nationality.isEmpty()){
            System.err.println("Quốc tịch không được bỏ trống.Vui lòng nhập lại:");
            nationality = sc.nextLine();
        }
        System.out.println("Mời bạn nhập giới tính");
        gender = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Mời bạn nhập thể loại: ");
        genre = sc.nextLine();
        while (genre.isEmpty()){
            System.err.println("Thể loại không được bỏ trống.Vui lòng nhập lại:");
            nationality = sc.nextLine();
        }
    }
    public void displayData(){
        System.out.printf("%-5d %-25s %-10d %-20s %-15b %-20s \n",singerId,singerName,age,nationality,gender,genre);
    }
}