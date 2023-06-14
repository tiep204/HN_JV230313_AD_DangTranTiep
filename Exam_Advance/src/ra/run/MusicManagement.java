package ra.run;

import ra.model.Singer;
import ra.model.Song;

import java.util.Scanner;

public class MusicManagement {
    static Singer[] singers = new Singer[200];
    static int index = 0;
    static int index1 = 0;
    static Song[] arrSong = new Song[200];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            System.out.println("Sự lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    singerManager(sc);
                    break;
                case 2:
                    songManager(sc);
                    break;
                case 3:
                    searchManager(sc);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn tử 1-4:");
            }
        } while (true);
    }

    /////////////////////////singerManager//////////////////////////////////////
    public static void singerManager(Scanner sc) {
        boolean exitMenuSinger = true;
        do {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3.Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4.Xóa ca sĩ theo mã id");
            System.out.println("5.Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    create(sc);
                    break;
                case 2:
                    findAll();
                    break;
                case 3:
                    update(sc);
                    break;
                case 4:
                    delete(sc);
                    break;
                case 5:
                    exitMenuSinger = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn tử 1-5!!");
            }
        } while (exitMenuSinger);
    }

    public static void create(Scanner sc) {
        System.out.println("Mời bạn nhập số lượng ca sĩ mà bạn muốn thêm");
        int number = Integer.parseInt(sc.nextLine());
        if (number > singers.length) {
            System.err.println("số lượng ca sĩ tối đa là 200 vui lòng nhập lại số lượng bạn muốn thêm: ");
            number = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < number; i++) {
            System.out.println("Mời bạn nhập thông tin ca sĩ: " + (index + 1));
            Singer singer = new Singer();
            singer.setSingerId(index + 1);
            singer.inputData();
            singers[index] = singer;
            index++;
        }
    }

    public static void findAll() {
        System.out.printf("%-5s %-25s %-10s %-20s %-15s %-20s \n", "id", "Name", "age", "nationality", "gender", "genre");
        for (int i = 0; i < index; i++) {
            singers[i].displayData();
        }
    }

    public static void update(Scanner sc) {
        System.out.println("Mời bạn nhập id cần update: ");
        int id = Integer.parseInt(sc.nextLine());
        int indexSinger = -1;
        for (int i = 0; i < index; i++) {
            if (singers[i].getSingerId() == id) {
                indexSinger = i;
                break;
            }
        }
        if (indexSinger != -1) {
            System.out.print("Mời bạn cập nhật tên ca sĩ: ");
            String singerName = sc.nextLine();
            if (!singerName.isEmpty()) {
                singers[indexSinger].setSingerName(singerName);
            }
            System.out.print("Mời bạn cập nhật tuổi ca sĩ: ");
            String age = sc.nextLine();
            if (!age.isEmpty()) {
                singers[indexSinger].setAge(Integer.parseInt(age));
            }
            System.out.print("Mời bạn cập nhật quốc tịch ca sĩ: ");
            String nationality = sc.nextLine();
            if (!nationality.isEmpty()) {
                singers[indexSinger].setNationality(nationality);
            }
            System.out.print("Mời bạn cập nhật giới tính ca sĩ: ");
            String gender = sc.nextLine();
            if (!gender.isEmpty()) {
                singers[indexSinger].setGender(Boolean.parseBoolean(gender));
            }
            System.out.print("Mời bạn cập nhật thể loại ca sĩ: ");
            String genre = sc.nextLine();
            if (!genre.isEmpty()) {
                singers[indexSinger].setGenre(genre);
            }

        }
    }

    public static void delete(Scanner sc) {
        System.out.println("Mời bạn nhập id ca sĩ bạn cần xóa:");
        int id = Integer.parseInt(sc.nextLine());
        int indexSinger = -1;
        for (int i = 0; i < index; i++) {
            if (singers[i].getSingerId() == id) {
                indexSinger = i;
                break;
            }
        }
        if (indexSinger != -1) {
            for (int i = 0; i < index - 1; i++) {
                singers[i] = singers[i + 1];
            }
            singers[index - 1] = null;
            index--;
            System.out.println("Ca si đã được xóa ");
        } else {
            System.out.println("id không hợp lệ");
        }
    }
    /////////////////////////singerManager//////////////////////////////////////

    /////////////////////////songManager//////////////////////////////////////

    public static void songManager(Scanner sc) {
        boolean exitMenuSong = true;
        do {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2.Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println("3.Thay đổi thông tin bài hát theo mã id");
            System.out.println("4.Xóa bài hát theo mã id");
            System.out.println("5.Thoát");
            System.out.println("Sự lựa chọn của bạn!!");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    createSong(sc);
                    break;
                case 2:
                    findAllSong();
                    break;
                case 3:
                    updateSong(sc);
                    break;
                case 4:
                    deleteSong(sc);
                    break;
                case 5:
                    exitMenuSong = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-5");
            }
        } while (exitMenuSong);
    }

    public static void createSong(Scanner sc) {
        System.out.println("Mời bạn nhập số lượng bài hát mà bạn muốn thêm");
        int number = Integer.parseInt(sc.nextLine());
        if (number > arrSong.length) {
            System.err.println("số lượng bai hát tối đa là 200 vui lòng nhập lại số lượng bạn muốn thêm: ");
            number = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < number; i++) {
            System.out.println("Mời bạn nhập thông tin ca sĩ: " + (index1 + 1));
            Song song = new Song();
            song.inputData();
            arrSong[index1] = song;
            index1++;
        }
    }

    public static void findAllSong() {
        System.out.printf("%-15s %-20s %-50s %-20s %-25s %-10s %-20s", "id", "Name", "descriptions", "SingerName", "songWriter", "songStatus", "createDate");
        for (int i = 0; i < index; i++) {
            arrSong[i].displayData();
        }
    }

    public static void updateSong(Scanner sc) {
        System.out.println("Mời bạn nhập id cần update: ");
        String id = sc.nextLine();
        int indexSong = -1;
        for (int i = 0; i < index; i++) {
            if (arrSong[i].getSongId() == id) {
                indexSong = i;
                break;
            }
        }
        if (indexSong != -1) {
            System.out.print("Mời bạn cập nhật tên bài hát: ");
            String songName = sc.nextLine();
            if (!songName.isEmpty()) {
                arrSong[indexSong].setSongName(songName);
            }
            System.out.print("Mời bạn cập nhật mô tả bài hát: ");
            String descriptions = sc.nextLine();
            if (!descriptions.isEmpty()) {
                arrSong[indexSong].setDescriptions(descriptions);
            }
            System.out.print("Mời bạn cập nhật người sáng tác: ");
            String songWriter = sc.nextLine();
            if (!songWriter.isEmpty()) {
                arrSong[indexSong].setSongWriter(songWriter);
            }
            System.out.print("Mời bạn cập nhật trạng thái bài hát: ");
            String songStatus = sc.nextLine();
            if (!songStatus.isEmpty()) {
                arrSong[indexSong].setSongStatus(Boolean.parseBoolean(songStatus));
            }
        } else {
            System.out.println("Không tìm thấy bài hát với id: " + id);
        }
    }

    public static void deleteSong(Scanner sc) {
        System.out.println("Mời bạn nhập id bài hát cần xóa:");
        String id = sc.nextLine();
        int indexSong = -1;
        for (int i = 0; i < index1; i++) {
            if (arrSong[i].getSongId().equals(id)) {
                indexSong = i;
                break;
            }
        }
        if (indexSong != -1) {
            for (int i = indexSong; i < index1 - 1; i++) {
                arrSong[i] = arrSong[i + 1];
            }
            arrSong[index1 - 1] = null;
            index1--;
            System.out.println("Bài hát đã được xóa");
        } else {
            System.out.println("Không tìm thấy bài hát với id: " + id);
        }
    }
    /////////////////////////songManager//////////////////////////////////////

    public static void searchManager(Scanner sc) {
        boolean exitMenuSearch = true;
        do {
            System.out.println("*********************SEARCH-MANAGEMENT************************");
            System.out.println("1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
            System.out.println("2.Tìm kiếm ca sĩ theo tên hoặc thể loại");
            System.out.println("3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("4.Hiển thị 10 bài hát được đăng mới nhất");
            System.out.println("5.Thoát");
            System.out.println("Sự lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    exitMenuSearch = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn tử 1-5");
            }
        } while (exitMenuSearch);
    }
}